package ltn.edu.appfood;

public class MonAn {
    private String tenMonAn;
    private double donGia;
    private String moTa;
    private int idAnhMH;
    //hàm tạo
    public MonAn(String tenMonAn, double donGia, String moTa, int idAnhMH) {
        this.tenMonAn = tenMonAn;
        this.donGia = donGia;
        this.moTa = moTa;
        this.idAnhMH = idAnhMH;
    }
    //các getter setter

    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getIdAnhMH() {
        return idAnhMH;
    }

    public void setIdAnhMH(int idAnhMH) {
        this.idAnhMH = idAnhMH;
    }
}
