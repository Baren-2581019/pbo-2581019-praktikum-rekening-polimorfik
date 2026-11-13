public class Tabungan extends Rekening implements BerBunga {
    private double bungaPersen;

    public Tabungan(String nomor, String pemilik, int saldo, double bungaPersen) {
        super(nomor, pemilik, saldo);
        this.bungaPersen = bungaPersen;
    }

    @Override // override method dari Rekening
    public int biayaAdminBulanan() {
        // gratis kalau saldo >= 1.000.000, selain itu Rp5.000
        if (saldo >= 1000000) {
            return 0;
        } else {
            return 5000;
        }
    }

    @Override // implementasi wajib dari interface BerBunga
    public int tambahBunga() {
        int besarBunga = (int) (saldo * (bungaPersen / 100.0));
        setor(besarBunga);
        return besarBunga;
    }

    @Override
    public void cetakInfo() {
        super.cetakInfo();
        System.out.println("Jenis: Tabungan (Bunga: " + bungaPersen + "%)");
    }
}