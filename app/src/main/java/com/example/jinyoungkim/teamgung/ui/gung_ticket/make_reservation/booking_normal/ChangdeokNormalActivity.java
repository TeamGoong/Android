package com.example.jinyoungkim.teamgung.ui.gung_ticket.make_reservation.booking_normal;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jinyoungkim.teamgung.R;
import com.example.jinyoungkim.teamgung.ui.gung_tour.TourMainActivity;

import org.w3c.dom.Text;

// 창덕궁 일반권 예매 페이지

public class ChangdeokNormalActivity extends AppCompatActivity {
    LinearLayout yesselect_palace_changdeok, yesselect_garden_changdeok; // 궁궐전각/왕실후원 탭 (선택)
    ImageView noselect_palace_changdeok, noselect_garden_changdeok; // 궁궐전각/왕실후원 탭 (미선택)
    CalendarView calendar_changdeok; // 캘린더
    int r_year, r_month, r_day; // 예약 날짜
    RelativeLayout payment_changdeok_normal; // 결제하기 버튼

//   궁궐전각 티켓 +,- 버튼 , 숫자
    ImageView adult_minus_changdeok_palace,  adult_plus_changdeok_palace; //궁궐 전각 대인(3000원)
    ImageView jongro_minus_changdeok_palace, jongro_plus_changdeok_palace; // 종로구민 50% 할인
    TextView adult_number_changdeok_palace, jongro_number_changdeok_palace;
    int adult_number_changdeok_palace_i,jongro_number_changdeok_palace_i;


//   왕실 정원 (후원) +,- 버튼, 숫자
    ImageView student1_minus_changdeok_garden, student1_plus_changdeok_garden; // 청소년 (2500원)
    ImageView jongro1_minus_changdeok_garden, jongro1_plus_changdeok_garden; //종로구민 50%할인
    TextView student1_number_changdeok_garden, jongro1_number_changdeok_garden;
    int student1_number_changdeok_garden_i, jongro1_number_changdeok_garden_i;


    ImageView student2_minus_changdeok_garden, student2_plus_changdeok_garden; // 청년 (5000원)
    ImageView jongro2_minus_changdeok_garden, jongro2_plus_changdeok_garden; //종로구민 50%할인
    TextView student2_number_changdeok_garden, jongro2_number_changdeok_garden;
    int student2_number_changdeok_garden_i,jongro2_number_changdeok_garden_i;

    ImageView adult_minus_changdeok_garden, adult_plus_changdeok_garden; // 성인 (8000원)
    ImageView jongro3_minus_changdeok_garden, jongro3_plus_changdeok_garden; //종로구민 50%할인
    TextView adult_number_changdeok_garden, jongro3_number_changdeok_garden;
    int adult_number_changdeok_garden_i, jongro3_number_changdeok_garden_i;

    ImageView old_minus_changdeok_garden, old_plus_changdeok_garden; // 경로 (5000원)
    ImageView jongro4_minus_changdeok_garden, jongro4_plus_changdeok_garden; //종로구민 50%할인
    TextView old_number_changdeok_garden, jongro4_number_changdeok_garden;
    int old_number_changdeok_garden_i, jongro4_number_changdeok_garden_i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTheme(R.style.changdeok);

        setContentView(R.layout.activity_changdeok_normal);

