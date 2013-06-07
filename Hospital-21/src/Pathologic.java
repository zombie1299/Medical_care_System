import java.util.ArrayList;

public class Pathologic extends Clinic
{
	final int NumberOrSyrgeriey = 3;
	
	//private Room Rooms[] ; //size numberOfRooms=20 that ihneritates from clinic
	//private Surgery Surgeries[] ; //size numberOfSurgeries=3
	
	private ArrayList pathologicRooms ;
	private ArrayList pathologicSurgeries ;
	
	public Pathologic()
	{
		pathologicRooms = new ArrayList() ;
		pathologicSurgeries = new ArrayList() ;
	}
	

	
	
	public void addRoom(Room aRoom)
	{
		pathologicRooms.add(aRoom) ;
	}
	
	public void addSurgeries(Surgery aSurgery)
	{
		pathologicSurgeries.add(aSurgery) ;
	}

	
	
}