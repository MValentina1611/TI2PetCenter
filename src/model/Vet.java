package model;

public class Vet{


	//Attributes:
	private String idVet;// Input. id of the vet.
	private String name; //Input. name of the vet
	private String lastname; //Input. lastname of the vet
	private String uniqueVetRegister;//Input. unique vet register
	private boolean petAttended; //Output. Indicates if the vet is available to attend a pet
	private int countConsultation; //Output. Indicates how many consultation had each vet

	//Builder:

	/**
	* Creates veterinarians <br>
	* <b> pre:</b> the attributes must be declared<br>
	* <b> pos:</b> The attributes are initialized<br>
	* @param atrributes types must match
	*/

	public Vet( String idVet, String name, String lastname, String uniqueVetRegister )
	{
		this.idVet = idVet;
		this.name = name;
		this.lastname = lastname;
		this.uniqueVetRegister = uniqueVetRegister;
		this.petAttended = false;
		this.countConsultation = 0;
	}


	//getters:

	public boolean getPetAttended()
	{
		return petAttended;
	}

	public String getIdVet()
	{
		return idVet;
	}

	public String getName()
	{
		return name;
	}

	public String getLastname()
	{
		return lastname;
	}

	public String getUniqueVetRegister()
	{
		return uniqueVetRegister;
	}

	public int getCountConsultation()
	{
		return countConsultation;
	}
	
	//setters:

	public void setPetAttended( boolean petAttended )
	{
		this.petAttended = petAttended;
	}

	public void setCountConsultation( int countConsultation )
	{
		this.countConsultation = countConsultation;
	}

	public String toString()
	{
		String vetInfo = "";

		vetInfo = "\n\tName: "+name+" "+lastname+"\t\nID: "+idVet+"\t\nUnique Vet Register: " + uniqueVetRegister + "\n\tAttendig Pets: "+ petAttended + "\t\nNumber of Consultation: "+ countConsultation;

		return vetInfo;
	}

}