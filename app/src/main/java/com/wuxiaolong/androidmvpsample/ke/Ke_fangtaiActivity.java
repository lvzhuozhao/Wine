package com.wuxiaolong.androidmvpsample.ke;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.weiwangcn.betterspinner.library.BetterSpinner;
import com.wuxiaolong.androidmvpsample.R;
import com.wuxiaolong.androidmvpsample.base.BasePresenter;
import com.wuxiaolong.androidmvpsample.base.MvpActivity;
import com.wuxiaolong.androidmvpsample.bean.Type;
import com.wuxiaolong.androidmvpsample.bean.Typenumber;
import com.wuxiaolong.androidmvpsample.retrofit.ApiStores;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.Calendar;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Ke_fangtaiActivity extends MvpActivity {
    //房态类型来源
    private static final String[] data = new String[]{"普通标间", "豪华标间", "普通大床", "豪华大床", "别墅", "水上木屋"};

    //房态类型来源
    private static final String[] data1 = new String[]{"OK房", "已预订", "使用中", "清洁中", "维修中"};
    @Bind(R.id.tai_back)
    ImageView taiBack;
    @Bind(R.id.real)
    RelativeLayout real;
    @Bind(R.id.tai_span1)
    BetterSpinner taiSpan1;
    @Bind(R.id.tai_span2)
    BetterSpinner taiSpan2;
    @Bind(R.id.tai_date)
    TextView taiDate;
    @Bind(R.id.tai_date1)
    TextView taiDate1;
    @Bind(R.id.tai_find)
    Button taiFind;
    @Bind(R.id.tai_yi)
    TextView taiYi;
    @Bind(R.id.tai_er)
    TextView taiEr;
    @Bind(R.id.tai_san)
    TextView taiSan;
    @Bind(R.id.tai_shui)
    TextView taiShui;
    @Bind(R.id.tai_bieshu)
    TextView taiBieshu;
    @Bind(R.id.tai_btn)
    Button taiBtn;
    private int mYear;
    private int mMonth;
    private int mDay;
    private String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ke_fangtai);
        ButterKnife.bind(this);

        initdata();
        xiala();
        Calendar ca = Calendar.getInstance();
        mYear = ca.get(Calendar.YEAR);
        mMonth = ca.get(Calendar.MONTH);
        mDay = ca.get(Calendar.DAY_OF_MONTH);


    }

    private void initdata() {
        String url = ApiStores.API_SERVER_URL + "order/order-room!roomTypeList.action";
        Log.d("hh", url);
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(String response) {

                Gson gson = new Gson();
                Type type = gson.fromJson(response, Type.class);
                List<Type.JsonInfoBean.DataBean> list = type.getJsonInfo().getData();


            }
        });
    }

    private void xiala() {
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(Ke_fangtaiActivity.this, android.R.layout.simple_dropdown_item_1line, data);
        taiSpan1.setAdapter(adapter1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(Ke_fangtaiActivity.this, android.R.layout.simple_dropdown_item_1line, data1);
        taiSpan2.setAdapter(adapter2);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }


    @OnClick({R.id.tai_back, R.id.tai_date, R.id.tai_date1, R.id.tai_find, R.id.tai_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tai_back:
                finish();
                break;
            case R.id.tai_date:
                new DatePickerDialog(Ke_fangtaiActivity.this, onDateSetListener, mYear, mMonth, mDay).show();
                break;
            case R.id.tai_date1:
                new DatePickerDialog(Ke_fangtaiActivity.this, onDateSetListener1, mYear, mMonth, mDay).show();
                break;
            case R.id.tai_find:

                String trim = taiSpan1.getText().toString().trim();
                if (trim.equals("普通标间")) {
                    id = new String("1");
                } else if (trim.equals("豪华标间")) {
                    id = new String("2");
                } else if (trim.equals("普通大床")) {
                    id = new String("3");
                } else if (trim.equals("豪华大床")) {
                    id = new String("4");
                } else if (trim.equals("别墅")) {
                    id = new String("5");
                } else if (trim.equals("水上木屋")) {
                    id = new String("6");
                }

                String url = ApiStores.API_SERVER_URL + "order/order-room!roomStatusInfo.action?roomTypeId  =" + id + "&roomStatus=" + taiSpan2.getText().toString().trim() + "&checkInDate=" + taiDate.getText().toString().trim() + "&checkOutDate=" + taiDate1.getText().toString().trim();
                Log.d("zz", url);
                OkHttpUtils.get().url(url).build().execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {
                        Log.d("VV", response);
                        Gson gson = new Gson();
                        Typenumber typenumber = gson.fromJson(response, Typenumber.class);
                        Typenumber.JsonInfoBean.DataBean data = typenumber.getJsonInfo().getData();
                        taiYi.setText(data.get_$1号楼() + "间");
                        taiEr.setText(data.get_$2号楼() + "间");
                        taiSan.setText(data.get_$3号楼() + "间");
                        taiShui.setText(data.get水上木屋() + "间");
                        taiBieshu.setText(data.get别墅() + "间");

                    }
                });
                break;
            case R.id.tai_btn:
                Intent intent = new Intent(Ke_fangtaiActivity.this, Ke_xiadanActivity.class);
                startActivity(intent);
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
            taiDate.setText(days);
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
            taiDate1.setText(days);
        }
    };
}
