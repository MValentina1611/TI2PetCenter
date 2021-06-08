package model;

public class CatArea extends Habitat{
	
	private double height;
	private double maximunWeight;

	public CatArea( String id, double lng , double width , UseType useType, double height, double maximunWeigth )
	{
		super( id, lng, width, useType );

		this.height = height;
		this.maximunWeight = maximunWeigth;
		
	}

	@Override
	public String toString()
	{
		String info = "";
		info = super.toString()+"\n\tHeight: "+height+"\n\tMaximunWeight: "+ maximunWeight;

		return info;
	}
}