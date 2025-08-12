package Null;

public class Main {

	
	public static void main(String[] args) {
		Vehicle vehicle = VehicleFactory.getVehicleObject("Bike");
		printVehicleDetails(vehicle);
		
	}
	
	public static void printVehicleDetails(Vehicle vehicle) {
		// if(vehicle != null)									No need of this statement
		System.out.println("Seating Capaciry: "+vehicle.getSeatingCapacity());
		System.out.println("Fuel Tank Capaciry: "+vehicle.getTankCapacity());
	}
}
