package com.jlkf.donglianrider.mvpprojectdemo.ui;

import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.TextView;
import com.hjq.toast.ToastUtils;
import com.jlkf.donglianrider.mvpprojectdemo.R;
import com.jlkf.donglianrider.mvpprojectdemo.base.BaseActivity;
import com.jlkf.donglianrider.mvpprojectdemo.bean.LoginBean;
import com.jlkf.donglianrider.mvpprojectdemo.contract.HomeContract;
import com.jlkf.donglianrider.mvpprojectdemo.present.HomePresentImpl;
import com.jlkf.donglianrider.mvpprojectdemo.utils.TimeUtils;
import com.jlkf.donglianrider.ui.pickerview.builder.TimePickerBuilder;
import com.jlkf.donglianrider.ui.pickerview.listener.OnTimeSelectListener;
import com.jlkf.donglianrider.ui.pickerview.view.TimePickerView;
import com.jlkf.donglianrider.ui.view.jdaddressselector.AddressSelector;
import com.jlkf.donglianrider.ui.view.jdaddressselector.BottomDialog;
import com.jlkf.donglianrider.ui.view.jdaddressselector.OnAddressSelectedListener;
import com.jlkf.donglianrider.ui.view.jdaddressselector.model.City;
import com.jlkf.donglianrider.ui.view.jdaddressselector.model.County;
import com.jlkf.donglianrider.ui.view.jdaddressselector.model.Province;
import com.jlkf.donglianrider.ui.view.jdaddressselector.model.Street;

import java.util.Calendar;
import java.util.Date;

public class HomeActivity extends BaseActivity<HomePresentImpl> implements HomeContract.IHomeView {

    private TextView mLogin;
    private TextView mContent;
    private TextView mTextView3;
    private TimePickerView pvTime;
    private TextView mTextView2;


    @Override
    public void refreshSuccess(LoginBean content) {
        mContent.setText(content.getUserInfo().getUser().getPhone());

        ToastUtils.show("登录成功");
    }

    @Override
    public void refreshError(String error) {
        mContent.setText(error);
    }

    @Override
    public String getUserId() {
        return null;
    }

    @Override
    public String getAccount() {
        return "13138895762";
    }

    @Override
    public String getPsw() {
        return "123456";
    }

    @Override
    protected int intiLayout() {
        return R.layout.activity_home;
    }

    @Override
    public void initView() {
        mLogin = findViewById(R.id.login);
        mContent = findViewById(R.id.content);
        mTextView3 = findViewById(R.id.textView3);
        mTextView2 = findViewById(R.id.textView2);

        mLogin.setOnClickListener(v -> present.getData());
        mTextView3.setOnClickListener(v -> selectTime());
        mTextView2.setOnClickListener(v -> selectAddr());
    }

    private void selectAddr() {
//        AddressSelector selector = new AddressSelector(this);
//        selector.setOnAddressSelectedListener(new OnAddressSelectedListener() {
//            @Override
//            public void onAddressSelected(Province province, City city, County county, Street street) {
//
//            }
//
//            @Override
//            public void dissmiss() {
//
//            }
//        });
//
//        View view = selector.getView();
//         frameLayout.addView(view)
// new AlertDialog.Builder(this).setView(view).show();

        BottomDialog dialog = new BottomDialog(this);
        dialog.setOnAddressSelectedListener(new OnAddressSelectedListener() {
            @Override
            public void onAddressSelected(Province province, City city, County county, Street street) {

            }

            @Override
            public void dissmiss() {

            }
        });
        dialog.show();
    }


    public void selectTime() {
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        //startDate.set(2013,1,1);
        Calendar endDate = Calendar.getInstance();
        Calendar currentDate = Calendar.getInstance();
        //endDate.set(2020,1,1);

        //正确设置方式 原因：注意事项有说明
        endDate.set(selectedDate.get(Calendar.YEAR), selectedDate.get(Calendar.MONTH), selectedDate.get(Calendar.DAY_OF_MONTH));
        startDate.set(selectedDate.get(Calendar.YEAR) - 100, 0, 1);
        currentDate.set(selectedDate.get(Calendar.YEAR),  selectedDate.get(Calendar.MONTH), selectedDate.get(Calendar.DAY_OF_MONTH));
        pvTime = new TimePickerBuilder(this, (date, v) -> {
            //选中事件回调
            String bir = TimeUtils.getCnDate3(date.getTime()).toString();
//                bir =   bir.replaceAll("·", "-");
            mTextView3.setText(bir);
        })
                .setType(new boolean[]{true, true, true, false, false, false})// 默认全部显示
                .setCancelText("取消")//取消按钮文字
                .setSubmitText("确定")//确认按钮文字
                .setContentTextSize(13)//滚轮文字大小
//                .setSubCalSize(13)
//                .setTitleSize(15)//标题文字大小
//                .setTitleText("选择生日")//标题文字
//                .setOutSideCancelable(false)//点击屏幕，点在控件外部范围时，是否取消显示
                .isCyclic(false)//是否循环滚动
//                .setTitleColor(Color.BLACK)//标题文字颜色
                .setSubmitColor(this.getResources().getColor(R.color.color_0FA9DF))//确定按钮文字颜色
                .setCancelColor(this.getResources().getColor(R.color.color_7E8A9B))//取消按钮文字颜色
                .setTitleBgColor(this.getResources().getColor(R.color.color_theme))//标题背景颜色 Night mode
                .setBgColor(this.getResources().getColor(R.color.color_theme))//滚轮背景颜色 Night mode
                .setDividerColor(this.getResources().getColor(R.color.white))

                .setTextColorCenter(this.getResources().getColor(R.color.color_222222))
                .setTextColorOut(this.getResources().getColor(R.color.color_b3b3b3))


                .setDate(currentDate)// 如果不设置的话，默认是系统时间*/
                .setRangDate(startDate, endDate)//起始终止年月日设定
//                .setLabel("年", "月", "日", "时", "分", "秒")//默认设置为年月日时分秒
//                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
//                .isDialog(false)//是否显示为对话框样式
//                .setDecorView((ViewGroup) ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0))
//                .setLineSpacingMultiplier(2)  //设置行间距
                .build();


        pvTime.show();


    }


}
