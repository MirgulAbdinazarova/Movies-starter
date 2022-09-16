package com.company.models;

import java.util.Comparator;

public class Cast implements Comparable <Cast> {

    private String fullName;
    private String role;

    public String getFullName() {
        return fullName;
    }

    public String getRole() {
        return role;
    }


    @Override
    public int compareTo(Cast o) {
        return fullName.compareTo(o.fullName);
    }
}