public interface CryptoCurrency
{

    public double getProfit();

    public double getInterest();

    public void assessProfit();

    public void mine(int attempts);

    public Demand getDemand();

    public void setDemand(Demand demand);

    public void purchase(int coin);
}