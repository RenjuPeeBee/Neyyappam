package com.example.renju.a108;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;

/**
 * Created by renju on 25/11/16.
 */

class CustomAdapter extends BaseAdapter{

    private Context mContext;
    String[] stringId;
    int [] imageId ;
    private static LayoutInflater inflater=null;

    public CustomAdapter(Context c,String[] prgmNameList, int[] prgmImages) {
        mContext = c;
        stringId=prgmNameList;
        imageId=prgmImages;
    }
    @Override
    public int getCount() {

        return stringId.length;
    }

    @Override
    public Object getItem(int i) {

        return i;
    }

    @Override
    public long getItemId(int i) {

        return i;
    }


    public class Holder
    {
        TextView tv;
        ImageView img;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      /*  ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(500,500));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            //imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(imageId[position]); */
        View rowView;



        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      //  if (convertView == null){
            Holder holder=new Holder();


            rowView = inflater.inflate(R.layout.gridlayout, null);
            holder.tv=(TextView) rowView.findViewById(R.id.textView1);
            holder.img=(ImageView) rowView.findViewById(R.id.imageView1);

            holder.tv.setText(stringId[position]);
            holder.img.setImageResource(imageId[position]);
     /*   }
        else{
            rowView = (View) convertView;
        } */

        return rowView;
       // return imageView ;
    }
}