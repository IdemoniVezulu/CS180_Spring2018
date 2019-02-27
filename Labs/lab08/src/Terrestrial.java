public class Terrestrial extends Planet
{
    private String  habitability;

    public Terrestrial(double mass, double radius, String name, double distFromSun, String habitability) throws PlutoNotAPlanetException
    {
        super(mass, radius, name, distFromSun);

        this.habitability = habitability;
    }

    public String getHabitability()
    {
        return habitability;
    }

    public void printInfo()
    {
        super.printInfo();
        System.out.printf(" The planet is %s", getHabitability());
    }

    public static void main(String[] args) throws PlutoNotAPlanetException
    {
        Terrestrial t = new Terrestrial(1000, 10, "Sun", 1, "not habitable");

                t.printInfo();
    }
}
