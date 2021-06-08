package model;

public class DogArea extends Habitat{

	private int numberOfToys;
	
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