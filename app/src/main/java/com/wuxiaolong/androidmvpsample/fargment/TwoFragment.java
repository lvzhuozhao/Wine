package com.wuxiaolong.androidmvpsample.fargment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.weiwangcn.betterspinner.library.BetterSpinner;
import com.wuxiaolong.androidmvpsample.R;
import com.wuxiaolong.androidmvpsample.base.BasePresenter;
import com.wuxiaolong.androidmvpsample.base.MvpFragment;

import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by LZZ on 2017/8/29.
 */

public class TwoFragment extends MvpFragment {

    @Bind(R.id.can_spanner)
    BetterSpinner canSpanner;
    @Bind(R.id.can_jianjian)
    ImageView canJianjian;
    @Bind(R.id.canrenshu)
    EditText canrenshu;
    @Bind(R.id.can_jiajia)
    ImageView canJiajia;
    @Bind(R.id.ssss)
    TextView ssss;
    @Bind(R.id.ccc_beizhu)
    EditText cccBeizhu;
    private View view;
    //客户来源
    private String[] data = new String[]{"一般", "VIP"};
    private int mYear;
    private int mMonth;
    private int mDay;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.wen_canyin, null);
        ButterKnife.bind(this, view);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, data);
        canSpanner.setAdapter(adapter);
        Calendar ca = Calendar.getInstance();
        mYear = ca.get(Calendar.YEAR);
        mMonth = ca.get(Calendar.MONTH);
        mDay = ca.get(Calendar.DAY_OF_MONTH);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
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

            ssss.setText(days);

        }
    };

    @OnClick({R.id.can_jianjian, R.id.can_jiajia, R.id.ssss})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.can_jianjian:
                String s = Integer.valueOf(canrenshu.getText().toString()) - 1 + "";
                if (s.equals("0")) {
                    toastShow("格式不正确");
                } else {
                    canrenshu.setText(s);
                }
                break;
            case R.id.can_jiajia:
                canrenshu.setText(Integer.valueOf(canrenshu.getText().toString()) + 1 + "");
                break;
            case R.id.ssss:

                new DatePickerDialog(getActivity(), onDateSetListener, mYear, mMonth, mDay).show();
                break;
        }


    }

}
