package com.company;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class Assassin {
    public static void main(String[] args)throws IOException {
        Scanner scan = new Scanner(System.in);
        LinkedList<String> link = ReadFromFile();
        System.out.println(link.size());
        boolean stop = true;
        while (stop) {
            System.out.println("Welcome to the Assassin game! Choose an option from the menu: " +
                    "\n 1. Create player \n 2. Start the game \n " +
                    "3. Print the list of players \n 4. Remove a player \n -1. Exit");
            switch (scan.next()) {
                case "1":
                    link.add(createPlayer(scan));
                    break;

                case "2":
                    if(link.size() == 1 || link.size() == 0){
                        System.out.println("You cant start the game with " + link.size() + " players, go on and" +
                                " add some more");
                        break;
                    }else {
                        startGame(link, scan);
                    }
                    break;

                case "3":
                    System.out.println("These are the competing players:");
                    System.out.println(link);
                    break;

                case "4":
                    removePlayer(scan, link);
                    break;
                case "-1":
                    writeToFile(link);

                    stop = false;
                    break;
            }

        }
    }
    @Test
    public static String createPlayer(Scanner scan){
            System.out.println("What is the name of the player: ");
            String name = scan.next();
            return name;
    }
    public static LinkedList<String> removePlayer(Scanner scan, LinkedList<String> link){
        System.out.println("Which player do your want to remove?");
        for(int i = 0; i < link.size(); i++){
            System.out.println(i + " " + link.get(i));
        }
        int choice = scan.nextInt();
        if(choice == -1){
            return link;
        }else{
            link.remove(link.get(choice));
            return link;
        }
    }
    public static LinkedList ReadFromFile() throws IOException {
        Scanner scan = new Scanner(new File("Assassin.txt"));
        LinkedList<String> list = new LinkedList<>();

        while (scan.hasNextLine()) {

            String line = scan.nextLine();
            Scanner read = new Scanner(line);

            String fN = read.next();

            list.add(fN);
            Collections.shuffle(list);
        }

        return list;
    }
    public static void writeToFile(LinkedList<String> list) throws FileNotFoundException {
        PrintStream write = new PrintStream(new File("Assassin.txt"));

        for (int i = 0; i < list.size(); i++) {
            write.println(list.get(i));

        }
        write.close();

    }
    public static void startGame(LinkedList<String> list, Scanner scan){
        System.out.println("The game has begun!\nIf you want to kill a person, " +
                "type the persons number and, otherwise type pass");
        ArrayList<String> graveyard = new ArrayList<>();
        int turn = 0;
        while(!list.isEmpty()){
            for(int i = 0; i < list.size(); i++) {
                if(!graveyard.isEmpty()){
                    System.out.println("The people who are now dead and gone... " + graveyard.toString());
                }
                System.out.println("It is " + list.get(i) + "'s turn");

                System.out.println("Do you want to kill or pass? kill/pass");

                String choice = scan.next();

                if(choice.equalsIgnoreCase("kill")){
                    for (int j = 0; j < list.size(); j++) {
                        System.out.println(j +" "+ list.get(j));
                    }
                    System.out.println("Who do you want to kill? type -1 to pass");
                    int kill = scan.nextInt();
                    if(kill == -1){
                        System.out.println("You passed your turn to the next player.");
                        continue;

                    }
                    while(kill == i){
                        System.out.println("You cant kill yourself dummy, try again");
                        for (int j = 0; j < list.size(); j++) {
                            System.out.println(j +" "+ list.get(j));
                        }
                        kill = scan.nextInt();
                    }
                    if(kill != i) {
                        graveyard.add(list.get(kill));
                        list.remove(kill);
                    }
                }else{
                    System.out.println("You passed your turn to the next player.");
                }
                turn++;
            }
            if(list.size() == 1){
                System.out.println("We have a winner!! It took " + turn + " turns and " + list.get(0) + " is the" +
                        " winner! congratulations!!!");
                for(int i = 0; i < graveyard.size(); i++){
                    list.add(graveyard.get(i));
                }
                break;
            }
        }

    }
}
