package com.twu.biblioteca;
import java.util.HashMap;
import java.util.Map;

public class BookList {
    private Map<String, Book> books;

    public BookList() {
        books = new HashMap<String, Book>();
    }

    public void populateBookList() {
        books.put("Introduction to the Design & Analysis of Algorithm",
                new Book("Introduction to the Design & Analysis of Algorithm",
                new AuthorList(new Author("Anany", "Levitin")),
                2012));
        books.put("Gears of War: Anvil Gate",
                new Book("Gears of War: Anvil Gate",
                new AuthorList(new Author("Karen", "Travis")),
                2010));
        books.put("Artificial Intelligence: A Modern Approach",
                new Book("Artificial Intelligence: A Modern Approach",
                new AuthorList(new Author("Peter", "Norvig")),
                2010));
        books.put("Test-Driven Development",
                new Book("Test-Driven Development",
                new AuthorList(new Author("Kent", "Beck")),
                2003));
    }

    public int size() {
        return books.size();
    }

    public Map<String, Book> getBooks() {
        return books;
    }

    public Book getBookByTitle(String title) {
        return books.get(title);
    }

    public void addBook(Book book) {
        books.put(book.getTitle(), book);
    }

    public void removeBook(String title) {
        books.remove(title);
    }

}
