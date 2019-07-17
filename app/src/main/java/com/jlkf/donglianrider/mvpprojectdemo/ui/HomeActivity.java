package com.jlkf.donglianrider.mvpprojectdemo.ui;

import android.view.View;
import android.widget.TextView;
import com.hjq.toast.ToastUtils;
import com.jlkf.donglianrider.mvpprojectdemo.R;
import com.jlkf.donglianrider.mvpprojectdemo.base.BaseActivity;
import com.jlkf.donglianrider.mvpprojectdemo.bean.LoginBean;
import com.jlkf.donglianrider.mvpprojectdemo.contract.HomeContract;
import com.jlkf.donglianrider.mvpprojectdemo.present.HomePresentImpl;

public class HomeActivity extends BaseActivity<HomePresentImpl> implements HomeContract.IHomeView {

    private TextView mLogin;
    private TextView mContent;




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
        mLogin = (TextView) findViewById(R.id.login);
        mContent = (TextView) findViewById(R.id.content);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                present.getData();

                int a = 1;
                int b = 2;
                int sum = a + b;
            }
        });
    }


}
