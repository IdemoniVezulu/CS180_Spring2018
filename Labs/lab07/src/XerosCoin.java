//NOTE: You will be using the random package for probability
import java.util.Random;
import java.lang.Math;

public class XerosCoin implements CryptoCurrency
{
	private Demand demand;
	private double interest;
	private double profit;
	private int muns;
	private double worth;

	public XerosCoin(Demand demand, int muns)
	{
		//TODO: Implement Constructor
		this.demand = demand;
		this.muns = muns;
		interest = 0.0;
		profit = this.muns * worth;
		worth = 0.75;
	}

	//TODO: Implement methods required by the CryptoCurrency Interface
	@Override
	public double getProfit()
	{
		return profit;
	}

	@Override
	public double getInterest()
	{
		if(demand == Demand.HIGH) interest = 0.05;
		else if(demand == Demand.ABOVE_AVERAGE) interest = 0.025;
		else if(demand == Demand.BELOW_AVERAGE) interest = -0.025;
		else if(demand == Demand.LOW) interest = -0.05;

		return interest;
	}

	public void assessProfit()
	{
		profit += worth * muns * Math.pow((1 + getInterest()/3), 9);
	}

	public void mine(int attempts)
	{
		Random num = new Random();

		for(int i = 0; i < attempts; i++)
		{
			if(num.nextInt(25) == 5) muns++;
		}
	}

	@Override
	public Demand getDemand()
	{
		return demand;
	}

	public void setDemand(Demand demand)
	{
		this.demand = demand;
	}

	public void purchase(int coin)
	{
		profit -= coin * worth;
	}
}