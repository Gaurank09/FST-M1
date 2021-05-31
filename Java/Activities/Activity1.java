package Activities;


public class Activity1 {
	
	
	public static void main(String[] args) {
		
		Cars HondaCity = new Cars();
		
		HondaCity.Color = "Crimson Red";
		HondaCity.make = 2016;
		HondaCity.Transmission = "Manual";
	
		HondaCity.accelerate();
		HondaCity.brake();
		HondaCity.displayCharacteristics();
		
		
		System.out.println("*************************");
		
	}

}
