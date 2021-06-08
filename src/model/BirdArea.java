package model;

public class BirdArea extends Habitat{
	
	private double height;//Output
	private int capacity;//Output
	private CageType cageType;//Output

	/**
	* Creates a bird area <br>
	* <b> pre:</b> the attributes must be declared<br>
	* <b> pos:</b> no change on global variables<br>
	* @param atrributes and relationships, types must match and must be other than null
	*/
	public BirdArea( String id, double lng, double width,  UseType useType, double height, int capacity, CageType cageType )
	{
		super(id, lng, width, useType );
		this.height = height;
		this.capacity = capacity;
		this.cageType = cageType;

	}

	@Override
	public String toString()
	{
		String info = "";

		info = super.toString()+"\n\tHeight: "+height+"\n\tCapacity: "+capacity+"\n\tCagetype: "+cageType;

		return info;
	}



}