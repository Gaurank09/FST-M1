package Activities;

public class Cars {
	
	String Color;
	String Transmission;
	int make;
	int tyres;
	int doors;
	
	
	 Cars() {
		tyres = 4;
		doors = 4;
		
	}
	
	public void	displayCharacteristics() {
		
		System.out.println("Color of Car is: " + Color);
		System.out.println("Transmision of Car is: " + Transmission);
		System.out.println("Number of Tyres in Car is: " + tyres);
		System.out.println("Make of Car is: " + make);
		System.out.println("Number of Doors in Car is: " + doors);
	}
	public void accelerate() {
		System.out.println("Car is accelrating");
	}
	public void brake() {
		System.out.println("Car is braking");
		
	}
}