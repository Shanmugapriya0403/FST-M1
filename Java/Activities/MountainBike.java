package javapractice;


	public class MountainBike extends Bicycle {
		public int seatHeight;
		
		public MountainBike(int gears, int currentSpeed, int seatHeight) {
			super (gears,currentSpeed);
			this.seatHeight=seatHeight;
			
		}
		public void setHeight(int seatValue) {
			seatHeight=seatValue;
		}
		public String bicycleDesc() {
			return(super.bicycleDesc()+"SeatHeight:" +seatHeight);
			
		}
	}


