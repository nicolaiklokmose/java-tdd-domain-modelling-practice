package com.booleanuk;

import java.util.List;

public class StudentSelector {

    public List<String> students;

    public StudentSelector() {

    }

    public boolean run() {
       if(showMenu()) {
           return true;
       }
       return false;
    }

    public boolean showMenu() {
        System.out.println("Welcome to the random Student Selector Program" + "\n");
        System.out.println("Please select one of the following options:" + "\n");
        System.out.println("A: ");
        System.out.println("B: ");
        System.out.println("C: ");
        System.out.println("D: ");

        return true;
    }

    public boolean optionA() {
        return false;
    }

    public static void main(String[] args) {
        StudentSelector s = new StudentSelector();
        s.showMenu();
    }

}
