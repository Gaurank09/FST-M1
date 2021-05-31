package Activities;
import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();
        
        hs.add("Crow");
        hs.add("Sparrow");
        hs.add("Pigeon");
        hs.add("Peacock");
        hs.add("Kingfisher");
        hs.add("Flamingo");
        
        System.out.println("Original HashSet: " + hs);        
        System.out.println("Size of HashSet: " + hs.size());
        
        System.out.println("---------------------------"); 
        System.out.println("Removing a bird from HashSet...... "); 
        
        
        try {
			Thread.sleep(5000);
        	hs.remove("Flamingo");
        	System.out.println("A bird is removed !!!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        
        
        if(hs.contains("Pigeon")) {
        	System.out.println("Pigeon is not removed from the Set");
        } 
        else {
        	System.out.println("Pigeon is removed from the Set");
        }
        
        System.out.println("---------------------------");
        System.out.println("Checking if Parrot is present: " + hs.contains("Parrot"));
        System.out.println("Updated HashSet: " + hs);
    }
}