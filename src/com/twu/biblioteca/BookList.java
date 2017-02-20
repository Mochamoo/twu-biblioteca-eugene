package com.twu.biblioteca;
import java.util.ArrayList;

public class BookList {
    private ArrayList<Book> list;

    public BookList() {
        list = new ArrayList<Book>();

        list.add(new Book("Introduction to the Design & Analysis of Algorithm",
                          "Anany Levitin", 2012));
        list.add(new Book("Gears of War: Anvil Gate",
                          "Karen Travis", 2010));
        list.add(new Book("Artificial Intelligence: A Modern Approach",
                          "Peter Norvig", 2010));
        list.add(new Book("Test-Driven Development",
                          "Kent Beck", 2003));
    }

    public int size() {
        return list.size();
    }

}
