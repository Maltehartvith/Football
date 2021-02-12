package com.company;

public class MemberPlayer {

    private String firstName;
    private String lastName;
    private int age;
    private String team;

    public MemberPlayer(String firstName, String lastName, int age, String team) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.team = team;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getTeam() {
        return team;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTeam(String team) {
        this.team = team;
    }
    public String toString(){
        return "\nFirst name: "+ firstName+ "\nLast Name: "+lastName+"\nAge: "+age+"\nTeam: "+team+"\n";
    }
    public String shortString(){
        return "Name: " + firstName +" "+ lastName + " " + age + "\n";

    }

    public String toStringToFile(){
        return firstName+ " "+lastName+" "+age+" "+team;
    }
}
