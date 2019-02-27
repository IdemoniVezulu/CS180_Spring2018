//NOTE: You will be using the random package for probability
import java.util.Random;
import java.lang.Math;

public class JVarnCoin implements CryptoCurrency
{
	private Demand demand;
	private double interest;
	private double profit;
	private int muns;
	private double worth;

	public JVarnCoin(Demand demand, int muns)
	{
		//Constructor
		this.demand = demand;
		this.muns = muns;
		interest = 0.0;
		profit = this.muns * worth;
		worth = 2.00;
	}

	//Methods required by the CryptoCurrency Interface

	@Override
	public double getProfit()
	{
		return profit;
	}

	@Override
	public double getInterest()
	{
		if(demand == Demand.HIGH) interest = 0.15;
		else if(demand == Demand.ABOVE_AVERAGE) interest = 0.075;
		else if(demand == Demand.BELOW_AVERAGE) interest = -0.075;
		else if(demand == Demand.LOW) interest = -0.15;

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
			if(num.nextInt(99) == 5) muns++;
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