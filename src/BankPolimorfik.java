public class BankPolimorfik {
    public static void main(String[] args) {
        // Simulasi pesan error karena instance abstract
        /*
         * Rekening rekSalah = new Rekening("000", "Testing", 100000);
         * java: Rekening is abstract; cannot be instantiated
         */

        System.out.println("=== Inisiasi Object ===");
        // Buat object di variabel ani, citra, budi
        Tabungan ani = new Tabungan("101", "Ani", 1000000, 2.5); // Tabungan 101 Ani
        Tabungan citra = new Tabungan("102", "Citra", 300000, 2.0); // Tabungan 102 Citra
        Giro budi = new Giro("201", "Budi", 200000, 500000); // Giro 201 Budi

        ani.cetakInfo();
        citra.cetakInfo();
        budi.cetakInfo();

        // 1. Koleksi Rekening (Polymorphism Abstract Class)
        Rekening[] semua = { ani, citra, budi };

        // 2. Koleksi BerBunga (Polymorphism Interface) tanpa instanceof
        BerBunga[] berbunga = { ani, citra };

        System.out.println("\n=== Proses Akhir Bulan ===");

        // potong biaya admin semua rekening
        for (Rekening rek : semua) {
            int admin = rek.potongBiayaAdmin(); // polymorphism bekerja otomatis
            System.out.println("Biaya admin " + rek.getNomor() + " dipotong: " + Rekening.formatRupiah(admin));
        }

        // tambahkan bunga untuk rekening yang berbunga
        for (BerBunga b : berbunga) {
            int bungaHitung = b.tambahBunga(); // interface method
            System.out.println("Bunga " + b.getNomor() + " bertambah: " + Rekening.formatRupiah(bungaHitung));
        }

        System.out.println("\n=== Saldo Akhir ===");
        int totalDana = 0;

        // cetak saldo akhir dan total dana bank
        for (Rekening rek : semua) {
            rek.cetakInfo();
            totalDana += rek.getSaldo();
        }
        System.out.println("\nTotal Dana di Bank: " + Rekening.formatRupiah(totalDana));
    }
}