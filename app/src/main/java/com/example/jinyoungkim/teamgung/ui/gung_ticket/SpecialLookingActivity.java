package com.example.jinyoungkim.teamgung.ui.gung_ticket;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jinyoungkim.teamgung.R;

public class SpecialLookingActivity extends AppCompatActivity {

    CalendarView calendarView;
    ImageView btn_normalperson,btn_hanbok,btn_old;
    ImageView adult_minus_special,adult_plus_special;
    TextView adult_number_special;
    ImageView btn_time1,btn_time2,btn_time3;
    RelativeLayout payment_special;
    int adult_number_special_i;
    int r_year, r_month, r_day;

    //  통신에 넘길 데이터
    int palace_id; // 궁 아이디(0 : 경복궁, 1 : 창덕궁, 2 : 창경궁, 3 : 덕수궁, 4 : 종묘 )
    String ticket_title; // 티켓 이름
    String ticket_start; // 티켓 시작 날짜
    String ticket_end; // 티켓 끝나는 날짜
    String ticket_people; // 사람 정보
    int ticket_special; // 특별권 여부
    int ticket_jongro; // 중구인 구분

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.special);
        setContentView(R.layout.activity_special_looking);

        //        상태바 색상변경
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(0xffEF5E5E);
        }

        // 초기화
        calendarView = (CalendarView)findViewById(R.id.calendar_special);
        btn_normalperson = (ImageView)findViewById(R.id.btn_normalperson);
        btn_hanbok = (ImageView)findViewById(R.id.btn_hanbok);
        btn_old = (ImageView)findViewById(R.id.btn_old);
        adult_minus_special = (ImageView)findViewById(R.id.adult_minus_special);
        adult_plus_special = (ImageView)findViewById(R.id.adult_plus_special);
        adult_number_special = (TextView)findViewById(R.id.adult_number_special);

        btn_time1 = (ImageView)findViewById(R.id.btn_time1);
        btn_time2 = (ImageView)findViewById(R.id.btn_time2);
        btn_time3 = (ImageView)findViewById(R.id.btn_time3);

        payment_special = (RelativeLayout)findViewById(R.id.payment_special);

        // 1. 가감 버튼
        adult_minus_special.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(adult_number_special_i>0){
                    adult_number_special_i --;
                    adult_number_special.setText(String.valueOf(adult_number_special_i));
                }
            }
        });

        adult_plus_special.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adult_number_special_i ++;
                adult_number_special.setText(String.valueOf(adult_number_special_i));
            }
        });

        // 2. 달력 리스너
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                r_year = year;
                r_month = month+1;
                r_day = dayOfMonth;
                Log.e("date",String.valueOf(r_year));
                ticket_start=r_year+"."+r_month+"."+r_day;
                ticket_end=r_year+"."+r_month+"."+r_day;
            }
        });

        // 3. 버튼 색깔 변경
        btn_normalperson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_normalperson.setImageResource(R.drawable.booking_special_normal_button_yes);
                btn_hanbok.setImageResource(R.drawable.booking_special_hanbok_button_no);
                btn_old.setImageResource(R.drawable.booking_special_old_button_no);
            }
        });

        btn_hanbok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_normalperson.setImageResource(R.drawable.booking_special_normal_button_no);
                btn_hanbok.setImageResource(R.drawable.booking_special_hanbok_button_yes);
                btn_old.setImageResource(R.drawable.booking_special_old_button_no);
            }
        });

        btn_old.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_normalperson.setImageResource(R.drawable.booking_special_normal_button_no);
                btn_hanbok.setImageResource(R.drawable.booking_special_hanbok_button_no);
                btn_old.setImageResource(R.drawable.booking_special_old_button_yes);
            }
        });

        btn_time1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_time1.setImageResource(R.drawable.booking_special_time_button_yes);
                btn_time2.setImageResource(R.drawable.booking_special_time_button_no);
                btn_time3.setImageResource(R.drawable.booking_special_time_button_no);
            }
        });

        btn_time2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_time1.setImageResource(R.drawable.booking_special_time_button_no);
                btn_time2.setImageResource(R.drawable.booking_special_time_button_yes);
                btn_time3.setImageResource(R.drawable.booking_special_time_button_no);
            }
        });

        btn_time3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_time1.setImageResource(R.drawable.booking_special_time_button_no);
                btn_time2.setImageResource(R.drawable.booking_special_time_button_no);
                btn_time3.setImageResource(R.drawable.booking_special_time_button_yes);
            }
        });


        // 4. 결제하기 버튼
        payment_special.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                palace_id=0; // 현재 특별관람은 경복궁 밖에 없음
                ticket_jongro=0;
                ticket_special=0;
                ticket_title="경복궁 특별관람권";
                Log.e("궁 아이디", String.valueOf(palace_id));
                Log.e("티켓 종류) ",ticket_title);
                Log.e("티켓 시작날짜) ",ticket_start);
                Log.e("티켓 끝나날짜) ", ticket_end);
                ticket_people = "대인 " + String.valueOf(adult_number_special_i);
                Log.e("사람정보) ", ticket_people);
                ticket_special=1;
                Log.e("특별권 구분) ", String.valueOf(ticket_special));
                Log.e("종로 구분) ",String.valueOf(ticket_jongro));

            }
        });

    }
}
