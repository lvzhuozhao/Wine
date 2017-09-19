package com.wuxiaolong.androidmvpsample.ke;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.wuxiaolong.androidmvpsample.R;
import com.wuxiaolong.androidmvpsample.base.BasePresenter;
import com.wuxiaolong.androidmvpsample.base.MvpActivity;
import com.wuxiaolong.androidmvpsample.bean.Banli;
import com.wuxiaolong.androidmvpsample.retrofit.ApiStores;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Ke_ChenkinActivity extends MvpActivity {

    @Bind(R.id.shouyin_back)
    ImageView shouyinBack;
    @Bind(R.id.real)
    RelativeLayout real;
    @Bind(R.id.ruzhu_fangjianhao)
    EditText ruzhuFangjianhao;
    @Bind(R.id.ruzhu_name)
    EditText ruzhuName;
    @Bind(R.id.ruzhu_shenfenzheng)
    EditText ruzhuShenfenzheng;
    @Bind(R.id.ruzhu_queding)
    Button ruzhuQueding;
    private String oid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chenkin);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        oid = intent.getStringExtra("oid");
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @OnClick({R.id.shouyin_back, R.id.ruzhu_queding})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.shouyin_back:
                finish();
                break;
            case R.id.ruzhu_queding:
                String url = ApiStores.API_SERVER_URL +
                        "room/room-checkin!roomRecord.action?orderId=" + oid +
                        "&roomNumber=" + ruzhuFangjianhao.getText().toString().trim() +
                        "&guestName=" + ruzhuName.getText().toString().trim() +
                        "&identityCardNumber=" + ruzhuShenfenzheng.getText().toString().trim();
                Log.d("oo",url);
                OkHttpUtils.get().url(url).build().execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {
                        Log.d("oo",response);
                        Gson gson=new Gson();
                        Banli banli = gson.fromJson(response, Banli.class);
                        String msg = banli.getJsonInfo().getMsg();
                        String code = banli.getJsonInfo().getCode();
                        if (code.equals("0"))
                        {
                            toastShow("办理成功");
                            Intent  intent=new Intent(Ke_ChenkinActivity.this,Ke_GeRenActivity.class);
                            startActivity(intent);
                        }
                        if (code.equals("1"))
                        {
                            toastShow(msg);
                        }

                    }
                });
                break;
        }
    }
}
