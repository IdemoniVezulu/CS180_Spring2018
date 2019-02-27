public class SouthernSummerConstellation extends StellarGrouping
{
    private Star[] Stars;

    public SouthernSummerConstellation(String name, Star[] Stars)
    {
        super(name, Stars);

        this.Stars = Stars;
    }

    @Override
    public boolean isVisible(Month month)
    {
        boolean isVisible = false;

        if(month == Month.NOVEMBER ||
           month == Month.DECEMBER ||
           month == Month.JANUARY ||
           month == Month.FEBRUARY ||
           month == Month.MARCH ||
           month == Month.APRIL)
            isVisible = true;

        return isVisible;
    }

    @Override
    public String planetsOrbiting()
    {
        String isOrbiting = "Unknown";

        for(int i = 0; i < Stars.length; i++)
        {
            if(Stars[i].getPlanetsOrbiting()) isOrbiting = "Yes";
        }

        return isOrbiting;
    }
}
