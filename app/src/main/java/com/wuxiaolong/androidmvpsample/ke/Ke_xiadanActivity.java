package com.wuxiaolong.androidmvpsample.ke;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.weiwangcn.betterspinner.library.BetterSpinner;
import com.wuxiaolong.androidmvpsample.R;
import com.wuxiaolong.androidmvpsample.base.BasePresenter;
import com.wuxiaolong.androidmvpsample.base.MvpActivity;
import com.wuxiaolong.androidmvpsample.bean.PPPP;
import com.wuxiaolong.androidmvpsample.bean.Xiadan;
import com.wuxiaolong.androidmvpsample.retrofit.ApiStores;
import com.wuxiaolong.androidmvpsample.utils.SharedPreferencesUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.Calendar;
import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class Ke_xiadanActivity extends MvpActivity {


    @Bind(R.id.yu_center_back)
    ImageView yuCenterBack;
    @Bind(R.id.real)
    RelativeLayout real;
    @Bind(R.id.yu_name)
    EditText yuName;
    @Bind(R.id.yu_phone)
    EditText yuPhone;
    @Bind(R.id.yu_beizhu)
    EditText yuBeizhu;
    @Bind(R.id.textView)
    TextView textView;

    @Bind(R.id.yu_im_zeng)
    ImageView yuImZeng;
    @Bind(R.id.yu_num)
    EditText yuNum;
    @Bind(R.id.yu_im_jian)
    ImageView yuImJian;
    @Bind(R.id.yu_add)
    ImageView yuAdd;
    @Bind(R.id.yu_btn)
    Button yuBtn;
    @Bind(R.id.yuding_xiala1)
    BetterSpinner yudingXiala1;
    @Bind(R.id.yuding_xiala2)
    BetterSpinner yudingXiala2;
    @Bind(R.id.yuding_xiala3)
    BetterSpinner yudingXiala3;
    @Bind(R.id.yuding_xiala4)
    BetterSpinner yudingXiala4;

    //客户来源
    private static final String[] data = new String[]{"散客", "商务协议", "签单协议", "团体", "会员", "套票", "常包房", "自用房", "OTA", "旅行社", "会议", "内部接待", "钟点房"};
    //市场分类来源数据源
    private static final String[] data1 = new String[]{"南昌", "新建", "安义", "高安", "奉新", "丰城", "樟树", "铜鼓"};
    //房间类型来源
    private static final String[] data2 = new String[]{"普通标间", "豪华标间", "普通大床", "豪华大床", "别墅", "水上木屋"};
    //结欠方式
    private static final String[] data3 = new String[]{"现金", "刷卡", "第三方", "结欠"};
    //结欠方式
    private static final String[] data4 = new String[]{"一号楼", "二号楼", "三号楼"};
    @Bind(R.id.yuding_date)
    TextView yudingDate;
    @Bind(R.id.yuding_date1)
    TextView yudingDate1;
    @Bind(R.id.yinyong)
    LinearLayout yinyong;
    @Bind(R.id.haha)
    LinearLayout haha;
    @Bind(R.id.yu_money)
    TextView yuMoney;
    @Bind(R.id.louhao)
    BetterSpinner louhao;

    private int mMonth;
    private int mYear;
    private int mDay;
    private String room;
    private String price;
    private PPPP pppp;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String obj = (String) msg.obj;
            yuMoney.setText(obj);
        }
    };
    private String code;
    private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ke_yuding);
        ButterKnife.bind(this);
        //下拉框数据
        xiala();
        initdata();
        Calendar ca = Calendar.getInstance();
        mYear = ca.get(Calendar.YEAR);
        mMonth = ca.get(Calendar.MONTH);
        mDay = ca.get(Calendar.DAY_OF_MONTH);
        yudingXiala3.addTextChangedListener(new TextWatcher() {
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

    private void initdata() {
        String url = ApiStores.API_SERVER_URL + "order/order-room!roomPrice.action?guestSourceName="
                + yudingXiala1.getText().toString().trim() + "&roomTypeName=" + yudingXiala3.getText().toString().trim();
        Log.d("ying", url);
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(String response) {
                Log.d("ying", response);
                Gson gson = new Gson();
                pppp = gson.fromJson(response, PPPP.class);
                price = pppp.getJsonInfo().getData().getPrice();
                String substring = price.substring(0, 3);
                handler.obtainMessage(0, substring).sendToTarget();

            }
        });
        yudingXiala1.addTextChangedListener(new TextWatcher() {
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

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    private void xiala() {
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(Ke_xiadanActivity.this, android.R.layout.simple_dropdown_item_1line, data4);
        louhao.setAdapter(adapter4);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Ke_xiadanActivity.this, android.R.layout.simple_dropdown_item_1line, data);
        yudingXiala1.setAdapter(adapter);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(Ke_xiadanActivity.this, android.R.layout.simple_dropdown_item_1line, data1);
        yudingXiala2.setAdapter(adapter1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(Ke_xiadanActivity.this, android.R.layout.simple_dropdown_item_1line, data2);
        yudingXiala3.setAdapter(adapter2);
        yudingXiala3.setSelection(0);
        yudingXiala3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initdata();
            }
        });
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(Ke_xiadanActivity.this, android.R.layout.simple_dropdown_item_1line, data3);
        yudingXiala4.setAdapter(adapter3);
    }


    @OnClick({R.id.yu_im_zeng, R.id.yu_im_jian, R.id.yu_add, R.id.yu_btn, R.id.yuding_date, R.id.yuding_date1, R.id.yu_center_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.yu_center_back:
                finish();
                break;
            case R.id.yu_im_zeng:
                String s = Integer.valueOf(yuNum.getText().toString()) - 1 + "";
                if (s.equals("0")) {
                    toastShow("预订数量不能小于1");
                } else {
                    yuNum.setText(s);
                }


                break;
            case R.id.yu_im_jian:
                String ss = Integer.valueOf(yuNum.getText().toString()) + 1 + "";

                yuNum.setText(ss);


                break;
            case R.id.yu_add:


                break;
            case R.id.yu_btn:
                data();

                break;
            case R.id.yuding_date:
                new DatePickerDialog(Ke_xiadanActivity.this, onDateSetListener, mYear, mMonth, mDay).show();

                break;
            case R.id.yuding_date1:
                new DatePickerDialog(Ke_xiadanActivity.this, onDateSetListener1, mYear, mMonth, mDay).show();

                break;
        }
    }

    private void data() {
        room = (String) SharedPreferencesUtils.getParam(Ke_xiadanActivity.this, "room", "");
        HashMap<String, String> list = new HashMap<>();
        list.put("guestName", yuName.getText().toString().trim());
        list.put("market", yudingXiala2.getText().toString().trim());
        list.put("checkOutDate", yudingDate.getText().toString());
        list.put("guestRemarks", yuBeizhu.getText().toString().trim());
        list.put("guestPhone", yuPhone.getText().toString().trim());
        list.put("guestSource", yudingXiala1.getText().toString().trim());
        list.put("checkInDate", yudingDate1.getText().toString().trim());

        String str = "";
        for (String key : list.keySet()) {
            // if(){
            str = str + "'" + key + "':'" + list.get(key) + "',";
            //  }

        }
        str = "%7B" + str + "%7D";
        Log.d("yy", str);

        HashMap<String, String> list1 = new HashMap<>();
        list1.put("count", "1");
        list1.put("buildingNumber", louhao.getText().toString().trim());
        list1.put("ReserveType", yudingXiala3.getText().toString().trim());
        list1.put("price", yuMoney.getText().toString().trim());
        list1.put("ownMoneyType", yudingXiala4.getText().toString().trim());
        list1.put("buildingNumber", "2");
        String str1 = "";
        for (String key : list1.keySet()) {
            // if(key.length()-1){
            str1 = str1 + "'" + key + "':'" + list1.get(key) + "',";
            // }

        }
        str1 = "%5B" + "%7B" + str1 + "%7D" + "%5D";
        Log.d("yy", str1);
        String url = ApiStores.API_SERVER_URL + "order/order-room!addOrder.action?order=" + str + "&orderReserve=" + str1 + "&userName=" + room;
        Log.d("yy", url);
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Request request, Exception e) {


            }

            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                Xiadan xiadan = gson.fromJson(response, Xiadan.class);
                code = xiadan.getJsonInfo().getCode();
                msg = xiadan.getJsonInfo().getMsg();
                if (code.equals("0")) {
                    toastShow(msg);
                    Intent intent = new Intent(Ke_xiadanActivity.this, Ke_GeRenActivity.class);
                    startActivity(intent);
                } else {
                    toastShow("下单失败");
                }
                Log.d("zz", response);


            }
        });
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
            yudingDate.setText(days);
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
            yudingDate1.setText(days);
        }
    };

}
