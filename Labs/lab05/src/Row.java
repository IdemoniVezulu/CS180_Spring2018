import java.util.Scanner;

public class Row
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int       userNum = 0;
        boolean   isTrue = true;
        boolean   isYes = true;
        String    userOpt;

                while(isYes)
                {
                    System.out.println("Welcome to Row Printer!");

                    System.out.println("What dimensions would you like?");
                    userNum = input.nextInt();

                    while (isTrue)
                    {
                        if (userNum > 0) isTrue = false;
                        else
                            {
                                System.out.println("Please enter an integer greater than or equal to 1. How many rows do you want?");
                                userNum = input.nextInt();
                            }
                    }

                    int[][] genAr = new int[userNum][userNum];

                    for (int i = 0; i < userNum; i++)
                        for (int j = 0; j < userNum; j++)
                        {
                            genAr[0][j] = j + 1;
                            if (i != 0) genAr[i][j] = 0;
                        }

                    for (int i = 0; i < userNum; i++)
                    {
                        for (int j = 0; j < userNum; j++)
                            System.out.printf("%d\t", genAr[i][j]);

                        System.out.print("\n");
                    }

                    input.nextLine();

                    System.out.println("Do you want to generate another row?");
                    userOpt = input.nextLine();

                    while(!userOpt.equalsIgnoreCase("y") && !userOpt.equalsIgnoreCase("n"))
                    {
                        System.out.println("ERROR: input only 'y' or 'n'. Do you want to generate another Row? (y/n)");
                        userOpt = input.nextLine();
                    }
                    if(userOpt.equalsIgnoreCase("n"))
                    {
                        System.out.println("Thank you for using Row Generator!");

                        isYes = false;
                    }
                }
    }
}
