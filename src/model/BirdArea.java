package model;

public class BirdArea extends Habitat{
	
	private double height;
	private int capacity;
	private CageType cageType;
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