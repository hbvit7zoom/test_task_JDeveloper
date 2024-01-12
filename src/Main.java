import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Scanner sc = new Scanner(System.in);
        while (counter.readyToWork){
            System.out.println("Введите команду счетчика: ");
            counter.run(sc.nextLine());
        }
    }
}