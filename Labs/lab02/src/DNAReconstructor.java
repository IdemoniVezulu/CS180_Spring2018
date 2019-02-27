/**
 * Lab 02 - DNA Reconstructor
 *
 * This is a program to find the longest terminating overlap between
 * a DNA sequence and a DNA sequencer.
 *
 * @author Varun Ramakrishnan, L09
 *
 * @version January 24th, 2018
 *
 */

import java.util.Scanner;

public class DNAReconstructor
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        String  initSeq;
        String  seqncr;
        String  newSeq;
        int     len;

                // Prints message
                System.out.print("Input DNA fragments one line at a time. " +
                                 "\nWe start with no DNA:\n");

                // Prompts user for initial sequence
                System.out.print("\nYour DNA (1): \"\"" +
                                 "\nInitial Sequence: ");
                initSeq = input.nextLine();

                // Converts initial sequence to lower case
                initSeq = initSeq.toLowerCase();

                // Prints initial sequence
                System.out.printf("Your DNA (2): \"%s\"", initSeq);

                // Prompts user for sequencer
                System.out.print("\nSequencer: ");
                seqncr = input.nextLine();

                // Converts sequencer to lower case
                seqncr = seqncr.toLowerCase();

                // Calculates length of sequencer string
                len = seqncr.length();

                // Makes the new string using initial sequence and sequencer (Assume ending of initial sequence and starting of sequencer are same)
                newSeq = initSeq + seqncr.substring(3, len);

                // Prints new sequence
                System.out.printf("New Sequence: %s", newSeq);
    }
}
