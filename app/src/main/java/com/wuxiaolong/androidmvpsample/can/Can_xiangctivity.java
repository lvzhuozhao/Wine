package com.wuxiaolong.androidmvpsample.can;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.wuxiaolong.androidmvpsample.R;
import com.wuxiaolong.androidmvpsample.base.BasePresenter;
import com.wuxiaolong.androidmvpsample.base.MvpActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Can_xiangctivity extends MvpActivity {


    @Bind(R.id.jiezhnag_back)
    ImageView jiezhnagBack;
    @Bind(R.id.shouyin_title)
    TextView shouyinTitle;
    @Bind(R.id.ke_bianhao)
    TextView keBianhao;
    @Bind(R.id.ke_yudingren)
    TextView keYudingren;
    @Bind(R.id.ke_bumen)
    TextView keBumen;
    @Bind(R.id.ke_yudingshijian)
    TextView keYudingshijian;
    @Bind(R.id.ke_name)
    TextView keName;
    @Bind(R.id.ke_phone)
    TextView kePhone;
    @Bind(R.id.ke_laiyuan)
    TextView keLaiyuan;
    @Bind(R.id.ke_fenlei)
    TextView keFenlei;
    @Bind(R.id.ke_leixing)
    TextView keLeixing;
    @Bind(R.id.ke_checkin)
    TextView keCheckin;
    @Bind(R.id.ke_checkout)
    TextView keCheckout;
    @Bind(R.id.ke_sum)
    TextView keSum;
    @Bind(R.id.ke_beizhu)
    TextView keBeizhu;
    @Bind(R.id.ke_fanghao)
    EditText keFanghao;
    @Bind(R.id.ke_jine)
    EditText keJine;
    @Bind(R.id.ke_renshu)
    EditText keRenshu;
    @Bind(R.id.yiyi_btn)
    Button yiyiBtn;
    @Bind(R.id.yiyi_btn1)
    Button yiyiBtn1;
    @Bind(R.id.yiyi_btn2)
    Button yiyiBtn2;
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
    private String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c__wshouyin);
        ButterKnife.bind(this);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd   HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());
        str = formatter.format(curDate);
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

        keBianhao.setText(orderNumber);
        keYudingren.setText(reserveUser);
        keBumen.setText(department);
        keYudingshijian.setText(reserveDate);

        keName.setText(guestName1);
        kePhone.setText(guestPhone);
        keLaiyuan.setText(guestSource);
        keFenlei.setText(market);

        keLeixing.setText(market);
        keCheckin.setText(checkInDate);
        keCheckout.setText(checkOutDate);
        keSum.setText(sum);
        keBeizhu.setText(guestRemarks);


    }


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }



    @OnClick({R.id.jiezhnag_back, R.id.yiyi_btn, R.id.yiyi_btn1, R.id.yiyi_btn2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.jiezhnag_back:
                break;
            case R.id.yiyi_btn:
                Intent intent = new Intent(Can_xiangctivity.this, Can_JieZhangActivity.class);
                intent.putExtra("oid", oid);
                intent.putExtra("trim",keFanghao.getText().toString().trim());
                intent.putExtra("trim1",keJine.getText().toString().trim());
                intent.putExtra("trim2",keRenshu.getText().toString().trim());
                startActivity(intent);
                break;
            case R.id.yiyi_btn1:
                Intent  intent1=new Intent(Can_xiangctivity.this,Can_jieqianActivity.class);
                intent1.putExtra("oid",oid);
                intent1.putExtra("trim",keFanghao.getText().toString().trim());
                intent1.putExtra("trim1",keJine.getText().toString().trim());
                intent1.putExtra("trim2",keRenshu.getText().toString().trim());
                intent1.putExtra("guestName1",guestName1);
                intent1.putExtra("reserveUser",reserveUser);
                intent1.putExtra("str",str);
                startActivity(intent1);

                break;
            case R.id.yiyi_btn2:
                Intent  intent2=new Intent(Can_xiangctivity.this,Can_guazhangActivity.class);
                intent2.putExtra("oid",oid);
                intent2.putExtra("trim1",keJine.getText().toString().trim());
                intent2.putExtra("trim2",keRenshu.getText().toString().trim());
                intent2.putExtra("trim",keFanghao.getText().toString().trim());
                startActivity(intent2);
                break;
        }
    }
}
