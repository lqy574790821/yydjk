package com.example.yydkj.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.yydkj.ui.fragment.BaseFragment;
import com.example.yydkj.utils.Fields;



public class BaseActivity extends AppCompatActivity {
    //完整的显示一个fragment
    public void startFragment(Class<? extends BaseFragment> fragmentClass, String title, Bundle bundle, boolean isShowActionbar, boolean isArrow) {
        Intent intent = new Intent(this, ShowActivity.class);
        //这个数据包给展示的fragment

        intent.putExtra(Fields.showActivity.bundle, bundle);

        //单独传递数据给activity
        intent.putExtra(Fields.showActivity.className, fragmentClass);
        intent.putExtra(Fields.showActivity.isShowActionbar, isShowActionbar);
        intent.putExtra(Fields.showActivity.title, title);
        intent.putExtra(Fields.showActivity.isArrow, isArrow);
        startActivity(intent);
    }

}
