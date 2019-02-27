
/**
 * WorldFiller
 *
 * This is a program that takes in certain input from the user and then
 * prints it out in a paragraph along with other words.
 *
 * @author Varun Ramakrishnan, L09
 *
 * @version 1/17/18
 *
 **/

import java.util.Scanner;

public class WordFiller
{
    public static void main(String[] args)
    {
        int     numbDay, numbWeek, numbSlice, numbTotal; // All integer inputs from the user
        String  adj1, adj2, adj3, adj4, nationality,
                noun1, noun2, noun3, pluralNoun, personName,
                shapeName, foodName1, foodName2; // All string inputs from the user

        Scanner input = new Scanner(System.in);

        // Everything that the user inputs
        System.out.println("Please provide the following:");

        System.out.println("adjective");
        adj1=input.nextLine();

        System.out.println("nationality");
        nationality = input.nextLine();

        System.out.println("person");
        personName = input.nextLine();

        System.out.println("noun");
        noun1 = input.nextLine();

        System.out.println("adjective");
        adj2 = input.nextLine();

        System.out.println("noun");
        noun2 = input.nextLine();

        System.out.println("adjective");
        adj3 = input.nextLine();

        System.out.println("adjective");
        adj4 = input.nextLine();

        System.out.println("plural noun");
        pluralNoun = input.nextLine();

        System.out.println("noun");
        noun3 = input.nextLine();

        System.out.println("number");
        numbSlice = input.nextInt();

        System.out.println("shape");
        input.nextLine();
        shapeName = input.nextLine();

        System.out.println("food");
        foodName1 = input.nextLine();

        System.out.println("food");
        foodName2 = input.nextLine();

        System.out.println("number ");
        numbDay = input.nextInt();

        System.out.println("number");
        numbWeek = input.nextInt();

        numbTotal = numbDay*numbWeek; // Calculates total number of pizzas

        // Prints out final paragraph with the words filled in
        System.out.print("Pizza was invented by a " + adj1 + " " + nationality + " chef named " + personName + ". To make a pizza, you need to take a lump of " +
                         noun1 + ", and make a thin, round " + adj2 + " " + noun2 + ". Then you cover it with " + adj3 + " sauce, " + adj4 +
                         " cheese, and fresh chopped " + pluralNoun + ". Next you have to bake it in a very hot " + noun3 +
                         ". When it is done, cut it into " + numbSlice + " " + shapeName + ". Some kids like " +
                         foodName1 + " pizza the best, but my favorite is the " + foodName2 + " pizza. I eat " + numbDay +
                         " whole pizzas every day that I eat pizza! In fact, I eat pizza " + numbWeek + " days every week! That means I eat " +
                         numbTotal + " pizzas every week!");
    }
}
