/**
 * Lab 02 - Protein Validator
 *
 * This is a program to validate proteins.
 *
 * @author Varun Ramakrishnan, L09
 *
 * @version January 24th, 2018
 *
 */

import java.util.Scanner;

public class ProteinValidator
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        String      dnaFrag;
        int         indxAtg;
        String      geneSeq;
        boolean     valProt = false;

                    // Asks user for DNA Fragment and reads input
                    System.out.print("Input the DNA fragment to be validated: ");
                    dnaFrag = input.nextLine();

                    // Prints the input DNA
                    System.out.printf("Input DNA: %s", dnaFrag);

                    // Converts input string to lower case
                    dnaFrag = dnaFrag.toLowerCase();

                    // Finds and prints the position of the first codon
                    indxAtg = dnaFrag.indexOf("atg");
                    System.out.printf("\nStart codon position: %d", indxAtg);

                    // Prints substring starting from position of first codon
                    geneSeq = dnaFrag.substring(indxAtg);
                    System.out.printf("\nGene: %s", geneSeq);

                    // Validates protein by checking the end sequence
                    if(geneSeq.endsWith("tag") || geneSeq.endsWith("taa") || geneSeq.endsWith("tga"))
                       valProt = true;

                    // Prints the validation
                    System.out.printf("\nProtein: %b", valProt);
    }
}
