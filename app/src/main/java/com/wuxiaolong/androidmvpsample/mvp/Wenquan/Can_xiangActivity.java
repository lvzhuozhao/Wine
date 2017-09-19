package com.wuxiaolong.androidmvpsample.mvp.Wenquan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wuxiaolong.androidmvpsample.R;
import com.wuxiaolong.androidmvpsample.base.BasePresenter;
import com.wuxiaolong.androidmvpsample.base.MvpActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Can_xiangActivity extends MvpActivity {

    @Bind(R.id.jieqian_back)
    ImageView jieqianBack;
    @Bind(R.id.real)
    RelativeLayout real;
    @Bind(R.id.jieqianren)
    TextView jieqianren;
    @Bind(R.id.jieqianjine)
    TextView jieqianjine;
    @Bind(R.id.jieqianriqi)
    TextView jieqianriqi;
    @Bind(R.id.danbaoren)
    EditText danbaoren;
    @Bind(R.id.jieqian_btn)
    Button jieqianBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_can_xiang);
        ButterKnife.bind(this);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @OnClick({R.id.jieqian_back, R.id.jieqian_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.jieqian_back:
                finish();
                break;
            case R.id.jieqian_btn:

                break;
        }
    }
}
