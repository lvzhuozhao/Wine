package com.wuxiaolong.androidmvpsample.ke;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

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

public class Ke_WhyActivity extends MvpActivity {

    @Bind(R.id.why_back)
    ImageView whyBack;
    @Bind(R.id.real)
    RelativeLayout real;
    @Bind(R.id.why_name)
    EditText whyName;
    @Bind(R.id.why_btn)
    Button whyBtn;
    private String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_why);
        ButterKnife.bind(this);
        number = (String) SharedPreferencesUtils.getParam(Ke_WhyActivity.this, "number", "");
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @OnClick({R.id.why_back, R.id.why_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.why_back:
                finish();
                break;
            case R.id.why_btn:
             String  url= ApiStores.API_SERVER_URL+"room/room!reason.action?roomNumber="+number
                     +"&reason="+whyName.getText().toString().trim();
                Log.d("ii",url);
                OkHttpUtils.get().url(url).build().execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {
                        Log.d("ii",response);
                        Intent intent=new Intent(Ke_WhyActivity.this,Ke_JieZhangActivity.class);
                        startActivity(intent);
                    }
                });
                break;
        }
    }
}
