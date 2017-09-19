package com.wuxiaolong.androidmvpsample.can;

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
import com.wuxiaolong.androidmvpsample.bean.JJJJJ;
import com.wuxiaolong.androidmvpsample.retrofit.ApiStores;
import com.wuxiaolong.androidmvpsample.utils.SharedPreferencesUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Can_JieZhangActivity extends MvpActivity {

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
    private String trim2;
    private String rest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jie_zhang__);
        ButterKnife.bind(this);
        Intent intent=getIntent();
        oid = intent.getStringExtra("oid");
        trim = intent.getStringExtra("trim");
        trim1 = intent.getStringExtra("trim1");
        trim2 = intent.getStringExtra("trim2");
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
                rest = (String) SharedPreferencesUtils.getParam(Can_JieZhangActivity.this, "rest", "");
                String  url= ApiStores.API_SERVER_URL+"restaurant/restaurant!checkout.action?orderId="+oid+
                      "&deskNumber"+trim+"&sum="+trim1+"&guestCount="+trim2+"&checkOutType="+"现金"+
                        "&userName="+rest;
                Log.d("uuuu",url);
                OkHttpUtils.get().url(url).build().execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {
                        Log.d("uuuu",response);
                        Gson gson=new Gson();
                        JJJJJ jjjjj = gson.fromJson(response, JJJJJ.class);
                        String url1 = jjjjj.getJsonInfo().getData().getUrl();
                        Intent  intent=new Intent(Can_JieZhangActivity.this,Can_WebActivity.class);
                        intent.putExtra("url1",url1);
                        startActivity(intent);
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
