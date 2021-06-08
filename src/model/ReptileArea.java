package model;

public class ReptileArea extends Habitat{
	
	private String material;//Output
	private ReptileType reptileType;//Output

	/**
	* Creates a reptile area<br>
	* <b> pre:</b> the attributes must be declared<br>
	* <b> pos:</b> no change on global variables<br>
	* @param atrributes and relationships, types must match and must be other than null
	*/
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