package com.wuxiaolong.androidmvpsample.mvp.Yingxiao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.wuxiaolong.androidmvpsample.R;
import com.wuxiaolong.androidmvpsample.base.BasePresenter;
import com.wuxiaolong.androidmvpsample.base.MvpActivity;
import com.wuxiaolong.androidmvpsample.ke.Ke_Yu_CanActivity;
import com.wuxiaolong.androidmvpsample.ke.Ke_fangtaiActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Ying_DingdanActivity extends MvpActivity {


    @Bind(R.id.y_center_back)
    ImageView yCenterBack;
    @Bind(R.id.y_center_btn1)
    Button yCenterBtn1;
    @Bind(R.id.ying_btn2)
    Button yingBtn2;
    @Bind(R.id.ying_btn3)
    Button yingBtn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ying__dingdan);
        ButterKnife.bind(this);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @OnClick({R.id.y_center_back, R.id.y_center_btn1, R.id.ying_btn2, R.id.ying_btn3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.y_center_back:
                finish();
                break;
            case R.id.y_center_btn1:
                Intent  intent=new Intent(Ying_DingdanActivity.this, Ke_fangtaiActivity.class);
                startActivity(intent);
                break;
            case R.id.ying_btn2:
                Intent  intent1=new Intent(Ying_DingdanActivity.this, Ke_Yu_CanActivity.class);
                startActivity(intent1);
                break;
            case R.id.ying_btn3:
                Intent intent2=new Intent(Ying_DingdanActivity.this,Ke_Yu_CanActivity.class);
                startActivity(intent2);
                break;
        }
    }
}



