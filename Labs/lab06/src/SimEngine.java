/**
 * Simulates Engine
 *
 * This program contains the main part that uses GameLogic and Cell to actually
 * show Conway's Game of Life.
 *
 * @author Varun Ramakrishnan, L09
 *
 * @version 2/21/18
 *
 **/
public class SimEngine
{
    public static void main(String[] args)
    {
        GameLogic   var = new GameLogic();
        boolean     isTru = true;

        var.initGridGUI();

        sleepMethod(20);

        while(isTru)
        {
            var.update();
            var.printGridGUI();
            sleepMethod(20);
        }
    }


	/*You do not need to modify any of the below code!*/

    public static void sleepMethod(int duration){
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }
}
