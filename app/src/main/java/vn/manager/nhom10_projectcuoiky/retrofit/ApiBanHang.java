package vn.manager.nhom10_projectcuoiky.retrofit;
import  io.reactivex.rxjava3.core.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

import retrofit2.http.Multipart;
import retrofit2.http.Part;
import vn.manager.nhom10_projectcuoiky.model.DonHangModel;
import vn.manager.nhom10_projectcuoiky.model.LoaiSpModel;
import vn.manager.nhom10_projectcuoiky.model.MessageModel;
import vn.manager.nhom10_projectcuoiky.model.SanPhamMoiModel;
import vn.manager.nhom10_projectcuoiky.model.ThongKe;
import vn.manager.nhom10_projectcuoiky.model.ThongKeModel;
import vn.manager.nhom10_projectcuoiky.model.UserModel;

import retrofit2.http.POST;

public interface ApiBanHang {
    @GET("getloaisp.php")
    Observable<LoaiSpModel> getLoaiSp();

    @GET("getspmoi.php")
    Observable<SanPhamMoiModel> getSpMoi();
    @GET("thongke.php")
    Observable<ThongKeModel> getthongke();
    @GET("thongkethang.php")
    Observable<ThongKeModel> getthongkeThang();

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
            @Field("mobile") String mobile,
            @Field("uid") String uid
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

    @FormUrlEncoded
    @POST("xoa.php")
    Observable<MessageModel> xoaSanPham(
            @Field("id") int id
    );

    @FormUrlEncoded
    @POST("insertsp.php")
    Observable<MessageModel> insertSp(
            @Field("tensp") String tensp,
            @Field("gia") String gia,
            @Field("hinhanh") String hinhanh,
            @Field("mota") String mota,
            @Field("loai") int id
    );

    @FormUrlEncoded
    @POST("updatesp.php")
    Observable<MessageModel> updatesp(
            @Field("tensp") String tensp,
            @Field("gia") String gia,
            @Field("hinhanh") String hinhanh,
            @Field("mota") String mota,
            @Field("loai") int idloai,
            @Field("id") int id
    );

    @FormUrlEncoded
    @POST("gettoken.php")
    Observable<UserModel> gettoken(
            @Field("status") int status,
            @Field("iduser") int iduser
    );

    @FormUrlEncoded
    @POST("updatetoken.php")
    Observable<MessageModel> updateToken(
            @Field("id") int id,
            @Field("token") String token

    );

    @FormUrlEncoded
    @POST("updateorder.php")
    Observable<MessageModel> updateOrder(
            @Field("id") int id,
            @Field("trangthai") int trangthai

    );

    @Multipart
    @POST("upload.php")
    Call<MessageModel> uploadFile(@Part MultipartBody.Part file);

}
