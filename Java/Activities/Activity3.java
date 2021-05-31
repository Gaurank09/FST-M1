package Activities;

public class Activity3 {

	public static void main(String[] args) {
		double age = 30.2*31557600;
		
		
		

		double EarthSeconds = 31557600;
		double MercurySeconds = 0.2408467;
		double VenusSeconds = 0.61519726;
		double MarsSeconds = 1.8808158;
		double JupiterSeconds = 11.862615;
		double SaturnSeconds = 29.447498;
		double UranusSeconds = 84.016846;
		double NeptuneSeconds = 164.79132;
		
		
		System.out.println("Age on Earth: " + (age/EarthSeconds) + " years");
		System.out.println("Age on Mercury: " + (age/EarthSeconds/MercurySeconds) + " years");
		System.out.println("Age on Venus: " + (age/EarthSeconds/VenusSeconds) + " years");
		
		System.out.println("Age on Mars: " + (age/EarthSeconds/MarsSeconds) + " years");
		System.out.println("Age on Jupiter: " + (age/EarthSeconds/JupiterSeconds) + " years");
		System.out.println("Age on Saturn: " + (age/EarthSeconds/SaturnSeconds) + " years");
		System.out.println("Age on Uranus: " + (age/EarthSeconds/UranusSeconds) + " years");
		System.out.println("Age on Neptune: " + (age/EarthSeconds/NeptuneSeconds) + " years");
		
		
		
		
	}

}
