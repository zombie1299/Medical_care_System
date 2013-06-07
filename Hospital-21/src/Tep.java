import java.util.ArrayList;

public class Tep extends Clinic
{
	
	final int NumberOrSyrgeries = 4 ;
	
	//private Room Rooms[] ; //size numberOfRooms=20 that ihneritates from clinic
	//private Surgery Surgeries[] ; //size numberOfSurgeries=4
	
	
	private ArrayList tepRooms ;
	private ArrayList tepSurgeries ;
	
	//constructor
	public Tep()
	{
		tepRooms = new ArrayList() ;
		tepSurgeries = new ArrayList() ;
	}
	
	public void printInfo(){
	  System.out.println("Arithmos Xeirourgiwn :" + NumberOrSyrgeries );
	  for(int i=0; i<= tepRooms.size();i++)
	      System.out.println("Dwmatio :" +tepRooms.get(i));
	  for(int i=0; i<= tepSurgeries.size();i++)
	      System.out.println("Xeirourgio :" +tepSurgeries.get(i));  
    }
    
	public void addRoom(Room aRoom)
	{
		tepRooms.add(aRoom) ;
	}
	
	public void addSurgeries(Surgery aSurgery)
	{
		tepSurgeries.add(aSurgery) ;
	}
	
}
