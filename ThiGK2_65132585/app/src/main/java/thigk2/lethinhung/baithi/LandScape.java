package thigk2.lethinhung.baithi;

public class LandScape {
    private String landscapeName;
    private String landscapeImage;
    private String address; // thêm

    public LandScape(String landscapeName, String landscapeImage, String address) {
        this.landscapeName = landscapeName;
        this.landscapeImage = landscapeImage;
        this.address = address;
    }

    public String getLandscapeName() {
        return landscapeName;
    }

    public String getLandscapeImage() {
        return landscapeImage;
    }

    public String getAddress() {
        return address;
    }
}