// mengimpor Scanner ke program
import java.util.Scanner;

// Membut Class
public class Jobvacancy3{
    public static void main (String [] args){

         // deklarasi variabel
         Scanner keyboard = new Scanner(System.in); // untuk inputan user
         String nama, JenisKelamin, posisi, lulusan, hasil;
         int umur, pengalaman;
         double penampilan;
         boolean isPassing;

         // Mengatur inisialisasi
       

         // Tampilkan input user
        System.out.println("Siapa Nama Mu : ");
        nama = keyboard.next();

        System.out.println("Berapa Umur Mu :");
        umur = keyboard.nextInt();

        System.out.println("Jenis Kelamin (Pria / Wanita):");
        JenisKelamin = keyboard.next();

        System.out.println("Lulusan (SMK / D3 / S1):");
        lulusan = keyboard.next();

        System.out.println("Pengalaman Bekerja : ");
        pengalaman = keyboard.nextInt();

        System.out.println("Penampilan Anda (1 - 10)");
        penampilan = keyboard.nextDouble();

        System.out.println("Posisi yang Anda Dilamar ( SPV, Admin Atau Kordinator )? ");
        posisi = keyboard.next();

         // alogirtma IF Else dan tambah nested
         if (posisi.equalsIgnoreCase("Koordinator")){ 
            // pemanggilan funsion untuk validasi koordinator
            isPassing = validateKoordinator(umur, JenisKelamin,lulusan, pengalaman,penampilan);
         }else if(posisi.equalsIgnoreCase("Admin")){
            // pemanggilan fungsion untuk validasi Admin
            isPassing = validateAdmin(umur, JenisKelamin,lulusan, pengalaman,penampilan);
         }else if(posisi.equalsIgnoreCase("SPV")){
            // pemanggilan fungsion untuk validasi SPV
            isPassing = validateSPV(umur, JenisKelamin,lulusan, pengalaman,penampilan);
         }else{
            // jika kriteria tidak di temukan
            isPassing = false;
         }

         // membuat kondisi if untuk menentukan hasil berupa Output text
         if (isPassing){ 
                hasil = ("Selamat " + nama + " Anda memenuhi Persyaratan Sebagai " + posisi + " dan Berhak Untuk ke Tahap Berikutnya \n");
            }else hasil = (" Mohon Maaf " + nama  + ", Anda Belum Memenuhi Syarat Sebagai " + posisi + " dan Anda Belum Berhak Untuk ke Tahap Berikutnya \n");


        // Pengecekan posisi
         printResult(nama, hasil, posisi);
         
    }

    // membuat funsion untuk posisi koordinator
    // membuat retrun value berupa boolean

    public static boolean validateKoordinator(int umur, String JenisKelamin,String lulusan, int pengalaman, double penampilan){
        // dekralasi variabel
        boolean kor1, kor2, result;

        // membuat kriteria koordinator
        kor1 = JenisKelamin.equalsIgnoreCase("Pria") && umur >= 21 && umur <= 30 && (lulusan.equalsIgnoreCase("SMK") || lulusan.equalsIgnoreCase("D3")) && pengalaman >= 2;
        kor2 = JenisKelamin.equalsIgnoreCase("Pria") && umur >= 30 && (lulusan.equalsIgnoreCase("S1")) && pengalaman >= 5;

        // Inisaliasi jika benar atau salah
        if(kor1 || kor2){
            result = true;
        }else{
            result = false;
        }
        return result;
    }

     // membuat funsion untuk posisi admin
    // membuat retrun value berupa boolean
    public static boolean validateAdmin(int umur, String JenisKelamin,String lulusan, int pengalaman, double penampilan){
        // dekralasi variabel
        boolean ad1, ad2, ad3, result;

        // membuat kriteria Admin
        ad1 = JenisKelamin.equalsIgnoreCase("Wanita") && umur >= 20 && umur <= 25 && lulusan.equalsIgnoreCase("D3") && (penampilan >= 8.5 || pengalaman >= 1);
        ad2 = JenisKelamin.equalsIgnoreCase("Wanita") && umur >= 25 && lulusan.equalsIgnoreCase("S1") && penampilan >= 8.5 && pengalaman >= 3;
        ad3 = JenisKelamin.equalsIgnoreCase("Pria") && umur >= 20 && umur <= 30 && penampilan >= 8.5 && (lulusan.equalsIgnoreCase("D3") || lulusan.equalsIgnoreCase("S1")) && pengalaman >= 2;

        // Inisalisasi jika benar atau salah
        if(ad1 || ad2 || ad3){
            result = true;
        }else{
            result = false;
        }
        return result;
    }

    // membuat funsion untuk posisi SPV
    // membuat retrun value berupa boolean
    public static boolean validateSPV(int umur, String JenisKelamin,String lulusan, int pengalaman, double penampilan){
        // dekralasi variabel
        boolean spv1, spv2, result;

        // membuat kriteria SPV
        spv1 = (JenisKelamin.equalsIgnoreCase("Pria") || JenisKelamin.equalsIgnoreCase("Wanita")) && umur >= 23 && umur <= 30 && lulusan.equalsIgnoreCase("S1") && pengalaman >= 1;
        spv2 = (JenisKelamin.equalsIgnoreCase("Pria") || JenisKelamin.equalsIgnoreCase("Wanita")) && umur >= 25 && umur <= 35 && lulusan.equalsIgnoreCase("D3") && pengalaman >= 4;

        // Inisialisasi jika benar atau salah
        if(spv1 || spv2){
            result = true;
        }else{
            result = false;
        }
        return result;
    }

    public static void printResult(String nama, String hasil, String posisi){
        System.out.println();
        System.out.println(nama + " Terimakasih sudah mengikuti proses rekrutmen PT ini \n ");
        System.out.println(" Berikut ini adalah hasil untuk rerutman posisi"+ posisi + " :");
        System.out.println(hasil); 
    }

}