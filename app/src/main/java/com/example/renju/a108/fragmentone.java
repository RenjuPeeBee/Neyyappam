package com.example.renju.a108;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.renju.a108.R;

public class fragmentone extends Fragment {


    public fragmentone() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String [] fronelistnames = {"Heart Pain","Breathing Problem","Poison Intake","Fainting","Chest Pain",
                                    "Head Injury","Neck Injury","Stomach Injury","Hand Injury","Leg Injury",
                                     "Back Injury"};
        int [] fronelistimages = {R.drawable.heart,R.drawable.lung,R.drawable.poison,R.drawable.fainted,R.drawable.chest,
                                  R.drawable.head,R.drawable.neck,R.drawable.stomach,R.drawable.hand,R.drawable.leg,
                                  R.drawable.back};
        View view = inflater.inflate(R.layout.fragment_fragmentone,container,false);

        GridView gview = (GridView) view.findViewById(R.id.gridv1);
        CustomAdapter custadapter = new CustomAdapter(getActivity(),fronelistnames,fronelistimages);
        gview.setAdapter(custadapter);

        ((MainActivity)getActivity()).sendSMSMessage();
        return view;
    }

}
