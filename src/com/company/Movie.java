package com.company;

import java.util.ArrayList;
import java.util.List;

public class Movie {

  private String name;
  private int releaseYear;
  private String genre;
  private int rating;

  private Movie(String name, int releaseYear, String genre, int rating) {
    this.name = name;
    this.releaseYear = releaseYear;
    this.genre = genre;
    this.rating = rating;
  }

  public String getName() {
    return name;
  }

  public String getGenre() {
    return genre;
  }

  public int getReleaaseYear() {
    return releaseYear;
  }

  public int getRating() {
    return rating;
  }

  public static List<Movie> getMovie() {
    List<Movie> list = new ArrayList<>();
    list.add(new Movie("21 jump street", 2004, "comedy", 6));
    list.add(new Movie("hangover", 2009, "comedy", 9));
    list.add(new Movie("life", 2004, "sci-fi", 7));
    list.add(new Movie("interstellar", 2007, "sci-fi", 9));
    return list;
  }

}

