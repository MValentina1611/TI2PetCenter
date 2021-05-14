package ui;

import java.util.Scanner;
import model.PetCenter;
import model.Status;
import model.Species;     
import model.Priority;

public class PetCenterSystem{

	private Scanner reader;
	private PetCenter petCenter;

	public PetCenterSystem()
	{
		reader = new Scanner(System.in);
		petCenter = new PetCenter();	
	}

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
				
	}//Main method ends

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
				System.out.println("Start a Consultation");
				break;

			case 6:
				System.out.println("Finalize a Consultation");
				break;
			
			case 7:
				System.out.println("Show the number of pets that have not been cared for");
				break;
			
			case 8:
				System.out.println("Center Closure");
				break;

			default:
				System.out.println("Error, invalid option");
		}//Switch ends
 		
	}//Method ends
	
	public void registerVet()
	{
		if( petCenter != null )
		{
			if( petCenter.verifyVet() == false )
			{
				System.out.println("\nYou have reached the limit of registered veterinarians: 7 ");	
			}

			else
			{
				String idVet = "";
 				String name = "";
 				String lastname = "";
 				String uniqueVetRegister = "";

				System.out.println("Enter the Vet's data\n");
				System.out.println("id: ");
				idVet = reader.nextLine();
	
				System.out.println("\nName: ");
				name = reader.nextLine();

				System.out.println("\nLastname: ");
				lastname = reader.nextLine();

				System.out.println("\nUnique Vet Register: ");
				uniqueVetRegister = reader.nextLine();

				petCenter.addVet( idVet, name, lastname, uniqueVetRegister );
				System.out.println("\nThe vet has been registered ");
			}

		}

	}
	


	public void registerPet()
	{	
		//Ask for owner:

		String  fullName,
			idOwner,
			phone,
			address;

		System.out.println("Enter the Owner's Data: ");

		System.out.println( "Name: ");
		fullName = reader.nextLine();

		System.out.println( "Id: " );
		idOwner = reader.nextLine();

		System.out.println( "Phone: ");
		phone = reader.nextLine();
		
		System.out.println( "Addres: " );
		address = reader.nextLine();
	
		//Ask for Pet:
		
		String  name, 
			age,
			symptom,
			species,
 			petBreed;

		System.out.println("Enter the Name of Pet: ");
		name = reader.nextLine();

		System.out.println("Enter the Age of Pet: ");
		age = reader.nextLine();

		System.out.println("Enter the Species of Pet: ");
		species = reader.nextLine();
		
		System.out.println("Enter the Symptom of Pet: ");
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

	public String askForBreed()
	{	
		String breed = "";
		System.out.println("Enter the breed: ");
		breed = reader.nextLine();
		return breed;
	}	
	
	public void removeAPet()
	{
		String name = "";
		System.out.println("Enter the name that you want remove: ");
		name = reader.nextLine();

		if( petCenter.getPet( name ).getPetStatus() == Status.WAITING_TO_BE_ATTENDED )
		{
			petCenter.setStatus( name, Status.EXIT_WITHOUT_ATTENTION );
		}
		
		if( petCenter.getPet( name ).getPetStatus() == Status.EXIT_WITHOUT_ATTENTION )
		{
			System.out.println("The Pet has been removed ");
		}
	} 

	public void deleteVetPCS()
	{
		String id = "";
		System.out.println( "Enter the ID of the vet that you wants delete: ");
		id = reader.nextLine();

	 	System.out.println( petCenter.deleteVet( id ) );
		
	}

 
}