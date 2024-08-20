package com.sunbeaminfo.project.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.sunbeaminfo.project.fragments.SettingFragment;
import com.sunbeaminfo.project.fragments.DashboardFragment;
import com.sunbeaminfo.project.fragments.ProfileFragment;
import com.sunbeaminfo.project.fragments.DashboardFragment;
import com.sunbeaminfo.project.fragments.ProfileFragment;
import com.sunbeaminfo.project.fragments.SettingFragment;

public class MainFragmentAdapter extends FragmentStateAdapter {
    public MainFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new DashboardFragment();
            case 1:
                return new SettingFragment();
            case 2:
                return new ProfileFragment();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
