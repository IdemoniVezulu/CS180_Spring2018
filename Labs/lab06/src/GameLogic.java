import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Game Logic
 *
 * This program contains all the logic for Conway's Game of Life
 *
 * @author Varun Ramakrishnan, L09
 *
 * @version 2/21/18
 *
 **/

public class GameLogic
{
    static Cell grid[][];

    static Cell gridUpdate[][];

    public GameLogic()
    {
        Random  rand1 = new Random(3);

        grid = new Cell[100][100];
        gridUpdate = new Cell[100][100];

        for(int i = 0; i < 100; i++)
        {
            for(int j = 0; j < 100; j++)
            {
                gridUpdate[i][j] = new Cell(false);
            }
        }

        for(int i = 0; i < 100; i++)
        {
            for(int j = 0; j < 100; j++)
            {
                int     numOne = rand1.nextInt(11);

                if(numOne == 1) grid[i][j] = new Cell(true);
                    else grid[i][j] = new Cell(false);
            }
        }
    }

    public boolean liveToNext(int m, int n)
    {
        int     cLive = 0;
        boolean isAlive = false;

        if(m > 1 && n > 1 && m < 99 && n < 99)
        {
            for (int i = m - 1; i <= m + 1; i++)
            {
                for (int j = n - 1; j <= n + 1; j++)
                {
                    if (grid[i][j].getLiving()) cLive++;
                }
            }
        }
        else if( m == 0 && n == 0)
        {
            for(int i = 0; i < 2; i++)
            {
                for(int j = 0; j < 2; j++)
                {
                    if(grid[i][j].getLiving()) cLive++;
                }
            }
        }
        else if(m == 0 && n == grid.length - 1)
        {
            for(int i = 0; i < 2; i++)
            {
                for(int j = grid.length - 1; j >= grid.length - 2; j--)
                {
                    if(grid[i][j].getLiving()) cLive++;
                }
            }
        }
        else if(m == grid.length - 1 && n == 0)
        {
            for(int i = m; i >= grid.length - 2; i--)
            {
                for(int j = 0; j < 2; j++)
                {
                    if(grid[i][j].getLiving()) cLive++;
                }
            }
        }
        else if(m == grid.length - 1 && n == grid.length - 1)
        {
            for(int i = grid.length - 1; i >= grid.length - 2; i--)
            {
                for(int j = grid.length - 1; j >= grid.length - 2; j--)
                {
                    if(grid[i][j].getLiving()) cLive++;
                }
            }
        }
            else if((m > 0 || m < grid.length - 1) && n == 0 )
            {
                for (int i = m; i >= m - 1; i--)
                {
                    for (int j = n; j <= n + 1; j++)
                    {
                        if (grid[i][j].getLiving()) cLive++;
                    }
                }
            }
                else if((m > 0 || m < grid.length - 1) && n == grid.length - 1)
                {
                    for (int i = m; i >= m - 1; i--)
                    {
                        for (int j = n; j >= n - 1; j--)
                        {
                            if (grid[i][j].getLiving()) cLive++;
                        }
                    }
                }

        if(cLive == 1) isAlive = false;
            else if(cLive == 3 || cLive == 4) isAlive = true;
                else if(cLive >= 4) isAlive = false;
                    if(!grid[m][n].getLiving() && cLive == 3) isAlive = true;

        return isAlive;
    }

    /*You do not need to modify any of the below code!*/
    public void update() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (liveToNext(i, j)) {
                    gridUpdate[i][j].setLiving(true);
                } else {
                    gridUpdate[i][j].setLiving(false);
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j].setLiving(gridUpdate[i][j].getLiving());
            }
        }
    }

    public static JFrame frame = new JFrame();
    public static JPanel[][] gridGUI;

    public void initGridGUI() {
        gridGUI = new JPanel[grid.length][grid[0].length]; //allocate the size of grid
        frame.setLayout(new GridLayout(grid.length, grid[0].length)); //set layout
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                gridGUI[i][j] = new JPanel(); //creates new panel
                gridGUI[i][j].setBackground(Color.white);
                frame.add(gridGUI[i][j]);
            }
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); //sets appropriate size for frame
        frame.setLocationRelativeTo(null);
        frame.setTitle("Conway's Game of Life");
        frame.setVisible(true);
    }

    public void printGridGUI() {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].getLiving()) {
                    gridGUI[i][j].setBackground(Color.black);
                } else {
                    gridGUI[i][j].setBackground(Color.white);
                }
            }
        }
    }

    public void printGrid() {

        for (int i = 0; i < grid.length; i++) {
            if (i == 0) {
                for (int k = 0; k < grid[i].length + 1; k++) {
                    System.out.print("-");
                }
                System.out.println("-");
            }
            for (int j = 0; j < grid[i].length; j++) {
                if (j == 0) {
                    System.out.print("|");
                }
                if (j == grid[i].length - 1) {
                    if (grid[i][j].getLiving()) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                    System.out.println("|");
                } else {
                    if (grid[i][j].getLiving()) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            if (i == grid.length - 1) {
                for (int k = 0; k < grid[i].length; k++) {
                    System.out.print("-");
                }
                System.out.println("-");
            }
        }
    }
}