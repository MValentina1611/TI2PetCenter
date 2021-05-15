package model;

public class PetCenter{

	//Attributes:

	//Constants:

	/**
	* Indicates the size of the vets arrays: how many vets can exist in the PetCenter  <br>
	*/
	
	private static final int NUM_VET = 7;

	/**
	* Indicates the size of the pets arrays: how many pets can be attended in the PetCenter  <br>
	*/

	private static final int NUM_PET = 120;

	//Variables:

	/**
	* Indicates how many positions in the array of vets are fill, and which position the vet will had in the array   <br>
	*/

	private int vetNumber;

	/**
	* Indicates how many positions in the array of pets are fill, and which position the pet will had in the array  <br>
	*/

	private int petNumber;


	//Relationships:

	/**
	* Vet's array   <br>
	*/
	private Vet [] vet;

	/**
	* Pet's array   <br>
	*/
	private Pet [] pet;

	
	//Builder:

	/**
	* Initialize the attributes and relationships <br>
	* <b> pre:</b> Constants must be declared <br>
	* <b> pos:</b> Global variables are initialized <br>
	*/


	public PetCenter()
	{
		vet = new Vet [NUM_VET];
		vetNumber = 0;
		pet = new Pet [NUM_PET];
		petNumber = 0;
	}
	

	//getters:

	public int getVetNumber()
	{
		return vetNumber;
	}

	public int getPetNumber()
	{
		return petNumber;
	}


	//Methods:

	/**
	* Creates and adds a vet to the vet's array <br>
	* <b> pre:</b> vet's array must be initialized <br>
	* <b> pos:</b> adds a vet to the vet's array, plus 1 to the variable vetNumber <br>
	* @param variables required to create a vet, types must be matches
	*/
	public void addVet( String idVet, String name, String lastname, String uniqueVetRegister )
	{
		Vet vetAdd = new Vet( idVet, name, lastname, uniqueVetRegister );
		vet [vetNumber] = vetAdd;
		vetNumber++;
	}

	/**
	* Creates and adds cats and dogs, to the pet's array, they need that their breeds specified <br>
	* <b> pre:</b> pet's array must be initialized <br>
	* <b> pos:</b> adds a pet to the pet's array, plus 1 to the variable petNumber <br>
	* @param variables required to create a pet, types must be matches
	*/

	public void addPet( String name, String age, String breed, String symptom, String idOwner, String fullName, String phone, String address, Status petStatus, Species petSpecies, Priority petPriority  )
	{
		Pet petAdd = new Pet( name, age, breed, symptom, idOwner, fullName, phone, address, petStatus, petSpecies, petPriority );
		pet [petNumber] = petAdd;
		petNumber++;
	}

	/**
	* Creates and adds rabbits, reptiles and birds, to the pet's array, they not need that their breeds specified <br>
	* <b> pre:</b> pet's array must be initialized <br>
	* <b> pos:</b> adds a pet to the pet's array, plus 1 to the variable petNumber <br>
	* @param variables required to create a pet, types must be matches
	*/

	public void addPet( String name, String age, String symptom, String idOwner, String fullName, String phone, String address, Status petStatus, Species petSpecies, Priority petPriority  )
	{
		Pet petAdd = new Pet( name, age, symptom, idOwner, fullName, phone, address, petStatus, petSpecies, petPriority );
		pet [petNumber] = petAdd;
		petNumber++;

	}

	/**
	* Verify if there empty spaces in the array for add a vet <br>
	* <b> pre:</b> vet array mmust be initialized <br>
	* <b> pos:</b> no changes on global variables <br>
	* @return veryfySpace boolean, return true if there empty spaces in the vet array
	*/

	public boolean verifyVet()
	{
		boolean verifySpace = false; 
		for( int i = 0; i < NUM_VET; i++ )
		{
			if( vet[i] == null )
			{
				verifySpace = true;
			}
		}
		
		return verifySpace;
	}



	/**
	* Find the pet with the name that matches the parameter <br>
	* <b> pre:</b> pet array must be initialized <br>
	* <b> pos:</b> no changes on global variables <br>
	* @param name String
	* @return pos int, return the position of the pet with the name that matches the parameter, if it can't be found return -1
	*/

	public int findPet( String name )
	{
		int pos = 0;
		boolean found = false;

		
		for( int i = 0;( (i < NUM_PET ) && !found ) ; i++ )
		{
			if( pet[i] != null )
			{
				if(  pet[i].getName().equalsIgnoreCase( name ) )
				{
					pos = i;
					found = true;
				}
				else
				{
					pos = -1;
				}
			}
		}


		return pos;
	}



	/**
	* Set the status of the pet with the name passed like parameter, to the status passed like parameter <br>
	* <b> pre:</b> pet array must be initialized <br>
	* <b> pos:</b> no changes on global variables <br>
	* @param name String
	* @param petStatus Status
	*/

	public void setStatus( String name, Status petStatus )
	{
		int petPos = findPet( name );
		
		pet[petPos].setPetStatus( petStatus );
		
	}
	
	/**
	* Set the priority of the pet with the name passed like parameter, to the priority passed like parameter <br>
	* <b> pre:</b> pet array must be initialized <br>
	* <b> pos:</b> no changes on global variables <br>
	* @param name String
	* @param petPriority Priority
	*/

	public void setPriority( String name, Priority petPriority  )
	{
		int petPos = findPet( name );
		
		pet[petPos].setPetPriority( petPriority );
		
	}

