package com.wuxiaolong.androidmvpsample.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wuxiaolong.androidmvpsample.R;
import com.wuxiaolong.androidmvpsample.ke.Ke_BuchongActivity;
import com.wuxiaolong.androidmvpsample.ke.Ke_WhyActivity;

/**
 * Created by LZZ on 2017/8/24.
 */

public class AlertDialogFragment extends DialogFragment {

    private Button mBtnSure;
    private Button mBtnCancel;
    private TextView mTvMsg;

    public interface DialogFragmentDataImp {//定义一个与Activity通信的接口，使用该DialogFragment的Activity须实现该接口

        void showMessage(String message);
    }

    public static AlertDialogFragment newInstance(String message) {
        //创建一个带有参数的Fragment实例
        AlertDialogFragment fragment = new AlertDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("message", message);
        fragment.setArguments(bundle);//把参数传递给该DialogFragment
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View customView = LayoutInflater.from(getActivity()).inflate(
                R.layout.base_dialogfragment, null);
        mBtnSure = (Button) customView.findViewById(R.id.dia_quxiao);
        mBtnCancel = (Button) customView.findViewById(R.id.dia_queren);
        mTvMsg = (TextView) customView.findViewById(R.id.message);

        mTvMsg.setText(getArguments().getString("message"));//把传递过来的数据设置给TextView
        mBtnSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), Ke_WhyActivity.class);
                startActivity(intent);
                dismiss();
            }
        });
        mBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Ke_BuchongActivity.class);
                startActivity(intent);
                dismiss();
            }
        });
        return new AlertDialog.Builder(getActivity()).setView(customView)
                .create();
    }

}
