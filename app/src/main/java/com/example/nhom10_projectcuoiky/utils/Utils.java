package com.example.nhom10_projectcuoiky.utils;

import com.example.nhom10_projectcuoiky.model.GioHang;
import com.example.nhom10_projectcuoiky.model.User;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static final String BASE_URL ="http://192.168.1.20/banhang/";
    public static List<GioHang> manggiohang;
    public static List<GioHang> mangmuahang = new ArrayList<>();
    public static User user_current = new User();
}
