package com.company;
import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        LinkedObjList link = ReadFromFile();


        boolean stop = true;
        while (stop) {
            System.out.println("Welcome, choose an option from the menu: \n 1. Create member \n 2. Print list \n 3. Exit");
            switch (scan.next()) {
                case "1":
                    link.add(CreateMember(scan, link));
                    break;

                case "2":
                    Collections.sort((List<String>) link);
                    System.out.println(link);
                    break;

                case "-1":
                    writeToFile(link);
                    ReadFromFile();
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

    public static LinkedObjList ReadFromFile() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("Members.txt"));
        LinkedObjList filLink = new LinkedObjList();
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] fields = line.split(" ");
            String fN = fields[0];
            String lN = fields[1];
            int age = Integer.parseInt(fields[2]);
            String t = fields[3];

            MemberPlayer memPla = new MemberPlayer(fN, lN, age, t);

            filLink.add(memPla);
        }
        return filLink;

        }
}

