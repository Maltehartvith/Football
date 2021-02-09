package com.company;

import javax.print.attribute.standard.NumberUp;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class LinkedObjList {
    private ListNode front;

    public LinkedObjList(){
        front = null;
    }
    public String toString() {
        if (front == null) {
            return "[]";
        } else {
            String result = "[" + front.data;
            ListNode current = front.next;
            while (current != null) {
                result += ", " + current.data;
                current = current.next;
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

    private ListNode nodeAt(int index) {
        ListNode current = front;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current;
    }

    //public void remove(MemberPlayer player.firstName){}


}
