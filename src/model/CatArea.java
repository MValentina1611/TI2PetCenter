package model;

public class CatArea extends Habitat{
	
	private double height; //Output
	private double maximunWeight; //Output

	/**
	* Creates a cat area <br>
	* <b> pre:</b> the attributes must be declared<br>
	* <b> pos:</b> no change on global variables<br>
	* @param atrributes and relationships, types must match and must be other than null
	*/
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