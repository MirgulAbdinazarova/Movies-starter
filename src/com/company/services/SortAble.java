package com.company.services;

import com.company.models.Director;

public interface SortAble {

    void printAllMovies();

    void findMovie();

    void sortByYear(int year);

    void sortByName(String name);

    void sortByDirector();
}
