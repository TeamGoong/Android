package com.example.jinyoungkim.teamgung.ui.gung_ticket;

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
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.example.jinyoungkim.teamgung.R;
import com.example.jinyoungkim.teamgung.ui.gung_ticket.confirm_reservation.ConfirmReservationFragment;
import com.example.jinyoungkim.teamgung.ui.gung_ticket.make_reservation.MakeReservationFragment;
import com.example.jinyoungkim.teamgung.ui.gung_tour.TourMainActivity;

// 예매하기, 예매 확인 메인 액티비티

public class TicketMainActivity extends AppCompatActivity implements View.OnClickListener{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Switch switch_ticket;
    private LinearLayout special_reservation_layout;
    private ImageView menu1, menu2, menu3, menu4, menu5, menu6, menu7, menu8, menu9;

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

        //특별관람 메뉴
        menu1=(ImageView)findViewById(R.id.menu1);
        menu2=(ImageView)findViewById(R.id.menu2);
        menu3=(ImageView)findViewById(R.id.menu3);
        menu4=(ImageView)findViewById(R.id.menu4);
        menu5=(ImageView)findViewById(R.id.menu5);
        menu6=(ImageView)findViewById(R.id.menu6);
        menu7=(ImageView)findViewById(R.id.menu7);
        menu8=(ImageView)findViewById(R.id.menu8);
        menu9=(ImageView)findViewById(R.id.menu9);



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

        /************* 특별관람 예매 *************/
        menu2.setOnClickListener(this);
        menu3.setOnClickListener(this);
        menu4.setOnClickListener(this);
        menu5.setOnClickListener(this);
        menu6.setOnClickListener(this);
        menu7.setOnClickListener(this);
        menu8.setOnClickListener(this);

        // 경복궁 특별관람

        menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SpecialLookingActivity.class));
            }
        });


    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(), "서비스 준비중입니다 :)", Toast.LENGTH_SHORT).show();
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
