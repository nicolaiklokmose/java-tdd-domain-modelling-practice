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
        students.add("Natalie Portman");
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
                    String[][] pairs = optionB();
                    for (int i = 0; i < pairs.length; i++) {
                        System.out.print("(" + (i+1) + ") " + "[");
                        for (int j = 0; j < pairs[i].length; j++) {
                            System.out.print(pairs[i][j]);
                            if (j == 0) {
                                System.out.print(", ");
                            }

                        }
                        System.out.println("]");
                    }
                    // Remove this men filepath works
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

    public String[][] optionB() {
        String[][] pairs = new String[this.students.size()/2][2];
        int counter = 0;
        while (this.students.size() > 1) {
            String[] pair;
            int firstPerson = this.random.nextInt(0, this.students.size());
            int secondPerson = this.random.nextInt(0, this.students.size());

            while (firstPerson == secondPerson) {
                secondPerson = this.random.nextInt(0, this.students.size());
            }

            pair = new String[]{this.students.get(firstPerson), this.students.get(secondPerson)};
            this.students.remove(firstPerson);
            this.students.remove(secondPerson - 1);
            pairs[counter] = pair;
            counter++;
        }
        return pairs;
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
