package com.wuxiaolong.androidmvpsample.ke;

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

public class Ke_jieqianActivity extends MvpActivity {

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
    @Bind(R.id.jieqian_btn)
    Button jieqianBtn;
    @Bind(R.id.danbaoren)
    EditText danbaoren;
    private String number;
    private String guestName;
    private String sum;
    private String reserveUser;
    private String str;
    private String result;
    private String room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jieqian);
        ButterKnife.bind(this);
        number = (String) SharedPreferencesUtils.getParam(Ke_jieqianActivity.this, "number", "");
        Intent intent = getIntent();
        guestName = intent.getStringExtra("guestName");
        sum = intent.getStringExtra("sum");
        reserveUser = intent.getStringExtra("reserveUser");
        str = intent.getStringExtra("str");
        jieqianren.setText(guestName);
        jieqianjine.setText(sum);
        String sss = sum;
        result = sss.substring(1, 6);
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
                room = (String) SharedPreferencesUtils.getParam(Ke_jieqianActivity.this, "room", "");
                String url = ApiStores.API_SERVER_URL + "room/room!oweMoney.action?roomNumber=" + number
                        + "&guestName=" + guestName
                        + "&sum=" + result
                        + "&oweMoneyDate=" + str
                        + "&guaranteeName=" + reserveUser
                        +"&userName="+room;
                Log.d("t", url);
                OkHttpUtils.get().url(url).build().execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {
                        Log.d("t", response);
                        toastShow("结欠成功");
                        Intent intent = new Intent(Ke_jieqianActivity.this, Ke_GeRenActivity.class);
                        startActivity(intent);
                    }
                });
                break;
        }
    }


}
