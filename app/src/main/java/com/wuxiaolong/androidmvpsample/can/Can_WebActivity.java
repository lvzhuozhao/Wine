package com.wuxiaolong.androidmvpsample.can;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;

import com.wuxiaolong.androidmvpsample.R;
import com.wuxiaolong.androidmvpsample.base.BasePresenter;
import com.wuxiaolong.androidmvpsample.base.MvpActivity;
import com.wuxiaolong.androidmvpsample.retrofit.ApiStores;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Can_WebActivity extends MvpActivity {

    @Bind(R.id.id_webView)
    WebView idWebView;
    @Bind(R.id.dayin)
    Button dayin;
    @Bind(R.id.wancheng)
    Button wancheng;
    @Bind(R.id.gua_back)
    ImageView guaBack;
    private String url1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wwww);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        url1 = intent.getStringExtra("url1");
        //设置WebView属性，能够执行Javascript脚本
        idWebView.getSettings().setJavaScriptEnabled(true);
        //加载需要显示的网页
        WebSettings webSettings = idWebView.getSettings();
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        String url = ApiStores.Web_URL+ url1;
        idWebView.loadUrl(url);
        Log.d("url", url);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @OnClick({R.id.dayin, R.id.wancheng})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.dayin:
                toastShow("打印成功");
                break;
            case R.id.wancheng:
                Intent intent = new Intent(Can_WebActivity.this, Can_GeRenActivity.class);
                startActivity(intent);
                break;
        }
    }


    @OnClick(R.id.gua_back)
    public void onViewClicked() {
        finish();
    }
}
