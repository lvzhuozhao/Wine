package com.wuxiaolong.androidmvpsample.wen;

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
import com.wuxiaolong.androidmvpsample.bean.Wen_liebiao;
import com.wuxiaolong.androidmvpsample.retrofit.ApiStores;
import com.wuxiaolong.androidmvpsample.utils.SharedPreferencesUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Wen_liebiaoActivity extends MvpActivity {

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
    private List<Wen_liebiao.JsonInfoBean.DataBean> data1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wen_find);
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
        String url = ApiStores.API_SERVER_URL + "hotspring/hotspring-checkin!orderList.action";
        Log.d("kk", url);
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(String response) {
                Log.d("kk", response);
                Gson gson = new Gson();
                Wen_liebiao wen_liebiao = gson.fromJson(response, Wen_liebiao.class);
                data1 = wen_liebiao.getJsonInfo().getData();

                listOo.setAdapter(new Adapter());
                listOo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                        Intent intent = new Intent(Wen_liebiaoActivity.this, Wen_xiangActivity.class);

                        intent.putExtra("orderNumber", Wen_liebiaoActivity.this.data1.get(position).getOrderNumber());
                        intent.putExtra("reserveUser", Wen_liebiaoActivity.this.data1.get(position).getReserveUser());
                        intent.putExtra("department", Wen_liebiaoActivity.this.data1.get(position).getDepartment());
                        intent.putExtra("reserveDate", Wen_liebiaoActivity.this.data1.get(position).getReserveDate());

                        intent.putExtra("guestName1", Wen_liebiaoActivity.this.data1.get(position).getGuestName());
                        intent.putExtra("guestPhone", Wen_liebiaoActivity.this.data1.get(position).getGuestPhone());
                        intent.putExtra("guestSource", Wen_liebiaoActivity.this.data1.get(position).getGuestSource());
                        intent.putExtra("market", Wen_liebiaoActivity.this.data1.get(position).getMarket());

                        intent.putExtra("roomType", Wen_liebiaoActivity.this.data1.get(position).getRoomType());
                        intent.putExtra("checkInDate", Wen_liebiaoActivity.this.data1.get(position).getCheckInDate());
                        intent.putExtra("checkOutDate", Wen_liebiaoActivity.this.data1.get(position).getCheckOutDate());
                        intent.putExtra("sum", Wen_liebiaoActivity.this.data1.get(position).getSum());
                        intent.putExtra("guestRemarks", Wen_liebiaoActivity.this.data1.get(position).getGuestRemarks());

                        intent.putExtra("oid", Wen_liebiaoActivity.this.data1.get(position).getOid());
                        SharedPreferencesUtils.setParam(Wen_liebiaoActivity.this,"oid", Wen_liebiaoActivity.this.data1.get(position).getOid());
                        startActivity(intent);
                    }
                });

            }
        });
    }

    class Adapter extends BaseAdapter {

        @Override
        public int getCount() {
            return data1.size();
        }

        @Override
        public Object getItem(int position) {
            return data1.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = View.inflate(Wen_liebiaoActivity.this, R.layout.list_item1, null);
            TextView textView = (TextView) convertView.findViewById(R.id.list__name);
            textView.setText(data1.get(position).getGuestName());
            return convertView;
        }
    }

}
