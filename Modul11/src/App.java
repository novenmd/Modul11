import java.io.*;

public class App {
    public static void main(String[] args) {
        String[] validBookIds = {"B001", "B002", "B003"};
        BufferedReader reader = null;

        try {
            FileReader file = new FileReader("src/data.txt");
            reader = new BufferedReader(file);

            String nama = reader.readLine();
            String bookId = reader.readLine();
            String lamaPinjamStr = reader.readLine();

            System.out.println("Masukkan nama Anda: " + nama);
            System.out.println("Masukkan ID buku: " + bookId);
            System.out.println("Masukkan lama peminjaman (hari): " + lamaPinjamStr);

            int lamaPinjam = Integer.parseInt(lamaPinjamStr.trim());

            boolean idValid = false;
            for (String id : validBookIds) {
                if (id.equalsIgnoreCase(bookId)) {
                    idValid = true;
                    break;
                }
            }

            if (!idValid) {
                throw new InvalidBookIdException("Exception: ID buku tidak ditemukan dalam sistem.");
            }

            if (lamaPinjam < 1 || lamaPinjam > 14) {
                throw new InvalidLoanDurationException("Exception: Lama peminjaman harus antara 1 - 14 hari.");
            }

            System.out.println("Peminjaman berhasil untuk " + nama + " dengan ID buku " + bookId + " selama " + lamaPinjam + " hari.");

        } catch (InvalidBookIdException | InvalidLoanDurationException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Exception: Lama peminjaman harus berupa angka.");
        } finally {
            try {
                if (reader != null) reader.close();
            } catch (IOException e) {
                System.out.println("Gagal menutup file: " + e.getMessage());
            }
            System.out.println("Program selesai.");
        }
    }
}
