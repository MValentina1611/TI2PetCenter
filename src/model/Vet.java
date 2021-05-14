package model;

public class Vet{

	private String idVet;
	private String name;
	private String lastname;
	private String uniqueVetRegister;

	//Relationships:

	private Pet petVet;

	//Builder:

	public Vet( String idVet, String name, String lastname, String uniqueVetRegister )
	{
		this.idVet = idVet;
		this.name = name;
		this.lastname = lastname;
		this.uniqueVetRegister = uniqueVetRegister;
		this.petVet = petVet;
	}

	public Vet( String idVetPet, String namePet, String lastnamePet, String uniqueVetRegisterPet, Pet petVet )
	{
		this.idVet = idVetPet;
		this.name = namePet;
		this.lastname = lastnamePet;
		this.uniqueVetRegister = uniqueVetRegisterPet;
		this.petVet = petVet;
	}

	public String getIdVet()
	{
		return idVet;
	}
}