package com.booleanuk;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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
        students.add("Steve Jobs");
        students.add("Matthew Wilson");
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
                    System.exit(0);
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
                    System.exit(0);
                    // Remove this men filepath works
                    break;
                case "C":
                    String[][] pairs_peers = optionC();
                    for (int i = 0; i < pairs_peers.length; i++) {
                        System.out.print("(" + (i+1) + ") " + "[");
                        for (int j = 0; j < pairs_peers[i].length; j++) {
                            System.out.print(pairs_peers[i][j]);
                            if (j < 3 ) {
                                System.out.print(", ");
                            }

                        }
                        System.out.println("]");
                    }
                    // Remove this men filepath works
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Operand, terminating cus noob...");
                    break;
            }
        }
        return true;
    }

    public void printMenu() {
        System.out.println("Please select one of the following options:" + "\n");
        System.out.println("A: Select a random student");
        System.out.println("B: Randomly Generate pairs of Students");
        System.out.println("C: Randomly Generate peer-pairs of Students");
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
            for (int i = 0; i < pair.length; i++) {
                for (int j = 0; j < this.students.size(); j++) {
                    if (this.students.get(j) == pair[i]) {
                        this.students.remove(j);
                        break;
                    }
                }
            }
            pairs[counter] = pair;
            counter++;
        }
        return pairs;
    }

    public String[][] optionC() {
        String[][] pairs = new String[this.students.size()/4][4];
        int counter = 0;
        while (this.students.size() > 3) {
            String[] pair_four;

            HashSet<Integer> set = new HashSet<>();
            while (set.size() < 4) {
                set.add(this.random.nextInt(0, this.students.size()));
            }
            Integer[] setToArray = set.toArray(new Integer[0]);

            int firstPerson = setToArray[0];
            int secondPerson = setToArray[1];
            int thirdPerson = setToArray[2];
            int fourthPerson = setToArray[3];

            pair_four = new String[]{this.students.get(firstPerson), this.students.get(secondPerson), this.students.get(thirdPerson), this.students.get(fourthPerson)};

            for (int i = 0; i < this.students.size(); i++) {
                for (int j = 0; j < pair_four.length; j++) {
                    if (this.students.get(j) == pair_four[i]) {
                        this.students.remove(j);
                        break;
                    }
                }
            }
            pairs[counter] = pair_four;
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
        s.run();
        //s.instantiateListFromFile("/names");
    }

}
