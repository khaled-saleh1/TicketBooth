//-------------------------------------------------------
//Assignment 4 Driver
//Written by: Mario El Shaer (40210124) & Khaled Saleh (40210125)
//COMP 248 Section P ñ Fall 2021
//This Program will resemble a metro system ticketbooth that calculates prices and displays to the user
//This program has 3 other classes (aside from the main) called Ticketbooth, OPUSCard, Tickets
//--------------------------------------------------------

import java.util.Scanner; //importing scanner

public class driver {

	public static void main(String[] args) {

		Scanner read = new Scanner(System.in); // making a scanner called read

		boolean mario = true;// assigning a true value to the boolesan variable to mario loops
		int response = 0; // Declare an integer
		int rakam1, rakam2,rakam3,rakam4,rakam5;
		int j,i, BT;
		int tboot;
		int index;
		boolean khaled;
		int month, year;
		int meem, ya2;
		int nubcard, nubticket, numcard;
		// Here we are creating tickets We will make some are equal in price  or distribution 
		Tickets tick0 = new Tickets(2, 2, 2, 2, 2);
		Tickets tick1 = new Tickets(2, 2, 2, 10, 0); 
		Tickets tick2 = new Tickets(2, 2, 2, 2, 2); 
		Tickets tick3 = new Tickets(2, 1, 3, 4, 0); 
		Tickets tick4 = new Tickets(2, 1, 3, 4, 0);

		// Here we are creating object of OpusCards "object":
		OPUSCard O0 = new OPUSCard("STM", "Khaled", 01, 2021);
		OPUSCard O1 = new OPUSCard("STL", "Mario", 02, 2021);
		OPUSCard O2 = new OPUSCard("REM", "Alex", 11, 2021);
		OPUSCard O3 = new OPUSCard();
		OPUSCard O4 = new OPUSCard();

		// Here we are creating arrays of object OPUSCards
		OPUSCard[] arrayA = { O0, O1 };
		OPUSCard[] arrayB = { O0, O1 };
		OPUSCard[] arrayC = { O0, O1, O2 };
		OPUSCard[] arrayD = {};

		// Here we are creating new 5 ticketbooths:
		Ticketbooth TA = new Ticketbooth(tick0, arrayA);
		Ticketbooth TB = new Ticketbooth(tick2, arrayB);
		Ticketbooth TC = new Ticketbooth(tick1, arrayC);
		Ticketbooth TD = new Ticketbooth(tick3, arrayD);
		Ticketbooth TE = new Ticketbooth(tick4, arrayD);

		// Put Ticketbooths khaled array
		Ticketbooth[] booth_array = { TA, TB, TC, TD, TE };

		// Intro message
		System.out.println("===================================================================");
		System.out.println("Welcome to Concordia 2021 Fall Geek's Ticketbooth Application");
		System.out.println("===================================================================");

		// This is the biggest while loop we have
		
		if (response >= 0 && response <= 9) {
			
			while (mario) {
				// Menu that the user will see while using the program 
				System.out.println("What would you like to do?");
				System.out.println("1. See the content of all Ticketbooths");
				System.out.println("2. See the content of one Ticketbooth");
				System.out.println("3. List Ticketbooths with same amount of tickets' values");
				System.out.println("4. List Ticketbooths with same Tickets amount");
				System.out.println("5. List Ticketbooths with same amount of tickets values and same number of OPUS cards");
				System.out.println("6. Add a OPUS card to an existing Ticketbooth");
				System.out.println("7. Remove an existing OPUS card from Ticketbooth");
				System.out.println("8. Update the expiry date of an existing OPUS card");
				System.out.println("9. Add Tickets to a Ticketbooth");
				System.out.println("0. To quit");
				System.out.println("Please enter your choice and press <Enter>: ");
				response = read.nextInt();

				
				
				if (response < 0 || response > 9) {// here if the user put invalid choice
					System.out.println("Sorry that is not a valid choice. Try again.");
					mario = true;
				}

				// Here we start declaring the cases
				
				switch (response) {
				
				
				
				case 1:// Case 1 is to print all in Ticketbooth
					System.out.println(" Content of each Ticketbooth");
					System.out.println("------------------------------");
					System.out.println(TA);
					System.out.println(TB);
					System.out.println(TC);
					System.out.println(TD);
					System.out.println(TE);
					break;
	
								
				case 2:// Case 2 Is to print one specific in the ticketbooth not all 
					System.out.println("Which Ticketbooth do you want to see the content of? (Enter number 0 to 4) "); 
					index = read.nextInt(); 
					khaled = true; // Initialize boolean
					
					if (index > booth_array.length - 1 | index < 0) {// To make sure the user will enter a valid choice
						khaled = false;
					}
					while (!khaled) {
						System.out.println("Try again: (Enter number 0 to 4): ");
						index = read.nextInt();
						if (index > 0 && index <= booth_array.length - 1)
							khaled = true;
					}
					System.out.println(booth_array[index]);
					break;
				
				
				case 3: //case 3  is to display the Ticketbooth with the same amount of money 
					System.out.println("List of Ticketbooths with same amount of money: "); 
					
					for ( i = 0; i < booth_array.length; i++) {
						for ( j = i + 1; j < booth_array.length; j++) {
							if (booth_array[i].SameValueTickets(booth_array[j]))//To check value of the tickets
																					
								System.out.println("Ticketbooth " + i + " and " + j + " both have "
										+ booth_array[i].TotalvalueTickets()); 
							else
								continue;
						}

					}
					break;
				
				
				case 4:// case 4 is to Equal ticket distribution ticketbooth
					System.out.println("List of Ticketbooths with same Tickets amount: ");
					// To look for tickebooths that have same ticket distribution
					for ( i = 0; i < booth_array.length; i++) {
						for (j = i + 1; j < booth_array.length; j++) {
							if (booth_array[i].Sameamountickets(booth_array[j])) 
								System.out.println(
										"Ticketbooths " + i + " and " + j + " both have " + booth_array[i].Tickets()); 
							else
								continue;
						}

					}
					break;
				
				
				case 5: // case 5 is for Equal ticketbooth
				
					for (i = 0; i < booth_array.length; i++) {// to check if equals
						for (j = i + 1; j < booth_array.length; j++) {
							if (booth_array[i].equals(booth_array[j])) 
								System.out.println("Ticketbooth " + i + " and " + j); // To print out the equal ticketbooth 
							else
								continue;
						}

					}
					break;
				
				
				case 6://Case 6 is To Add OPUSCard
					System.out.println("Which Ticketbooth do you want to add a OPUS card to? (Enter 0 to 4): ");
					tboot = read.nextInt(); // The user has to choose which one he want to add to 
					if (tboot >= booth_array.length || tboot < 0) {
						do {
							System.out.println("This ticketbooth does not exist");
							System.out.println("This input is invalid. Please try again --> ");// Id the user input an invalid choice 
							tboot = read.nextInt();
						} while (tboot >= booth_array.length - 1 || tboot < 0);
					}
					System.out.println(
							"Please enter the following information so that we may complete the transaction- ");
					System.out.println("--> Type of OPUS card (STL, RTL, etc...");
					String type = read.next(); //Ask the user for the type of card they want to add
					System.out.println("--> Full name on OPUS card: ");
					String name = read.next() + read.nextLine(); //Ask the user for full name
					System.out.println("--> Expiry month number and year (seperate by a space): ");
					month = read.nextInt(); //Ask the user for the expiry month
					year = read.nextInt(); //Ask the user for the expiry year

					OPUSCard O_0 = new OPUSCard(type, name, month, year); // To add the opus card to whatever we have 

					int length = booth_array[tboot].AddOpus(O_0); // to make sure the value of variable length sets
					System.out.println("You know have " + length + " Opus cards"); // To print how many OPUS cards we have 
					break;

				
				
				case 7:// Case7 is To Remove opus card if needed
					System.out.println(
							"Which Ticketbooth do you want to remove a OPUS card from? (Enter number 0 to 4): ");
					BT = read.nextInt();// Ticketbooth
					if (BT >= booth_array.length - 1 || BT  < 0) {
						do {
							System.out.println("This ticketbooth does not exist");
							System.out.println("Try again ! ");
							BT  = read.nextInt();
						} while (BT  >= booth_array.length - 1 || BT  < 0);
					}
					if (booth_array[BT].OpusQuan() == 0) { // If ticketbooth has no cards then there is no card to remove
						System.out.println("Sorry that Ticketbooths has no cards");
						break;
					}
					// Has opus cards
					else {
						System.out.println("(Enter card number 0 to " + (booth_array[BT ].OpusQuan() - 1) + ")");
						 numcard = read.nextInt(); // to choose the card number to be removed 
						booth_array[BT ].RemoveOpus(numcard); 
					}
					System.out.println("Card was removed successfully");
					break;
				
				
				case 8:// case 8 is to Update the OPUSCard
					System.out.println(
							"Which Ticketbooth do you want to update a OPUS card from? (Enter number 0 to 4): ");
					nubticket = read.nextInt(); // The user has to choose which one they want to update
					if (nubticket >= booth_array.length - 1 || nubticket < 0) {
						do {
							System.out.println("This ticketbooth does not exist");
							System.out.println("Try again !");
							nubticket = read.nextInt();
						} while (nubticket >= booth_array.length - 1 || nubticket < 0);
					}
					if (booth_array[nubticket].OpusQuan() == 0) {
						do {
							System.out.println("This ticketbooth has no opus cards");
							System.out.println("Try again !");
							nubticket = read.nextInt();
						} while (booth_array[nubticket].OpusQuan() == 0);
					}

					System.out.println("Which card do you want to update? (Enter card number 0 to "
							+ (booth_array[nubticket].OpusQuan() - 1) + ")"); 
					nubcard = read.nextInt(); 
					
					if (nubcard > (booth_array[nubticket].OpusQuan() - 1) || nubcard < 0) {
						do {// If user enters invalid input it will keep asking for input
							System.out.println("Sorry but there is no card number " + nubcard);
							System.out.println("--> Try again:");
							System.out.println("(Enter card number 0 to " + (booth_array[nubticket].OpusQuan() - 1) + ")"); 
							
							
							nubcard = read.nextInt();
						} while (nubcard > (booth_array[nubticket].OpusQuan() - 1) || nubcard < 0); 
					}
					// Ask the user for new info that they want to update
					System.out.println("Enter new expiry month number and year (seperate by a space): ");
					meem = read.nextInt(); // The month 
					ya2 = read.nextInt(); // The year
					booth_array[nubticket].UpdateOpus(nubcard, meem, ya2); 

					System.out.println("Expiry date updated."); 
					break;
				
				
				case 9: // Case 9 is to Add tickets 
					System.out.println("Which Ticketbooth do you want to add tickets to? (Enter 0 to 4): ");
					j = read.nextInt(); // Ticketbooth number that the user want to add tickets to 
					System.out.println("How many regular, junior, senior, daily and weekly do you want to add? ");
					System.out.println("Enter 5 numbers seperated by a space: ");
					
					rakam1 = read.nextInt(); //rakam 1 refers to number 1 
					rakam2 = read.nextInt();
					rakam3 = read.nextInt();
					rakam4 = read.nextInt();
					rakam5 = read.nextInt();
					booth_array[j].AddTickets(rakam1, rakam2,rakam3,rakam4,rakam5); 
					System.out.println("You now have $" + booth_array[j].TotalvalueTickets());
					break;
			
				
				case 0: //Case 0 is for when the user wants to quit the program and end it 
					System.out.println("Thank you for using Concordia Fall Geek's Ticketbooth application"); // Goodbye message for the user 
																												
					System.exit(0); // Quit program
				}
			}

		}
 read.close();
	} // Close main method

}
//Close class 