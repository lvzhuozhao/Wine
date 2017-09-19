package com.wuxiaolong.androidmvpsample.ke;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.wuxiaolong.androidmvpsample.bean.Add;
import com.wuxiaolong.androidmvpsample.retrofit.ApiStores;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Ke_LiebiaoActivity extends MvpActivity {


    @Bind(R.id.banli_back)
    ImageView banliBack;
    @Bind(R.id.real)
    RelativeLayout real;
    @Bind(R.id.ruzhu_list)
    ListView ruzhuList;

    @Bind(R.id.zhu_find)
    ImageView zhuFind;
    @Bind(R.id.search)
    EditText search;



    private String guestName;

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
    private List<Add.JsonInfoBean.DataBean> list_data;
    private String oid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        ButterKnife.bind(this);
        initdata();
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String url = ApiStores.API_SERVER_URL + "room/room-checkin!searchOrderList.action?searchText=" +
                        search.getText().toString();
                Log.d("----", url);
                OkHttpUtils.get().build().execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {
                        Log.d("----", response);
                    }
                });
            }
        });
    }




    private void initdata() {

        String url = ApiStores.API_SERVER_URL + "room/room-checkin!orderList.action";
        Log.d("pp", url);
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                Add add = gson.fromJson(response, Add.class);
                list_data = add.getJsonInfo().getData();
                Log.d("ll", response);
                ruzhuList.setAdapter(new Adapter());
                ruzhuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(Ke_LiebiaoActivity.this, Ke_xiangActivity.class);

                        intent.putExtra("orderNumber", list_data.get(position).getOrderNumber());
                        intent.putExtra("reserveUser", list_data.get(position).getReserveUser());
                        intent.putExtra("department", list_data.get(position).getDepartment());
                        intent.putExtra("reserveDate", list_data.get(position).getReserveDate());

                        intent.putExtra("guestName1", list_data.get(position).getGuestName());
                        intent.putExtra("guestPhone", list_data.get(position).getGuestPhone());
                        intent.putExtra("guestSource", list_data.get(position).getGuestSource());
                        intent.putExtra("market", list_data.get(position).getMarket());

                        intent.putExtra("roomType", list_data.get(position).getRoomType());
                        intent.putExtra("checkInDate", list_data.get(position).getCheckInDate());
                        intent.putExtra("checkOutDate", list_data.get(position).getCheckOutDate());
                        intent.putExtra("sum", list_data.get(position).getSum());
                        intent.putExtra("guestRemarks", list_data.get(position).getGuestRemarks());

                        intent.putExtra("oid", list_data.get(position).getOid());

                        startActivity(intent);
                    }
                });
            }
        });


    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }


    @OnClick({R.id.banli_back, R.id.zhu_find})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.banli_back:
                finish();
                break;
            case R.id.zhu_find:


                break;
        }
    }

    class Adapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list_data.size();
        }

        @Override
        public Object getItem(int position) {
            return list_data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = View.inflate(Ke_LiebiaoActivity.this, R.layout.list_item, null);
            TextView name = (TextView) convertView.findViewById(R.id.list_name);
            name.setText(list_data.get(position).getGuestName());
            return convertView;
        }
    }
}
