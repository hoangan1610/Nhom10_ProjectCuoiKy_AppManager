package com.example.nhom10_projectcuoiky.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nhom10_projectcuoiky.R;
import com.example.nhom10_projectcuoiky.adapter.CoBidaLoAdapter;
import com.example.nhom10_projectcuoiky.model.SanPhamMoi;
import com.example.nhom10_projectcuoiky.model.SanPhamMoiModel;
import com.example.nhom10_projectcuoiky.retrofit.ApiBanHang;
import com.example.nhom10_projectcuoiky.retrofit.RetrofitClient;
import com.example.nhom10_projectcuoiky.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SearchActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    EditText edtsearch;
    CoBidaLoAdapter adapterLo;
    List<SanPhamMoi> sanPhamMoiList;
    ApiBanHang apiBanHang;
    CompositeDisposable compositeDisposable = new CompositeDisposable();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
        ActionToolBar();
    }

    private void initView() {
        sanPhamMoiList = new ArrayList<>();
        apiBanHang = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiBanHang.class);

        edtsearch = findViewById(R.id.edtsearch);
        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recycleview_search);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        edtsearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() == 0){
                    sanPhamMoiList.clear();
                    adapterLo = new CoBidaLoAdapter(getApplicationContext(), sanPhamMoiList);
                    recyclerView.setAdapter(adapterLo);
                }else {
                    getDataSearch(s.toString());
                }


            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });


    }

    private void getDataSearch(String s) {
        sanPhamMoiList.clear();
        String str_search = edtsearch.getText().toString().trim();
        compositeDisposable.add(apiBanHang.search(s)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        sanPhamMoiModel -> {
                                if(sanPhamMoiModel.isSuccess()){
                                    sanPhamMoiList = sanPhamMoiModel.getResult();
                                    adapterLo = new CoBidaLoAdapter(getApplicationContext(), sanPhamMoiList);
                                    recyclerView.setAdapter(adapterLo);
                                }
                        },
                        throwable -> {
                            Toast.makeText(getApplicationContext(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
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

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }
}