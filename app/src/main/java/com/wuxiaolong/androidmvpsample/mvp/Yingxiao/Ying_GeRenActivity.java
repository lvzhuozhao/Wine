package com.wuxiaolong.androidmvpsample.mvp.Yingxiao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.wuxiaolong.androidmvpsample.R;
import com.wuxiaolong.androidmvpsample.base.BasePresenter;
import com.wuxiaolong.androidmvpsample.base.MvpActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Ying_GeRenActivity extends MvpActivity {

    @Bind(R.id.y_center_back)
    ImageView yCenterBack;
    @Bind(R.id.y_center_btn1)
    Button yCenterBtn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ying__ge_ren);
        ButterKnife.bind(this);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @OnClick({R.id.y_center_back, R.id.y_center_btn1})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.y_center_back:
                finish();
                break;
            case R.id.y_center_btn1:
                Intent  intent=new Intent(Ying_GeRenActivity.this,Ying_DingdanActivity.class);
                startActivity(intent);
                break;
        }
    }
}
