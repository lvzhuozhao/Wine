package com.wuxiaolong.androidmvpsample.can;

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
import com.wuxiaolong.androidmvpsample.bean.CanGGG;
import com.wuxiaolong.androidmvpsample.retrofit.ApiStores;
import com.wuxiaolong.androidmvpsample.utils.SharedPreferencesUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Can_guazhangActivity extends MvpActivity {

    @Bind(R.id.banli_back)
    ImageView banliBack;
    @Bind(R.id.real)
    RelativeLayout real;
    @Bind(R.id.why_name)
    EditText whyName;
    @Bind(R.id.btn)
    Button btn;
    private String oid;
    private String trim;
    private String trim1;
    private String trim2;
    private String rest;
    private String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guazhang);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        oid = intent.getStringExtra("oid");
        trim = intent.getStringExtra("trim");
        trim1 = intent.getStringExtra("trim1");
        trim2 = intent.getStringExtra("trim2");

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
                rest = (String) SharedPreferencesUtils.getParam(Can_guazhangActivity.this, "rest", "");
                String url = ApiStores.API_SERVER_URL + "restaurant/restaurant!credit.action?orderId=" + oid + "&deskNumber=" +
                        trim + "&sum=" + trim1 + "&guestCount=" + trim2 + "&roomNumber=" + whyName.getText().toString().trim()+
                        "&userName="+rest;
                Log.d("rrr",url);
                OkHttpUtils.get().url(url).build().execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {
                        Log.d("rrr",response);
                        Gson  gson=new Gson();
                        CanGGG canGGG = gson.fromJson(response, CanGGG.class);
                        code = canGGG.getJsonInfo().getCode();
                        String msg = canGGG.getJsonInfo().getMsg();
                        String url1 = canGGG.getJsonInfo().getData().getUrl();
                        if (code.equals("0"))
                        {
                           Intent  intent=new Intent(Can_guazhangActivity.this,Can_guaWebActivity.class);
                           intent.putExtra("url1",url1);
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
