package com.example.jinyoungkim.teamgung.ui.gung_ticket.make_reservation.viewpager_items;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.jinyoungkim.teamgung.R;
import com.example.jinyoungkim.teamgung.ui.gung_ticket.make_reservation.booking.BookingChangdeokActivity;
import com.example.jinyoungkim.teamgung.ui.gung_ticket.make_reservation.booking.BookingChanggyeongActivity;
import com.example.jinyoungkim.teamgung.util.SessionCallback;
import com.kakao.auth.AuthType;
import com.kakao.auth.Session;

public class Changgyong extends Fragment {

    private FrameLayout goto_reservation;
    private String token;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    public Changgyong() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        {
        super.onCreate(savedInstanceState);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.vpitem_changgyong, container, false);

        goto_reservation = (FrameLayout)v.findViewById(R.id.changgyeong);
        pref = PreferenceManager.getDefaultSharedPreferences(getContext()); // sharedPreference 선언
        editor = pref.edit(); // sharePreference Editor 선언


        //        여기 추후에 로그인 여부에 따라 넘어가는 화면 바꿔야댐
        goto_reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e("버튼클릭","click");
                Session session = Session.getCurrentSession();
                session.addCallback(new SessionCallback());
                session.open(AuthType.KAKAO_LOGIN_ALL,Changgyong.this);

                if (Session.getCurrentSession().getTokenInfo() != null) {

                    Log.e("세선 진입","session");
                    token = Session.getCurrentSession().getAccessToken();
                    // 토큰 저장
                    Log.e("token",token);
                    editor.putString("token",token);
                    editor.commit();

                    startActivity(new Intent(getActivity().getApplicationContext(), BookingChanggyeongActivity.class));
                } else
                {
                    Log.e("else","else");
                }

            }
        });


        return v;
    }

    }


