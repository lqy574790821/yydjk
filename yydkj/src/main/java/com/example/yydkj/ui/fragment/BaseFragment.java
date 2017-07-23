package com.example.yydkj.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yydkj.ui.activity.ShowActivity;
import com.example.yydkj.ui.view.LoaderPager;
import com.example.yydkj.utils.Fields;



public abstract class BaseFragment extends Fragment {

    private LoaderPager mLoaderPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mLoaderPager == null) {
            mLoaderPager = new LoaderPager(container.getContext()) {
                @Override
                protected Object getNetData() {
                    return requestData();
                }



                @Override
                protected View createSuccessView() {
                    return getSuccessView();
                }
            };
        }




        return mLoaderPager;
    }

    //得到一个成功的view
    protected abstract View getSuccessView();

    //请求数据
    public abstract Object requestData();

    //刷新方法
    public void refreshData() {
        mLoaderPager.loadData();
    }


    //显示的类只要一个标题
    public void startFragment(Class<? extends BaseFragment> fragmentClass,String title) {
        startFragment(fragmentClass, title, null, false, false);
    }

    //给fragment参数参数入标题时用
    public void startFragment(Class<? extends BaseFragment> fragmentClass,Bundle bundle,String title) {
        startFragment(fragmentClass,title,bundle,false,false);
    }

    //需要给fragment传递参数时候用
    public void startFragment(Class<? extends BaseFragment> fragmentClass,Bundle bundle) {
        startFragment(fragmentClass, "", bundle, false, false);
    }

    //只是显示一个fragment
    public void startFragment(Class<? extends BaseFragment> fragmentClass) {
        startFragment(fragmentClass,"",null,false,false);
    }


    //完整的显示一个fragment
    public void startFragment(Class<? extends BaseFragment> fragmentClass,String title,Bundle bundle, boolean isShowActionbar, boolean isArrow) {
        Intent intent = new Intent(getContext(), ShowActivity.class);
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
