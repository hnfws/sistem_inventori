package tokoOnline.BackEnd;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StokHabisException extends Exception {
    private String namaBarang;
    private Date waktu;

    public StokHabisException(String namaBarang) {
        this(namaBarang, new Date()); // default pakai waktu sekarang
    }

    public StokHabisException(String namaBarang, Date waktu) {
        super("Stok barang \"" + namaBarang + "\" sudah HABIS! (pada " 
              + new SimpleDateFormat("dd-MM-yyyy HH:mm").format(waktu) + ")");
        this.namaBarang = namaBarang;
        this.waktu = waktu;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public Date getWaktu() {
        return waktu;
    }
}