package com.wuxiaolong.androidmvpsample.wen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wuxiaolong.androidmvpsample.FinishActivity;
import com.wuxiaolong.androidmvpsample.R;
import com.wuxiaolong.androidmvpsample.base.BasePresenter;
import com.wuxiaolong.androidmvpsample.base.MvpActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Wen_GeRenActivity extends MvpActivity {

    @Bind(R.id.wc_back)
    ImageView wcBack;
    @Bind(R.id.can_yuding_title)
    TextView canYudingTitle;
    @Bind(R.id.real)
    RelativeLayout real;
    @Bind(R.id.wc_btn1)
    Button wcBtn1;
    @Bind(R.id.wc_btn2)
    Button wcBtn2;
    @Bind(R.id.tuichu)
    ImageView tuichu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ggggg);
        ButterKnife.bind(this);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @OnClick({R.id.wc_back, R.id.wc_btn1, R.id.wc_btn2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.wc_back:
                finish();
                break;
            case R.id.wc_btn1:
                Intent intent = new Intent(Wen_GeRenActivity.this, Wen_DingdanActivity.class);
                startActivity(intent);

                break;
            case R.id.wc_btn2:
                Intent intent1 = new Intent(Wen_GeRenActivity.this, Wen_liebiaoActivity.class);
                startActivity(intent1);
                break;
        }
    }

    @OnClick(R.id.tuichu)
    public void onViewClicked() {
        Intent  intent=new Intent(Wen_GeRenActivity.this, FinishActivity.class);
        startActivity(intent);
    }
}
