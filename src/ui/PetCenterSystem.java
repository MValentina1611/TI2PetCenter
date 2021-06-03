package ui;

import java.util.Scanner;
import model.PetCenter;
import model.Status;
import model.Species;     
import model.Priority;

public class PetCenterSystem{

	//Attributes:
	private Scanner reader;

	/**
	* Indicates how many pets left the PetCenter without attention <br>
	*/
	private int countWA;

	/**
	* Indicates how many pets were registered with priority1 <br>
	*/
	private int countPriority1;

	/**
	* Indicates how many pets were registered with priority2 <br>
	*/
	private int countPriority2;

	/**
	* Indicates how many pets were registered with priority3 <br>
	*/
	private int countPriority3;

	/**
	* Indicates how many pets were registered with priority4 <br>
	*/
	private int countPriority4;

	/**
	* Indicates how many pets were registered with priority5 <br>
	*/
	private int countPriority5;
	

	//Relationships:

	/**
	*Relationship between ui and model packages<br>
	*/
	private PetCenter petCenter;


	/**
	* Initialize the attributes and relationships <br>
	* <b> pre:</b> Constants must be declared <br>
	* <b> pos:</b> Global variables are initialized <br>
	*/
	public PetCenterSystem()
	{
		reader = new Scanner(System.in);
		petCenter = new PetCenter();	
		countWA = 0;
		countPriority1 = 0;
		countPriority2 = 0;
		countPriority3 = 0;
		countPriority4 = 0;
		countPriority5 = 0;

	}

	//Method main start.
	public static void main( String args [] )
	{
		System.out.println("The App is initializing...");
		
		PetCenterSystem pcs = new PetCenterSystem();
		
		int menuOp = 0;

		do
		{
			menuOp = pcs.showMenu();
			pcs.executeOptions(menuOp);

		}while( menuOp != 0 );
				
	}//Main method ends.



	/**
	* Displays menu, and catch the option choosen by the user <br>
	* <b> pre:</b> reader must be initialized <br>
	* <b> pos:</b> no changes on global variables <br>
	* @return munuOp int, return the variable with the option choosen by the user
	*/
	public int showMenu() 
	{
		int menuOp = 0;

		System.out.println(
			"Pick an option \n" +
			"(1) Register a Vet\n" +
			"(2) Delete a Vet\n"+
			"(3) Register a Pet\n" +								
			"(4) Remove a pet from the center\n"+
			"(5) Start a Consultation\n"+
			"(6) Finalize a Consultation\n"+
			"(7) Show the number of pets that have not been cared for\n"+
			"(8) Center Closure\n"+
			"(0) Exit");

		menuOp = reader.nextInt();
		reader.nextLine();
		return menuOp;

	}//Method ends
	

	/**
	* Execute the methods required for accomplish each option <br>
	* <b> pre:</b> global variables must be initialized. Depends of each option <br>
	* <b> pos:</b> no changes on global variables. Depends of each option <br>
	* @param menuOp int
	*/
	
	public void executeOptions(int menuOp) 
	{
		
		switch( menuOp ) 
		{
			case 0:
				System.out.println(" Finished. Bye ");
				break;
			case 1:
				registerVet();
				break;
			case 2:
				deleteVetPCS();
				break;
	
			case 3:
				registerPet();
				break;
		
			case 4:
				removeAPet();
				break;

			case 5:
				startAConsultation();
				break;

			case 6:
				finalizeAConsultation();
				break;
			
			case 7:
				System.out.println( "The number of pets that have not been cared for is: " + countPetForCare() );
				System.out.println( petCenter.showPets());
				break;
			
			case 8:
				showReports();
				break;

			default:
				System.out.println("Error, invalid option");
		}//Switch ends
 		
	}//Method ends
	

	/**
	* Asks for the vet's data, and call the necessary method to add it to the array <br>
	* <b> pre:</b> vet array must be initialized<br>
	* <b> pos:</b> no changes on global variables <br>
	*/

