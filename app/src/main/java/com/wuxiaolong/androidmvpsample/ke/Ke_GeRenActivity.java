package com.wuxiaolong.androidmvpsample.ke;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.wuxiaolong.androidmvpsample.FinishActivity;
import com.wuxiaolong.androidmvpsample.R;
import com.wuxiaolong.androidmvpsample.base.BasePresenter;
import com.wuxiaolong.androidmvpsample.base.MvpActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Ke_GeRenActivity extends MvpActivity {


    @Bind(R.id.center_back)
    ImageView centerBack;
    @Bind(R.id.center_btn1)
    Button centerBtn1;
    @Bind(R.id.center_btn2)
    Button centerBtn2;
    @Bind(R.id.center_btn3)
    Button centerBtn3;
    @Bind(R.id.tuichu)
    ImageView tuichu;
    private String department;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ke__ge_ren);

        ButterKnife.bind(this);
        Intent intent = getIntent();
        department = intent.getStringExtra("department");

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }


    public void Tiao(Class v) {
        Intent intent = new Intent(Ke_GeRenActivity.this, v);
        startActivity(intent);
    }



    @OnClick({R.id.center_back, R.id.center_btn1, R.id.center_btn2, R.id.center_btn3,R.id.tuichu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.center_back:
                finish();
                break;
            case R.id.center_btn1:
                Intent intent = new Intent(Ke_GeRenActivity.this, Ke_DingDanActivity.class);
                intent.putExtra("department", department);
                startActivity(intent);
                break;
            case R.id.center_btn2:
                Tiao(Ke_ShouyinActivity.class);
                break;
            case R.id.center_btn3:
                Tiao(Ke_LiebiaoActivity.class);
                break;
            case R.id.tuichu:
                Tiao(FinishActivity.class);
                break;
        }
    }


}
