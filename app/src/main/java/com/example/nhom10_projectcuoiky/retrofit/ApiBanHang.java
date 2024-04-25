package com.example.nhom10_projectcuoiky.retrofit;
import  io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

import com.example.nhom10_projectcuoiky.model.DonHangModel;
import com.example.nhom10_projectcuoiky.model.LoaiSpModel;
import com.example.nhom10_projectcuoiky.model.SanPhamMoiModel;
import com.example.nhom10_projectcuoiky.model.UserModel;

import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiBanHang {
    @GET("getloaisp.php")
    Observable<LoaiSpModel> getLoaiSp();

    @GET("getspmoi.php")
    Observable<SanPhamMoiModel> getSpMoi();

    //POST DATA
    @FormUrlEncoded
    @POST("chitiet.php")
    Observable<SanPhamMoiModel> getSanPham(
            @Field("page") int page,
            @Field("loai") int loai
    );

    @FormUrlEncoded
    @POST("dangki.php")
    Observable<UserModel> dangki(
            @Field("email") String email,
            @Field("pass") String pass,
            @Field("username") String username,
            @Field("mobile") String mobile
    );

    @FormUrlEncoded
    @POST("dangnhap.php")
    Observable<UserModel> dangNhap(
            @Field("email") String email,
            @Field("pass") String pass

    );

    @FormUrlEncoded
    @POST("reset.php")
    Observable<UserModel> resetPass(
            @Field("email") String email
    );

    @FormUrlEncoded
    @POST("donhang.php")
    Observable<UserModel> createOder(
            @Field("email") String email,
            @Field("sdt") String sdt,
            @Field("tongtien") String tongtien,
            @Field("iduser") int id,
            @Field("diachi") String diachi,
            @Field("soluong") int soluong,
            @Field("chitiet") String chitiet
    );

    @FormUrlEncoded
    @POST("xemdonhang.php")
    Observable<DonHangModel> xemDonHang(
            @Field("iduser") int id
    );

    @FormUrlEncoded
    @POST("timkiem.php")
    Observable<SanPhamMoiModel> search(
            @Field("search") String search
    );


}
