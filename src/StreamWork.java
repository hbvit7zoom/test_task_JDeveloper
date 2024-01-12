import java.io.*;
public class StreamWork implements Serializable{
    private final String filename = "Counter.txt";
    private int cnt;
    public StreamWork() {
        try {
            this.cnt = readCountFromFile();
        }
        catch (IOException e){
            this.cnt = 0;
        }
    }
    public int getCount() {
        return this.cnt;
    }
    public final void saveCountToFile(int cnt) throws IOException{
        try(PrintWriter writer = new PrintWriter(filename)) {
            writer.println(cnt);
        }
    }
    private int readCountFromFile() throws IOException {
        StringBuilder result = new StringBuilder();
        try(BufferedReader br = new BufferedReader((new FileReader(filename)))){
            String line;
            while ((line = br.readLine())!= null){
                result.append(line);
            }
            this.cnt = Integer.parseInt(result.toString());
            System.out.printf("Счетчик загружен, значение '%d'\n", this.cnt);
        } catch(IOException e) {
            this.cnt = 0;
            System.out.println("Текущее значение счетчика: " + this.cnt);
        }
        return this.cnt;
    }
}
