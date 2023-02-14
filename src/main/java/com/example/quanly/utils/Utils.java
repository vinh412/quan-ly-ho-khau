package com.example.quanly.utils;

import java.time.LocalDate;

public class Utils {
    public static int AgeCalc(LocalDate dob){
        LocalDate now = LocalDate.now();
        long from = dob.toEpochDay();
        long to = now.toEpochDay();
        LocalDate age = LocalDate.ofEpochDay(to - from);
        return (age.getYear()-1970) + 1;
    }
}
