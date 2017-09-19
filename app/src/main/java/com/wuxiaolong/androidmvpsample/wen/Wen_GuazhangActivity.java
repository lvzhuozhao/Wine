package com.wuxiaolong.androidmvpsample.wen;

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
import com.wuxiaolong.androidmvpsample.bean.Wen_guaweb;
import com.wuxiaolong.androidmvpsample.retrofit.ApiStores;
import com.wuxiaolong.androidmvpsample.utils.SharedPreferencesUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Wen_GuazhangActivity extends MvpActivity {

    @Bind(R.id.banli_back)
    ImageView banliBack;
    @Bind(R.id.real)
    RelativeLayout real;
    @Bind(R.id.why_name)
    EditText whyName;
    @Bind(R.id.btn)
    Button btn;
    private String spring;
    private String oid;
    private String trim;
    private String trim1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w__guazhang);
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

    @OnClick({R.id.banli_back, R.id.btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.banli_back:
                finish();
                break;
            case R.id.btn:
                spring = (String) SharedPreferencesUtils.getParam(Wen_GuazhangActivity.this, "spring", "");
                String  url= ApiStores.API_SERVER_URL+"hotspring/hotspring!credit.action?orderId="+oid+
                        "&keyBrand="+trim+"&sum="+trim1+"&roomNumber="+whyName.getText().toString().trim()+"&userName="+spring;
                Log.d("iii",url);
                OkHttpUtils.get().url(url).build().execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {
                        Gson gson=new Gson();
                        Wen_guaweb wen_guaweb = gson.fromJson(response, Wen_guaweb.class);
                        String url1 = wen_guaweb.getJsonInfo().getData().getUrl();
                        Intent intent=new Intent(Wen_GuazhangActivity.this,Wen_gua_webActivity.class);
                        intent.putExtra("url",url1);
                        startActivity(intent);
                        Log.d("iii",response);
                    }
                });
                break;
        }
    }
}
