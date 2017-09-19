package com.wuxiaolong.androidmvpsample.ke;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.wuxiaolong.androidmvpsample.R;
import com.wuxiaolong.androidmvpsample.base.BasePresenter;
import com.wuxiaolong.androidmvpsample.base.MvpActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Ke_xiangActivity extends MvpActivity {


    @Bind(R.id.shouyin_back)
    ImageView shouyinBack;
    @Bind(R.id.xiang_danhao)
    TextView xiangDanhao;
    @Bind(R.id.xiang_yudingren)
    TextView xiangYudingren;
    @Bind(R.id.xiang_bumen)
    TextView xiangBumen;
    @Bind(R.id.xiang_yudingshijian)
    TextView xiangYudingshijian;
    @Bind(R.id.xiang_kehuname)
    TextView xiangKehuname;
    @Bind(R.id.xiang_phone)
    TextView xiangPhone;
    @Bind(R.id.xiang_laiyuan)
    TextView xiangLaiyuan;
    @Bind(R.id.xiang_fenlei)
    TextView xiangFenlei;
    @Bind(R.id.xiang_lexing)
    TextView xiangLexing;
    @Bind(R.id.xiang_checkin)
    TextView xiangCheckin;
    @Bind(R.id.xiang_checkout)
    TextView xiangCheckout;
    @Bind(R.id.xiang_price)
    TextView xiangPrice;
    @Bind(R.id.xiang_markeys)
    TextView xiangMarkeys;
    @Bind(R.id.ruzhu_btn)
    Button ruzhuBtn;
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
        setContentView(R.layout.activity_check_xiang);
        ButterKnife.bind(this);
        shuju();
        initdata();
    }

    private void shuju() {
        Intent intent = getIntent();
        orderNumber = intent.getStringExtra("orderNumber");
        reserveUser = intent.getStringExtra("reserveUser");
        department = intent.getStringExtra("department");
        reserveDate = intent.getStringExtra("reserveDate");

        guestName1 = intent.getStringExtra("guestName1");
        guestPhone = intent.getStringExtra("guestPhone");
        guestSource = intent.getStringExtra("guestSource");
        market = intent.getStringExtra("market");

        roomType = intent.getStringExtra("roomType");
        checkInDate = intent.getStringExtra("checkInDate");
        checkOutDate = intent.getStringExtra("checkOutDate");
        sum = intent.getStringExtra("sum");
        guestRemarks = intent.getStringExtra("guestRemarks");

        oid = intent.getStringExtra("oid");
    }

    private void initdata() {
        xiangDanhao.setText(orderNumber);
        xiangYudingren.setText(reserveUser);
        xiangBumen.setText(department);
        xiangYudingshijian.setText(reserveDate);

        xiangKehuname.setText(guestName1);
        xiangPhone.setText(guestPhone);
        xiangLaiyuan.setText(guestSource);
        xiangFenlei.setText(market);

        xiangLexing.setText(market);
        xiangCheckin.setText(checkInDate);
        xiangCheckout.setText(checkOutDate);
        xiangPrice.setText(sum);
        xiangMarkeys.setText(guestRemarks);


    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }


    @OnClick({R.id.shouyin_back, R.id.ruzhu_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.shouyin_back:
                finish();
                break;
            case R.id.ruzhu_btn:
                Intent intent = new Intent(Ke_xiangActivity.this, Ke_ChenkinActivity.class);
                intent.putExtra("oid",oid);
                startActivity(intent);
                break;
        }
    }
}
