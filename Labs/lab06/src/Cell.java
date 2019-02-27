/**
 * Cell classes
 *
 * This class initializes, sets, and gets the values of each cell.
 *
 * @author Varun Ramakrishnan, L09
 *
 * @version 2/21/18
 *
 **/

public class Cell
{

    private boolean living;

            public Cell(boolean living)
            {
                this.living = living;
            }

            public void setLiving(boolean living)
            {
                this.living = living;
            }

            public boolean getLiving()
            {
                return living;
            }
}
