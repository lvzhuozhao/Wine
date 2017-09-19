package com.wuxiaolong.androidmvpsample.ke;

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
import com.wuxiaolong.androidmvpsample.bean.Checkout;
import com.wuxiaolong.androidmvpsample.retrofit.ApiStores;
import com.wuxiaolong.androidmvpsample.utils.SharedPreferencesUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Ke_JiezhangwayActivity extends MvpActivity {

    @Bind(R.id.jj_back)
    ImageView jjBack;
    @Bind(R.id.real)
    RelativeLayout real;
    @Bind(R.id.jj_btn1)
    Button jjBtn1;
    @Bind(R.id.jj_btn2)
    Button jjBtn2;
    @Bind(R.id.jj_btn3)
    Button jjBtn3;
    private String number;
    private String dataurl;
    private String sum;
    private String room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ke_jj);
        ButterKnife.bind(this);
        Intent intent=getIntent();
        sum = intent.getStringExtra("sum");
        Log.d("jine",sum);
        number = (String) SharedPreferencesUtils.getParam(Ke_JiezhangwayActivity.this, "number", "");
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @OnClick({R.id.jj_back, R.id.jj_btn1, R.id.jj_btn2, R.id.jj_btn3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.jj_back:
                finish();
                break;
            case R.id.jj_btn1:
                room = (String) SharedPreferencesUtils.getParam(Ke_JiezhangwayActivity.this, "room", "");
                String substring = sum.substring(1, 4);
                String  url= ApiStores.API_SERVER_URL+"room/room!checkout.action?roomNumber="+number
                       +"&checkOutType="+"现金"+"&sum="+substring+"&userName="+room;
                Log.d("hhh",url);
                OkHttpUtils.get().url(url).build().execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {
                        Log.d("hhh",response);
                        Gson  gson=new Gson();
                        Checkout checkout = gson.fromJson(response, Checkout.class);
                        Checkout.JsonInfoBean.DataBean data = checkout.getJsonInfo().getData();
                        dataurl = data.getUrl();
                        Intent intent=new Intent(Ke_JiezhangwayActivity.this,Ke_WebActivity.class);
                        intent.putExtra("dataurl",dataurl);
                        Log.d("urlurl",dataurl);
                        startActivity(intent);

                    }
                });
                break;
            case R.id.jj_btn2:
                break;
            case R.id.jj_btn3:
                break;
        }
    }
}
