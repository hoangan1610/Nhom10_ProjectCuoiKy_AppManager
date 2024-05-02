package vn.manager.nhom10_projectcuoiky.retrofit;


import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import vn.manager.nhom10_projectcuoiky.model.NotiResponse;
import vn.manager.nhom10_projectcuoiky.model.NotiSendData;

public interface ApiPushNofication {
    @Headers(
            {
                    "Content-Type: application/json",
                    "Authorization: key=AAAAqaliOhg:APA91bEZOVwxpUOmDBFZ1k76KU4Csq2E-HHPNGquUPUfvhZ6tYALGjnjkmVHXJF6bo3_3gySj_3PCUbvxsC9plkzEur96QmbC2nFbzd2Wkz2vjSU8PTLHCjYM4AmwJJgnxDJW0XaCAnn"
            }
    )
    @POST("fcm/send")
    Observable<NotiResponse>sendNofitication(@Body NotiSendData data);
}
