package model;

public abstract class Habitat{
	
	//Atributes
	private String id;// Output id of the habbitats
	
	//Relationships
	private Pet daycarePet; //pet that stays in the habitat
	private Dimensions dimensions; // Output dimensions of the habitat
	private UseType useType; // Output if the habitat is empty or if the pet is sick or healthy


	/**
	* Creates an habitat <br>
	* <b> pre:</b> the attributes must be declared<br>
	* <b> pos:</b> no change on global variables<br>
	* @param atrributes and relationships, types must match and must be other than null
	*/
	public Habitat(String id, double lng, double width, UseType useType ){

		this.id = id;
		this.useType = useType;
		daycarePet = null;
		dimensions = new Dimensions( lng, width );

	}

	public String getId()
	{
		return id;
	}

	public Pet getDaycarePet()
	{
		return daycarePet;
	}

	public void setDaycarePet( Pet daycarePet )
	{
		this.daycarePet = daycarePet;
	}

	public UseType getUseType()
	{
		return useType;
	}

	public void setUseType( UseType useType )
	{
		this.useType = useType;
	}

	public String toString()
	{
		String info = "";

		info = "\n\tHabitat's info: \n\tID: "+id+"\n\tDimensions: "+dimensions.toString()+"\n\tUse Type: "+useType+"\n\t";

		return info;
	}
} 