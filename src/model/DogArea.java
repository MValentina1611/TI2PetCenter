package model;

public class DogArea extends Habitat{

	private int numberOfToys; // Output.


	/**
	* Creates a dog area <br>
	* <b> pre:</b> the attributes must be declared<br>
	* <b> pos:</b> no change on global variables<br>
	* @param atrributes and relationships, types must match and must be other than null
	*/
	public DogArea( String id, double lng, double width, UseType useType, int numberOfToys )
	{
		super( id, lng, width, useType );

		this.numberOfToys = numberOfToys;

	}

	@Override
	public String toString()
	{
		String info = "";

		info  = super.toString()+"\n\tNumber of Toys: "+numberOfToys;
		
		return info;
	}
}