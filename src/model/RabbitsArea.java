package model;

public class RabbitsArea extends Habitat{
	
	private String plantsType;
	private int numberOfPlants;

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