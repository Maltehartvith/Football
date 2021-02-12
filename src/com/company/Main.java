package com.company;
import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        LinkedObjList link = new LinkedObjList();





        boolean stop = true;
        link = ReadFromFile(link);
        while (stop) {
            System.out.println("Welcome, choose an option from the menu: \n 1. Create member \n 2. Print list \n " +
                    "3. Remove member\n -1. Exit");
            switch (scan.next()) {
                case "1":
                    link.add(CreateMember(scan, link));
                    break;

                case "2":
                    //Collections.sort((List<String>) link);
                    System.out.println(link);
                    break;


                case "3":
                    System.out.println(link.toString(" ") + "\nType in the index of the member you want removed");
                    int choice = scan.nextInt();
                    link.remove(choice);
                    System.out.println(link.toString(" "));

                    break;
                case "-1":
                    writeToFile(link);

                    stop = false;
                    break;
            }

        }


    }

    public static MemberPlayer CreateMember(Scanner scan, LinkedObjList link) {

        System.out.println("Enter firstname: ");
        String f = scan.next();

        System.out.println("Enter lastname: ");
        String l = scan.next();

        System.out.println("Enter age: ");
        int a = scan.nextInt();

        System.out.println("Enter first or second team: ");
        String t = scan.next();


        MemberPlayer mObj = new MemberPlayer(f, l, a, t);


        return mObj;
    }

    public static void writeToFile(LinkedObjList list) throws FileNotFoundException {
        PrintStream write = new PrintStream(new File("Members.txt"));

        for (int i = 0; i < list.size(); i++) {
            write.println(list.get(i).toStringToFile());

        }
        write.close();

    }

    public static LinkedObjList ReadFromFile(LinkedObjList list) throws IOException {
        Scanner scan = new Scanner(new File("Members.txt"));
        while (scan.hasNextLine()) {

            String line = scan.nextLine();
            //String[] words = line.split(" ");
            Scanner read = new Scanner(line);

            String fN = read.next();
            String lN = read.next();
            int age = read.nextInt();
            String t = read.next();


            MemberPlayer memPla = new MemberPlayer(fN, lN, age, t);

            list.add(memPla);
        }

        return list;
    }

}

