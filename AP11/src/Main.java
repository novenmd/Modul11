public class Main {
    public static void main(String[] args) {
        int[] angka = {1, 2, 3};

        try{
            System.out.println(angka[2]);    
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Terjadi Kesalahan:" + e.getMessage());
        }
        try{
            int hasil = 10 / 5;
            System.out.println("Hasil:" + hasil);
        }catch (ArithmeticException e){
            System.out.println("Tidak Bisa Membagi Dengan Nol:" + e.getMessage());
        }
    }
}