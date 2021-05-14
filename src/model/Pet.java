package model;

public class Pet{

	private String name;
	private String age;
	private String breed;
	private String symptom;

	//Relationships:

	private Owner petOwner;
	private Status petStatus;
	private Species petSpecies;
	private Priority petPriority;

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
	}

	public Pet( String name, String age, String symptom, String idOwner, String fullName, String phone, String address, Status petStatus, Species petSpecies, Priority petPriorityBreed )
	{
		this.name = name;
		this.age = age;
		this.symptom = symptom;
		petOwner = new Owner( idOwner, fullName, phone, address );
		this.petStatus = petStatus;
		this.petSpecies = petSpecies;
		this.petPriority = petPriority;
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

	//getters:

	public String getName()
	{
		return name;
	}

	public Status getPetStatus()
	{
		return petStatus;
	}

	public String toString()
	{
		String petInfo = "";

		petInfo = petOwner.toString() + "Pet's Data: \nName: "+name+"\nAge: "+age+"\nSpecies: "+petSpecies+"\nBreed: "+breed+"\nSymptom: "+symptom+"\nStatus:  "+petStatus+"\nPriority: "+petPriority;

		return petInfo;
	}

}