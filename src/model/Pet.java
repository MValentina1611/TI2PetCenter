package model;

public class Pet{

	//Attributes:
	private String name; //Input. Pet's Name
	private String age;  //Input. Pet's Age
	private String breed;//Input. Pet's breed, only for dogs and cats.
	private String symptom;//Input. Pet's symptoms

	//Relationships:
	private Owner petOwner;  
	private Status petStatus;
	private Species petSpecies;
	private Priority petPriority;
	private Vet vetPet;//Contains the information of the veterinarian who attended the pet

	//Builders:

	/**
	* Creates cats and dogs, they need their breed specified<br>
	* <b> pre:</b> the attributes must be declared<br>
	* <b> pos:</b> no change on global variables<br>
	* @param atrributes and relationships, types must match and must be other than null
	*/


	public Pet( String nameBreed, String ageBreed, String breed, String symptomBreed, String idOwner, String fullName, String phone, String address, Status petStatusBreed, Species petSpeciesBreed, Priority petPriorityBreed )
	{
		name = nameBreed;
		age = ageBreed;
		this.breed = breed;
		symptom = symptomBreed;
		petOwner = new Owner( idOwner, fullName, phone, address );
		petStatus = petStatusBreed;
		petSpecies = petSpeciesBreed;
		petPriority = petPriorityBreed;
		this.vetPet = new Vet( "Has", "not", "been", "assigned" );

	}

	/**
	* Creates rabbits, birds and reptiles, they not need their breed specified<br>
	* <b> pre:</b> the attributes must be declared<br>
	* <b> pos:</b> no change on global variables<br>
	* @param atrributes and relationships, types must match and must be other than null
	*/

	public Pet( String name, String age, String symptom, String idOwner, String fullName, String phone, String address, Status petStatus, Species petSpecies, Priority petPriorityBreed )
	{
		this.name = name;
		this.age = age;
		this.symptom = symptom;
		petOwner = new Owner( idOwner, fullName, phone, address );
		this.petStatus = petStatus;
		this.petSpecies = petSpecies;
		this.petPriority = petPriority;
		this.vetPet = new Vet( "Has", "not", "been", "assigned" );
	}

	//setters:

	public void setPetOwner( Owner petOwner )
	{
		this.petOwner = petOwner;	
	}

	public void setPetStatus( Status petStatus )
	{
		this.petStatus = petStatus;
	}

	public  void setPetPriority( Priority petPriority )
	{
		this.petPriority = petPriority;
	}

	public void setVetPet( Vet vetPet)
	{
		this.vetPet = vetPet;
	}

	//getters:

	public String getName()
	{
		return name;
	}

	public Status getPetStatus()
	{
		return petStatus;
	}

	public Vet getVetPet()
	{
		return vetPet;
	}

	public Priority getPetPriority()
	{
		return petPriority;
	}

	public Owner getPetOwner()
	{
		return petOwner;
	}

	//toString method:

	public String toString()
	{
		String petInfo = "";

		petInfo = petOwner.toString() + "\n\t\nPet's Data: \n\tName: "+name+"\t\nAge: "+age+"\t\nSpecies: "+petSpecies+"\n\tBreed: "+breed+"\n\tSymptom: "+symptom+"\n\tStatus:  "+petStatus+"\n\tPriority: "+petPriority+"\n\t\nVet: "+ vetPet.toString();

		return petInfo;
	}

}