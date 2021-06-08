package model;

public abstract class Habitat{
	
	private String id;
	private Dimensions dimensions;
	private UseType useType;
	private Pet daycarePet;

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

		info = "\n\tHabitat's info: \n\tID: "+id+"\n\tDimensions: "+dimensions+"\n\tUse Type: "+useType+"\n\t";

		return info;
	}
} 