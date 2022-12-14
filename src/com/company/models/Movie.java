package com.company.models;

import java.util.Comparator;
import java.util.List;

public class Movie  {

    private String name;
    private int year;
    private String description;
    private Director director;
    private List<Cast> cast;

    void printCast() {
        int counter = 1;
        for (Cast s : cast) {
            System.out.printf("%s)   Fullname: %s\n", counter, s.getFullName());
            System.out.println("     Role: " + s.getRole());
            counter++;
        }
    }


    public static Comparator<Movie> sortMovieByYearAscendingOrder = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {

            return o1.year-o2.year;
        }
    };
    public static Comparator<Movie> sortMovieByYearDescendingOrder = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {

            return o2.year-o1.year;
        }
    };
    public static Comparator<Movie>sortMovieByNameAscendingOrder=new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o1.name.compareTo(o2.name);
        }
    };
    public static Comparator<Movie>sortMovieByNameDescendingOrder=new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o2.name.compareTo(o1.name);
        }
    };
    public static Comparator<Movie>sortMovieByDirectorAscendingOrder=new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o1.director.getFullName().compareTo(o2.director.getFullName());
        }
    };
    public static Comparator<Movie>sortMovieByDirectorDescendingOrder=new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o2.director.getFullName().compareTo(o1.director.getFullName());
        }
    };
    public static Comparator<Movie>sortByActorNameAscendingOrder=new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o2.director.getFullName().compareTo(o1.director.getFullName());
        }
    };

    public List<Cast> getCast() {
        return cast;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getDescription() {
        return description;
    }

    public Director getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", description='" + description + '\'' +
                ", director=" + director +
                ", cast=" + cast +
                '}';
    }
}
