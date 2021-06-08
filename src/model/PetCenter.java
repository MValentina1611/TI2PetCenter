package model;

import model.UseType;
import model.CageType;
import model.ReptileType;
import model.Species;

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

	//for cats
	private static final int MIN_CAT_ROWS = 0;
	private static final int MAX_CAT_ROWS = 2;
	private static final int MIN_CAT_COL = 0;
	private static final int MAX_CAT_COL = 2;

	//for dogs
	private static final int MIN_DOG_ROWS = 3;
	private static final int MAX_DOG_ROWS = 5;
	private static final int MIN_DOG_COL = 0;
	private static final int MAX_DOG_COL = 2;

	//for reptiles
	private static final int MIN_REPTILE_ROWS = 0;
	private static final int MAX_REPTILE_ROWS = 1;
	private static final int MIN_REPTILE_COL = 3;
	private static final int MAX_REPTILE_COL = 4;

	//for rabbits
	private static final int MIN_RABBIT_ROWS = 2;
	private static final int MAX_RABBIT_ROWS = 3;
	private static final int MIN_RABBIT_COL = 3;
	private static final int MAX_RABBIT_COL = 4;

	//for birds

	private static final int MIN_BIRD_ROWS = 4;
	private static final int MAX_BIRD_ROWS = 5;
	private static final int MIN_BIRD_COL = 3;
	private static final int MAX_BIRD_COL = 4;

	
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

	//TI3
	private Habitat[][] habitats;

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
		//Habitats for DayCare -> TI3
		habitats = new Habitat[6][5];
		createAreas();
	}
	
	//init habitats

	private void createAreas()
	{
		initHabitats( MIN_DOG_ROWS, MAX_DOG_ROWS, MIN_DOG_COL, MAX_DOG_COL, 1 );
		initHabitats( MIN_CAT_ROWS, MAX_CAT_ROWS, MIN_CAT_COL, MAX_CAT_COL, 2 );
		initHabitats( MIN_BIRD_ROWS, MAX_BIRD_ROWS, MIN_BIRD_COL, MAX_BIRD_COL, 3 );
		initHabitats( MIN_REPTILE_ROWS, MAX_REPTILE_ROWS, MIN_REPTILE_COL, MAX_REPTILE_COL, 4 );
		initHabitats( MIN_RABBIT_ROWS, MAX_RABBIT_ROWS, MIN_RABBIT_COL, MAX_RABBIT_COL, 5 );

	}

	private void initHabitats( int minRows, int maxRows, int minCol, int maxCol, int species)
	{
		int contArea = 1;
		for( int rows = minRows; rows <=  maxRows; rows++ )
		{
				for( int col = minCol; col <= maxCol; col++ )
				{
					switch( species )
					{
						case 1:
						habitats[rows][col] = new DogArea( "D" + contArea, 3.5, 4.5, UseType.UNOCCUPIED, 5 );

						break;

						case 2:
						habitats[rows][col] = new CatArea( "C" + contArea, 4.5, 5.5, UseType.UNOCCUPIED, 7.5, 2.5 );

						break;

						case 3:
						habitats[rows][col] = new BirdArea( "B" + contArea, 6.5, 2.5, UseType.UNOCCUPIED, 7.5, 4, CageType.CORRAL );
						if( rows == 5 )
						{
							habitats[rows][col] = new BirdArea( "B" + contArea, 6.5, 2.5, UseType.UNOCCUPIED, 7.5, 4, CageType.HANGING_CAGE );
						}

						break;

						case 4:
						habitats[rows][col] = new ReptileArea( "R" + contArea, 8.5, 7.5, UseType.UNOCCUPIED,  "GLASS", ReptileType.AMPHIBIANS );
						if( rows == 1  )
						{
							habitats[rows][col] = new ReptileArea( "R" + contArea, 8.5, 7.5, UseType.UNOCCUPIED, "SAND", ReptileType.TERRESTRIAL );
						}

						break;

						case 5:
						habitats[rows][col] = new RabbitsArea( "RA" + contArea, 10, 5.5, UseType.UNOCCUPIED, "GRASSES", 6);

						break;
					}
						
					contArea++;
				}
		}

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

	//TI3 Methods:

	public String showDaycareMap()
	{
		String useType = "";
		String map = "";
		for( int i = 0; i < habitats.length; i++ )
		{
			for( int j = 0; j < habitats[0].length; j++ )
			{
				if( habitats[i][j].getUseType() == UseType.UNOCCUPIED )
				{
					useType = "U";
				}
				else if( habitats[i][j].getUseType() == UseType.OCCUPIED_H )
				{
					useType = "H";
				}
				else if( habitats[i][j].getUseType() == UseType.OCCUPIED_S )
				{
					useType = "S";
				}

				map += habitats[i][j].getId() + useType + " ";
			}
			map += "\n";
		}
		map += "\n";

		return map;
	}

	public int[] findSpecificArea( String species )
	{
		int[] position = {-1,-1};

		if( species.equalsIgnoreCase("CAT") )
		{
			position = verifyEmptyHabitats( MIN_CAT_ROWS, MAX_CAT_ROWS, MIN_CAT_COL, MAX_CAT_COL );
		}
		else if( species.equalsIgnoreCase("DOG") )
		{
			position = verifyEmptyHabitats( MIN_DOG_ROWS, MAX_DOG_ROWS, MIN_DOG_COL, MAX_DOG_COL );
		}
		else if( species.equalsIgnoreCase("RABBIT") )
		{
			position = verifyEmptyHabitats( MIN_RABBIT_ROWS, MAX_RABBIT_ROWS, MIN_RABBIT_COL, MAX_RABBIT_COL );
		}
		else if( species.equalsIgnoreCase("REPTILE") )
		{
			position = verifyEmptyHabitats(MIN_REPTILE_ROWS, MAX_REPTILE_ROWS, MIN_REPTILE_COL, MAX_REPTILE_COL );
		}
		else if( species.equalsIgnoreCase("BIRD") )
		{
			position  = verifyEmptyHabitats(MIN_BIRD_ROWS, MAX_BIRD_ROWS, MIN_BIRD_COL, MAX_BIRD_COL );
		}

		return position;
	}

	public int[] verifyEmptyHabitats( int minRows, int maxRows, int minCol, int maxCol )
	{
		boolean empty = false;
		int[] position = {-1,-1};
		for( int i = minRows; i <= maxRows && !empty; i++ )
		{
			for( int j = minCol; j <= maxCol; j++ )
			{
				if( habitats[i][j].getUseType() == UseType.UNOCCUPIED ) 
				{
					empty = true;
					position[0] = i;
					position[1] = j; 
				}
			}
		}

		return position;
		
	}

	//add pet from hospitalize
	public String addPetToDaycare( String name, String age, String symptom, String idOwner, String fullName, String phone, String address, Status petStatus, Species petSpecies, Priority petPriority,  int days, String swimOrFly )
	{
		String notification = "";
		int row = 0;
		int col = 0;
		String species = petSpecies.name();
		int[] position = findSpecificArea( species );
		row = position[0];
		col = position[1];
		if( (row == -1) && (col == -1) )
		{
			notification = "\t--ERROR--\nThere's not space for the pet";
		}		
		else
		{
			Pet petToHospitalize = new Pet( name, age, symptom, idOwner, fullName, phone, address, petStatus, petSpecies, petPriority, days );

			if( swimOrFly.equalsIgnoreCase("NONE") )
			{
				habitats[row][col].setDaycarePet( petToHospitalize );
				habitats[row][col].setUseType( UseType.OCCUPIED_S );
				notification = "The pet was added to the habitat "+habitats[row][col].getId();
			}
			else if( swimOrFly.equalsIgnoreCase("FLY") )
			{
				position = verifyEmptyHabitats( 5, 5, 3, 4 );
				if( position[0] == -1 )
				{
					notification = "--Error--\nThere's not space: All HANGING CAGES are full";
				}
				else
				{
					row = position[0];
					col = position[1];
					habitats[row][col].setDaycarePet( petToHospitalize );
					habitats[row][col].setUseType( UseType.OCCUPIED_S );
				    notification = "The pet was added to the habitat "+habitats[row][col].getId();
				}
			}
			else if(swimOrFly.equalsIgnoreCase("SWIM") )
			{
				position = verifyEmptyHabitats( 0, 0, 3, 4 );
				if( position[0] == -1 )
				{
					notification = "--Error--\nThere's not space: All AQUARIUMS are full ";
				}
				else
				{
					row = position[0];
					col = position[1];
					habitats[row][col].setDaycarePet( petToHospitalize );
					habitats[row][col].setUseType( UseType.OCCUPIED_S );
				    notification = "The pet was added to the habitat "+habitats[row][col].getId();
				}
			}
		}

		return notification;
	}


	public String showHabitatInfo( String  id )
	{
		String info = "";
		boolean found = false;

		for( int i = 0; i < habitats.length && !found; i++)
		{
			for( int j =  0; j < habitats[0].length; j++ )
			{
				if( habitats[i][j].getId().equalsIgnoreCase(id) )
				{
					if( habitats[i][j].getUseType() == UseType.UNOCCUPIED )
					{
						info = habitats[i][j].toString()+"\n\tThe habitat is empty";
					}
					else if( habitats[i][j].getUseType() == UseType.OCCUPIED_S )
					{
						info = habitats[i][j].toString() + habitats[i][j].getDaycarePet().toString()+"\n\tThe pet is Sick";
					}
					else if( habitats[i][j].getUseType() == UseType.OCCUPIED_H )
					{
						info = habitats[i][j].toString() + habitats[i][j].getDaycarePet().toString()+"\n\tThe pet is healthy";
					}

					
				}
				
			}
		}

		return info;	
	}

	public String addPetToDaycare( String name, String age, String idOwner, String fullName, String phone, String address, Species petSpecies, int days, String swimOrFly )
	{
		String notification = "";
		int row = 0;
		int col = 0;
		String species = petSpecies.name();
		int[] position = findSpecificArea( species );
		row = position[0];
		col = position[1];
		if( (row == -1) && (col == -1) )
		{
			notification = "\t--ERROR--\nThere's not space for the pet";
		}		
		else
		{
			Pet petToDaycare = new Pet( name, age, idOwner, fullName, phone, address, petSpecies, days );

			if( swimOrFly.equalsIgnoreCase("NONE") )
			{
				habitats[row][col].setDaycarePet(  petToDaycare );
				habitats[row][col].setUseType( UseType.OCCUPIED_H );
				notification = "The pet was added to the habitat "+habitats[row][col].getId();
			}
			else if( swimOrFly.equalsIgnoreCase("FLY") )
			{
				position = verifyEmptyHabitats( 5, 5, 3, 4 );
				if( position[0] == -1 )
				{
					notification = "--Error--\nThere's not space: All HANGING CAGES are full";
				}
				else
				{
					row = position[0];
					col = position[1];
					habitats[row][col].setDaycarePet(  petToDaycare );
					habitats[row][col].setUseType( UseType.OCCUPIED_H );
				    notification = "The pet was added to the habitat "+habitats[row][col].getId();
				}
			}
			else if(swimOrFly.equalsIgnoreCase("SWIM") )
			{
				position = verifyEmptyHabitats( 0, 0, 3, 4 );
				if( position[0] == -1 )
				{
					notification = "--Error--\nThere's not space: All AQUARIUMS are full ";
				}
				else
				{
					row = position[0];
					col = position[1];
					habitats[row][col].setDaycarePet(  petToDaycare );
					habitats[row][col].setUseType( UseType.OCCUPIED_H );
				    notification = "The pet was added to the habitat "+habitats[row][col].getId();
				}
			}

		}

		return notification;
	}

	public String showPetInfo( String name )
	{
		String info = "";
		
		for( int i = 0; i < habitats.length; i++)
		{
			for( int j =  0; j < habitats[0].length; j++ )
			{
				if( habitats[i][j].getUseType() == UseType.UNOCCUPIED )
				{

				}
				else
				{
					if( habitats[i][j].getDaycarePet().getName().equalsIgnoreCase(name) )
					{

						if( habitats[i][j].getUseType() == UseType.OCCUPIED_S )
						{
							if( habitats[i][j].getDaycarePet().getPetSpecies() == Species.DOG )
							{
								info += "\n\tArea: DogArea\n\t Habitat's ID: " + habitats[i][j].getId() + habitats[i][j].getDaycarePet().toString()+"\n\tThe pet is Sick\n";
							}

							else if( habitats[i][j].getDaycarePet().getPetSpecies() == Species.CAT ) 
							{
								info += "\n\tArea: CatArea\n\t Habitat's ID: " + habitats[i][j].getId() + habitats[i][j].getDaycarePet().toString()+"\n\tThe pet is Sick\n";
							}

							else if( habitats[i][j].getDaycarePet().getPetSpecies() == Species.REPTILE ) 
							{
								info += "\n\tArea: ReptileArea\n\t Habitat's ID: " + habitats[i][j].getId() + habitats[i][j].getDaycarePet().toString()+"\n\tThe pet is Sick\n";
							}

							else if( habitats[i][j].getDaycarePet().getPetSpecies() == Species.BIRD ) 
							{
								info += "\n\tArea: BirdArea\n\t Habitat's ID: " + habitats[i][j].getId() + habitats[i][j].getDaycarePet().toString()+"\n\tThe pet is Sick\n";
							}

							else if( habitats[i][j].getDaycarePet().getPetSpecies() == Species.RABBIT ) 
							{
								info += "\n\tArea: RabbitArea\n\t Habitat's ID: " + habitats[i][j].getId() + habitats[i][j].getDaycarePet().toString()+"\n\tThe pet is Sick\n";
							}
						}


						else if( habitats[i][j].getUseType() == UseType.OCCUPIED_H )
						{
							if( habitats[i][j].getDaycarePet().getPetSpecies() == Species.DOG )
							{
								info += "\n\tArea: DogArea\n\t Habitat's ID: " + habitats[i][j].getId() + habitats[i][j].getDaycarePet().showPetInfo()+"\n\tThe pet is Healthy\n";
							}

							else if( habitats[i][j].getDaycarePet().getPetSpecies() == Species.CAT ) 
							{
								info += "\n\tArea: CatArea\n\t Habitat's ID: " + habitats[i][j].getId() + habitats[i][j].getDaycarePet().showPetInfo()+"\n\tThe pet is Healthy\n";
							}

							else if( habitats[i][j].getDaycarePet().getPetSpecies() == Species.REPTILE ) 
							{
								info += "\n\tArea: ReptileArea\n\t Habitat's ID: " + habitats[i][j].getId() + habitats[i][j].getDaycarePet().showPetInfo()+"\n\tThe pet is Healthy\n";
							}

							else if( habitats[i][j].getDaycarePet().getPetSpecies() == Species.BIRD ) 
							{
								info += "\n\tArea: BirdArea\n\t Habitat's ID: " + habitats[i][j].getId() + habitats[i][j].getDaycarePet().showPetInfo()+"\n\tThe pet is Healthy\n";
							}

							else if( habitats[i][j].getDaycarePet().getPetSpecies() == Species.RABBIT ) 
							{
								info += "\n\tArea: RabbitArea\n\t Habitat's ID: " + habitats[i][j].getId() + habitats[i][j].getDaycarePet().showPetInfo()+"\n\tThe pet is Healthy\n";
							}
						}

					
					}
					else
					{
						info = "\n\t--ERROR--\n\tThe pet with the name "+ name +" is not in the daycare";
					}
				}
			}
		}

		return info;	

	} 

	public String showOccupationPercentage()
	{
		String percentage = "";
		int countOccupied = 0;
		int countUnoccupied = 0;
		int countHealthy = 0;
		int countSick = 0; 

		int countDogsArea = 0;
		int countCatsArea = 0;
		int countReptilesArea = 0;
		int countRabbitsArea = 0;
		int countBirdsArea = 0;

		double generalPercentage = 0.0;
		double healthyPercentage = 0.0;
		double sickPercentage = 0.0;


		double dogsOccupation = 0.0;
		double catsOccupation = 0.0;
		double reptilesOccupation = 0.0;
		double rabbitsOccupation = 0.0;
		double birdsOccupation = 0.0;

		for( int i = 0; i < habitats.length; i++ )
		{
			for( int j = 0; j < habitats[0].length; j++ )
			{
				if( habitats[i][j].getUseType() == UseType.UNOCCUPIED )
				{
					countUnoccupied++;
				}
				else if( habitats[i][j].getDaycarePet().getPetSpecies() == Species.DOG )
				{
					countDogsArea++;
				}
				else if( habitats[i][j].getDaycarePet().getPetSpecies() == Species.CAT )
				{
					countCatsArea++;
				}
				else if( habitats[i][j].getDaycarePet().getPetSpecies() == Species.RABBIT )
				{
					countRabbitsArea++;
				}
				else if( habitats[i][j].getDaycarePet().getPetSpecies() == Species.REPTILE )
				{
					countReptilesArea++;
				}
				else if( habitats[i][j].getDaycarePet().getPetSpecies() == Species.BIRD )
				{
					countBirdsArea++;
				}

				if( habitats[i][j].getUseType() == UseType.OCCUPIED_H )
				{
					countOccupied++;
					countHealthy++;
				}
				if( habitats[i][j].getUseType() == UseType.OCCUPIED_S )
				{
					countOccupied++;
					countSick++;
				}
			}
		}

		generalPercentage = (countOccupied * 100)/30;
		healthyPercentage = (countHealthy * 100)/countOccupied;
		sickPercentage = (countSick * 100)/countOccupied;

		dogsOccupation = ( countDogsArea * 100 ) /9;
		catsOccupation = ( countCatsArea * 100 ) /9;
		reptilesOccupation = ( countReptilesArea * 100 )/4;
		rabbitsOccupation = (countRabbitsArea * 100 )/4;
		birdsOccupation = (countBirdsArea * 100 )/4;

		percentage += "\n\tGeneral Occupation Percentage: "+generalPercentage+"%\n\t";
		percentage += "\n\tPercentage of Healthy Pets: "+healthyPercentage+"%\n\t";
		percentage += "\n\tPercentage of Sick Pets: "+sickPercentage+"%\n\t";


		percentage += "\n\tThe Occupation percentage of each area is: \n\n";
		percentage += "\tDogsArea: "+dogsOccupation +"%\n\t";
		percentage += "\tCatsArea: "+catsOccupation +"%\n\t";
		percentage += "\tBirdsArea: "+birdsOccupation +"%\n\t";
		percentage += "\tReptilesArea: "+reptilesOccupation +"%\n\t";
		percentage += "\tRabbitsArea: "+rabbitsOccupation +"%\n\t";

		return percentage;

	}

}