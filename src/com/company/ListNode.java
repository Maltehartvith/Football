package com.company;

public class ListNode {
    public MemberPlayer data;
    public ListNode next;


    public ListNode() {
        this(null, null);
    }


    public ListNode(MemberPlayer data) {
        this(data, null);
    }


    public ListNode(MemberPlayer data, ListNode next) {
        this.data = data;
        this.next = next;
    }
}