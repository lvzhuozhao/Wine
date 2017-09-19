package com.wuxiaolong.androidmvpsample.fargment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
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
import com.wuxiaolong.androidmvpsample.utils.SharedPreferencesUtils;

import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by LZZ on 2017/8/29.
 */

public class OneFragment extends MvpFragment {


    @Bind(R.id.jianjian)
    ImageView jianjian;
    @Bind(R.id.canyin_canzhuoshuliang)
    EditText canyinCanzhuoshuliang;
    @Bind(R.id.jiajia)
    ImageView jiajia;
    @Bind(R.id.jianjianjian)
    ImageView jianjianjian;
    @Bind(R.id.yuding_renshu)
    EditText yudingRenshu;
    @Bind(R.id.jiajiajia)
    ImageView jiajiajia;
    @Bind(R.id.xiaofeishijian)
    TextView xiaofeishijian;
    @Bind(R.id.beibei)
    EditText beibei;
    @Bind(R.id.can_yuding_spanner3)
    BetterSpinner canYudingSpanner3;
    private View view;
    private int mMonth;
    private int mYear;
    private int mDay;

    //客户来源
    private static final String[] data = new String[]{"包厢", "散桌"};

    @Override
    protected BasePresenter createPresenter() {

        return null;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.ke_canyin, null);
        ButterKnife.bind(this, view);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, data);
        canYudingSpanner3.setAdapter(adapter);
        Calendar ca = Calendar.getInstance();
        mYear = ca.get(Calendar.YEAR);
        mMonth = ca.get(Calendar.MONTH);
        mDay = ca.get(Calendar.DAY_OF_MONTH);

        Log.d("ppp", xiaofeishijian.getText().toString().trim());

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }



    /*日期选择器对话框监听*/

    private DatePickerDialog.OnDateSetListener onDateSetListener;

    {
        onDateSetListener = new DatePickerDialog.OnDateSetListener() {

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
                SharedPreferencesUtils.setParam(getActivity(), "leixing", canYudingSpanner3.getText().toString().trim());
                SharedPreferencesUtils.setParam(getActivity(), "shuliang", canyinCanzhuoshuliang.getText().toString().trim());
                SharedPreferencesUtils.setParam(getActivity(), "renshu", yudingRenshu.getText().toString().trim());
                SharedPreferencesUtils.setParam(getActivity(), "shi", xiaofeishijian.getText().toString().trim());
                SharedPreferencesUtils.setParam(getActivity(), "beizhu", beibei.getText().toString().trim());
            }
        };
    }


    @OnClick({R.id.jianjian, R.id.jiajia, R.id.jianjianjian, R.id.jiajiajia, R.id.xiaofeishijian})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.jianjian:
                String s = Integer.valueOf(canyinCanzhuoshuliang.getText().toString()) - 1 + "";
                if (s.equals("0")) {
                    toastShow("格式不正确");
                } else {
                    canyinCanzhuoshuliang.setText(s);
                }
                break;
            case R.id.jiajia:

                canyinCanzhuoshuliang.setText(Integer.valueOf(canyinCanzhuoshuliang.getText().toString()) + 1 + "");
                break;
            case R.id.jianjianjian:
                String s1 = Integer.valueOf(yudingRenshu.getText().toString()) - 1 + "";
                if (s1.equals("0")) {
                    toastShow("格式不正确");
                } else {
                    yudingRenshu.setText(s1);
                }
                break;
            case R.id.jiajiajia:
                yudingRenshu.setText(Integer.valueOf(canyinCanzhuoshuliang.getText().toString()) + 1 + "");
                break;
            case R.id.xiaofeishijian:
                new DatePickerDialog(getActivity(), onDateSetListener, mYear, mMonth, mDay).show();


                break;
        }
    }


}
