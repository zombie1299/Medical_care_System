import java.util.ArrayList;

public class Neurologic extends Clinic
{
	final int NumberOrSyrgeriey = 2 ;
	
	//private Room Rooms[] ; //size numberOfRooms=20 that ihneritates from clinic
	//private Surgery Surgeries[] ; //size numberOfSurgeries=2
	
	private ArrayList neurologicRooms ;
	private ArrayList neurologicSurgeries ;
	
	public Neurologic()
	{
		neurologicRooms = new ArrayList() ;
		neurologicSurgeries = new ArrayList() ;
	}
	
	
	public void addRoom(Room aRoom)
	{
		neurologicRooms.add(aRoom) ;
	}
	
	public void addSurgeries(Surgery aSurgery)
	{
		neurologicSurgeries.add(aSurgery) ;
	}

	
}
