public abstract class Rekening { // Rekening jadi abstract class
    private String nomor;
    private String pemilik;
    protected int saldo; // protected agar dapat diakses oleh child class

    public Rekening(String nomor, String pemilik, int saldo) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    // Method konkret yang memanggil method abstract biayaAdminBulanan
    public int potongBiayaAdmin() {
        int biaya = biayaAdminBulanan(); // polymorphism in action, bergantung pada child
        saldo -= biaya; // mengurangi saldo
        return biaya; // mengembalikan besar biayanya
    }

    // Method abstract, aturan biaya admin belum diketahui di sini (berbeda tiap jenis)
    public abstract int biayaAdminBulanan(); // tanpa {}, diakhiri ;

    public boolean setor(int jumlah) {
        if (jumlah <= 0) return false;
        this.saldo += jumlah;
        return true;
    }

    public boolean tarik(int jumlah) {
        if (jumlah <= 0 || jumlah > this.saldo) return false;
        this.saldo -= jumlah;
        return true;
    }

    public String getNomor() {
        return nomor;
    }

    public int getSaldo() {
        return saldo;
    }

    protected static String formatRupiah(int nominal) {
        return String.format("Rp%,d", nominal).replace(',', '.');
    }

    public void cetakInfo() {
        System.out.println(this.nomor + " | " + this.pemilik + " | " + formatRupiah(this.saldo));
    }
}