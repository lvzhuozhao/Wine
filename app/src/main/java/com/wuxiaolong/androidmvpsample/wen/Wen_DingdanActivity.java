package com.wuxiaolong.androidmvpsample.wen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wuxiaolong.androidmvpsample.R;
import com.wuxiaolong.androidmvpsample.base.BasePresenter;
import com.wuxiaolong.androidmvpsample.base.MvpActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Wen_DingdanActivity extends MvpActivity {

    @Bind(R.id.wc_back)
    ImageView wcBack;
    @Bind(R.id.can_yuding_title)
    TextView canYudingTitle;
    @Bind(R.id.real)
    RelativeLayout real;
    @Bind(R.id.btn1)
    Button btn1;
    @Bind(R.id.btn2)
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wwwww);
        ButterKnife.bind(this);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @OnClick({R.id.wc_back, R.id.btn1, R.id.btn2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.wc_back:
                finish();
                break;
            case R.id.btn1:
                Intent intent1=new Intent(Wen_DingdanActivity.this,Wen_xiadanActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn2:
                Intent intent=new Intent(Wen_DingdanActivity.this,Wen_liebiaoActivity.class);
                startActivity(intent);
                break;
        }
    }
}
