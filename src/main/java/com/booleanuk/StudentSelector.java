package com.booleanuk;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class StudentSelector {

    private String filePath = "/Users/niczorn/IdeaProjects/java-tdd-domain-modelling-practice/src/main/java/com/booleanuk";
    public List<String> students;
    Random random = new Random(100);

    public StudentSelector() {
        //this.students = instantiateListFromFile(filePath);
        this.students = new ArrayList<>();
        students.add("Nicolai Klokmose");
        students.add("Dave Amos");
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
        System.out.println("A: Select a random student");
        System.out.println("B: ");
        System.out.println("C: ");
        System.out.println("D: ");

        return true;
    }

    public String optionA() {
        return this.students.get(random.nextInt(0, this.students.size()));
    }

    public List<String> instantiateListFromFile(String filePath) {
        List<String> students = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            scanner.useDelimiter(",|\\n");
            while (scanner.hasNext()) {
                String name = scanner.next().trim();
                students.add(name);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static void main(String[] args) {
        StudentSelector s = new StudentSelector();
        s.showMenu();
        System.out.println(s.optionA());
        //s.instantiateListFromFile("/names");
    }

}
