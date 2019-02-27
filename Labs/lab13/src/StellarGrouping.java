public abstract class StellarGrouping
{
    private String name;
    private Star[] Stars;

    public StellarGrouping(String name, Star[] Stars)
    {
        this.name = name;
        this.Stars = Stars;
    }

    public String planetsOrbiting()
    {
        String  inOrbit = "Unknown";


        return inOrbit;
    }

    public Star brightestStar()
    {
        Star    brightest = null;
        double  magnitude = Stars[0].getMagnitude();

                for(int i = 1; i < Stars.length; i++)
                {
                    if(magnitude > Stars[i].getMagnitude())
                    {
                        magnitude = Stars[i].getMagnitude();
                        brightest = Stars[i];
                    }
                }

        return brightest;
    }

    public abstract boolean isVisible(Month month);

    public double distanceFromEarth(String starName)
    {
        double  dist = -1;

        for(int i = 0; i < Stars.length; i++)
        {
            if(Stars[i].getName().equals(starName))
            {
                dist = Stars[i].getLightyearsFromEarth() * 5.878625;
            }
        }

        return dist;
    }

    public double distanceFromEarth(Star s)
    {
        double  dist = -1;

        for(int i = 0; i < Stars.length; i++)
        {
            if(Stars[i].equals(s))
            {
                dist = Stars[i].getLightyearsFromEarth() * 5.878625;
            }
        }

                //dist = s.getLightyearsFromEarth() * 5.878625;

        return dist;
    }

    public double furthestStar()
    {
        double  dist = distanceFromEarth(Stars[0]);

                for(int i = 1; i < Stars.length; i++)
                {
                    if(dist < distanceFromEarth(Stars[i]))
                    {
                        dist = distanceFromEarth(Stars[i]);
                    }
                }

        return dist;
    }

    public String getName()
    {
        return name;
    }

    public Star[] getStars()
    {
        return Stars;
    }
}
