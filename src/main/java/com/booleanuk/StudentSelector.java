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
        students.add("Miley Cyrus");
        students.add("Yugi Moto");
        students.add("Seto Kaiba");
    }

    public boolean run() {
       if(showMenu()) {
           return true;
       }
       return false;
    }

    public boolean showMenu() {
        System.out.println("Welcome to the random Student Selector Program" + "\n");
        printMenu();

        Scanner sc = new Scanner(System.in);
        String input = "";

        while (sc.hasNext()) {
            input = sc.nextLine();
            switch (input) {
                case "x":
                    System.exit(0);
                    break;
                case "A":
                    System.out.println(optionA());
                    break;
                case "B":
                    String[] pair = optionB();
                    System.out.println(pair[0] + " " + pair[1]);
                    break;
                case "C":
                    System.out.println("placeholder optionC");
                    break;
                case "D":
                    System.out.println("placeholder optionD");
                    break;
                default:
                    System.out.println("Invalid Operand, terminating cus noob...");
                    break;
            }
            printMenu();

            if (input.equalsIgnoreCase("x")) {
                System.exit(0);
            }
        }

        return true;
    }

    public void printMenu() {
        System.out.println("Please select one of the following options:" + "\n");
        System.out.println("A: Select a random student");
        System.out.println("B: ");
        System.out.println("C: ");
        System.out.println("D: ");
        System.out.println("X: Exit the Program");
    }

    public String optionA() {
        return this.students.get(random.nextInt(0, this.students.size()));
    }

    public String[] optionB() {
        String firstPerson = this.students.get(this.random.nextInt(0, this.students.size()));
        String secondPerson = this.students.get(this.random.nextInt(0, this.students.size()));
        while (firstPerson.equalsIgnoreCase(secondPerson)) {
            secondPerson = this.students.get(this.random.nextInt(0, this.students.size()));
        }
        return new String[]{firstPerson, secondPerson};
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
        //s.instantiateListFromFile("/names");
    }

}
