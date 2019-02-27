public class Star
{
    private String name;
    private double magnitude;
    private double lightyearsFromEarth;
    private boolean planetsOrbitting;

    public Star(String name, double magnitude, double lightyearsFromEarth, boolean planetsOrbitting)
    {
        this.name = name;
        this.magnitude = magnitude;
        this.lightyearsFromEarth = lightyearsFromEarth;
        this.planetsOrbitting = planetsOrbitting;
    }

    public String getName()
    {
        return name;
    }

    public double getMagnitude()
    {
        return magnitude;
    }

    public double getLightyearsFromEarth()
    {
        return lightyearsFromEarth;
    }

    public boolean getPlanetsOrbiting()
    {
        return planetsOrbitting;
    }
}
