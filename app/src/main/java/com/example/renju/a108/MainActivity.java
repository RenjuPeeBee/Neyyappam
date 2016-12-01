package com.example.renju.a108;

import android.Manifest;
import android.app.FragmentTransaction;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


  //  public ViewPager viewp = null;

    victim vic = new victim();
    instruction inst = new instruction();
    heart hrt = new heart();
    breathe brt = new breathe();
    poison poi = new poison();
    faint fnt = new faint();
    chest chs = new chest();
    head hed = new head();
    neck nek = new neck();
    stomach stm = new stomach();
    hand hnd = new hand();
    leg leg = new leg();
    back bck = new back();
    fragmentone frone = new fragmentone();
    fragmenttwo frtwo = new fragmenttwo();
    fragmentthree frthree = new fragmentthree();

    Fragment [] fragId = {vic,inst,hrt,brt,poi,fnt,chs,hed,nek,stm,hnd,leg,bck,frone,frtwo,frthree};
    public static int playfrag = 0;

    public static MediaPlayer mp = new MediaPlayer();
    int [] audioId = {R.raw.victim,R.raw.instruction,R.raw.heart,R.raw.breathe,R.raw.poison,R.raw.faint,
                      R.raw.chest,R.raw.head,R.raw.neck,R.raw.stomach,R.raw.hand,R.raw.leg,R.raw.back};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zero);



        FragmentManager fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();


        ft.replace(R.id.placeholder,fragId[0]);
        ft.commit();
        play(0);





        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            Log.d("PLAYGROUND", "Permission is not granted, requesting");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 123);
            //button.setEnabled(false);
        } else {
            Log.d("PLAYGROUND", "Permission is granted");
        }

    }

    protected void sendSMSMessage() {
        Log.i("Send SMS", "");
        String phoneNo = "9447936451";//txtphoneNo.getText().toString();
        String message = "Great work";//txtMessage.getText().toString();
        try {

            SmsManager smsManager = SmsManager.getDefault();
            ArrayList<String> msgArray = smsManager.divideMessage(message);

          //  smsManager.sendMultipartTextMessage(phoneNo, null,msgArray, null, null);
            Toast.makeText(getApplicationContext(), "Message Sent",Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), ex.getMessage().toString(), Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 123) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.d("PLAYGROUND", "Permission has been granted");
                //textView.setText("You can send SMS!");
                //button.setEnabled(true);
            } else {
                Log.d("PLAYGROUND", "Permission has been denied or request cancelled");
                //textView.setText("You can not send SMS!");
                //button.setEnabled(false);
            }
        }
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int action = event.getAction();
        int keyCode = event.getKeyCode();
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                if (action == KeyEvent.ACTION_DOWN) {
                   // Toast.makeText(getApplicationContext(), "Volume Up pressed",Toast.LENGTH_LONG).show();
                    fragmentchange(1);
                }
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if (action == KeyEvent.ACTION_DOWN) {
                   // Toast.makeText(getApplicationContext(), "Volume Down pressed",Toast.LENGTH_LONG).show();
                    fragmentchange(0);
                }
                return true;
            default:
                return super.dispatchKeyEvent(event);
        }
    }

    public void replay(View v){
        int i = Integer.parseInt(v.getTag().toString());
        play(i);
    }

    public void play(int i){

        if (mp.isPlaying()){
            mp.stop();
        }

        mp = MediaPlayer.create(getApplicationContext(),audioId[i]);

        mp.start();

    }

    public void fragmentchange(int ans){
       // String [] fname = getSupportFragmentManager().findFragmentById(R.id.placeholder).toString().split(" ");
        //fname[3] = fname[3].replace("}","");
        FragmentManager fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
        if (playfrag == 0 && ans == 0){
           // Intent myIntent = new Intent(MainActivity.this, activity2.class);
            //MainActivity.this.startActivity(myIntent);
            if (mp.isPlaying()){
                mp.stop();
            }
            ft.replace(R.id.placeholder,fragId[13]);
            ft.commit();
            playfrag = 13;
        }
        else if (playfrag == 13){
            if (mp.isPlaying()){
                mp.stop();
            }
            ft.replace(R.id.placeholder,fragId[14]);
            ft.commit();
            playfrag = 14;
        }
        else if (playfrag == 0 && ans==1){
            ft.replace(R.id.placeholder,fragId[1]);
            ft.commit();
            playfrag = 1;
            play(1);
        }
        else if (playfrag == 1 ){
            ft.replace(R.id.placeholder,fragId[2]);
            ft.commit();
            playfrag = 2;
            play(2);
        }
        else if (playfrag == 2 ){
            ft.replace(R.id.placeholder,fragId[3]);
            ft.commit();
            playfrag = 3;
            play(3);
        }
        else if (playfrag == 3 ){
            ft.replace(R.id.placeholder,fragId[4]);
            ft.commit();
            playfrag = 4;
            play(4);
        }
        else if (playfrag == 4 ){
            ft.replace(R.id.placeholder,fragId[5]);
            ft.commit();
            playfrag = 5;
            play(5);
        }
        else if (playfrag == 5 ){
            ft.replace(R.id.placeholder,fragId[6]);
            ft.commit();
            playfrag = 6;
            play(6);
        }
        else if (playfrag == 6 ){
            ft.replace(R.id.placeholder,fragId[7]);
            ft.commit();
            playfrag = 7;
            play(7);
        }
        else if (playfrag == 7 ){
            ft.replace(R.id.placeholder,fragId[8]);
            ft.commit();
            playfrag = 8;
            play(8);
        }
        else if (playfrag == 8 ){
            ft.replace(R.id.placeholder,fragId[9]);
            ft.commit();
            playfrag = 9;
            play(9);
        }
        else if (playfrag == 9 ){
            ft.replace(R.id.placeholder,fragId[10]);
            ft.commit();
            playfrag = 10;
            play(10);
        }
        else if (playfrag == 10 ){
            ft.replace(R.id.placeholder,fragId[11]);
            ft.commit();
            playfrag = 11;
            play(11);
        }
        else if (playfrag == 11 ){
            ft.replace(R.id.placeholder,fragId[12]);
            ft.commit();
            playfrag = 12;
            play(12);
        }

        //Toast.makeText(getApplicationContext(),fname[2],Toast.LENGTH_SHORT).show();
    }

}
