package com.udemy.guru.spring5webapp.bootstrap;

import com.udemy.guru.spring5webapp.model.Author;
import com.udemy.guru.spring5webapp.model.Book;

public class DevBootstrap {

    private void initData() {
        // Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", "");
    }

}
