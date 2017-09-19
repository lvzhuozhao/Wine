package com.wuxiaolong.androidmvpsample.ke;

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

public class Ke_DingDanActivity extends MvpActivity {

    @Bind(R.id.ding_center_back)
    ImageView dingCenterBack;
    @Bind(R.id.ding_btn1)
    Button dingBtn1;
    @Bind(R.id.ding_btn2)
    Button dingBtn2;
    @Bind(R.id.ding_btn3)
    Button dingBtn3;
    private String department;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ke__ding);
        ButterKnife.bind(this);
        Intent intent=getIntent();
        department = intent.getStringExtra("department");
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }


    @OnClick({R.id.ding_center_back, R.id.ding_btn1, R.id.ding_btn2, R.id.ding_btn3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ding_center_back:
                finish();
                break;
            case R.id.ding_btn1:

                Intent intent=new Intent(Ke_DingDanActivity.this, Ke_fangtaiActivity.class);
                intent.putExtra("department",department);
                startActivity(intent);

                break;
            case R.id.ding_btn2:
                Intent intent1 = new Intent(Ke_DingDanActivity.this, Ke_Yu_CanActivity.class);
                intent1.putExtra("tag", "11");
                startActivity(intent1);
                break;
            case R.id.ding_btn3:
                Intent intent2 = new Intent(Ke_DingDanActivity.this, Ke_Yu_CanActivity.class);
                intent2.putExtra("tag", "22");
                startActivity(intent2);
                break;
        }
    }





}