	/**
	* Return the pet with the name passed like parameter <br>
	* <b> pre:</b> pet array must be initialized <br>
	* <b> pos:</b> no changes on global variables <br>
	* @param name String
	* @return pet Pet
	*/

	public Pet getPet( String name )
	{
		int petPos = findPet( name );
		
		return pet[petPos];
	}

	/**
	* Return the vet with the id passed like parameter <br>
	* <b> pre:</b> vet array must be initialized <br>
	* <b> pos:</b> no changes on global variables <br>
	* @param idVet String
	* @return vet Vet
	*/


	public Vet getVet( String idVet)
	{
		int vetPos = findVet( idVet );	
		return vet[vetPos];
	}

	/**
	* Returns the data of the veterinarians in the array <br>
	* <b> pre:</b> vet array must be initialized, anf fill <br>
	* <b> pos:</b> no changes on global variables <br>
	* @return vetInfo String
	*/

	// only for testing
	public String showVets()
	{
		String vetInfo= "";

		for( int i = 0; i < NUM_VET; i++ )
		{
			if ( vet[i] != null )
			{
				vetInfo += vet[i].toString();
			}

		}

		return vetInfo;
	}


	/**
	* Find the vet with the id that matches the parameter <br>
	* <b> pre:</b> vet array must be initialized <br>
	* <b> pos:</b> no changes on global variables <br>
	* @param idVet String
	* @return pos int, return the position of the vet with the id that matches the parameter, if it can't be found return -1
	*/

	public int findVet( String idVet )
	{
		int pos = 0;
		boolean found = false;

		for( int i = 0;( (i < NUM_VET ) && !found ) ; i++ )
		{
			if( vet[i] != null )
			{
				if(  vet[i].getIdVet().equalsIgnoreCase( idVet ) )
				{
					pos = i;
					found = true;
				}
				else
				{
					pos = -1;
				}
			}
		}


		return pos;
	
	}


	/**
	* Delete the vet with the id that matches the parameter <br>
	* <b> pre:</b> vet array must be initialized and fill <br>
	* <b> pos:</b> no changes on global variables <br>
	* @param idVet String
	* @return out String, returns a message notifying if the vet has been deleted or if the vet has not been registered
	*/

	public String deleteVet( String idVet )
	{
		String out = "";

		int vetPos = findVet( idVet );

		if( vetPos == -1 )
		{
			out = " The Vet has not been registered ";
		}
		else if( petNumber == 0 )
		{
			vet[vetPos] = null;
			vetMinus1();
			out = "The Vet has been deleted";
		}
		
		return out;
	}

	/**
	* Subtract 1 from vetNumber  <br>
	* <b> pre:</b> vetNumber must be initialized  <br>
	* <b> pos:</b> subtract 1 from vetNumber<br>
	*/

	public void vetMinus1()
	{
		vetNumber = vetNumber - 1; 
	}

	/**
	* Indicates if a consultation can start <br>
	* <b> pre:</b> vet array must be initialized and fill <br>
	* <b> pos:</b> no changes on global variables <br>
	* @param idVet String
	* @return canStart String, returns a message notifying if the consultation can start or not
	*/

	public String canStartAConsultation( String idVet )
	{
		String canStart = "";
		int vetPos = findVet( idVet );

		if( vetPos == -1 )
		{
			canStart = " \t--ERROR--\nCan't start a Consultation: The Vet has not been registered ";
		}
		else if( vet[vetPos].getPetAttended() == true )
		{
			canStart = " \t--ERROR--\nCan't start a Consultation: The Vet already cared for a pet ";
		}
		else
		{
			canStart = "\t--Starting the Consultation--";
		}
		return canStart;
	}

	/**
	* Returns a specific pet <br>
	* <b> pre:</b> pet array must be initialized and fill <br>
	* <b> pos:</b> no changes on global variables <br>
	* @param int i must be greater or equal than 0
	* @return pet Pet
	*/

	public Pet getPetForConsultation( int i )
	{
		return pet[i];
	}

	/**
	* Indicates which vet has the greater amount of Consultations<br>
	* <b> pre:</b> vet array must be initialized and fill, consultations muts be finilized <br>
	* <b> pos:</b> no changes on global variables <br>
	* @return vetInfo String, return the info of the vet with the greater amount of consultations
	*/

	public String getMaxVet()
	{
		double maxAmount = 0;
		String vetInfo = "";
		
		for( int i = 0; i < NUM_VET; i++ )
		{
			if( vet[i] != null )
			{
				if( vet[i].getCountConsultation() > maxAmount )
				{
					maxAmount = vet[i].getCountConsultation();
					vetInfo = vet[i].toString();
				}
			}
		}

		return vetInfo;
	}	
	

	/**
	* Becomes pet array to empty<br>
	* <b> pre:</b> pet array must be initialized and fill <br>
	* <b> pos:</b> becomes pet array to empty <br>
	*/
	
	public void becomePetNull()
	{
		for( int i = 0; i < NUM_PET; i++ )
		{
			pet[i] = null;
			petNumber = 0;
		}
	}

	public String showPets()
	{
		String petInfo= "";

		for( int i = 0; i < NUM_PET; i++ )
		{
			if ( pet[i] != null )
			{
				petInfo += pet[i].toString();
			}

		}

		return petInfo;
	}





}