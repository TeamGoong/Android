package com.example.jinyoungkim.teamgung.ui.gung_ticket;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;

import com.example.jinyoungkim.teamgung.R;
import com.example.jinyoungkim.teamgung.ui.gung_ticket.confirm_reservation.ConfirmReservationFragment;
import com.example.jinyoungkim.teamgung.ui.gung_ticket.make_reservation.MakeReservationFragment;
import com.example.jinyoungkim.teamgung.ui.gung_tour.TourMainActivity;

// 예매하기, 예매 확인 메인 액티비티

public class TicketMainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Switch switch_ticket;
    private LinearLayout special_reservation_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_main);

//        상태바 색상변경
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(0xffb54141);
        }


//        뷰 초기화
        tabLayout = (TabLayout)findViewById(R.id.tab_ticket); // 예매확인/예매하기 탭
        viewPager = (ViewPager)findViewById(R.id.viewpager_ticket); // 뷰페이저
        switch_ticket = (Switch)findViewById(R.id.switch_ticket); // 화면전환 스위치
        special_reservation_layout= (LinearLayout)findViewById(R.id.special_reservation_layout); // 특별관람 예매하기 하단 레이아웃


//        스위치
        switch_ticket.setChecked(false);
        switch_ticket.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    startActivity(new Intent(getApplicationContext(), TourMainActivity.class));
                    overridePendingTransition(0,0);
                    finish();
                }
            }
        });


//        탭 레이아웃 초기화
        tabLayout.addTab(tabLayout.newTab().setText("예매확인"));
        tabLayout.addTab(tabLayout.newTab().setText("예매하기"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabTextColors(R.color.background,Color.BLACK);


//        탭 어댑터
        TabPagerAdapter pagerAdapter = new TabPagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


//        탭 리스너
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

//  탭 리스너 추가 하기

    /************* 탭 레이아웃 어댑터 클래스 *************/
    public class TabPagerAdapter extends FragmentStatePagerAdapter {

        private int tabCount; //탭 개수

        public TabPagerAdapter(FragmentManager fm, int tabCount) {
            super(fm);
            this.tabCount = tabCount;
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    special_reservation_layout.setVisibility(View.GONE);
                    ConfirmReservationFragment confirmReservationFragment = new ConfirmReservationFragment();
                    return  confirmReservationFragment; //예매 확인하기 프래그먼트

                case 1:
                    special_reservation_layout.setVisibility(View.VISIBLE);
                    MakeReservationFragment makeReservationFragment = new MakeReservationFragment();
                    return makeReservationFragment; //예매 하기 프래그먼트

                default:
                    return null;
            }

    }

        @Override
        public int getCount() {
            return tabCount;
        }
    }
}
