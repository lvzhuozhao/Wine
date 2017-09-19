package com.wuxiaolong.androidmvpsample;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.wuxiaolong.androidmvpsample.base.BasePresenter;
import com.wuxiaolong.androidmvpsample.base.MvpActivity;
import com.wuxiaolong.androidmvpsample.bean.Login;
import com.wuxiaolong.androidmvpsample.can.Can_GeRenActivity;
import com.wuxiaolong.androidmvpsample.ke.Ke_GeRenActivity;
import com.wuxiaolong.androidmvpsample.mvp.Yingxiao.Ying_GeRenActivity;
import com.wuxiaolong.androidmvpsample.retrofit.ApiStores;
import com.wuxiaolong.androidmvpsample.utils.SharedPreferencesUtils;
import com.wuxiaolong.androidmvpsample.wen.Wen_GeRenActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends MvpActivity {


    @Bind(R.id.login_name)
    EditText loginName;
    @Bind(R.id.login_pwd)
    EditText loginPwd;
    @Bind(R.id.login_btn)
    Button loginBtn;
    private String department;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(LoginActivity.this);
        SharedPreferencesUtils.setParam(LoginActivity.this,"room","room");
        SharedPreferencesUtils.setParam(LoginActivity.this,"rest","rest");
        SharedPreferencesUtils.setParam(LoginActivity.this,"spring","spring");
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }


    @OnClick({R.id.login_name, R.id.login_pwd, R.id.login_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_name:
                break;
            case R.id.login_pwd:
                break;
            case R.id.login_btn:
                tiaozhuan();


                break;
        }
    }

    private void tiaozhuan() {
        String trim = loginName.getText().toString().trim();
        String trim1 = loginPwd.getText().toString().trim();
        if (trim.equals("room") && trim1.equals("room")) {
            data();
            Intent intent = new Intent(LoginActivity.this, Ke_GeRenActivity.class);
            intent.putExtra("department", department);
            startActivity(intent);
        } else if (trim.equals("rest") && trim1.equals("rest")) {
            data();
            Intent intent = new Intent(LoginActivity.this, Can_GeRenActivity.class);
            intent.putExtra("department", department);
            startActivity(intent);
        } else if (trim.equals("spring") && trim1.equals("spring")) {
            data();
            Intent intent = new Intent(LoginActivity.this, Wen_GeRenActivity.class);
            intent.putExtra("department", department);
            startActivity(intent);
        } else if (trim.equals("market") && trim1.equals("market")) {
            data();
            Intent intent = new Intent(LoginActivity.this, Ying_GeRenActivity.class);
            intent.putExtra("department", department);
            startActivity(intent);
        }
        else if (trim.equals("reserve") && trim1.equals("reserve"))
        {
            data();
            Intent intent = new Intent(LoginActivity.this, Ying_GeRenActivity.class);
            intent.putExtra("department", department);
            startActivity(intent);
        }else if (trim.equals("") || trim1.equals("")) {
            toastShow("用户名或密码不能为空！");
        } else {
            toastShow("用户名或密码错误！");
        }
    }

    private void data() {
        String url = ApiStores.API_SERVER_URL + "user/user!signIn.action?userName=" +
                loginName.getText().toString().trim() + "&password=" + loginPwd.getText().toString().trim();
        Log.d("yy", url);
        OkHttpUtils.get().url(url)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Request request, Exception e) {


            }

            @Override
            public void onResponse(String response) {
                Log.d("yy", response);
                Gson gson = new Gson();
                Login login = gson.fromJson(response, Login.class);
                department = login.getJsonInfo().getData().getDepartment();

            }
        });
    }

    @Override
    public int[] hideSoftByEditViewIds() {
        int[] ids = {R.id.login_name, R.id.login_pwd};
        return ids;
    }

    @Override
    public View[] filterViewByIds() {

        View[] views = {loginName};
        return views;
    }
}
