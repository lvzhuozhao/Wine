package com.wuxiaolong.androidmvpsample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.wuxiaolong.androidmvpsample.base.BasePresenter;
import com.wuxiaolong.androidmvpsample.base.MvpActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FinishActivity extends MvpActivity {

    @Bind(R.id.center_back)
    ImageView centerBack;
    @Bind(R.id.center_btn1)
    Button centerBtn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        ButterKnife.bind(this);

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @OnClick({R.id.center_back, R.id.center_btn1})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.center_back:
                finish();
                break;
            case R.id.center_btn1:
                finish();
                break;
        }
    }
}
