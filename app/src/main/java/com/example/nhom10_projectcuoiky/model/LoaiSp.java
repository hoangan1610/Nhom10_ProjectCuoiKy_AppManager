package com.example.nhom10_projectcuoiky.model;

public class LoaiSp {
    int id;
    String tensanpham;

    public LoaiSp(String tensanpham, String hinhanh) {
        this.tensanpham = tensanpham;
        this.hinhanh = hinhanh;
    }

    String hinhanh;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }
}
