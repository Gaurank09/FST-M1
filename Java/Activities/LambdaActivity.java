package Activities;

import java.util.ArrayList;
import java.util.List;

public class LambdaActivity {

	public static void main(String[] args) {
		
		List<Object> TWDNames = new ArrayList<>();
		
		TWDNames.add("Rick");
		TWDNames.add("Daryl");
		TWDNames.add("Negan");
		TWDNames.add("Carl");
		TWDNames.add("Glenn");
		
		
		System.out.println(TWDNames);
		
		System.out.println("*************************");
		
		System.out.println("The Walking Dead Characters:");
		TWDNames.forEach( 
				(name) -> 
				{
			System.out.println("Name --- " + name);	
				}
			);

	}

}
