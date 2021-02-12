package com.company;

import java.util.Scanner;

public class LinkedObjList {
    private ListNode front;

    public LinkedObjList(){
        front = null;
    }

    public String toString() {
        int index = 1;
        if (front == null) {
            return "[]";
        } else {
            String result = "[" + "0 "+ front.data;
            ListNode current = front.next;
            while (current != null) {
                result += "\nIndex: " +index +" "+ current.data;
                current = current.next;
                index++;
            }
            result += "]";
            return result;
        }
    }

    public String toString(String h) {
        int index = 1;
        if (front == null) {
            return "[]";
        } else {
            String result = "[" + "0 "+ front.data.shortString();
            ListNode current = front.next;
            while (current != null) {
                result += "Index: " +index +" "+ current.data.shortString();
                current = current.next;
                index++;
            }
            result += "]";
            return result;
        }
    }


    public void add(MemberPlayer player){
        if(front == null){
            front = new ListNode(player);
        }else{
            ListNode current = front;
            while(current.next != null){
            current = current.next;
            }
            current.next = new ListNode(player);
        }

    }
    public int size() {
        int count = 0;
        ListNode current = front;
            while (current != null) {
                current = current.next;
                count++;
        }
        return count;
    }

    public MemberPlayer get(int index){
        return nodeAt(index).data;
    }

    public void remove(int index){
        if(index == 0){
            front = front.next;
        } else {
            ListNode current = nodeAt(index -1);
            current.next = current.next.next;
        }
    }

    private ListNode nodeAt(int index) {
        ListNode current = front;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current;
    }

    //public void remove(MemberPlayer player.firstName){}


}
