//-------------------------------------------------------
//Assignment 4 Driver
//Written by: Mario (40210124) & Khaled (40210125)
//COMP 248 Section P ñ Fall 2021
//--------------------------------------------------------

public class OPUSCard {
	// Here we declare the attributes variables
	private String cardtype;
	private String name;
	private int month;
	private int year;

	// Here is the Default constructor
	public OPUSCard() {
		cardtype = "";
		name = "";
		month = 0;
		year = 0;
	}

	// We initialize the Parameter constructor
	public OPUSCard(String cardtype, String name, int month, int year) {
		this.cardtype = cardtype;
		this.name = name;
		if (month > 12 || month < 1)
			this.month = 0;
		else
			this.month = month;
		this.year = year;
	}

	// This is the  Copy constructor
	public OPUSCard(OPUSCard ba1) {
		this.cardtype = ba1.cardtype;
		this.name = ba1.name;
		this.month = ba1.month;
		this.year = ba1.year;
	}

// Here we are using our getters
	public String getType() {
		return cardtype;
	}

	public String getName() {
		return name;
	}

	public int getMonth() {
		return month;
	}

	
	public int getYear() {
		return year;
	}
	// Here we using our setters
	
	public void setMonth(int month) {
		if (month > 12 || month < 1)
			this.month = 0;
		else
			this.month = month;
	}
	
	public void setYear(int year) {
		this.year = year;
	}

	// Print OPUSCard
	public String toString() {
	
		if (month < 10) // This when the month is less than 10 so we add the zero 
			return cardtype + "-" + name + "-0" + month + "/" + year;

		// if the month is 10 or more 
		else
			return cardtype + "-" + name + "-" + month + "/" + year;
	}

	// Check if The two OPUS Cards are equal
	public boolean equals(OPUSCard c2) {
		return (c2.getType().equals(cardtype) && c2.getName().equals(name) && c2.getMonth() == month && c2.getYear() == year);
	}

}