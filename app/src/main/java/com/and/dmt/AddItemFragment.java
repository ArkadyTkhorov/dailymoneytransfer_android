package com.and.dmt;

/**
 * Created by user on 11/23/2017.
 */
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.and.dmt.SubItemFragment.AddCategoryFragment;
import com.and.dmt.SubItemFragment.AddDateFragment;
import com.and.dmt.SubItemFragment.AddFileFragment;
import com.and.dmt.SubItemFragment.AddMoneyFragment;
import com.and.dmt.SubItemFragment.AddRemainFragment;
import com.and.dmt.SubItemFragment.AddTextFragment;
import com.and.dmt.SubItemFragment.DoneFragment;
import com.and.dmt.SubItemFragment.MultiAddFragment;

import java.util.ArrayList;
import java.util.List;


public class AddItemFragment extends Fragment {

    TabLayout tabLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_additemdialog, container, false);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.addFragment(new AddCategoryFragment(),null);
        adapter.addFragment(new AddFileFragment(),null);
        adapter.addFragment(new AddTextFragment(),null);
        adapter.addFragment(new AddMoneyFragment(),null);
        adapter.addFragment(new AddDateFragment(),null);
        adapter.addFragment(new AddRemainFragment(),null);
        adapter.addFragment(new DoneFragment(),null);
        adapter.addFragment(new MultiAddFragment(),null);
        viewPager.setAdapter(adapter);
        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
        return view;
    }
    private void setupTabIcons(){
        tabLayout.getTabAt(0).setIcon(R.drawable.add_category);
        tabLayout.getTabAt(1).setIcon(R.drawable.add_file);
        tabLayout.getTabAt(2).setIcon(R.drawable.add_text);
        tabLayout.getTabAt(3).setIcon(R.drawable.add_money);
        tabLayout.getTabAt(4).setIcon(R.drawable.add_date);
        tabLayout.getTabAt(5).setIcon(R.drawable.add_remain);
        tabLayout.getTabAt(6).setIcon(R.drawable.add_done);
        tabLayout.getTabAt(7).setIcon(R.drawable.add_multi);
    }
    class ViewPagerAdapter extends FragmentPagerAdapter
    {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();
        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }
        @Override
        public int getCount() {
            return mFragmentList.size();
        }
        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}