package com.wuxiaolong.androidmvpsample.mvp.Wenquan;

import android.os.Bundle;

import com.wuxiaolong.androidmvpsample.R;
import com.wuxiaolong.androidmvpsample.base.BasePresenter;
import com.wuxiaolong.androidmvpsample.base.MvpActivity;

public class Can_shouyinActivity extends MvpActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_can_shouyin);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
}
