package com.example.renju.a108;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;


public class fragmenttwo extends Fragment {


    public fragmenttwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String [] frtwolistnames = {"Accident","Fire","Earthquake","Flood","Terror"};
        int [] frtwolistimages = {R.drawable.accident,R.drawable.fire,R.drawable.quake,R.drawable.flood,R.drawable.terror};


        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_fragmenttwo, container, false);
        GridView gview = (GridView) view.findViewById(R.id.gridv2);
        CustomAdapter custadapter = new CustomAdapter(getActivity(),frtwolistnames,frtwolistimages);
        gview.setAdapter(custadapter);
        return view;
    }

}
