package com.wuxiaolong.androidmvpsample.wen;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

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

public class Wen_jieqianActivity extends MvpActivity {

    @Bind(R.id.jieqian_back)
    ImageView jieqianBack;
    @Bind(R.id.real)
    RelativeLayout real;
    @Bind(R.id.jieqianren)
    TextView jieqianren;
    @Bind(R.id.jieqianjine)
    TextView jieqianjine;
    @Bind(R.id.jieqianriqi)
    TextView jieqianriqi;
    @Bind(R.id.danbaoren)
    EditText danbaoren;
    @Bind(R.id.jieqian_btn)
    Button jieqianBtn;
    private String oid;
    private String oid1;
    private String trim;
    private String trim1;
    private String guestName1;
    private String reserveUser;
    private String str;
    private String spring;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ww_jieqian);
        ButterKnife.bind(this);
        Intent intent=getIntent();
        oid1 = intent.getStringExtra("oid");
        trim = intent.getStringExtra("trim");
        trim1 = intent.getStringExtra("trim1");
        guestName1 = intent.getStringExtra("guestName1");
        reserveUser = intent.getStringExtra("reserveUser");
        str = intent.getStringExtra("str");
        jieqianjine.setText(trim1);
        jieqianren.setText(guestName1);
        jieqianriqi.setText(str);
        danbaoren.setText(reserveUser);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @OnClick({R.id.jieqian_back, R.id.jieqian_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.jieqian_back:
                finish();
                break;
            case R.id.jieqian_btn:
                 spring = (String) SharedPreferencesUtils.getParam(Wen_jieqianActivity.this, "spring", "");
                String url= ApiStores.API_SERVER_URL+"hotspring/hotspring!oweMoney.action?orderId="+
                        oid1+"&keyBrand="+trim+"&sum="+trim1+"&guestName="+guestName1+
                        "&oweMoneyDate="+str+"&guaranteeName="+reserveUser+"&userName="+spring;
                Log.d("fff",url);
                OkHttpUtils.get().url(url).build().execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {
                        Log.d("fff",response);
                        toastShow("结欠成功");
                        Intent intent=new Intent(Wen_jieqianActivity.this,Wen_GeRenActivity.class);
                        startActivity(intent);
                    }
                });

                break;
        }
    }
}
