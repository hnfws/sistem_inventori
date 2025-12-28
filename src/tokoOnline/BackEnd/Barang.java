package tokoOnline.BackEnd;

import java.util.ArrayList;
import java.util.Date;

public class Barang {

    private ArrayList<String> namaBarang = new ArrayList<>();
    private ArrayList<Integer> stok = new ArrayList<>();
    private ArrayList<Integer> harga = new ArrayList<>();
    private ArrayList<Date> terakhirMasuk = new ArrayList<>();
    private ArrayList<Date> terakhirKeluar = new ArrayList<>();

    // 🔹 INTEGRASI KATEGORI
    private KategoriBarang kategoriBarang = new KategoriBarang();

    public Barang() {
        // contoh data awal dengan tanggal null
        tambahDataBaru("Kalung Mutiara", "Aksesoris", 10, 9000, null);
        tambahDataBaru("Cincin Manik", "Cincin", 20, 2000, null);
        tambahDataBaru("Gelang Tali", "Gelang", 1, 6000, null);
    }

    // --- Tambah produk baru dengan tanggal masuk ---
    public void tambahDataBaru(String nama, String kategori, int s, int h, Date tanggalMasuk) {
        namaBarang.add(nama);
        stok.add(s);
        harga.add(h);
        terakhirMasuk.add(tanggalMasuk);   // bisa null jika belum ada
        terakhirKeluar.add(null);
        kategoriBarang.tambahKategori(kategori);
    }

    public int getJmlBarang() { return namaBarang.size(); }
    public String getNamaBarang(int id) { return namaBarang.get(id); }
    public int getStok(int id) { return stok.get(id); }
    public int getHarga(int id) { return harga.get(id); }

    public void setNamaBarang(String nama, String kategori, Date tanggalMasuk) {
        namaBarang.add(nama);
        stok.add(0);
        harga.add(0);
        terakhirMasuk.add(tanggalMasuk);
        terakhirKeluar.add(null);
        kategoriBarang.tambahKategori(kategori);
    }

    public String getKategori(int id) {
        return kategoriBarang.getKategori(id);
    }

    public void editStok(int id, int jumlah) throws StokHabisException {
        if (jumlah < 0) {
            throw new StokHabisException(namaBarang.get(id));
        }
        stok.set(id, jumlah);
    }

    public void editHarga(int id, int h) {
        harga.set(id, h);
    }

    // --- Getter & Setter tanggal masuk/keluar ---
    public Date getWaktuMasuk(int id) { return terakhirMasuk.get(id); }
    public void setWaktuMasuk(int id, Date waktu) { terakhirMasuk.set(id, waktu); }
    public Date getWaktuKeluar(int id) { return terakhirKeluar.get(id); }
    public void setWaktuKeluar(int id, Date waktu) { terakhirKeluar.set(id, waktu); }
}