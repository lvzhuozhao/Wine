package com.wuxiaolong.androidmvpsample.ke;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.wuxiaolong.androidmvpsample.R;
import com.wuxiaolong.androidmvpsample.base.BasePresenter;
import com.wuxiaolong.androidmvpsample.base.MvpActivity;
import com.wuxiaolong.androidmvpsample.bean.GGGGGGG;
import com.wuxiaolong.androidmvpsample.retrofit.ApiStores;
import com.wuxiaolong.androidmvpsample.utils.SharedPreferencesUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Ke_JieZhangActivity extends MvpActivity {


    @Bind(R.id.jiezhnag_back)
    ImageView jiezhnagBack;
    @Bind(R.id.shouyin_title)
    TextView shouyinTitle;
    @Bind(R.id.shouyin_tab_layou)
    TabLayout shouyinTabLayou;
    @Bind(R.id.shouyin_view_pager)
    ViewPager shouyinViewPager;
    @Bind(R.id.jiezhang_fanghao)
    TextView jiezhangFanghao;
    @Bind(R.id.jiezhang_jine)
    EditText jiezhangJine;
    @Bind(R.id.jiezhang_btn)
    Button jiezhangBtn;
    @Bind(R.id.jiezhang_btn1)
    Button jiezhangBtn1;
    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
    private View view1, view2, view3;//页卡视图
    private List<View> mViewList = new ArrayList<>();//页卡视图集合
    private LayoutInflater mInflater;
    private MyPagerAdapter mAdapter;
    private String number;
    private TextView ke_bianhao;
    private TextView ke_yudingren;
    private TextView ke_bumen;
    private TextView ke_yudingshijian;
    private TextView ke_name;
    private TextView ke_phone;
    private TextView ke_laiyuan;
    private TextView ke_fenlei;
    private TextView ke_leixing;
    private TextView ke_checkin;
    private TextView ke_checkout;
    private TextView ke_sum;
    private TextView ke_beizhu;
    private String orderNumber;
    private String reserveUser;
    private String department;
    private String reserveDate;
    private String guestName;
    private String guestPhone;
    private String guestSource;
    private String market;
    private String roomType;
    private String checkInDate;
    private String checkOutDate;
    private String sum;
    private String guestRemarks;
    private String str;
    private TextView can_bianhao;
    private TextView can_yudingren;
    private TextView can_bumen;
    private TextView can_yudingshijian;
    private TextView can_yuding_name;
    private TextView can_yuding_phone;
    private TextView can_laiyuan;
    private TextView can_fenlei;
    private TextView can_leixing;
    private TextView can_shuliang;
    private TextView can_renshu;
    private TextView can_jine;
    private TextView can_way;
    private TextView can_xiaofeishijian;
    private TextView can_beizhu;
    private TextView wen_bianhao;
    private TextView wen_yudingren1;
    private TextView wen_bumen;
    private TextView wen_yudingshijian;
    private TextView wen_name;
    private TextView wen_phone;
    private TextView wen_laiyuan;
    private TextView wen_fenlei;
    private TextView wen_leixing;
    private TextView wen_sum;
    private TextView wen_way;
    private TextView wen_xiaofeishijian;
    private TextView wen_beizhu;
    private GGGGGGG ggggggg;
    private List<GGGGGGG.JsonInfoBean.DataBean.RestaurantOrderBean> restaurantOrder1;
    private List<GGGGGGG.JsonInfoBean.DataBean.HotSpringOrderBean> hotSpringOrder1;
    private String day;
    private double v;
    private int i1;
    private int i;
    private double v1;
    private double wen_v;
    private double can_v;
    private double ke_v;
    private double zong_v;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jie_zhang);
        ButterKnife.bind(this);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd   HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());
        str = formatter.format(curDate);
        number = (String) SharedPreferencesUtils.getParam(Ke_JieZhangActivity.this, "number", "");
        initdata();
        BootomFragment();

    }

    private void initdata() {
        String url = ApiStores.API_SERVER_URL + "room/room!checkoutList.action?roomNumber=" + number;
        Log.d("qq", url);
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(String response) {
                Log.d("qq", response);
                Gson gson = new Gson();
                ggggggg = gson.fromJson(response, GGGGGGG.class);
                day = ggggggg.getJsonInfo().getData().getDay();
                v1 = Double.parseDouble(day);
                Log.d("day",day);
                kefang();
                restaurantOrder1 = ggggggg.getJsonInfo().getData().getRestaurantOrder();
                hotSpringOrder1 = ggggggg.getJsonInfo().getData().getHotSpringOrder();
                if (restaurantOrder1.size() == 0) {
                    can_bianhao.setText("---");
                    can_yudingren.setText("---");
                    can_bumen.setText("---");
                    can_yudingshijian.setText("---");

                    can_yuding_name.setText("---");
                    can_yuding_phone.setText("---");
                    can_laiyuan.setText("---");
                    can_fenlei.setText("---");

                    can_leixing.setText("---");
                    can_shuliang.setText("---");
                    can_renshu.setText("---");
                    can_jine.setText("---");
                    can_way.setText("---");
                    can_xiaofeishijian.setText("---");
                    can_beizhu.setText("---");


                }
                if (restaurantOrder1.size() != 0) {
                    for (int i = 0; i < restaurantOrder1.size(); i++) {
                        can_bianhao.setText(restaurantOrder1.get(i).getOrderNumber());
                        can_yudingren.setText(restaurantOrder1.get(i).getReserveUser());
                        can_bumen.setText(restaurantOrder1.get(i).getDepartment());
                        can_yudingshijian.setText(restaurantOrder1.get(i).getReserveDate());

                        can_yuding_name.setText(restaurantOrder1.get(i).getGuestName());
                        can_yuding_phone.setText(restaurantOrder1.get(i).getGuestPhone());
                        can_laiyuan.setText(restaurantOrder1.get(i).getGuestSource());
                        can_fenlei.setText(restaurantOrder1.get(i).getMarket());

                        can_leixing.setText(restaurantOrder1.get(i).getReserveType());
                        can_shuliang.setText(restaurantOrder1.get(i).getCount());
                        can_renshu.setText(restaurantOrder1.get(i).getGuestCount());
                        String sum = restaurantOrder1.get(i).getSum();
                        String substring = sum.substring(1, 4);
                        double v = Double.parseDouble(substring);
                        wen_v = v1 * v;
                        can_jine.setText( wen_v +"");
                        can_way.setText(restaurantOrder1.get(i).getOweMoneyType());
                        can_xiaofeishijian.setText(restaurantOrder1.get(i).getCheckInDate());
                        can_beizhu.setText(restaurantOrder1.get(i).getGuestRemarks());
                    }
                }
                if (hotSpringOrder1.size() == 0) {
                    wen_bianhao.setText("---");
                    wen_yudingren1.setText("---");
                    wen_bumen.setText("---");
                    wen_yudingshijian.setText("---");

                    wen_name.setText("---");
                    wen_phone.setText("---");
                    wen_laiyuan.setText("---");
                    wen_fenlei.setText("---");

                    wen_leixing.setText("---");
                    wen_sum.setText("---");
                    wen_way.setText("---");
                    wen_xiaofeishijian.setText("---");
                    wen_beizhu.setText("---");
                }

                if (hotSpringOrder1.size() != 0) {
                    for (int  i=0;i<hotSpringOrder1.size();i++)
                    {
                        wen_bianhao.setText(hotSpringOrder1.get(i).getOrderNumber());
                        wen_yudingren1.setText(hotSpringOrder1.get(i).getReserveUser());
                        wen_bumen.setText(hotSpringOrder1.get(i).getDepartment());
                        wen_yudingshijian.setText(hotSpringOrder1.get(i).getReserveDate());

                        wen_name.setText(hotSpringOrder1.get(i).getGuestName());
                        wen_phone.setText(hotSpringOrder1.get(i).getGuestPhone());
                        wen_laiyuan.setText(hotSpringOrder1.get(i).getGuestSource());
                        wen_fenlei.setText(hotSpringOrder1.get(i).getMarket());

                        wen_leixing.setText(hotSpringOrder1.get(i).getReserveType());
                        String sum = hotSpringOrder1.get(i).getSum();
                        String substring = sum.substring(1, 4);
                        double v = Double.parseDouble(substring);
                        can_v = v1 * v;
                        wen_sum.setText( can_v +"");
                        wen_way.setText(hotSpringOrder1.get(i).getOweMoneyType());
                        wen_xiaofeishijian.setText(hotSpringOrder1.get(i).getCheckInDate());
                        wen_beizhu.setText(hotSpringOrder1.get(i).getGuestRemarks());
                    }

                }

                jiezhangFanghao.setText(number);
                String substring1 = sum.substring(1, 4);
                double vv = Double.parseDouble(substring1);
                double vvv = v1 * vv;
                zong_v = ke_v + can_v + wen_v;
                jiezhangJine.setText("$"+ zong_v +"");

            }
        });
    }

    private void kefang() {
        GGGGGGG.JsonInfoBean.DataBean.RoomOrderBean roomOrder1 = ggggggg.getJsonInfo().getData().getRoomOrder();
        orderNumber = roomOrder1.getOrderNumber();
        reserveUser = roomOrder1.getReserveUser();
        department = roomOrder1.getDepartment();
        reserveDate = roomOrder1.getReserveDate();

        guestName = roomOrder1.getGuestName();
        guestPhone = roomOrder1.getGuestPhone();
        guestSource = roomOrder1.getGuestSource();
        market = roomOrder1.getMarket();

        roomType = roomOrder1.getRoomType();
        checkInDate = roomOrder1.getCheckInDate();
        checkOutDate = roomOrder1.getCheckOutDate();
        sum = roomOrder1.getSum();
        guestRemarks = roomOrder1.getGuestRemarks();

        ke_bianhao.setText(orderNumber);
        ke_yudingren.setText(reserveUser);
        ke_bumen.setText(department);
        ke_yudingshijian.setText(reserveDate);

        ke_name.setText(guestName);
        ke_phone.setText(guestPhone);
        ke_laiyuan.setText(guestSource);
        ke_fenlei.setText(market);

        ke_leixing.setText(roomType);
        ke_checkin.setText(checkInDate);
        ke_checkout.setText(checkOutDate);
        String substring = sum.substring(1, 4);
        double v = Double.parseDouble(substring);
        ke_v = v1 * v;
        ke_sum.setText( ke_v +"");
        ke_beizhu.setText(guestRemarks);
    }



    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    private void BootomFragment() {
        mInflater = LayoutInflater.from(this);
        view1 = mInflater.inflate(R.layout.one, null);
        ke_bianhao = (TextView) view1.findViewById(R.id.ke_bianhao);
        ke_yudingren = (TextView) view1.findViewById(R.id.ke_yudingren);
        ke_bumen = (TextView) view1.findViewById(R.id.ke_bumen);
        ke_yudingshijian = (TextView) view1.findViewById(R.id.ke_yudingshijian);

        ke_name = (TextView) view1.findViewById(R.id.ke_name);
        ke_phone = (TextView) view1.findViewById(R.id.ke_phone);
        ke_laiyuan = (TextView) view1.findViewById(R.id.ke_laiyuan);
        ke_fenlei = (TextView) view1.findViewById(R.id.ke_fenlei);

        ke_leixing = (TextView) view1.findViewById(R.id.ke_leixing);
        ke_checkin = (TextView) view1.findViewById(R.id.ke_checkin);
        ke_checkout = (TextView) view1.findViewById(R.id.ke_checkout);
        ke_sum = (TextView) view1.findViewById(R.id.ke_sum);
        ke_beizhu = (TextView) view1.findViewById(R.id.ke_beizhu);


        view2 = mInflater.inflate(R.layout.two, null);
        can_bianhao = (TextView) view2.findViewById(R.id.can_bianhao);
        can_yudingren = (TextView) view2.findViewById(R.id.can_yudingren);
        can_bumen = (TextView) view2.findViewById(R.id.can_bumen);
        can_yudingshijian = (TextView) view2.findViewById(R.id.can_yudingshijian);
        can_yuding_name = (TextView) view2.findViewById(R.id.can_name);
        can_yuding_phone = (TextView) view2.findViewById(R.id.can_phone);
        can_laiyuan = (TextView) view2.findViewById(R.id.can_laiyuan);
        can_fenlei = (TextView) view2.findViewById(R.id.can_fenlei);
        can_leixing = (TextView) view2.findViewById(R.id.can_leixing);
        can_shuliang = (TextView) view2.findViewById(R.id.can_shuliang);
        can_renshu = (TextView) view2.findViewById(R.id.can_renshu);
        can_jine = (TextView) view2.findViewById(R.id.can_jine);
        can_way = (TextView) view2.findViewById(R.id.can_way);
        can_xiaofeishijian = (TextView) view2.findViewById(R.id.can_xiaofeishijian);
        can_beizhu = (TextView) view2.findViewById(R.id.can_beizhu);


        view3 = mInflater.inflate(R.layout.three, null);
        wen_bianhao = (TextView) view3.findViewById(R.id.wen_bianhao);
        wen_yudingren1 = (TextView) view3.findViewById(R.id.wen_yudingren);
        wen_bumen = (TextView) view3.findViewById(R.id.wen_bumen);
        wen_yudingshijian = (TextView) view3.findViewById(R.id.wen_yudingshijian);

        wen_name = (TextView) view3.findViewById(R.id.wen_name);
        wen_phone = (TextView) view3.findViewById(R.id.wen_phone);
        wen_laiyuan = (TextView) view3.findViewById(R.id.wen_laiyuan);
        wen_fenlei = (TextView) view3.findViewById(R.id.wen_fenlei);

        wen_leixing = (TextView) view3.findViewById(R.id.wen_leixing);
        wen_sum = (TextView) view3.findViewById(R.id.wen_sum);
        wen_way = (TextView) view3.findViewById(R.id.wen_way);
        wen_xiaofeishijian = (TextView) view3.findViewById(R.id.wen_xiaofeishijian);
        wen_beizhu = (TextView) view3.findViewById(R.id.wen_beizhu);


        //添加页卡视图
        mViewList.add(view1);
        mViewList.add(view2);
        mViewList.add(view3);

        //添加页卡标题
        mTitleList.add("客房");
        mTitleList.add("餐饮");
        mTitleList.add("温泉");

        shouyinTabLayou.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式
        shouyinTabLayou.addTab(shouyinTabLayou.newTab().setText(mTitleList.get(0)));//添加tab选项卡
        shouyinTabLayou.addTab(shouyinTabLayou.newTab().setText(mTitleList.get(1)));
        shouyinTabLayou.addTab(shouyinTabLayou.newTab().setText(mTitleList.get(2)));
        mAdapter = new MyPagerAdapter(mViewList);
        shouyinViewPager.setAdapter(mAdapter);//给ViewPager设置适配器
        shouyinTabLayou.setupWithViewPager(shouyinViewPager);//将TabLayout和ViewPager关联起来。
    }

    @OnClick({R.id.jiezhang_btn, R.id.jiezhang_btn1})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.jiezhang_btn:
                Intent intent1 = new Intent(Ke_JieZhangActivity.this, Ke_JiezhangwayActivity.class);
                intent1.putExtra("sum", jiezhangJine.getText().toString());
                startActivity(intent1);
                break;
            case R.id.jiezhang_btn1:
                Intent intent = new Intent(Ke_JieZhangActivity.this, Ke_jieqianActivity.class);
                intent.putExtra("guestName", guestName);
                intent.putExtra("sum", jiezhangJine.getText().toString());
                intent.putExtra("reserveUser", reserveUser);
                intent.putExtra("str", str);
                startActivity(intent);
                break;
        }
    }

    @OnClick(R.id.jiezhnag_back)
    public void onViewClicked() {
        finish();
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
            return mTitleList.get(position);//页卡标题
        }

    }

}
