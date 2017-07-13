package com.jiawei.vchat;

import android.os.Bundle;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;
import android.widget.LinearLayout;

import com.jiawei.vchat.contact.ContactFragment;
import com.jiawei.vchat.conversation.ConversationFragment;
import com.jiawei.vchat.moment.MomentFragment;
import com.jiawei.vchat.profile.ProfileFragment;
import com.jiawei.vchat.widget.EmptyPageChangeListener;
import com.jiawei.vchat.widget.TabBar;
import com.jiawei.vchat.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    /**
     * UI
     */
    @BindView(R.id.ll_tabs)
    LinearLayout mLlTabs;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;

    /**
     * DATA
     */
    private List<BaseFragment> fragmentList = new ArrayList<>(4);
    private List<TabBar> mTabBarList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {
        mTabBarList=new ArrayList<>(mLlTabs.getChildCount());
        fragmentList.add(new ConversationFragment());
        fragmentList.add(new ContactFragment());
        fragmentList.add(new MomentFragment());
        fragmentList.add(new ProfileFragment());

        View.OnClickListener onClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=(int)v.getTag();
                mViewpager.setCurrentItem(position,false);
            }
        };

        mViewpager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public BaseFragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });

        mViewpager.addOnPageChangeListener(new EmptyPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                onTabChecked(position);
            }
        });

        for (int i = 0; i < mLlTabs.getChildCount(); i++) {
            TabBar tabBar = (TabBar) mLlTabs.getChildAt(i);
            tabBar.setTag(i);
            tabBar.setOnClickListener(onClickListener);
            mTabBarList.add(tabBar);
        }
    }

    private void onTabChecked(int position) {
        TabBar tabBar = mTabBarList.get(position);
        for (TabBar tab : mTabBarList) {
            tab.setSelected(false);
        }
        tabBar.setSelected(true);
    }
}
