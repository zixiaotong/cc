package com.thread.ticket;

public class TicketDemo {
    public static void main(String[] args) {
        Ticket t = new Ticket();
        Thread t1 = new Thread(t, "1");
        Thread t2 = new Thread(t, "2");
        Thread t3 = new Thread(t, "3");

        t1.start();
        t2.start();
        t3.start();
    }
}
