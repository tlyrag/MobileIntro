package com.example.lec7demo;

public class GalleryImg {
    private int imgId;
    private String imgName;
    private int imgPic;

    public GalleryImg(int imgId, String imgName, int imgPic) {
        this.imgId = imgId;
        this.imgName = imgName;
        this.imgPic = imgPic;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public int getImgPic() {
        return imgPic;
    }

    public void setImgPic(int imgPic) {
        this.imgPic = imgPic;
    }
}
