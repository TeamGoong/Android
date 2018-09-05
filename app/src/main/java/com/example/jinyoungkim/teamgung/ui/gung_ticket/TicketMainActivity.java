package com.example.jinyoungkim.teamgung.ui.gung_ticket;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jinyoungkim.teamgung.R;

public class TicketMainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_main);

//        뷰 초기화
        tabLayout = (TabLayout)findViewById(R.id.tab_ticket);
        viewPager = (ViewPager)findViewById(R.id.viewpager_ticket);
    }
}
