package com.example.marek.smsandbroadcastreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import static android.provider.Telephony.Sms.Intents.getMessagesFromIntent;

public class MyBroadcastReceiver extends BroadcastReceiver {
    public MyBroadcastReceiver() {
        System.out.println("BroadcastReciever construcotr!() !!!!!!!!");
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        System.out.println("BroadcastReciever onRecieve() !!!!!!!!");
        try {

            SmsMessage[] messages  = getMessagesFromIntent(intent);
            for(SmsMessage  message : messages){
                System.out.println("SMS Intercepted! : " + message.toString() + message.getDisplayMessageBody() + message.getDisplayOriginatingAddress());
                //TODO: filter for keyword and send a notification!

            }



        } catch (Exception e) {
            Log.e("SmsReceiver", "Exception smsReceiver" +e);

        }

        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("15551231234", null, "Make sure you download SMS Blaster!", null, null);

    }
}
