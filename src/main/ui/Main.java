package ui;

import java.util.*;

public class Main {
    private static void OpeningSpeech(){
        System.out.println("Hello!");
        System.out.println("How many times would you like to be congratulated for completing your first deliverable?");
    }

    private static void Congratulate(int number){
        for (int i = 1; i <= number; i++) {
            System.out.println("congratulations!");
        }
    }

    private static void ClosingSpeech(){
        System.out.println("That's all the congratulations. You have successfully completed the first step.");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        OpeningSpeech();
        int howmany = scan.nextInt();
        int subhowmany = (howmany - 1);
        System.out.println(howmany + " is too much! I will give you one less, so " + subhowmany + " congratulations!");
        Congratulate(subhowmany);
        ClosingSpeech();
    }
}
