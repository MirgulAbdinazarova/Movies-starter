package com.company.services.impl;

import com.company.JsonIO;
import com.company.models.Cast;
import com.company.models.Director;
import com.company.models.Movie;
import com.company.services.FindAble;
import com.company.services.SortAble;

import java.util.*;

public class FindAbleImpl implements FindAble {
     public static Scanner sc=new Scanner(System.in);

    @Override
    public void findMoviesByActor() {
        System.out.println("Enter actor name:");
        String actorName= sc.nextLine();
                List<Movie> movieList = JsonIO.getMovies();
                for (Movie muv : movieList) {
                    for (int j = 0; j < muv.getCast().size(); j++) {
                        if (muv.getCast().get(j).getFullName().equalsIgnoreCase(actorName)
                        || muv.getCast().get(j).getFullName().contains(actorName)) {
                            System.out.println("Actor name:" + muv.getCast().get(j).getFullName());
                            System.out.println("Role:"+muv.getCast().get(j).getRole());
                            System.out.println("Movie name: " + muv.getName());
                            System.out.println("----------------");
                        }
                    }

                }
        }

    @Override
    public void findMoviesByDirector() {
        System.out.println("Enter director name:");
        String directorName= sc.nextLine();
        List<Movie>movieList=JsonIO.getMovies();
        for (Movie m:movieList) {
            for (int i = 0; i < movieList.size() ; i++) {
                if (m.getDirector().getFullName().equalsIgnoreCase(directorName)
                || m.getDirector().getFullName().toLowerCase().contains(directorName.toLowerCase())){
                    System.out.println("Director:"+m.getDirector().getFullName());
                    System.out.println("Movie:"+m.getName());
                    System.out.println("-----------------");
                   break;
                }
            }
        }
    }
    @Override
    public void findMoviesByYear() {
        System.out.println("Enter year");
        int year= sc.nextInt();
        List<Movie>movieList=JsonIO.getMovies();
        for (int i = 0; i < movieList.size(); i++) {
            if (movieList.get(i).getYear()==year){
                System.out.println("Year:"+movieList.get(i).getYear());
                System.out.println("Movie:"+movieList.get(i).getName());
                System.out.println("-----------------------");
            }
        }

    }

    @Override
    public void findMoviesAndRoleByActor() {
        System.out.println("Enter actor name:");
        String actorName= sc.nextLine();
        int sch=0;
        List<Movie>movieList=JsonIO.getMovies();
        for (Movie m:movieList) {
            for (int i = 0; i < m.getCast().size(); i++) {
                if (m.getCast().get(i).getFullName().equalsIgnoreCase(actorName)
                        || m.getCast().get(i).getFullName().toLowerCase().contains(actorName.toLowerCase())) {
                    System.out.println("Actor:" + m.getCast().get(i).getFullName());
                    System.out.println("Movie:" + m.getName());
                    System.out.println("Role:" + m.getCast().get(i).getRole());
                    System.out.println("--------------");
                    sch++;
                }
            }
        }
            try{
                if(sch==0)
                 throw new RuntimeException();
            }catch (RuntimeException r){
                System.out.println("Ne naiden");
            }
    }

    @Override
    public void showActorRoles() {
        List<Movie> movieList = JsonIO.getMovies();
        TreeSet<Cast> treeSet = new TreeSet<>();
        System.out.println("1 or 2");
        int choose =sc.nextInt();
        for (Movie m : movieList) {
            treeSet.addAll(m.getCast());

        }
        if (choose == 1) {
            for (Cast c : treeSet) {
                System.out.println("Actor name: " + c.getFullName());
                for (int i = 0; i < movieList.size(); i++) {
                    for (int j = 0; j < movieList.get(i).getCast().size(); j++) {
                        if (c.getFullName().equals(movieList.get(i).getCast().get(j).getFullName())) {
                            System.out.println("Movie: " + movieList.get(i).getName());
                            System.out.println("Role: " + movieList.get(i).getCast().get(j).getRole());
                        }
                    }
                }
                System.out.println("__________________________________");
            }
        } else if (choose == 2) {

            System.out.println("----------------------");

            TreeSet<Cast> treesetCast = (TreeSet<Cast>) treeSet.descendingSet();
            for (Cast c : treesetCast) {
                System.out.println("Actor name:" + c.getFullName());
                for (int i = 0; i < movieList.size(); i++) {
                    for (int j = 0; j < movieList.get(i).getCast().size(); j++) {
                        if (c.getFullName().equals(movieList.get(i).getCast().get(j).getFullName())) {
                            System.out.println("Movie: " + movieList.get(i).getName());
                            System.out.println("Role: " + movieList.get(i).getCast().get(j).getRole());
                        }
                    }
                }
                System.out.println("__________________________________");
            }
        }

        try {
            if(choose>2 );
            throw  new RuntimeException();
        }catch (RuntimeException r){
            System.out.println("Ne pravilno");
        }
    }

}