	public void registerVet()
	{
		if( petCenter != null )
		{
			if( petCenter.verifyVet() == false )
			{
				System.out.println("\n\t--ERROR--\nYou have reached the limit of registered veterinarians: 7 ");	
			}

			else
			{
				//Inputs.
				String idVet = "";
 				String name = "";
 				String lastname = "";
 				String uniqueVetRegister = "";

				System.out.println("\t--Enter the Vet's data--\n");
				System.out.println("\n\tid: ");
				idVet = reader.nextLine();
	
				System.out.println("\n\tName: ");
				name = reader.nextLine();

				System.out.println("\n\tLastname: ");
				lastname = reader.nextLine();

				System.out.println("\n\tUnique Vet Register: ");
				uniqueVetRegister = reader.nextLine();

				petCenter.addVet( idVet, name, lastname, uniqueVetRegister );
				System.out.println("\n\tThe vet has been registered ");
			}

		}

	}
	

	/**
	* Asks for the pet's data, and call the necessary method to add it to the array <br>
	* <b> pre:</b> pet array must be initialized<br>
	* <b> pos:</b> no changes on global variables <br>
	*/

	public void registerPet()
	{	
		//Ask for owner:
		//Inputs.
		String  fullName,
			idOwner,
			phone,
			address;

		System.out.println("\n\t--Enter the Owner's Data-- ");

		System.out.println( "\n\tName: ");
		fullName = reader.nextLine();

		System.out.println( "\n\tId: " );
		idOwner = reader.nextLine();

		System.out.println( "\n\tPhone: ");
		phone = reader.nextLine();
		
		System.out.println( "\n\tAddres: " );
		address = reader.nextLine();
	
		//Ask for Pet:
		//Inputs.
		String  name, 
			age,
			symptom,
			species,
 			petBreed;

		System.out.println("\n\t--Enter the Pet's Data-- ");

		System.out.println("\n\tName: ");
		name = reader.nextLine();

		System.out.println("\n\tAge: ");
		age = reader.nextLine();

		System.out.println("\n\tSpecies: ");
		species = reader.nextLine();
		
		System.out.println("\n\tEnter the Symptoms: ");
		symptom = reader.nextLine();

		boolean created = false;

		//Create pet:
		

			if( species.equalsIgnoreCase("Dog") )
			{	
				petBreed = askForBreed();
				petCenter.addPet( name, age, petBreed, symptom, idOwner, fullName, phone, address, Status.WAITING_TO_BE_ATTENDED, Species.DOG, Priority.BLUE_5 );
				created = true;	
			}

			if( species.equalsIgnoreCase("Cat") )
			{	
				petBreed = askForBreed();
				petCenter.addPet( name, age, petBreed, symptom, idOwner, fullName, phone, address, Status.WAITING_TO_BE_ATTENDED, Species.CAT, Priority.BLUE_5 );
				created = true;		
			}

			if( species.equalsIgnoreCase("Rabbit") )
			{
				petCenter.addPet( name, age, symptom, idOwner, fullName, phone, address, Status.WAITING_TO_BE_ATTENDED, Species.RABBIT, Priority.BLUE_5 );
				created = true;	
			}

			if( species.equalsIgnoreCase("Reptile") )
			{
				petCenter.addPet( name, age, symptom, idOwner, fullName, phone, address, Status.WAITING_TO_BE_ATTENDED, Species.REPTILE, Priority.BLUE_5 );
				created = true;	
			}
		
			if( species.equalsIgnoreCase("Bird") )
			{
				petCenter.addPet( name, age, symptom, idOwner, fullName, phone, address, Status.WAITING_TO_BE_ATTENDED, Species.BIRD, Priority.BLUE_5 );
				created = true;	
			}
		
		
			selectPriority( name );	

			if( created != false )
			{
				System.out.println("The Pet was registered");
			}
			else
			{
				System.out.println(" ERROR ");
			}
		
		

	}//Method ends
		

	//Ask for priority:

	/**
	* Assigns a priority an each pet<br>
	* <b> pre:</b> pet must be created<br>
	* <b> pos:</b> no changes on global variables <br>
	* @param name String
	*/

	public void selectPriority( String name )
	{
		int choosePriority = 0;

		System.out.println(" Choose priority ");
		System.out.println(
				"(1) Priority 1 or Red\n" +
				"(2) Priority 2 or Orange\n"+
				"(3) Priority 3 or Yellow\n" +				
				"(4) Priority 4 or Green\n"+
				"(5) Priority 5 or Blue\n");

		choosePriority = reader.nextInt();
		reader.nextLine();
			
		switch( choosePriority )
		{
			case 1:
				petCenter.setPriority( name, Priority.RED_1 );
				
				break;
			case 2:
				petCenter.setPriority( name, Priority.ORANGE_2 );
				break;
	
			case 3:
				petCenter.setPriority( name, Priority.YELLOW_3 );
				break;
		
			case 4:
				petCenter.setPriority( name, Priority.GREEN_4 );
				break;

			case 5:
				petCenter.setPriority( name, Priority.BLUE_5 );
				break;

		}
		

	}//Method ends



