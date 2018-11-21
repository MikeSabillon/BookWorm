package com.udemy.guru.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.udemy.guru.spring5webapp.model.Author;
import com.udemy.guru.spring5webapp.model.Book;
import com.udemy.guru.spring5webapp.model.Publisher;
import com.udemy.guru.spring5webapp.repositories.AuthorRepository;
import com.udemy.guru.spring5webapp.repositories.BookRepository;
import com.udemy.guru.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
            PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        this.initData();
    }

    private void initData() {
        // Eric
        Publisher testPublisher = new Publisher("Andres Books", "España, Murcia");
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", testPublisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        this.publisherRepository.save(testPublisher);
        this.authorRepository.save(eric);
        this.bookRepository.save(ddd);

        // Rod
        Publisher testPublisher2 = new Publisher("Angel Books", "España, Madrid");
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", testPublisher2);
        eric.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        this.publisherRepository.save(testPublisher2);
        this.authorRepository.save(rod);
        this.bookRepository.save(noEJB);
    }

}
