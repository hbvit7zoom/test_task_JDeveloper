import java.io.IOException;

public class Counter {
    boolean readyToWork;
    private int counter;
    StreamWork stream;
    public Counter() {
        stream = new StreamWork();
        counter = stream.get_count();
        readyToWork = true;
    };

    public int get_counter(){
        return this.counter;
    }
    public void set_counter(int counter){
        this.counter = counter;
    }
    public boolean run(String cmd) {
        boolean isWorking = true;
        switch (cmd) {
            case ("/inc"):
                inc_counter();
                break;
            case ("/stop"):
                stop_counter();
                isWorking = false;
                break;
            case ("/reset"):
                reset_counter();
                break;
            default:
                System.out.println("Введите другую команду");
                break;
        }
        return isWorking;
    }
    private void inc_counter() {
        this.counter++;
        System.out.println("Текущее состояние счетчика: " + this.counter);
    }
    private void stop_counter(){
        System.out.println("Текущее состояние счетчика: " + this.counter);
        System.out.println("Завершение работы");
        try {
            stream.saveCountToFile(this.counter);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        this.readyToWork = false;
    }
    private void reset_counter(){
        this.counter = 0;
        System.out.println("Текущее состояние счетчика: " + this.counter);
    }

}
