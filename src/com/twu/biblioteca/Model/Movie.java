package com.twu.biblioteca.Model;

public class Movie {
    private String title;
    private int year;
    private Name director;
    private Rating rating;

    public Movie(String title, int year, Name director, Rating rating) {
        this.title = title;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public int getYearReleased() {
        return year;
    }

    public String getDirectorName() {
        return director.getFullName();
    }

    public String getRatingInString() {
        return rating.getRating();
    }
}
