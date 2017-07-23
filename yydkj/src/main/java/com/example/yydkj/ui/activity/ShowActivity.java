package com.example.yydkj.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.MenuItem;

import com.example.yydkj.R;
import com.example.yydkj.ui.fragment.BaseFragment;
import com.example.yydkj.utils.Fields;



public class ShowActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        Bundle bundle = getIntent().getBundleExtra(Fields.showActivity.bundle);

        //替换
        try {
            Class<BaseFragment> classname = (Class<BaseFragment>) getIntent().getSerializableExtra("className");
            BaseFragment fragment = classname.newInstance();

            fragment.setArguments(bundle);

            getSupportFragmentManager().beginTransaction().replace(R.id.fl_main_show_layout, fragment).commit();
        } catch ( Exception e) {
            e.printStackTrace();
        }

        init();
    }

    private void init() {
        initACtionbar();
    }

    private void initACtionbar() {
        ActionBar actionBar = getSupportActionBar();
        boolean isShowActionbar = getIntent().getBooleanExtra(Fields.showActivity.isShowActionbar, false);
        if (isShowActionbar) {
            actionBar.show();
        } else {
            actionBar.hide();
        }

        String title = getIntent().getStringExtra(Fields.showActivity.title);
        if (!TextUtils.isEmpty(title)) {
            actionBar.setTitle(title);
        }

        boolean isArrow = getIntent().getBooleanExtra(Fields.showActivity.isArrow, false);
        if (isArrow) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    //选择
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
                    case android.R.id.home:
                        finish();

                        break;

                    default:
                        break;

                }
        return super.onOptionsItemSelected(item);
    }
}
