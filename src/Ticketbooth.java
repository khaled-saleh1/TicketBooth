//-------------------------------------------------------
//Assignment 4 Driver
//Written by: Mario (40210124) & Khaled (40210125)
//COMP 248 Section P ñ Fall 2021
//--------------------------------------------------------

public class Ticketbooth {
	private Tickets Tik = new Tickets();// creating an object Tik from class Tickets
	private OPUSCard[] arrayOpus = new OPUSCard[5]; // creating an array of 5 elements

	//Initialize the variables to use later 
		int i,j,z,y;
		int calculate;
		String opus, tickets;
		boolean sameer;
	
		// Here is the Default constructor
	public Ticketbooth() {
		Tik = null;
		arrayOpus = null;
	}

	// We initialize the Parameter constructor
	public Ticketbooth(Tickets Tik, OPUSCard[] OP) {
		this.Tik = Tik; // Tickets attribute
		
		for (j = 0; j <= OP.length - 1; j++) {
			if (OP[j] == null)
				arrayOpus = null;
			else
				arrayOpus[j] = new OPUSCard(OP[j]); // Create object in array

		}
	}

	// Same value of tickets
	public boolean SameValueTickets(Ticketbooth Billet1) {
		
		return (Tik.ticketTotal() == Billet1.TotalvalueTickets());
	}

	// Same quantity of the same type of tickets
	public boolean Sameamountickets(Ticketbooth Billet1) {
		
		return (Tik.getDaily() == Billet1.Tik.getDaily() && Tik.getJunior() == Billet1.Tik.getJunior() && Tik.getRegular() == Billet1.Tik.getRegular() && Tik.getSenior() == Billet1.Tik.getSenior() && Tik.getWeekly() == Billet1.Tik.getWeekly());
	}

	// Total value of tickets
	public double TotalvalueTickets() {
		return (Tik.ticketTotal()); // Call method ticketTotal from Tickets
	}

	// Number of OUPSCards
	public int OpusQuan() {
		calculate = 0; // Initialize Int
		// To calculate the values that are not null
		for (i = 0; i < arrayOpus.length; i++) {
			if (arrayOpus[i] != null)
				calculate++;
		}
		return calculate;
	}

	// To Add OPUSCards
	public int AddOpus(OPUSCard OC) {
		OPUSCard[] O_array2 = new OPUSCard[arrayOpus.length + 1]; // Make a Copy array
		// Copy the values into the new array
		for (z = 0; z <= arrayOpus.length - 1; z++) {
			O_array2[z] = arrayOpus[z];
		}
		// Add a new OPUSCard
		O_array2[arrayOpus.length - 1] = OC;
		arrayOpus = O_array2;

		return this.OpusQuan(); // Return the number of OPUScards
	}

	
	public boolean RemoveOpus(int index) {// Remove OPUSCards
		sameer = false;
		OPUSCard[] c = new OPUSCard[arrayOpus.length - 1]; 
		// if we don't have cards we can not remove them then 
		
		if (arrayOpus == null)
			sameer = false;

		
		
		else {
			for (i = 0, j = 0; i < arrayOpus.length; i++) { // To skip the index of whatever we don't want 
				if (i != index) {
					c[j++] = arrayOpus[i];
				}
			}
			arrayOpus = c;
			sameer = true;
		}
		return sameer;
	}

	// Update the  expiry month and expiry year of the OPUS Card
	public void UpdateOpus(int op, int month, int year) {
		
		arrayOpus[op].setMonth(month); // To set the new month value 
		arrayOpus[op].setYear(year); // To set the  new year value
	
	}

	// To Add tickets
	public double AddTickets(int reg, int jun, int sen, int daily, int weekly) {
		Tik.addTickets(reg, jun, sen, daily, weekly);
		return (Tik.ticketTotal()); 
		
	}

	// To when they are equal 
	public boolean equals(Ticketbooth T2) {
		
		return (this.TotalvalueTickets() == T2.TotalvalueTickets() && this.OpusQuan() == T2.OpusQuan());
	}

	// We use toString so we can print in our driver 
	public String toString() {
		
		opus = "";
		tickets = "";
		
		if (arrayOpus[0] == null) 
			opus += "No OPUS cards" + "\n";
		else {
			
			for (y = 0; y < arrayOpus.length; y++) {
				
				
				if (arrayOpus[y] != null)
					opus += arrayOpus[y] + "\n";
				
			}
		}
		return Tik + "\n" + opus;

	}


	public String Tickets() {
		
		
		return Tik.getRegular() + " x $3.50" + " + " + Tik.getJunior() + " x $2.50" + " + " + Tik.getSenior() + " x $1.00" + " + " + Tik.getDaily() + " x $10" + " + " + Tik.getWeekly() + " x $40";
	}// return the ticket and how many of each type 

}