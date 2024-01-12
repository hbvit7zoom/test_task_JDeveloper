import java.io.IOException;

public class Counter {
    boolean readyToWork;
    private int counter;
    StreamWork stream;
    public Counter() {
        stream = new StreamWork();
        counter = stream.getCount();
        readyToWork = true;
    }

    public void run(String cmd) {
        switch (cmd.toLowerCase()) {
            case ("/inc"):
                incCounter();
                break;
            case ("/stop"):
                stopCounter();
                break;
            case ("/reset"):
                resetCounter();
                break;
            default:
                System.out.println("Введите другую команду");
                break;
        }
    }
    private void incCounter() {
        this.counter++;
        System.out.println("Текущее значение счетчика: " + this.counter);
    }
    private void stopCounter(){
        System.out.println("Текущее значение счетчика: " + this.counter);
        System.out.println("Завершение работы");
        try {
            stream.saveCountToFile(this.counter);
        }
        catch (IOException e){
            System.out.println("Данные не сохранены");
        }
        this.readyToWork = false;
    }
    private void resetCounter(){
        this.counter = 0;
        System.out.println("Текущее значение счетчика: " + this.counter);
    }
}
