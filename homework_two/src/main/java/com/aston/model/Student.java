package com.aston.model;

import java.util.List;

public class Student {

    private static final int MIN_BOOK_QUANTITY = 5;

    private final String name;
    private final List<Book> books;

    public Student(String name, List<Book> books) {

        if (books == null || books.size() < MIN_BOOK_QUANTITY) {
            throw new IllegalArgumentException("Student must have at least " + MIN_BOOK_QUANTITY + " books"
            );
        }

        this.name = name;
        this.books = List.copyOf(books);;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}