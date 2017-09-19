package com.wuxiaolong.androidmvpsample.wen;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.okhttp.Request;
import com.weiwangcn.betterspinner.library.BetterSpinner;
import com.wuxiaolong.androidmvpsample.R;
import com.wuxiaolong.androidmvpsample.adapter.MyViewPagerAdapter;
import com.wuxiaolong.androidmvpsample.base.BasePresenter;
import com.wuxiaolong.androidmvpsample.base.MvpActivity;
import com.wuxiaolong.androidmvpsample.fargment.OneFragment;
import com.wuxiaolong.androidmvpsample.fargment.TwoFragment;
import com.wuxiaolong.androidmvpsample.retrofit.ApiStores;
import com.wuxiaolong.androidmvpsample.utils.SharedPreferencesUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Wen_xiadanActivity extends MvpActivity implements TabLayout.OnTabSelectedListener {

    @Bind(R.id.can_yuding_back)
    ImageView canYudingBack;
    @Bind(R.id.can_yuding_title1)
    TextView canYudingTitle1;
    @Bind(R.id.real)
    RelativeLayout real;
    @Bind(R.id.can_yuding_name)
    EditText canYudingName;
    @Bind(R.id.can_yuding_phone)
    EditText canYudingPhone;
    @Bind(R.id.can_yuding_span1)
    BetterSpinner canYudingSpan1;
    @Bind(R.id.can_yuding_span2)
    BetterSpinner canYudingSpan2;
    @Bind(R.id.yuyu_tab_layou)
    TabLayout yuyuTabLayou;
    @Bind(R.id.yuyu_pager)
    ViewPager yuyuPager;
    @Bind(R.id.can_fragrement_btn)
    Button canFragrementBtn;
    //客户来源
    private static final String[] data = new String[]{"散客", "商务协议", "签单协议", "团体", "会员", "套票", "常包房", "自用房", "OTA", "旅行社", "会议", "内部接待", "钟点房"};
    //市场分类来源数据源
    private static final String[] data1 = new String[]{"南昌", "新建", "安义", "高安", "奉新", "丰城", "樟树", "铜鼓"};

    //TabLayout标签
    private String[] titles = new String[]{"温泉", "餐饮"};
    private List<Fragment> fragments = new ArrayList<>();
    private MyViewPagerAdapter viewPagerAdapter;
    private String shijian;
    private String ren;
    private String lei;
    private String jine;
    private String bei;
    private String spring;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuding_ww);
        ButterKnife.bind(this);
        xiala();
        BootomFragment();

    }

    private void BootomFragment() {
        //设置TabLayout标签的显示方式
        yuyuTabLayou.setTabMode(TabLayout.MODE_FIXED);
        //循环注入标签
        for (String tab : titles) {
            yuyuTabLayou.addTab(yuyuTabLayou.newTab().setText(tab));
        }
        //设置TabLayout点击事件
        yuyuTabLayou.setOnTabSelectedListener(this);
        fragments.add(new TwoFragment());
        fragments.add(new OneFragment());


        viewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), titles, fragments);
        yuyuPager.setAdapter(viewPagerAdapter);
        yuyuTabLayou.setupWithViewPager(yuyuPager);
    }

    private void xiala() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Wen_xiadanActivity.this, android.R.layout.simple_dropdown_item_1line, data);
        canYudingSpan1.setAdapter(adapter);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(Wen_xiadanActivity.this, android.R.layout.simple_dropdown_item_1line, data1);
        canYudingSpan2.setAdapter(adapter1);

    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        yuyuPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }


    @OnClick({R.id.can_yuding_back, R.id.can_fragrement_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.can_yuding_back:
                finish();
                break;
            case R.id.can_fragrement_btn:
                spring = (String) SharedPreferencesUtils.getParam(Wen_xiadanActivity.this, "spring", "");
                HashMap<String, String> list = new HashMap<>();
                list.put("guestName", canYudingName.getText().toString().trim());
                list.put("market", canYudingSpan2.getText().toString().trim());
                list.put("guestPhone", canYudingPhone.getText().toString().trim());
                list.put("guestSource", canYudingSpan1.getText().toString().trim());
                String str = "";
                for (String key : list.keySet()) {
                    // if(){
                    str = str + "'" + key + "':'" + list.get(key) + "',";
                    //  }

                }
                str = "%7B" + str + "%7D";


                shijian = (String) SharedPreferencesUtils.getParam(Wen_xiadanActivity.this, "shijian", "");
                ren = (String) SharedPreferencesUtils.getParam(Wen_xiadanActivity.this, "ren", "");
                lei = (String) SharedPreferencesUtils.getParam(Wen_xiadanActivity.this, "lei", "");
                jine = (String) SharedPreferencesUtils.getParam(Wen_xiadanActivity.this, "jine", "");
                bei = (String) SharedPreferencesUtils.getParam(Wen_xiadanActivity.this, "bei", "");
                spring = (String) SharedPreferencesUtils.getParam(Wen_xiadanActivity.this, "spring", "");
                HashMap<String, String> list1 = new HashMap<>();
                list.put("checkInDate", shijian);
                list.put("count", ren);
                list.put("ReserveType", lei);
                list.put("price", jine);
                list.put("guestRemarks", bei);

                String str1 = "";
                for (String key : list1.keySet()) {
                    // if(key.length()-1){
                    str1 = str1 + "'" + key + "':'" + list1.get(key) + "',";
                    // }

                }
                str1 = "%5B" + "%7B" + str1 + "%7D" + "%5D";
                String url = ApiStores.API_SERVER_URL + "order/order!addOrder.action?order=" +
                        str + "&orderReserveHotSpring=" + str1+"&userName="+spring;
                Log.d("ggg",url);
                OkHttpUtils.get().url(url).build().execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {
                        Log.d("ggg",response);
                    }
                });
                break;
        }
    }
}
