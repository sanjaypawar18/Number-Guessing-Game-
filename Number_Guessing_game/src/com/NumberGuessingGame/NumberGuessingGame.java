package com.NumberGuessingGame;

import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int maxAttempts = 5;
        int round = 1;
        int totalScore = 0;

        System.out.println("🎯 Welcome to the Number Guessing Game!");
        System.out.println("👉 Guess the number between 1 and 100.");
        System.out.println("💡 You have " + maxAttempts + " attempts per round.");

        boolean playAgain = true;

        while (playAgain) {
            int targetNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\n🔁 Round " + round + " begins!");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess;

                try {
                    userGuess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("❌ Invalid input! Please enter a number.");
                    continue;
                }

                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("🎉 Correct! You guessed it in " + attempts + " attempts.");
                    int score = (maxAttempts - attempts + 1) * 10;
                    totalScore += score;
                    System.out.println("🏆 Score this round: " + score);
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("⬆️ Too low! Try again.");
                } else {
                    System.out.println("⬇️ Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You've used all attempts. The correct number was: " + targetNumber);
            }

            System.out.println("⭐ Total Score: " + totalScore);

            System.out.print("\nDo you want to play another round? (yes/no): ");
            String answer = scanner.nextLine().trim().toLowerCase();

            if (!answer.equals("yes")) {
                playAgain = false;
                System.out.println("👋 Thanks for playing! Final Score: " + totalScore);
            } else {
                round++;
            }
        }

        scanner.close();
    }
}
