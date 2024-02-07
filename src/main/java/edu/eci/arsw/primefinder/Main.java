package edu.eci.arsw.primefinder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Control control = Control.newControl();
        control.start();

        new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                scanner.nextLine();
                synchronized (Control.lock) {
                    Control.lock.notifyAll();
                }
            }
        }).start();
    }
}