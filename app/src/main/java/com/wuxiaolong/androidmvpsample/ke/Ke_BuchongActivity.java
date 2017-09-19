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

public class Ke_BuchongActivity extends MvpActivity {

    @Bind(R.id.bu_back)
    ImageView buBack;
    @Bind(R.id.real)
    RelativeLayout real;
    @Bind(R.id.bu_name)
    EditText buName;
    @Bind(R.id.bu_haoma)
    EditText buHaoma;
    @Bind(R.id.bu_btn)
    Button buBtn;
    private String number;
    private String number1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buchong);
        ButterKnife.bind(this);
        number1 = (String) SharedPreferencesUtils.getParam(Ke_BuchongActivity.this, "number", "");
        Log.d("uu", number1);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @OnClick({R.id.bu_back, R.id.bu_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bu_back:
                finish();
                break;
            case R.id.bu_btn:
                String url = ApiStores.API_SERVER_URL + "room/room!supplementaryInfo.action?roomNumber=" + number1 +
                        "&guestName=" + buName.getText().toString().trim()
                        + "&identityCardNumber=" + buHaoma.getText().toString().trim();
                Log.d("uu",url);
                OkHttpUtils.get().url(url).build().execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {
                        Log.d("uu",response);
                        Intent intent = new Intent(Ke_BuchongActivity.this, Ke_JieZhangActivity.class);
                        startActivity(intent);
                    }
                });

                break;
        }
    }


}
