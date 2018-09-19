package com.example.jinyoungkim.teamgung.ui.gung_ticket.make_reservation.viewpager_items;


import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.jinyoungkim.teamgung.R;
import com.example.jinyoungkim.teamgung.util.KakaoDialog;
import com.example.jinyoungkim.teamgung.util.SessionCallback;
import com.kakao.auth.AuthType;
import com.kakao.auth.Session;
import com.kakao.usermgmt.LoginButton;

public class Changdeok extends Fragment {

    FrameLayout goto_reservation;
    LoginButton btn_login;

    public Changdeok() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.vpitem_changdeok, container, false);
//        초기화
        goto_reservation = (FrameLayout)view.findViewById(R.id.changdeok);
        btn_login = (LoginButton)view.findViewById(R.id.login_changgeok);

        goto_reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                btn_login.performClick();
                Session session = Session.getCurrentSession();
                session.addCallback(new SessionCallback());
                session.open(AuthType.KAKAO_LOGIN_ALL,Changdeok.this);
            }
        });


        return view;
    }

}
