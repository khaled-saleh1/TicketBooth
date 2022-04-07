//-------------------------------------------------------
//Assignment 4 Driver
//Written by: Mario (40210124) & Khaled (40210125)
//COMP 248 Section P ñ Fall 2021
//--------------------------------------------------------

public class Tickets {
	// Since these numbers are not changing they are final, and since it is a
	// variable it is private
	private final static double rgl = 3.50;
	private final static double jr = 2.50;
	private final static double sr = 1;
	private final static double dly = 10;
	private final static double wkly = 40;

	// These are the quantity of each ticket and they are a double since they are
	// not integers
	private double Regular;
	private double Junior;
	private double Senior;
	private double Daily;
	private double Weekly;

	// Putting our default constructor, and its name is after the class name
	public Tickets() {
		Regular = 0;
		Junior = 0;
		Senior = 0;
		Daily = 0;
		Weekly = 0;
	}

	// This constructor is for the parameters
	public Tickets(int Reg, int Jun, int Sen, int Dai, int wee) {
		this.Regular = Reg;
		this.Junior = Jun;
		this.Senior = Sen;
		this.Daily = Dai;
		this.Weekly = wee;
	}

	// Making a copy
	public Tickets(Tickets ta1) {
		this.Regular = ta1.Regular;
		this.Junior = ta1.Junior;
		this.Senior = ta1.Senior;
		this.Daily = ta1.Daily;
		this.Weekly = ta1.Weekly;
	}

	// Here we are using our getters 
	public double getRegular() {
		return Regular;
	}

	public double getJunior() {
		return Junior;
	}

	public double getSenior() {
		return Senior;
	}

	public double getDaily() {
		return Daily;
	}

	public double getWeekly() {
		return Weekly;
	}
   // Here we are using our setters
	public void setRegular(double reg) {
		Regular = reg;
	}

	public void setJunior(double jun) {
		Junior = jun;
	}

	public void setSenior(double sen) {
		Senior = sen;
	}

	public void setDaily(double daiy) {
		Daily = daiy;
	}

	public void setWeekly(double weey) {
		this.Weekly = weey;
	}

	// Here we are incrementing the variables
	public void addTickets(int awal, int tani, int talet, int rabe, int khames) {
		this.Regular += awal;
		this.Junior += tani;
		this.Senior += talet;
		this.Daily += rabe;
		this.Weekly += khames;
	}

	// This calculates the sum
	public double ticketTotal() {
		double sum = 0;
		sum = (Regular * rgl) + (Junior * jr) + (Senior * sr) + (Daily * dly) + (Weekly * wkly);
		return sum;
	}

	// This method prints out the ticket information
	public String toString() {
		return Regular + " x $" + rgl + " + " + Junior + " x $" + jr + " + " + Senior + " x $" + sr + " + " + Daily + " x $" + dly + " + " + Weekly + " x $" + wkly;
	}

	// This method checks whether or not they are equal or not
	public boolean equals(Tickets ta1) {
		return (ta1.getRegular() == Regular && ta1.getJunior() == Junior && ta1.getSenior() == Senior && ta1.getDaily() == Daily && ta1.getWeekly() == Weekly);

	}
}