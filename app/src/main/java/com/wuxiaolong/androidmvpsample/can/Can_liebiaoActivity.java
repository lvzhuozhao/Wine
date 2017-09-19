package com.wuxiaolong.androidmvpsample.can;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.wuxiaolong.androidmvpsample.R;
import com.wuxiaolong.androidmvpsample.base.BasePresenter;
import com.wuxiaolong.androidmvpsample.base.MvpActivity;
import com.wuxiaolong.androidmvpsample.bean.DDD;
import com.wuxiaolong.androidmvpsample.retrofit.ApiStores;
import com.wuxiaolong.androidmvpsample.utils.SharedPreferencesUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Can_liebiaoActivity extends MvpActivity {

    @Bind(R.id.wc_back)
    ImageView wcBack;
    @Bind(R.id.can_yuding_title)
    TextView canYudingTitle;
    @Bind(R.id.real)
    RelativeLayout real;
    @Bind(R.id.liebiao_find)
    ImageView liebiaoFind;
    @Bind(R.id.search)
    EditText search;
    @Bind(R.id.list_oo)
    ListView listOo;
    private List<DDD.JsonInfoBean.DataBean> data;
    private String orderNumber;
    private String reserveUser;
    private String department;
    private String reserveDate;
    private String guestName1;
    private String guestPhone;
    private String guestSource;
    private String market;
    private String roomType;
    private String checkInDate;
    private String checkOutDate;
    private String sum;
    private String guestRemarks;
    private String oid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_can_find);
        ButterKnife.bind(this);
        data();
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @OnClick({R.id.wc_back, R.id.liebiao_find})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.wc_back:
                finish();
                break;
            case R.id.liebiao_find:

                break;
        }
    }

    private void data() {
        String url = ApiStores.API_SERVER_URL + "restaurant/restaurant-checkin!orderList.action";
        Log.d("kk", url);
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(String response) {
                Log.d("kk", response);
                Gson gson = new Gson();
                DDD ddd = gson.fromJson(response, DDD.class);
                data = ddd.getJsonInfo().getData();
                listOo.setAdapter(new Adapter());
                listOo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                        Intent intent = new Intent(Can_liebiaoActivity.this, Can_xiangctivity.class);

                        intent.putExtra("orderNumber", data.get(position).getOrderNumber());
                        intent.putExtra("reserveUser", data.get(position).getReserveUser());
                        intent.putExtra("department", data.get(position).getDepartment());
                        intent.putExtra("reserveDate", data.get(position).getReserveDate());

                        intent.putExtra("guestName1", data.get(position).getGuestName());
                        intent.putExtra("guestPhone", data.get(position).getGuestPhone());
                        intent.putExtra("guestSource", data.get(position).getGuestSource());
                        intent.putExtra("market", data.get(position).getMarket());

                        intent.putExtra("roomType", data.get(position).getRoomType());
                        intent.putExtra("checkInDate", data.get(position).getCheckInDate());
                        intent.putExtra("checkOutDate", data.get(position).getCheckOutDate());
                        intent.putExtra("sum", data.get(position).getSum());
                        intent.putExtra("guestRemarks", data.get(position).getGuestRemarks());

                        intent.putExtra("oid", data.get(position).getOid());
                        SharedPreferencesUtils.setParam(Can_liebiaoActivity.this,"oid",data.get(position).getOid());
                        startActivity(intent);
                    }
                });


            }
        });
    }

    class Adapter extends BaseAdapter {

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = View.inflate(Can_liebiaoActivity.this, R.layout.list_item1, null);
            TextView textView = (TextView) convertView.findViewById(R.id.list__name);
            textView.setText(data.get(position).getGuestName());
            return convertView;
        }
    }

}