        //        상태바 색상변경
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(0xffF9C210);
        }

        // 초기화


        // 1. 하단 메뉴 설정
        yesselect_garden_changdeok = (LinearLayout)findViewById(R.id.yesselect_garden_changdeok);
        yesselect_palace_changdeok = (LinearLayout)findViewById(R.id.yesselect_palace_changdeok);

        noselect_garden_changdeok = (ImageView)findViewById(R.id.noselect_garden_changdeok);
        noselect_palace_changdeok = (ImageView)findViewById(R.id.noselect_palace_changdeok);

        // 2. 캘린더
        calendar_changdeok = (CalendarView)findViewById(R.id.calendar_changdeok);

        // 3.  궁궐전각 티켓 +,- 버튼 , 숫자
        adult_minus_changdeok_palace = (ImageView)findViewById(R.id.adult_minus_changdeok_palace);
        adult_plus_changdeok_palace = (ImageView)findViewById(R.id.adult_plus_changdeok_palace);
        jongro_minus_changdeok_palace = (ImageView)findViewById(R.id.jongro_minus_changdeok_palace);
        jongro_plus_changdeok_palace = (ImageView)findViewById(R.id.jongro_plus_changdeok_palace);

        adult_number_changdeok_palace = (TextView)findViewById(R.id.adult_number_changdeok_palace); adult_number_changdeok_palace.setText("0");
        adult_number_changdeok_palace_i = Integer.parseInt(adult_number_changdeok_palace.getText().toString());
        jongro_number_changdeok_palace = (TextView)findViewById(R.id.jongro_number_changdeok_palace); jongro_number_changdeok_palace.setText("0");
        jongro_number_changdeok_palace_i = Integer.parseInt(jongro_number_changdeok_palace.getText().toString());

        // 4. 왕실 정원 (후원) +,- 버튼, 숫자
        student1_minus_changdeok_garden = (ImageView)findViewById(R.id.student1_minus_changdeok_garden);
        student1_plus_changdeok_garden = (ImageView)findViewById(R.id.student1_plus_changdeok_garden);
        jongro1_minus_changdeok_garden = (ImageView)findViewById(R.id.jongro1_minus_changdeok_garden);
        jongro1_plus_changdeok_garden = (ImageView)findViewById(R.id.jongro1_plus_changdeok_garden);

        student1_number_changdeok_garden = (TextView)findViewById(R.id.student1_number_changdeok_garden); student1_number_changdeok_garden.setText("0");
        student1_number_changdeok_garden_i = Integer.parseInt(student1_number_changdeok_garden.getText().toString());
        jongro1_number_changdeok_garden = (TextView)findViewById(R.id.jongro1_number_changdeok_garden); jongro1_number_changdeok_garden.setText("0");
        jongro1_number_changdeok_garden_i = Integer.parseInt(jongro1_number_changdeok_garden.getText().toString());


        student2_minus_changdeok_garden = (ImageView)findViewById(R.id.student2_minus_changdeok_garden);
        student2_plus_changdeok_garden = (ImageView)findViewById(R.id.student2_plus_changdeok_garden);
        jongro2_minus_changdeok_garden = (ImageView)findViewById(R.id.jongro2_minus_changdeok_garden);
        jongro2_plus_changdeok_garden = (ImageView)findViewById(R.id.jongro2_plus_changdeok_garden);

        student2_number_changdeok_garden = (TextView)findViewById(R.id.student2_number_changdeok_garden); student2_number_changdeok_garden.setText("0");
        student2_number_changdeok_garden_i=Integer.parseInt(student2_number_changdeok_garden.getText().toString());
        jongro2_number_changdeok_garden = (TextView)findViewById(R.id.jongro2_number_changdeok_garden); jongro2_number_changdeok_garden.setText("0");
        jongro2_number_changdeok_garden_i = Integer.parseInt(jongro2_number_changdeok_garden.getText().toString());


        adult_minus_changdeok_garden = (ImageView)findViewById(R.id.adult_minus_changdeok_garden);
        adult_plus_changdeok_garden = (ImageView)findViewById(R.id.adult_plus_changdeok_garden);
        jongro3_minus_changdeok_garden = (ImageView)findViewById(R.id.jongro3_minus_changdeok_garden);
        jongro3_plus_changdeok_garden = (ImageView)findViewById(R.id.jongro3_plus_changdeok_garden);

        adult_number_changdeok_garden = (TextView)findViewById(R.id.adult_number_changdeok_garden); adult_number_changdeok_garden.setText("0");
        adult_number_changdeok_garden_i = Integer.parseInt(adult_number_changdeok_garden.getText().toString());
        jongro3_number_changdeok_garden = (TextView)findViewById(R.id.jongro3_number_changdeok_garden); jongro3_number_changdeok_garden.setText("0");
        jongro3_number_changdeok_garden_i = Integer.parseInt(jongro3_number_changdeok_garden.getText().toString());


        old_minus_changdeok_garden = (ImageView)findViewById(R.id.old_minus_changdeok_garden);
        old_plus_changdeok_garden = (ImageView)findViewById(R.id.old_plus_changdeok_garden);
        jongro4_minus_changdeok_garden = (ImageView)findViewById(R.id.jongro4_minus_changdeok_garden);
        jongro4_plus_changdeok_garden = (ImageView)findViewById(R.id.jongro4_plus_changdeok_garden);

        old_number_changdeok_garden = (TextView)findViewById(R.id.old_number_changdeok_garden); old_number_changdeok_garden.setText("0");
        old_number_changdeok_garden_i = Integer.parseInt(old_number_changdeok_garden.getText().toString());
        jongro4_number_changdeok_garden = (TextView)findViewById(R.id.jongro4_number_changdeok_garden); jongro4_number_changdeok_garden.setText("0");
        jongro4_number_changdeok_garden_i = Integer.parseInt(jongro4_number_changdeok_garden.getText().toString());


        // 5. 결제하기 버튼
        payment_changdeok_normal = (RelativeLayout)findViewById(R.id.payment_changdeok_normal);

        // 1. 하단 메뉴 설정
        yesselect_palace_changdeok.bringToFront();

        noselect_garden_changdeok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yesselect_garden_changdeok.bringToFront();

                yesselect_garden_changdeok.setVisibility(View.VISIBLE);
                yesselect_palace_changdeok.setVisibility(View.GONE);
                noselect_palace_changdeok.setVisibility(View.VISIBLE);
            }
        });

        noselect_palace_changdeok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yesselect_palace_changdeok.bringToFront();

                yesselect_palace_changdeok.setVisibility(View.VISIBLE);
                yesselect_garden_changdeok.setVisibility(View.GONE);
                noselect_garden_changdeok.setVisibility(View.VISIBLE);
            }
        });

        // 2. 캘린더
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            calendar_changdeok.setFocusedMonthDateColor(getResources().getColor(R.color.changduk));
        }

        // +,- 버튼 동작

        // 1-1. 궁궐전각) 대인 (3000원)
        adult_minus_changdeok_palace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(adult_number_changdeok_palace_i>0){
                    adult_number_changdeok_palace_i --;
                    adult_number_changdeok_palace.setText(String.valueOf(adult_number_changdeok_palace_i));
                }
            }
        });

       adult_plus_changdeok_palace.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               adult_number_changdeok_palace_i ++;
               adult_number_changdeok_palace.setText(String.valueOf(adult_number_changdeok_palace_i));
           }
       });


        // 1-2. 궁궐전각) 종로구민 50% 할인
        jongro_minus_changdeok_palace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(jongro_number_changdeok_palace_i>0){
                    jongro_number_changdeok_palace_i --;
                    jongro_number_changdeok_palace.setText(String.valueOf(jongro_number_changdeok_palace_i));
                }
            }
        });
        jongro_plus_changdeok_palace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    jongro_number_changdeok_palace_i ++;
                    jongro_number_changdeok_palace.setText(String.valueOf(jongro_number_changdeok_palace_i));
            }
        });


        // 2-1. 왕실정원) 청소년 (2500원)
        student1_minus_changdeok_garden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(student1_number_changdeok_garden_i>0){
                    student1_number_changdeok_garden_i --;
                    student1_number_changdeok_garden.setText(String.valueOf(student1_number_changdeok_garden_i));
                }
            }
        });

        student1_plus_changdeok_garden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    student1_number_changdeok_garden_i ++;
                    student1_number_changdeok_garden.setText(String.valueOf(student1_number_changdeok_garden_i));
                }
        });


        // 2-2. 왕실정원) 종로구민 50% 할인
        jongro1_minus_changdeok_garden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(jongro1_number_changdeok_garden_i>0){
                    jongro1_number_changdeok_garden_i --;
                    jongro1_number_changdeok_garden.setText(String.valueOf(jongro1_number_changdeok_garden_i));
                }
            }
        });

        jongro1_plus_changdeok_garden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    jongro1_number_changdeok_garden_i ++;
                    jongro1_number_changdeok_garden.setText(String.valueOf(jongro1_number_changdeok_garden_i));
            }
        });


        // 2-3. 왕실정원) 청년 (5000원)
        student2_minus_changdeok_garden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(student2_number_changdeok_garden_i>0){
                    student2_number_changdeok_garden_i --;
                    student2_number_changdeok_garden.setText(String.valueOf(student2_number_changdeok_garden_i));
                }
            }
        });
        student2_plus_changdeok_garden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    student2_number_changdeok_garden_i ++;
                    student2_number_changdeok_garden.setText(String.valueOf(student2_number_changdeok_garden_i));
            }
        });


        // 2-4. 왕실정원) 종로구민 50% 할인
        jongro2_minus_changdeok_garden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(jongro2_number_changdeok_garden_i>0){
                    jongro2_number_changdeok_garden_i --;
                    jongro2_number_changdeok_garden.setText(String.valueOf(jongro2_number_changdeok_garden_i));
                }
            }
        });
        jongro2_plus_changdeok_garden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    jongro2_number_changdeok_garden_i ++;
                    jongro2_number_changdeok_garden.setText(String.valueOf(jongro2_number_changdeok_garden_i));
            }
        });


        // 2-5. 왕실정원) 성인 (8000원)
        adult_minus_changdeok_garden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(adult_number_changdeok_garden_i>0){
                    adult_number_changdeok_garden_i --;
                    adult_number_changdeok_garden.setText(String.valueOf(adult_number_changdeok_garden_i));
                }
            }
        });
        adult_plus_changdeok_garden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adult_number_changdeok_garden_i ++;
                adult_number_changdeok_garden.setText(String.valueOf(adult_number_changdeok_garden_i));
            }
        });


        // 2-6. 왕실정원) 종로구민 50% 할인
        jongro3_minus_changdeok_garden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(jongro3_number_changdeok_garden_i>0){
                    jongro3_number_changdeok_garden_i --;
                    jongro3_number_changdeok_garden.setText(String.valueOf(jongro3_number_changdeok_garden_i));
                }
            }
        });
        jongro3_plus_changdeok_garden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jongro3_number_changdeok_garden_i ++;
                jongro3_number_changdeok_garden.setText(String.valueOf(jongro3_number_changdeok_garden_i));
            }
        });


        // 2-7. 왕실정원) 경로 (5000원)
        old_minus_changdeok_garden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(old_number_changdeok_garden_i>0){
                    old_number_changdeok_garden_i --;
                    old_number_changdeok_garden.setText(String.valueOf(old_number_changdeok_garden_i));
                }
            }
        });
        old_plus_changdeok_garden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                old_number_changdeok_garden_i ++;
                old_number_changdeok_garden.setText(String.valueOf(old_number_changdeok_garden_i));
            }
        });


        // 2-8. 왕실정원) 종로구민 50% 할인
        jongro4_minus_changdeok_garden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(jongro4_number_changdeok_garden_i>0){
                    jongro4_number_changdeok_garden_i --;
                    jongro4_number_changdeok_garden.setText(String.valueOf(jongro4_number_changdeok_garden_i));
                }
            }
        });
        jongro4_plus_changdeok_garden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jongro4_number_changdeok_garden_i ++;
                jongro4_number_changdeok_garden.setText(String.valueOf(jongro4_number_changdeok_garden_i));
            }
        });



        /**************************** 예매 데이터 ****************************/

        Log.e("날짜 데이터", String.valueOf(calendar_changdeok.getDate()));
        calendar_changdeok.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Log.e("날짜", String.valueOf(year)+"년 "+String.valueOf(month)+"월 "+String.valueOf(dayOfMonth)+"일");
                r_year = year;
                r_month = month;
                r_day = dayOfMonth;
            }
        });

        // 결제하기 버튼 클릭
        payment_changdeok_normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("궁궐전각) 대인", String.valueOf(adult_number_changdeok_palace_i));
                Log.e("궁궐전각) 종로구민 50% 할인", String.valueOf(jongro_number_changdeok_palace_i));
                Log.e("왕실정원) 청소년(2500원)",String.valueOf(student1_number_changdeok_garden_i));
                Log.e("왕실정원) 종로구민 50% 할인", String.valueOf(jongro1_number_changdeok_garden_i));
                Log.e("왕실정원) 청년 (5000원)", String.valueOf(student2_number_changdeok_garden_i));
                Log.e("왕실정원) 종로구민 50% 할인", String.valueOf(jongro2_number_changdeok_garden_i));
                Log.e("왕실정원) 성인 (8000원)", String.valueOf(adult_number_changdeok_garden_i));
                Log.e("왕실정원) 종로구민 50% 할인", String.valueOf(jongro3_number_changdeok_garden_i));
                Log.e("왕실정원) 경로 (5000원)", String.valueOf(old_number_changdeok_garden_i));
                Log.e("왕실정원) 종로구민 50% 할인", String.valueOf(jongro4_number_changdeok_garden_i));
                Log.e("예매날짜)", String.valueOf(r_year+"년 "+r_month+"월 "+r_day+"일"));
            }
        });



    }
}
