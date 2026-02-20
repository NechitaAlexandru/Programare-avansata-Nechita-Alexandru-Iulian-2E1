public class Main {

    public static void main(String[] args) {
        //1
        System.out.println("Hello World!");

        //2
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        //3
        int n = (int) (Math.random() * 1_000_000);

        //4
        int result = n * 3;
        result += 0b10101; // binary for 21
        result += 0xFF;    // hex for 255
        result *= 6;

        //5
        while (result > 9) {
            int sum = 0;
            while(result > 0) {
                sum += result % 10;
                result /= 10;
            }
            result = sum;
        }

        //6
        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }
}