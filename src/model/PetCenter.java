package model;

public class PetCenter{

	
	private static final int NUM_VET = 7;
	private static final int NUM_PET = 120;
	private int vetNumber;
	private int petNumber;

	//Relationships:

	private Vet [] vet;
	private Pet [] pet;
	
	//Builder:

	public PetCenter()
	{
		vet = new Vet [NUM_VET];
		vetNumber = 0;
		pet = new Pet [NUM_PET];
		petNumber = 0;

	}
	
	public void addVet( String idVet, String name, String lastname, String uniqueVetRegister )
	{
		Vet vetAdd = new Vet( idVet, name, lastname, uniqueVetRegister );
		vet [vetNumber] = vetAdd;
		vetNumber++;
	}

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


	public void addPet( String name, String age, String breed, String symptom, String idOwner, String fullName, String phone, String address, Status petStatus, Species petSpecies, Priority petPriority  )
	{
		Pet petAdd = new Pet( name, age, breed, symptom, idOwner, fullName, phone, address, petStatus, petSpecies, petPriority );
		pet [petNumber] = petAdd;
		petNumber++;
	}

	public void addPet( String name, String age, String symptom, String idOwner, String fullName, String phone, String address, Status petStatus, Species petSpecies, Priority petPriority  )
	{
		Pet petAdd = new Pet( name, age, symptom, idOwner, fullName, phone, address, petStatus, petSpecies, petPriority );
		pet [petNumber] = petAdd;
		petNumber++;

	}

	private int findPet( String name )
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

	public void setStatus( String name, Status petStatus )
	{
		int petPos = findPet( name );
		
		pet[petPos].setPetStatus( petStatus );
		
	}
	
	public void setPriority( String name, Priority petPriority  )
	{
		int petPos = findPet( name );
		
		pet[petPos].setPetPriority( petPriority );
		
	}

	public Pet getPet( String name )
	{
		int petPos = findPet( name );
		
		return pet[petPos];
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
			out = "The vet has been deleted";
		}
		
		return out;
	}

	public void vetMinus1()
	{
		int vetNumberMinus = vetNumber - 1; 
	}
}