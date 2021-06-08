package model;

public class RabbitsArea extends Habitat{
	
	private String plantsType; //Output
	private int numberOfPlants;//Output

	/**
	* Creates a rabbit area<br>
	* <b> pre:</b> the attributes must be declared<br>
	* <b> pos:</b> no change on global variables<br>
	* @param atrributes and relationships, types must match and must be other than null
	*/
	public RabbitsArea(  String id, double lng , double width, UseType useType, String plantsType, int numberOfPlants)
	{
		super( id, lng, width, useType );

		this.numberOfPlants = numberOfPlants;

	}

	@Override
	public String toString()
	{
		String info = "";

		info = super.toString()+"\n\tPlantsType: "+plantsType+"\n\tNumber Of Plants: "+numberOfPlants;

		return info;
	}


}