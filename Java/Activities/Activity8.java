package Activities;

class CustomException extends Exception {
    private String message = null;

    public CustomException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

public class Activity8 {
    public static void main(String[] a){
        try {
            
            Activity8.exceptionTest("No Exception on 1st Try");
            
            System.out.println("........................");
            
            Activity8.exceptionTest(null); 
        } 
        
        catch(CustomException ex1) {
            System.out.println(ex1.getMessage());
        }
    }

    static void exceptionTest(String str) throws CustomException {
        
    	if(str == null) {
            throw new CustomException("Error.. String value is  -> " + str);
        } 
        else {
            System.out.println(str);
        }
    }
}