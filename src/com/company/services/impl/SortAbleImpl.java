package com.company.services.impl;

import com.company.JsonIO;
import com.company.models.Director;
import com.company.models.Movie;
import com.company.services.SortAble;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class SortAbleImpl implements SortAble {
    static Scanner scanner=new Scanner(System.in);
    @Override
    public void printAllMovies() {

        List<Movie> movieList= JsonIO.getMovies();
        for (Movie i:movieList) {
            System.out.println("---------movie--------");
            System.out.println("Name:"+i.getName());
            System.out.println("Year:"+i.getYear());
            System.out.println("Description:"+i.getDescription());
            System.out.println("Director name:"+i.getDirector().getFullName());
            for (int j = 0; j <i.getCast().size(); j++) {
                System.out.println("Cast name:"+i.getCast().get(j).getFullName());
                System.out.println("Cast role:"+i.getCast().get(j).getRole());

            }
        }
    }

    @Override
    public void findMovie() {
        System.out.println("Enter movie name: ");
        String movieName = scanner.nextLine();
        int sch=0;
        List<Movie>movieList=JsonIO.getMovies();
        for (Movie m:movieList) {
            if(m.getName().toLowerCase().contains(movieName.toLowerCase()) || m.getName().equalsIgnoreCase(movieName) ){
                System.out.println(m.getName());
                sch++;
            }

        }
      try {
          if (sch==0)
              throw new RuntimeException();
      }catch (RuntimeException e){
          System.out.println("Film ne naiden");
      }

    }

    @Override
    public void sortByYear(int year) {
            List<Movie>movieList=JsonIO.getMovies();

            if (year==1){
            Collections.sort(movieList,Movie.sortMovieByYearAscendingOrder);
            for(Movie m:movieList){
                System.out.println(m.getYear());
            }
        }else if(year==2){
            Collections.sort(movieList,Movie.sortMovieByYearDescendingOrder);
            for (Movie m:movieList) {
                System.out.println(m.getYear());
            }
        }
    }
    @Override
    public void sortByName(String name) {
            List<Movie> movieList = JsonIO.getMovies();
            int choose1= scanner.nextInt();

            if (choose1==1) {
            Collections.sort(movieList, Movie.sortMovieByNameAscendingOrder);
            for (Movie m : movieList) {
                System.out.println(m.getName());
            }
        }else if(choose1==2){

            Collections.sort(movieList, Movie.sortMovieByNameDescendingOrder);
            for (Movie m : movieList) {
                System.out.println(m.getName());

            }
        }
    }

    @Override
    public void sortByDirector() {
            List<Movie>movieList=JsonIO.getMovies();
        System.out.println("Enter director name:");
        String director=scanner.nextLine();
        System.out.println("1 or 2");
            int choose= scanner.nextInt();
            if (choose==1){
            Collections.sort(movieList,Movie.sortMovieByDirectorAscendingOrder);
            for (Movie m:movieList) {
                System.out.println(m.getDirector().getFullName());
            }
            } else if (choose == 2) {
                Collections.sort(movieList,Movie.sortMovieByDirectorDescendingOrder);
                for (Movie m:movieList) {
                    System.out.println(m.getDirector().getFullName());
                }
            }


        }
}
