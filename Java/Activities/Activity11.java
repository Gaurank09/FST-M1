package Activities;
import java.util.HashMap;

public class Activity11 {
    public static void main(String[] args) {
        HashMap<Integer, String> map1 = new HashMap<Integer, String>();
        map1.put(1, "Red");
        map1.put(2, "Green");
        map1.put(3, "Blue");
        map1.put(4, "Yellow");
        map1.put(5, "Pink");

        System.out.println("The Original map: " + map1);
        
        map1.remove(4);
        
        System.out.println("After removing a Color: " + map1);
        
        if(map1.containsValue("Green")) {
            System.out.println("Green exists..");
        }
        else {
            System.out.println("Green does not exist!!");
        }
        
        System.out.println("Number of Colors in the Map is: " + map1.size());
    }
}