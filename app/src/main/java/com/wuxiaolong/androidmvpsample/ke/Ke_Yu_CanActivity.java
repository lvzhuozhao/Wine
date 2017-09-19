package com.wuxiaolong.androidmvpsample.ke;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.weiwangcn.betterspinner.library.BetterSpinner;
import com.wuxiaolong.androidmvpsample.R;
import com.wuxiaolong.androidmvpsample.base.BasePresenter;
import com.wuxiaolong.androidmvpsample.base.MvpActivity;
import com.wuxiaolong.androidmvpsample.bean.Wen_price;
import com.wuxiaolong.androidmvpsample.bean.Wen_xiadan;
import com.wuxiaolong.androidmvpsample.retrofit.ApiStores;
import com.wuxiaolong.androidmvpsample.utils.SharedPreferencesUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Ke_Yu_CanActivity extends MvpActivity implements View.OnClickListener {

    @Bind(R.id.can_yuding_back)
    ImageView canYudingBack;
    @Bind(R.id.can_yuding_title)
    TextView canYudingTitle;
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
    private String tag;
    //客户来源
    private static final String[] data = new String[]{"散客", "商务协议", "签单协议", "团体", "会员", "套票", "常包房", "自用房", "OTA", "旅行社", "会议", "内部接待", "钟点房"};
    //市场分类来源数据源
    private static final String[] data1 = new String[]{"南昌", "新建", "安义", "高安", "奉新", "丰城", "樟树", "铜鼓"};
    //客户来源
    private static final String[] data2 = new String[]{"包厢", "散桌"};
    //客户来源
    private static final String[] data3 = new String[]{"一般", "VIP"};
    private String leixing;
    private String shuliang;
    private String renshu;
    private String shi;
    private String beizhu;
    private String lei;
    private String jine;
    private String ren;
    private String shijian;
    private String bei;
    private String room;
    private ArrayList<String> arrayList1;
    private BetterSpinner betterSpinner;
    private BetterSpinner betterSpinner1;
    private ImageView jianjian;
    private ImageView jiajia;
    private EditText table_num;
    private ImageView jianjianjian;
    private ImageView jiajiajia;
    private EditText renshu1;
    private TextView xiaofeishijian;
    private EditText beibei;
    private int mYear;
    private int mMonth;
    private int mDay;
    private TextView can_money;
    private ImageView can_jianjian;
    private ImageView can_jiajia;
    private EditText canrenshu;
    private TextView shijian1;
    private EditText ccc_beizhu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuding_yy);
        ButterKnife.bind(this);
        room = (String) SharedPreferencesUtils.getParam(Ke_Yu_CanActivity.this, "room", "");
        Calendar ca = Calendar.getInstance();
        mYear = ca.get(Calendar.YEAR);
        mMonth = ca.get(Calendar.MONTH);
        mDay = ca.get(Calendar.DAY_OF_MONTH);
        Intent intent = getIntent();
        tag = intent.getStringExtra("tag");
     /*   if (tag.equals("11")) {
            canYudingTitle.setVisibility(View.VISIBLE);
            canYudingTitle1.setVisibility(View.GONE);
        } else if (tag.equals("22")) {
            canYudingTitle.setVisibility(View.GONE);
            canYudingTitle1.setVisibility(View.VISIBLE);
        }*/
        Bootm1();
        xiala();
        canYudingSpan1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                initdata();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        betterSpinner1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                initdata();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void Bootm1() {
        //加载文件
        LayoutInflater from = LayoutInflater.from(this);
        View inflate = from.inflate(R.layout.ke_canyin, null);
        betterSpinner = (BetterSpinner) inflate.findViewById(R.id.can_yuding_spanner3);
        jianjian = (ImageView) inflate.findViewById(R.id.jianjian);
        jianjian.setOnClickListener(this);
        jiajia = (ImageView) inflate.findViewById(R.id.jiajia);
        jiajia.setOnClickListener(this);
        table_num = (EditText) inflate.findViewById(R.id.canyin_canzhuoshuliang);
        jianjianjian = (ImageView) inflate.findViewById(R.id.jianjianjian);
        jianjianjian.setOnClickListener(this);
        jiajiajia = (ImageView) inflate.findViewById(R.id.jiajiajia);
        jiajiajia.setOnClickListener(this);
        renshu1 = (EditText) inflate.findViewById(R.id.yuding_renshu);
        xiaofeishijian = (TextView) inflate.findViewById(R.id.xiaofeishijian);
        xiaofeishijian.setOnClickListener(this);
        beibei = (EditText) inflate.findViewById(R.id.beibei);


        View inflate1 = from.inflate(R.layout.wen_canyin, null);
        betterSpinner1 = (BetterSpinner) inflate1.findViewById(R.id.can_spanner);
        can_money = (TextView) inflate1.findViewById(R.id.can_money_one);

        can_jianjian = (ImageView) inflate1.findViewById(R.id.can_jianjian);
        can_jianjian.setOnClickListener(this);
        can_jiajia = (ImageView) inflate1.findViewById(R.id.can_jiajia);
        can_jiajia.setOnClickListener(this);
        canrenshu = (EditText) inflate1.findViewById(R.id.canrenshu);
        shijian1 = (TextView) inflate1.findViewById(R.id.ssss);
        shijian1.setOnClickListener(this);
        ccc_beizhu = (EditText) inflate1.findViewById(R.id.ccc_beizhu);

        //添加页卡视图
        ArrayList<View> arrayList = new ArrayList<>();
        arrayList.add(inflate);
        arrayList.add(inflate1);

        //添加页卡标题
        arrayList1 = new ArrayList<>();
        arrayList1.add("餐饮");
        arrayList1.add("温泉");
        //设置标题
        yuyuTabLayou.setTabMode(TabLayout.MODE_FIXED);
        yuyuTabLayou.addTab(yuyuTabLayou.newTab().setText(arrayList1.get(0)));
        yuyuTabLayou.addTab(yuyuTabLayou.newTab().setText(arrayList1.get(1)));
        //适配器
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(arrayList);
        yuyuPager.setAdapter(myPagerAdapter);
        yuyuTabLayou.setupWithViewPager(yuyuPager);

    }

    private void initdata() {
        String url = ApiStores.API_SERVER_URL + "order/order!hotSpringPrice.action?guestSourceName=" +
                canYudingSpan1.getText().toString().trim() +
                "&hotSpringTypeName=" + betterSpinner1.getText().toString().trim();
        Log.d("nihao", url);
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(String response) {
                Log.d("nihao", response);
                Gson  gson=new Gson();
                Wen_price wen_price = gson.fromJson(response, Wen_price.class);
                String price = wen_price.getJsonInfo().getData().getPrice();
                can_money.setText(price);

            }
        });
    }


    private void xiala() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Ke_Yu_CanActivity.this, android.R.layout.simple_dropdown_item_1line, data);
        canYudingSpan1.setAdapter(adapter);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(Ke_Yu_CanActivity.this, android.R.layout.simple_dropdown_item_1line, data1);
        canYudingSpan2.setAdapter(adapter1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(Ke_Yu_CanActivity.this, android.R.layout.simple_dropdown_item_1line, data2);
        betterSpinner.setAdapter(adapter2);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(Ke_Yu_CanActivity.this, android.R.layout.simple_dropdown_item_1line, data3);
        betterSpinner1.setAdapter(adapter3);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.jianjian:
                String s = Integer.valueOf(table_num.getText().toString()) - 1 + "";
                if (s.equals("0")) {
                    toastShow("预订数量不能小于1");
                } else {
                    table_num.setText(s);
                }
                break;
            case R.id.jiajia:
                String ss = Integer.valueOf(table_num.getText().toString()) + 1 + "";
                table_num.setText(ss);
                break;
            case R.id.jianjianjian:
                String s1 = Integer.valueOf(renshu1.getText().toString()) - 1 + "";
                if (s1.equals("0")) {
                    toastShow("预订数量不能小于1");
                } else {
                    renshu1.setText(s1);
                }
                break;
            case R.id.jiajiajia:
                String sss = Integer.valueOf(renshu1.getText().toString()) + 1 + "";
                renshu1.setText(sss);
                break;
            case R.id.xiaofeishijian:
                new DatePickerDialog(Ke_Yu_CanActivity.this, onDateSetListener, mYear, mMonth, mDay).show();
                break;
            case R.id.can_jianjian:
                String ws = Integer.valueOf(canrenshu.getText().toString()) - 1 + "";
                if (ws.equals("0")) {
                    toastShow("预订数量不能小于1");
                } else {
                    canrenshu.setText(ws);
                }
                break;
            case R.id.can_jiajia:
                String ssss = Integer.valueOf(canrenshu.getText().toString()) + 1 + "";
                canrenshu.setText(ssss);
                break;
            case R.id.ssss:
                new DatePickerDialog(Ke_Yu_CanActivity.this, onDateSetListener1, mYear, mMonth, mDay).show();
                break;
        }
    }


    //ViewPager适配器
    class MyPagerAdapter extends PagerAdapter {
        private List<View> mViewList;

        public MyPagerAdapter(List<View> mViewList) {
            this.mViewList = mViewList;
        }

        @Override
        public int getCount() {
            return mViewList.size();//页卡数
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;//官方推荐写法
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mViewList.get(position));//添加页卡
            return mViewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mViewList.get(position));//删除页卡
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return arrayList1.get(position);//页卡标题
        }

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
                HashMap<String, String> list = new HashMap<>();
                list.put("guestPhone", canYudingPhone.getText().toString().trim());
                list.put("market", canYudingSpan2.getText().toString().trim());
                list.put("guestSource", canYudingSpan1.getText().toString());
                list.put("guestName", canYudingName.getText().toString().trim());
                String str = "";
                for (String key : list.keySet()) {

                    str = str + "'" + key + "':'" + list.get(key) + "',";
                    //  }

                }
                str = "%7B" + str + "%7D";

                HashMap<String, String> list1 = new HashMap<>();
                list1.put("checkInDate", xiaofeishijian.getText().toString().trim());
                list1.put("count", table_num.getText().toString().trim());
                list1.put("ReserveType", betterSpinner.getText().toString().trim());
                list1.put("guestRemarks", beibei.getText().toString().trim());
                list1.put("guestCount", renshu1.getText().toString().trim());
                String str1 = "";
                for (String key : list1.keySet()) {
                    // if(key.length()-1){
                    str1 = str1 + "'" + key + "':'" + list1.get(key) + "',";
                    // }

                }
                str1 = "%5B" + "%7B" + str1 + "%7D" + "%5D";
                HashMap<String, String> list2 = new HashMap<>();
                list1.put("checkInDate", shijian1.getText().toString().trim());
                list1.put("count", canrenshu.getText().toString().trim());
                list1.put("ReserveType", betterSpinner1.getText().toString().trim());
                list1.put("guestRemarks", ccc_beizhu.getText().toString().trim());
                list1.put("price", can_money.getText().toString().trim());
                String str2 = "";
                for (String key : list2.keySet()) {
                    // if(key.length()-1){
                    str2 = str2 + "'" + key + "':'" + list2.get(key) + "',";
                    // }

                }
                str2 = "%5B" + str2 + "%5D";
                String url = ApiStores.API_SERVER_URL + "order/order!addOrder.action?order=" + str + "&orderReserveRestaurant=" + str1 + "&orderReserveHotSpring=" + str2 +
                        "&userName=" + room;
                Log.d("ppp", url);
                OkHttpUtils.get().url(url).build().execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {
                        Log.d("ppp", response);
                        toastShow("下单成功");
                        Gson gson=new Gson();
                        Wen_xiadan wen_xiadan = gson.fromJson(response, Wen_xiadan.class);
                        String code = wen_xiadan.getJsonInfo().getCode();
                        String msg = wen_xiadan.getJsonInfo().getMsg();
                        if (code.equals("0"))
                        {
                            toastShow(msg);
                        }
                        Intent intent = new Intent(Ke_Yu_CanActivity.this, Ke_GeRenActivity.class);
                        startActivity(intent);

                    }
                });
                break;
        }
    }
     /*日期选择器对话框监听*/

    private DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            String days;
            if (mMonth + 1 < 10) {
                if (mDay < 10) {
                    days = new StringBuffer().append(mYear).append("-").append("0").
                            append(mMonth + 1).append("-").append("0").append(mDay).toString();
                } else {
                    days = new StringBuffer().append(mYear).append("-").append("0").
                            append(mMonth + 1).append("-").append(mDay).toString();
                }

            } else {
                if (mDay < 10) {
                    days = new StringBuffer().append(mYear).append("-").
                            append(mMonth + 1).append("-").append("0").append(mDay).toString();
                } else {
                    days = new StringBuffer().append(mYear).append("-").
                            append(mMonth + 1).append("-").append(mDay).toString();
                }

            }
            xiaofeishijian.setText(days);
        }
    };

       /*日期选择器对话框监听*/

    private DatePickerDialog.OnDateSetListener onDateSetListener1 = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            String days;
            if (mMonth + 1 < 10) {
                if (mDay < 10) {
                    days = new StringBuffer().append(mYear).append("-").append("0").
                            append(mMonth + 1).append("-").append("0").append(mDay).toString();
                } else {
                    days = new StringBuffer().append(mYear).append("-").append("0").
                            append(mMonth + 1).append("-").append(mDay).toString();
                }

            } else {
                if (mDay < 10) {
                    days = new StringBuffer().append(mYear).append("-").
                            append(mMonth + 1).append("-").append("0").append(mDay).toString();
                } else {
                    days = new StringBuffer().append(mYear).append("-").
                            append(mMonth + 1).append("-").append(mDay).toString();
                }

            }
            shijian1.setText(days);
        }
    };
}
