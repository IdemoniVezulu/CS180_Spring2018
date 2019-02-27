import java.util.Scanner;

public class SpiralArray
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
                    System.out.println("Welcome to Spiral Array Generator!");

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
            int     colMin = 0;
            int     colMax = userNum - 1;
            int     rowMin = 0;
            int     rowMax = userNum - 1;
            int     val = 1;

                    while(val < userNum * userNum)
                    {
                        for(int i = colMin; i <= colMax; i++)
                        {
                            genAr[rowMin][i] = val++;
                        }

                        for(int i = rowMin + 1; i <= rowMax; i++)
                        {
                            genAr[i][colMax] = val++;
                        }

                        for (int i = colMax - 1; i >= colMin; i--)
                        {
                            genAr[rowMax][i] = val++;
                        }

                        for (int i = rowMax - 1; i >= rowMin + 1; i--)
                        {
                            genAr[i][colMin] = val++;
                        }

                        colMin++;
                        colMax--;
                        rowMin++;
                        rowMax--;
                    }

                    if(userNum % 2 != 0) genAr[userNum/2][userNum/2] = val;

                    for (int i = 0; i < userNum; i++)
                    {
                        for (int j = 0; j < userNum; j++)
                            System.out.printf("%d\t", genAr[i][j]);

                        System.out.print("\n");
                    }

                    input.nextLine();

                    System.out.println("Do you want to generate another Spiral Array?");
                    userOpt = input.nextLine();

                    while(!userOpt.equalsIgnoreCase("y") && !userOpt.equalsIgnoreCase("n"))
                    {
                        System.out.println("ERROR: input only 'y' or 'n'. Do you want to generate another Spiral Array? (y/n)");
                        userOpt = input.nextLine();
                    }

                    if(userOpt.equalsIgnoreCase("n"))
                    {
                        System.out.println("Thank you for using Spiral Array Generator!");

                        isYes = false;
                    }
        }
    }
}
