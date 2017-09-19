package com.wuxiaolong.androidmvpsample.ke;

import android.app.Fragment;
import android.app.FragmentTransaction;
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
import com.wuxiaolong.androidmvpsample.bean.Yanzheng;
import com.wuxiaolong.androidmvpsample.retrofit.ApiStores;
import com.wuxiaolong.androidmvpsample.utils.AlertDialogFragment;
import com.wuxiaolong.androidmvpsample.utils.SharedPreferencesUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Ke_ShouyinActivity extends MvpActivity {


    @Bind(R.id.shouyin_back)
    ImageView shouyinBack;
    @Bind(R.id.real)
    RelativeLayout real;
    @Bind(R.id.shouyin_numberhhh)
    EditText shouyinNumberhhh;
    @Bind(R.id.shouyin_btn)
    Button shouyinBtn;
    private String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shouyin);
        ButterKnife.bind(this);

    }

    public void showDialogFragment() {
        FragmentTransaction mFragTransaction = getFragmentManager().beginTransaction();
        Fragment fragment = getFragmentManager().findFragmentByTag("dialogFragment");
        if (fragment != null) {
            //为了不重复显示dialog，在显示对话框之前移除正在显示的对话框
            mFragTransaction.remove(fragment);
        }
        AlertDialogFragment dialogFragment = AlertDialogFragment.newInstance("身份信息不完整，是否要补充？");
        dialogFragment.show(mFragTransaction, "dialogFragment");//显示一个Fragment并且给该Fragment添加一个Tag，可通过findFragmentByTag找到该Fragment
    }


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @OnClick({R.id.shouyin_back, R.id.shouyin_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.shouyin_back:
                finish();
                break;
            case R.id.shouyin_btn:
                String url = ApiStores.API_SERVER_URL + "room/room!identityCheck.action?roomNumber=" + shouyinNumberhhh.getText().toString().trim();
                Log.d("d", url);
                OkHttpUtils.get().url(url).build().execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {
                        Log.d("d", response);
                        Gson gson = new Gson();
                        Yanzheng yanzheng = gson.fromJson(response, Yanzheng.class);
                        String isConfirm = yanzheng.getJsonInfo().getData().getIsConfirm();
                        String isCheck = yanzheng.getJsonInfo().getData().getIsCheck();
                        String msg = yanzheng.getJsonInfo().getMsg();
                        if (isCheck.equals("0"))
                        {
                            toastShow(msg);
                        }else  if (isCheck.equals("1"))
                        {
                            if (isConfirm.equals("0")) {
                                showDialogFragment();
                            }
                            else if (isConfirm.equals("1")) {
                                Intent intent = new Intent(Ke_ShouyinActivity.this, Ke_JieZhangActivity.class);
                                startActivity(intent);
                            }
                            number = shouyinNumberhhh.getText().toString().trim();
                            SharedPreferencesUtils.setParam(Ke_ShouyinActivity.this, "number", number);
                        }

                    }
                });


                break;
        }
    }


}
