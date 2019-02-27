public class Planet
{
    private double  mass;
    private double  radius;
    private String  name;
    private double  distFromSun;

    public Planet(double mass, double radius, String name, double distFromSun) throws PlutoNotAPlanetException
    {
        this.mass = mass;
        this.radius = radius;
        this.name = name;
        this.distFromSun = distFromSun;

        if(name.equals("pluto")) throw new PlutoNotAPlanetException("Sorry Pluto...");
    }

    public double getVolume()
    {
        double  volume;

                volume = (4.0 / 3.0) * (Math.PI * Math.pow(radius, 3));

        return  volume;
    }

    public double getDensity()
    {
        double  density;

                density = mass / getVolume();

        return  density;
    }

    public double getDistFromSun()
    {
        return distFromSun;
    }

    public double distToPlanet(Planet otherPlanet)
    {
        double  distToPlanet;

                if(otherPlanet.distFromSun > this.distFromSun) distToPlanet = otherPlanet.distFromSun - this.distFromSun;
                else distToPlanet = this.distFromSun - otherPlanet.distFromSun;

        return  distToPlanet;
    }

    public String getName()
    {
        return name;
    }

    public void printInfo()
    {
        System.out.printf("This is the planet %s. It is %.2f AU from the Sun. It has density of %.2f kg/m^3.", name, distFromSun, getDensity());
    }
}