	/**
	* Asks for the pet's breed if is cat or dog <br>
	* <b> pre:</b> pet must be created <br>
	* <b> pos:</b> no changes on global variables <br>
	* @return breed String
	*/

	public String askForBreed()
	{	
		String breed = "";
		System.out.println("Enter the breed: ");
		breed = reader.nextLine();
		return breed;
	}	
	

	/**
	* Asks for the name of a pet for set its status <br>
	* <b> pre:</b> countWA must be initialized <br>
	* <b> pos:</b> plus 1 to countWA  <br>
	*/

	public void removeAPet()
	{
		String name = "";
		if( petCenter.getPetNumber() == 0 )
		{
			System.out.println("\t--ERROR--\nNone Pet has been registered");
		}
		else
		{
			System.out.println("\tEnter the name of the pet that you want remove: ");
			name = reader.nextLine();

			if( petCenter.getPet( name ).getPetStatus() == Status.WAITING_TO_BE_ATTENDED )
			{
				petCenter.setStatus( name, Status.EXIT_WITHOUT_ATTENTION );

				if( petCenter.getPet( name ).getPetStatus() == Status.EXIT_WITHOUT_ATTENTION )
				{
					System.out.println("The Pet has been removed ");
					countWA++;

				}

			}
			else
			{
				System.out.println("The Pet is not waiting for to be attended ");
			}
		
		}
	} 


	/**
	* Asks for the id of a vet for delete it of the array <br>
	* <b> pre:</b> vet must exist<br>
	* <b> pos:</b> no changes on global variables <br>
	*/

	public void deleteVetPCS()
	{
		String id = "";

		if( petCenter.getPetNumber() > 0 )
		{
			System.out.println(" \t--ERROR--\nThere are pets at the center");
		}
		else
		{
			if( petCenter.getVetNumber() == 0 )
			{
				System.out.println(" \t--ERROR--\nNone Vet has been registered");
			}
			else
			{
				System.out.println( "\tEnter the ID of the vet that you wants delete: ");
				id = reader.nextLine();
				System.out.println( petCenter.deleteVet( id ) );
			}

		}
	 	
		
	}

	/**
	* Ask for the data, call the necessary methods, and indicates if it can start a consultation <br>
	* <b> pre:</b> vetNumber must be greater than 0<br>
	* <b> pos:</b> no changes on global variables <br>
	*/

	public void startAConsultation()
	{
		String idVet = "";

		if( petCenter.getVetNumber() == 0 )
		{
			System.out.println( "\t--ERROR--\nNone Vet has been registered" );
		}

		else
		{
			System.out.println( "\t========Start a Consultation========:\n\tEnter the ID of the Vet: " );
			idVet = reader.nextLine();
			
			if( petCenter.canStartAConsultation( idVet ).equals(" \t--ERROR--\nCan't start a Consultation: The Vet already cared for a pet ") )
			{
				System.out.println( petCenter.canStartAConsultation( idVet ) );
			} 
			else
			{
				System.out.println( petCenter.canStartAConsultation( idVet ) );

				System.out.println( "The pet that will be cared for is... ");

				System.out.println( selectPetForCare( idVet ) );
			}
			
		}

	}
 

	/**
	*Makes the necessary verifications, and call the required methods to select a pet for care, and displays the pet selected<br>
	* <b> pre:</b> pet array must be initialized and fill <br>
	* <b> pos:</b> plus 1 to counPriority1, countPriority2, countPriority3, countPriority4, countPriority5, depends the pet <br>
	* @param idVet String
	* @return petInfo String
	*/

