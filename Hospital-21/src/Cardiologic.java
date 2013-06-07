import java.util.ArrayList;

public class Cardiologic extends Clinic 
{
	
	final int NumberOrSyrgeriey = 4;

	//private Room Rooms[]; //size numberOfRooms=20 that ihneritates from clinic
	//private Surgery Surgeries[]; //size numberOfSurgeries=4

	private ArrayList cardiologicRooms ;
	private ArrayList cardiologicSurgeries ;
	
	public Cardiologic()
	{
		cardiologicRooms = new ArrayList() ;
		cardiologicSurgeries = new ArrayList() ;
	}
	


	
	public void addRoom(Room aRoom)
	{
		cardiologicRooms.add(aRoom) ;
	}
	
	public void addSurgeries(Surgery aSurgery)
	{
		cardiologicSurgeries.add(aSurgery) ;
	}

}


