import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Counter counter = new Counter();
        Scanner sc = new Scanner(System.in);
        while (counter.readyToWork){
            System.out.println("Введите команду счетчика: ");
            counter.run(sc.nextLine());
        }

    }
}