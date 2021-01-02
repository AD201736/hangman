package hangman;

import java.util.Scanner;
import java.util.Random;

public class Hangman {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        String wordList[] = {"forever", "watermelon", "strawberry", "pomegranate", "avacado", "tangerine", "gooseberry", "clementine", "cucumber", "gojiberry"};
        int errors = 0;
        int arrayLength = wordList.length;

        int chosen = rand.nextInt(arrayLength);
        String chosenWord = wordList[chosen];

        String alreadyGuessed = "";
        boolean wordFound = false;
        String changedWord = chosenWord;
        int howMany = chosenWord.length();
        String madeWord = "";
        for (int i = 0; i < howMany; i++) {
            madeWord = madeWord + "_ ";
        }
        System.out.println(madeWord);
        StringBuilder myString = new StringBuilder(madeWord);

        while (errors < 10 && wordFound == false) {
            System.out.println("\n\n Try guessing a letter: ");

            char letterGuessed = in.next().charAt(0);
            if (chosenWord.indexOf(letterGuessed) > -1) {
                if (alreadyGuessed.indexOf(letterGuessed) > -1) {
                    System.out.println("You already guessed that!");
                } else {
                    System.out.println("That is correct! ");
                    alreadyGuessed = alreadyGuessed + letterGuessed;
                    changedWord = changedWord.replace(String.valueOf(letterGuessed), "");

                    int theIndex = chosenWord.indexOf(letterGuessed);

                    while (theIndex > -1) {

                        myString.setCharAt(theIndex * 2, letterGuessed);
                        int startPoint = theIndex + 1;
                        if (startPoint > chosenWord.length()) {
                            break;
                        }
                        theIndex = chosenWord.indexOf(letterGuessed, startPoint);
                    }

                    System.out.println(myString);
                }
            } else {
                if (alreadyGuessed.indexOf(letterGuessed) > -1) {
                    System.out.println("You already guessed that!");
                } else {
                    System.out.println("Wrong! Try again");
                    errors++;
                    alreadyGuessed = alreadyGuessed + letterGuessed;

                }
            }
            if (changedWord.equals("")) {
                wordFound = true;
            }

        }
        if (wordFound == true) {
            System.out.println("Hurray! You found the word! It was " + chosenWord);
        } else {
            System.out.println("Too many errors! You lost!");
        }
    }

}
