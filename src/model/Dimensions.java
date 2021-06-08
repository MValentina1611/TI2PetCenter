package model;

public class Dimensions{
	
	private double lng;
	private double width;

	public Dimensions( double lng, double width )
	{
		this.lng =  lng;
		this.width = width;
	}

	public String toString()
	{
		String info = "";

		info = "\n\tDimensions: \n\tLong: "+lng+" mts"+"\n\tWidth: "+ width+" mts"; 

		return info;
	}
}