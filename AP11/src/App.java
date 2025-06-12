import java.io. *;
public class App {
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("src/data.txt");
            BufferedReader reader = new BufferedReader(file);
            System.out.println(reader.readLine());
            reader.close();
        
        }catch (IOException e) {
            System.out.println("Terjadi Kesalahan Saat Membaca File" + e.getMessage());
        }
    }
}
