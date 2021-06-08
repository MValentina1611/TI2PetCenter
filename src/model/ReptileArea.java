package model;

public class ReptileArea extends Habitat{
	
	private String material;
	private ReptileType reptileType;

	public ReptileArea( String id, double lng , double width, UseType useType, String material, ReptileType reptileType )
	{
		super(id, lng, width, useType);
		this.material = material;
		this.reptileType = reptileType;

	}

	@Override
	public String toString()
	{
		String info = "";

		info = super.toString() + "\n\tMaterial: "+material+"\n\tReptileType: "+reptileType;

		return info;
	}
}