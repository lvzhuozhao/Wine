package com.wuxiaolong.androidmvpsample.wen;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.wuxiaolong.androidmvpsample.R;
import com.wuxiaolong.androidmvpsample.base.BasePresenter;
import com.wuxiaolong.androidmvpsample.base.MvpActivity;
import com.wuxiaolong.androidmvpsample.retrofit.ApiStores;
import com.wuxiaolong.androidmvpsample.utils.SharedPreferencesUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Wen_jiezhangwayActivity extends MvpActivity {

    @Bind(R.id.jj_back)
    ImageView jjBack;
    @Bind(R.id.real)
    RelativeLayout real;
    @Bind(R.id.zz_btn1)
    Button zzBtn1;
    @Bind(R.id.zz_btn2)
    Button zzBtn2;
    @Bind(R.id.zz_btn3)
    Button zzBtn3;
    private String oid;
    private String trim;
    private String trim1;
    private String rest;
    private String spring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ww__jie_zhang__);
        ButterKnife.bind(this);
        Intent intent=getIntent();
        oid = intent.getStringExtra("oid");
        trim = intent.getStringExtra("trim");
        trim1 = intent.getStringExtra("trim1");
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @OnClick({R.id.jj_back, R.id.zz_btn1, R.id.zz_btn2, R.id.zz_btn3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.jj_back:
                finish();
                break;
            case R.id.zz_btn1:
                spring = (String) SharedPreferencesUtils.getParam(Wen_jiezhangwayActivity.this, "spring", "");
                String  url= ApiStores.API_SERVER_URL+"hotspring/hotspring!checkout.action?orderId="
                        +oid+"&keyBrand="+trim+"&sum="+trim1+"&userName="+spring;
                Log.d("eee",url);
                OkHttpUtils.get().url(url).build().execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {
                        Gson gson=new Gson();
                        Wen_url wen_url = gson.fromJson(response, Wen_url.class);
                        String url1 = wen_url.getJsonInfo().getData().getUrl();
                        Intent intent=new Intent(Wen_jiezhangwayActivity.this,Wen_jiezhangwebActivity.class);
                        intent.putExtra("dataurl",url1);
                        startActivity(intent);
                        Log.d("eee",response);
                    }
                });
                break;
            case R.id.zz_btn2:
                break;
            case R.id.zz_btn3:
                break;
        }
    }
}
