package Activities;

import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
        
        ArrayList<String> List1 = new ArrayList<String>();
        
        List1.add("Samsung");
        List1.add("Apple");
        List1.add("LG");
        List1.add("OnePlus");
        List1.add("Micromax");
        
        System.out.println("List:");
        for(String x: List1){
            System.out.println(x);
        }
        
        System.out.println("---------------------------");
        System.out.println("3rd name in the list is: " + List1.get(2));
        System.out.println("---------------------------");
        System.out.println("Is Oppo on the list: " + List1.contains("OPPO"));
        System.out.println("---------------------------");
        System.out.println("Size of List: " + List1.size());
        
        List1.remove("LG");
        System.out.println("---------------------------");
        System.out.println("New Size of List: " + List1.size());
        System.out.println("---------------------------");
        System.out.println("New List:");
        
        for(String a: List1){
            System.out.println(a);
        }
    }
}