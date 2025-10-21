package com.nt;

public class LoveMessage {
    public static void main(String[] args) throws InterruptedException {
        String message = "I LOVE YOU AMBIKA";
        String heart = "💖";

        System.out.println("\n");
        for (int i = 0; i < message.length(); i++) {
            System.out.print(message.charAt(i));
            Thread.sleep(200); 
        }

        System.out.println("\n\n");

        
        String[] heartPattern = {
            "   " + heart + heart + "     " + heart + heart + "   ",
            " " + heart + heart + heart + heart + heart + " " + heart + heart + heart + heart + heart,
            heart + heart + heart + heart + heart + heart + heart + heart + heart + heart + heart,
            " " + heart + heart + heart + heart + heart + heart + heart + heart + heart,
            "   " + heart + heart + heart + heart + heart + heart + heart,
            "     " + heart + heart + heart + heart + heart,
            "       " + heart + heart + heart,
            "         " + heart
        };

        for (String line : heartPattern) {
            System.out.println(line);
            Thread.sleep(200);
        }

        System.out.println("\n        ❤️ I LOVE YOU AMBIKA ❤️");
        System.out.println("             — Yours Forever 💫");
    }
}

