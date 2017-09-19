package com.wuxiaolong.androidmvpsample.mvp.Wenquan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.wuxiaolong.androidmvpsample.R;
import com.wuxiaolong.androidmvpsample.base.BasePresenter;
import com.wuxiaolong.androidmvpsample.base.MvpActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class C_shouyinActivity extends MvpActivity {


    @Bind(R.id.shouyin_back)
    ImageView shouyinBack;
    @Bind(R.id.real)
    RelativeLayout real;
    @Bind(R.id.shouyin_numberhhh)
    EditText shouyinNumberhhh;
    @Bind(R.id.shouyin_btn)
    Button shouyinBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_shouyin);
        ButterKnife.bind(this);


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
                break;
        }
    }
}
