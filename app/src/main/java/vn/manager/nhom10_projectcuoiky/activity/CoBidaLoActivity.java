package vn.manager.nhom10_projectcuoiky.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import vn.manager.nhom10_projectcuoiky.R;
import vn.manager.nhom10_projectcuoiky.adapter.CoBidaLoAdapter;
import vn.manager.nhom10_projectcuoiky.model.SanPhamMoi;
import vn.manager.nhom10_projectcuoiky.retrofit.ApiBanHang;
import vn.manager.nhom10_projectcuoiky.retrofit.RetrofitClient;
import vn.manager.nhom10_projectcuoiky.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CoBidaLoActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    ApiBanHang apiBanHang;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    int page = 1;
    int loai;
    CoBidaLoAdapter adapterLo;
    List<SanPhamMoi> sanPhamMoiList;
    LinearLayoutManager linearLayoutManager;
    Handler handler = new Handler();
    boolean isLoading = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_co_bida_lo);
        apiBanHang = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiBanHang.class);
        loai = getIntent().getIntExtra("loai", 1);
        AnhXa();
        ActionToolBar();
        getData(page);
        addEventLoad();
    }

    private void addEventLoad() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(isLoading == false) {
                    if(linearLayoutManager.findLastCompletelyVisibleItemPosition() == sanPhamMoiList.size() - 1){
                        isLoading = true;
                        loadMore();
                    }
                }
            }
        });
    }
    private void loadMore(){
        handler.post(new Runnable() {
            @Override
            public void run() {
                //add null
                sanPhamMoiList.add(null);
                adapterLo.notifyItemInserted(sanPhamMoiList.size() -1);
            }
        });
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //remover null
                sanPhamMoiList.remove(sanPhamMoiList.size()-1);
                adapterLo.notifyItemRemoved(sanPhamMoiList.size());
                page = page + 1;
                getData(page);
                adapterLo.notifyDataSetChanged();
                isLoading = false;
            }
        }, 2000);
    }

    private void getData(int page) {
        compositeDisposable.add(apiBanHang.getSanPham(page, loai)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        sanPhamMoiModel -> {
                            if(sanPhamMoiModel.isSuccess()){
                                if (adapterLo == null){
                                    sanPhamMoiList = sanPhamMoiModel.getResult();
                                    adapterLo = new CoBidaLoAdapter(getApplicationContext(), sanPhamMoiList);
                                    recyclerView.setAdapter(adapterLo);
                                }else {
                                    int vitri = sanPhamMoiList.size()-1;
                                    int soluongadd = sanPhamMoiModel.getResult().size();
                                    for (int i = 0; i < soluongadd; i++){
                                        sanPhamMoiList.add(sanPhamMoiModel.getResult().get(i));
                                    }
                                    adapterLo.notifyItemRangeInserted(vitri, soluongadd);
                                }

                            }else {
                                Toast.makeText(getApplicationContext(),"Hết dữ liệu rồi", Toast.LENGTH_LONG).show();
                                isLoading = true;
                            }
                        },
                        throwable -> {
                            Toast.makeText(getApplicationContext(), "Không kết nối sever", Toast.LENGTH_LONG).show();
                        }
                ));


    }

    private void ActionToolBar(){
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void AnhXa(){
        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recycleview_bidalo);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        sanPhamMoiList = new ArrayList<>();

    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }
}

