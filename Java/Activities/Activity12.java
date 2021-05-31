package Activities;

interface Addable {
    int add(int a, int b);
}

public class Activity12 {
    public static void main(String[] args) {

        Addable ad1 = (a, b) -> (a + b);
        System.out.println("Addable 1: " + ad1.add(25, 35));

        Addable ad2 = (int a, int b) -> {
            return (a + b);
        };
        System.out.println("Addable 2: " + ad2.add(5, 10));
    }
}