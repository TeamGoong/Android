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
import android.widget.Toast;

import com.example.jinyoungkim.teamgung.R;
import com.example.jinyoungkim.teamgung.ui.gung_ticket.make_reservation.booking.BookingChangdeokActivity;
import com.example.jinyoungkim.teamgung.ui.gung_ticket.make_reservation.booking.BookingChanggyeongActivity;
import com.example.jinyoungkim.teamgung.ui.gung_ticket.make_reservation.booking.BookingDuksuActivity;
import com.example.jinyoungkim.teamgung.util.SessionCallback;
import com.kakao.auth.AuthType;
import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeResponseCallback;
import com.kakao.usermgmt.response.model.UserProfile;
import com.kakao.util.exception.KakaoException;


public class Duksu extends Fragment {
    private FrameLayout goto_reservation;

    private String userName;
    private String profileUrl;
    private SessionCallback sessionCallback;

    public Duksu() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vpitem_duksu, container, false);

        goto_reservation = (FrameLayout)view.findViewById(R.id.duksu);


        //        여기 추후에 로그인 여부에 따라 넘어가는 화면 바꿔야댐
        goto_reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(pref.getString("token","").equals(token)){
                    Toast.makeText(getActivity().getApplicationContext(),"카카오톡 자동로그인 되었습니다:)",Toast.LENGTH_SHORT).show();
                    kakaoLogin();

                } else {
                    // 토큰 저장
                    editor.putString("token",token);
                    editor.commit();
                    kakaoLogin();
                }
                Intent i = new Intent(getContext(),LoadingActivity.class);
                i.putExtra("fragment_type","duksu");
                startActivity(i);

            }
        });

        return view;
    }
    private void kakaoLogin(){
        sessionCallback = new SessionCallback();
        Session.getCurrentSession().addCallback(sessionCallback);
        Session.getCurrentSession().checkAndImplicitOpen();
        Session.getCurrentSession().open(AuthType.KAKAO_LOGIN_ALL,getActivity());
        Log.e("kakaoLogin()","in");


    }

    private class SessionCallback implements ISessionCallback {
        @Override
        public void onSessionOpened() {
            Log.e("TAG" , "세션 오픈됨");
            // 사용자 정보를 가져옴, 회원가입 미가입시 자동가입 시킴
            KakaorequestMe();
        }

        @Override
        public void onSessionOpenFailed(KakaoException exception) {
            if(exception != null) {
                Log.e("TAG" , exception.getMessage());
            }
        }
    }
    /**
     * 사용자의 상태를 알아 보기 위해 me API 호출을 한다.
     */
    protected void KakaorequestMe() {
        UserManagement.requestMe(new MeResponseCallback() {

            @Override
            public void onFailure(ErrorResult errorResult) {
                int ErrorCode = errorResult.getErrorCode();
                int ClientErrorCode = -777;

                if (ErrorCode == ClientErrorCode) {
                    Toast.makeText(getContext(), "카카오톡 서버의 네트워크가 불안정합니다. 잠시 후 다시 시도해주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    Log.d("TAG" , "오류로 카카오로그인 실패 ");
                }
            }

            @Override
            public void onSessionClosed(ErrorResult errorResult) {
                Log.e("TAG" , "오류로 카카오로그인 실패 ");
            }

            @Override
            public void onSuccess(UserProfile userProfile) {


                profileUrl = userProfile.getProfileImagePath();
                userName = userProfile.getNickname();
                token = Session.getCurrentSession().getAccessToken();

                Log.e("유저 이름 ) ",userName);
                Log.e("토큰 ) ",token);
                Toast.makeText(getContext(),"카카오 로그인이 되었습니다 :)",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity().getApplicationContext(), BookingDuksuActivity.class));

            }

            @Override
            public void onNotSignedUp() {
                // 자동가입이 아닐경우 동의창
                Log.e("here","here");

            }
        });
    }

}