	public String selectPetForCare( String idVet )
	{
		boolean petAttended = true;
		boolean found = false;
		String petInfo = "";
		int countConsultation = 0;
		int priority = 1;

		for( int i = 0; i < petCenter.getPetNumber() && !found; i++ )
		{
			if( petCenter.getPetForConsultation( i ) != null )			
			{
					petInfo = "null si"; 

				if( petCenter.getPetForConsultation( i ).getPetStatus() == Status.WAITING_TO_BE_ATTENDED )
				{
					petInfo = "waiting si";

					if( priority == 1)
					{
						if( petCenter.getPetForConsultation( i ).getPetPriority() == Priority.RED_1 )
						{
							petCenter.getPetForConsultation( i ).setVetPet( petCenter.getVet( idVet ) );
							petCenter.getPetForConsultation( i ).setPetStatus( Status.IN_CONSULTATION );
							petCenter.getVet( idVet ).setPetAttended( petAttended );
							countConsultation = petCenter.getVet( idVet ).getCountConsultation();
							countConsultation++;
							petCenter.getVet( idVet ).setCountConsultation( countConsultation );
							countPriority1++;

							petInfo = petCenter.getPetForConsultation( i ).toString();
							
							found = true;
						
						}
						else
						{
							priority ++;
						}
					}
			

					if( priority == 2)
					{
			
						if( petCenter.getPetForConsultation( i ).getPetPriority() == Priority.ORANGE_2 )
						{
							petCenter.getPetForConsultation( i ).setVetPet( petCenter.getVet( idVet ) );
							petCenter.getPetForConsultation( i ).setPetStatus( Status.IN_CONSULTATION );
							petCenter.getVet( idVet ).setPetAttended( petAttended );
							countConsultation = petCenter.getVet( idVet ).getCountConsultation();
							countConsultation++;
							petCenter.getVet( idVet ).setCountConsultation( countConsultation );
							countPriority2++;
							
							petInfo = petCenter.getPetForConsultation( i ).toString();


							found = true;
						}
						else
						{
							priority ++;
						}
					}

					if( priority == 3 )
					{

						if( petCenter.getPetForConsultation( i ).getPetPriority() == Priority.YELLOW_3 )
						{
							petCenter.getPetForConsultation( i ).setVetPet( petCenter.getVet( idVet ) );
							petCenter.getPetForConsultation( i ).setPetStatus( Status.IN_CONSULTATION );
							petCenter.getVet( idVet ).setPetAttended( petAttended );
							countConsultation = petCenter.getVet( idVet ).getCountConsultation();
							countConsultation++;
							petCenter.getVet( idVet ).setCountConsultation( countConsultation );
							countPriority3++;
							
							petInfo = petCenter.getPetForConsultation( i ).toString();

							found = true;
						}
						else
						{
							priority ++;
						}
	
					}	

					if( priority == 4 )
					{

						if( petCenter.getPetForConsultation( i ).getPetPriority() == Priority.GREEN_4 )
						{
							petCenter.getPetForConsultation( i ).setVetPet(  petCenter.getVet( idVet ) );
							petCenter.getPetForConsultation( i ).setPetStatus( Status.IN_CONSULTATION );
							petCenter.getVet( idVet ).setPetAttended( petAttended );
							countConsultation = petCenter.getVet( idVet ).getCountConsultation();
							countConsultation++;
							petCenter.getVet( idVet ).setCountConsultation( countConsultation );
							countPriority4++;

							petInfo = petCenter.getPetForConsultation( i ).toString();

							found = true;
						}

						else
						{
							priority ++;
						}
	
					}

					if( priority == 5 )
					{

						if( petCenter.getPetForConsultation( i ).getPetPriority() == Priority.BLUE_5 )
						{
							petCenter.getPetForConsultation( i ).setVetPet(  petCenter.getVet( idVet ) );
							petCenter.getPetForConsultation( i ).setPetStatus( Status.IN_CONSULTATION );
							petCenter.getVet( idVet ).setPetAttended( petAttended );
							countConsultation = petCenter.getVet( idVet ).getCountConsultation();
							countConsultation++;
							petCenter.getVet( idVet ).setCountConsultation( countConsultation );
							countPriority5++;

							petInfo = petCenter.getPetForConsultation( i ).toString();

							found = true;
						}
						else
						{
							priority ++;
						}

					}

					if( priority > 5)
					{
						petInfo = "No pets found with status: "+ Status.WAITING_TO_BE_ATTENDED;
					}

				}//if ends

			}//if ends

			

		}//for ends

		return petInfo;

	}//Method ends

	/**
	* Ask for the data, call the necessary methods, to finalize a consultation <br>
	* <b> pre:</b> vetNumber and petNumber must be greater than 0, <br>
	* <b> pos:</b> no changes on global variables <br>
	*/

