package com.example.jinyoungkim.teamgung.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class SharePreferenceController {
    private static final String TOKEN_COMPARE = "token_compare"; // 이전 토큰값과 똑같은지 비교하기 위한 변수
    private static final String TOKEN_HEADER = "token_header"; // 서버로 부터 받은 토큰 값 (헤더에 넣어야 할)
    private static final String PROFILE = "profile"; // 사용자 프로필 이미지 url
    private static final String LOGIN = "login";


    // 1. 토큰 값 비교
    public static void setTokenCompare(Context context, String tokenCompare){
        SharedPreferences pref = context.getSharedPreferences(TOKEN_COMPARE,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(TOKEN_COMPARE,tokenCompare);
        editor.commit();
    }

    public static String getTokenCompare(Context context){
        SharedPreferences pref = context.getSharedPreferences(TOKEN_COMPARE,context.MODE_PRIVATE);
        String tokenCompare = pref.getString(TOKEN_COMPARE,"");
        return tokenCompare;
    }


    // 2. 서버로 부터 받은 토큰 값
    public static void setTokenHeader(Context context,String tokenHeader){
        SharedPreferences pref = context.getSharedPreferences(TOKEN_HEADER,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(TOKEN_HEADER,tokenHeader);
        editor.commit();
    }

    public static String getTokenHeader(Context context){
        SharedPreferences pref = context.getSharedPreferences(TOKEN_HEADER,context.MODE_PRIVATE);
        String tokenHeader = pref.getString(TOKEN_HEADER,"");
        return tokenHeader;
    }

    public static void deleteTokenHeader (Context context){
        SharedPreferences pref = context.getSharedPreferences(TOKEN_HEADER,context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.remove(TOKEN_HEADER);
        Log.e("delete","delete");
    }


    // 3. 이미지 url
    public static void setProfile(Context context, String profile){
        SharedPreferences pref = context.getSharedPreferences(PROFILE,context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(PROFILE,profile);
        editor.commit();
    }

    public static String getProfile(Context context){
        SharedPreferences pref = context.getSharedPreferences(PROFILE,context.MODE_PRIVATE);
        String profile = pref.getString(PROFILE,"");
        return  profile;
    }

    // 4. 로그인 여부
    public static void setLogin(Context context, String login){
        SharedPreferences pref = context.getSharedPreferences(LOGIN,context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(LOGIN,login);
        editor.commit();
    }

    public static String getLogin(Context context){
        SharedPreferences pref = context.getSharedPreferences(LOGIN,context.MODE_PRIVATE);
        String login = pref.getString(LOGIN,"");
        return login;
    }
}
