package com.example.jinyoungkim.teamgung.ui.gung_ticket.confirm_reservation;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jinyoungkim.teamgung.R;
import com.example.jinyoungkim.teamgung.ui.gung_ticket.confirm_reservation.adapter.ReservationConfirmAdapter;
import com.example.jinyoungkim.teamgung.ui.gung_ticket.confirm_reservation.data.TicketData;
import com.example.jinyoungkim.teamgung.ui.gung_tour.looking_palace.adapter.ShowingReviewsAdapter;
import com.example.jinyoungkim.teamgung.ui.gung_tour.looking_palace.data.PalaceData;

import java.util.ArrayList;

// 예매 확인 탭 프레그먼트

public class ConfirmReservationFragment extends Fragment {

    RecyclerView coming_rcv;
    RecyclerView finish_rcv;
    RecyclerView.LayoutManager mLayoutManager_f;
    RecyclerView.LayoutManager mLayoutManager_c;

    public ConfirmReservationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_confirm_reservation, container, false);

        //      < 예매확인 > 리사이클러뷰 부분

        mLayoutManager_f = new LinearLayoutManager(this.getContext());
        mLayoutManager_c = new LinearLayoutManager(this.getContext());


        coming_rcv = view.findViewById(R.id.rcv_coming_confirm_ticket);//다가오는 예약
        coming_rcv.setHasFixedSize(true);

        coming_rcv.setLayoutManager(mLayoutManager_c);

        finish_rcv = view.findViewById(R.id.rcv_finish_confirm_ticket);//끝난 예약
        finish_rcv.setHasFixedSize(true);
        finish_rcv.setLayoutManager(mLayoutManager_f);

        ArrayList<TicketData> ticketDataArrayList = new ArrayList<>();

        ticketDataArrayList.add(new TicketData(0,1,1));
        ticketDataArrayList.add(new TicketData(1,1,0));
        ticketDataArrayList.add(new TicketData(1,0,1));
        ticketDataArrayList.add(new TicketData(2,1,0));
        ticketDataArrayList.add(new TicketData(1,1,1));

        ArrayList<TicketData> finishTicket = new ArrayList<>();
        ArrayList<TicketData> comingTicket = new ArrayList<>();

        for(int i = 0; i<ticketDataArrayList.size();i++){
            if(ticketDataArrayList.get(i).finish_flag == 1){
                finishTicket.add(new TicketData(ticketDataArrayList.get(i).ticket_flag,ticketDataArrayList.get(i).finish_flag
                        ,ticketDataArrayList.get(i).review_flag));
            }else{
                comingTicket.add(new TicketData(ticketDataArrayList.get(i).ticket_flag,ticketDataArrayList.get(i).finish_flag
                        ,ticketDataArrayList.get(i).review_flag));
            }
        }

        ReservationConfirmAdapter reservationConfirmAdapter_finish = new ReservationConfirmAdapter(finishTicket);
        ReservationConfirmAdapter reservationConfirmAdapter_coming = new ReservationConfirmAdapter(comingTicket);

        finish_rcv.setAdapter(reservationConfirmAdapter_finish);
        coming_rcv.setAdapter(reservationConfirmAdapter_coming);

        return view;
    }

}
