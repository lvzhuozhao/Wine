package com.wuxiaolong.androidmvpsample.zhang_fra;

import android.os.Bundle;

import com.wuxiaolong.androidmvpsample.base.BasePresenter;
import com.wuxiaolong.androidmvpsample.base.MvpFragment;

/**
 * Created by LZZ on 2017/8/24.
 */

public class Zhang_ke_fra extends MvpFragment {
    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
    public static Zhang_ke_fra newInstance(int index){
        Bundle bundle = new Bundle();
        bundle.putInt("index", 'A' + index);
        Zhang_ke_fra fragment = new Zhang_ke_fra();
        fragment.setArguments(bundle);
        return fragment;
    }
}