	public void finalizeAConsultation()
	{
	
		String idVet = "";
		String name = "";
		int option = 0;
		
		if( petCenter.getPetNumber() == 0 )
		{
			System.out.println("\t--ERROR--\nNone Pet and None Vet has been registered");
		}
		else
		{
			System.out.println("Enter the ID of the Vet for finalize the Consultation: ");
			idVet = reader.nextLine();
		
		
			System.out.println("Enter the name of the Pet: ");
			name = reader.nextLine();
	
			if( petCenter.findVet( idVet ) == -1 )
			{
				System.out.println("No matches found for id: "+ idVet );
			}

			else if( petCenter.getPet( name ).getVetPet().getIdVet().equals( idVet ) )
			{
				System.out.println("The pet... ");
		
				System.out.println(
				"Pick an option \n" +
				"(1) Has an Authorized Exit\n" +
				"(2) Must go to Hospitalization\n");
				option = reader.nextInt();
		

				switch( option )
				{
					case 1:
						petCenter.getPet( name ).setPetStatus( Status.DISCHARGE );
						petCenter.getVet( idVet ).setPetAttended( false );
					break;
			
					case 2:
						petCenter.getPet( name ).setPetStatus( Status.TRANSFER_TO_HOSPITALIZATION );
						petCenter.getVet( idVet ).setPetAttended( false );
					break;


				}			
			}

			else
			{
				System.out.println("\t--ERROR--\nThe Vet with the id: "+ idVet +" Didn't care for the pet " + name );
			}
		}
	
	}

	/**
	* Calculate how many pets left to attend <br>
	* <b> pre:</b> pet array must be initialized and fill <br>
	* <b> pos:</b> no changes on global variables <br>
	* @return countPet int
	*/

	public int countPetForCare()
	{
		int countPet = 0;
		
		for( int i = 0; i < 120; i++ )
		{
			if( petCenter.getPetForConsultation( i ) != null )
			{
				if( petCenter.getPetForConsultation( i ).getPetStatus() == Status.WAITING_TO_BE_ATTENDED )
				{
					countPet++;
				}
			}
		}

		return countPet;
	}

	/**
	* Indicates to the user how many pets left to attend or if all pets have been attended <br>
	* <b> pre:</b> countPriority1, countPriority2, countPriority3, countPriority4, countPriority5 must be initialized<br>
	* <b> pos:</b> no changes on global variables <br>
	*/

	public void verifyPetForCare()
	{
		if( countPetForCare() > 0 )
		{
			System.out.println( "\t\n"+countPetForCare() + " pets left to attend");
		}
		else
		{
			System.out.println("\t\nAll pets have been cared for");
			
		}
	}

	
	/**
	* Shows how many pets were attended for each priority. <br>
	* <b> pre:</b> countPriority1, countPriority2, countPriority3, countPriority4, countPriority5 must be initialized<br>
	* <b> pos:</b> no changes on global variables <br>
	*/

	public void countPetsForPriority()
	{
		System.out.println("Number of pets attended: ");
		System.out.println("\n\tPriority 1: " +countPriority1 );
		System.out.println("\n\tPriority 2: " +countPriority2 );
		System.out.println("\n\tPriority 3: " +countPriority3 );
		System.out.println("\n\tPriority 4: " +countPriority4 );
		System.out.println("\n\tPriority 5: " +countPriority5 );
		
	}

	public double percentagePWA()
	{
		double percentage = 0; 

		if( petCenter.getPetNumber() > 0 )
		{
			percentage = ( (countWA * 100) / petCenter.getPetNumber() );
		}

		else
		{
			percentage = -1;
		}	

		return percentage;
	}


	/**
	* Call the necessary methods, for show the reports and close the petcenter <br>
	* <b> pre:</b> vetNumber and petNumber must be greater than 0<br>
	* <b> pos:</b> no changes on global variables <br>
	*/

	public void showReports()
	{
		if( petCenter.getPetNumber() == 0 )
		{
			System.out.println("\t--ERROR--\nNone Pet and None Vet has been registered");
		}
		else
		{

			System.out.println("\n\t========Reports========" );
			 verifyPetForCare();
			System.out.println( "\n\tThe vet with the most visits is: " + petCenter.getMaxVet() );
			countPetsForPriority();

			if( percentagePWA() == -1 )
			{
				System.out.println( "\n\tNo pets Registered " );
			}

			else
			{
				System.out.println( "\n\tThe percentage of pets that left the center without attention is: " + percentagePWA()+"%" );
			}
		
			petCenter.becomePetNull();
		}
		
	}


}