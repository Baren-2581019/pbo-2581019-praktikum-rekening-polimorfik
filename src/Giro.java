public class Giro extends Rekening { // tidak implements BerBunga
    private int batasOverdraft;

    public Giro(String nomor, String pemilik, int saldo, int batasOverdraft) {
        super(nomor, pemilik, saldo);
        this.batasOverdraft = batasOverdraft;
    }

    @Override // override method abstract parent
    public int biayaAdminBulanan() {
        return 15000; // Giro selalu Rp15.000
    }

    @Override // override tarik dari Bab 10 tetap ada
    public boolean tarik(int jumlah) {
        if (jumlah <= 0 || (saldo - jumlah) < -batasOverdraft) {
            return false;
        }
        saldo -= jumlah;
        return true;
    }

    @Override
    public void cetakInfo() {
        super.cetakInfo();
        System.out.println("Jenis: Giro (Batas Overdraft: " + formatRupiah(batasOverdraft) + ")");
    }
}