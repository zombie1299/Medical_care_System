import java.util.ArrayList;

public class Surgery {

		private String floor;
		private boolean available;
		//private ArrayList availableSurgeries ;
		
		public Surgery (String floor, boolean available)
		{
			this.floor = floor ;
			this.available = available ;
			//availableSurgeries = new ArrayList() ;
		}
		
		public boolean getAvailable() {
			return available;
		}

		public void setAvailable(boolean available) {
			this.available = available;
		}
		
		
		
		
		public void addToAvailableSurgeries(Surgery aSurgery){
			//availableSurgeries.add(aSurgery);
		}
		
		
		public void printInfo() //it prints info about the surgery.
		{
			//String floor = this.floor ;
			String available ;
			if (this.available == true)
				available = "AVAILABLE" ; 
			else
				available = "NOT AVAILABLE" ; 
			//System.out.println(floor+ ", " +available) ;
			
		}
		public boolean getAvailableValue()
		{
			return available;
		}
		public void setSyrgeryFree(boolean available) //you can set it free or commit it.
		{
			this.available = available ;
			//prepei afou alla3e h timh ths idiothtas available na alla3ei kais ta grafika
			//grafeio kinhshs->Xeirourgia h timh tou available sto xeirougeio.
		}
		
}
