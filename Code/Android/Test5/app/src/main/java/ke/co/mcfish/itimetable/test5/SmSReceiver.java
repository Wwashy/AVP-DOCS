package ke.co.mcfish.itimetable.test5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.util.Log;

public class SmSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        SmsMessage[] messges =
                Telephony.Sms.Intents.getMessagesFromIntent(intent);
        if (messges != null && messges.length > 0){
            for(SmsMessage m : messges){
                Log.e(
                        "SmSReceiver",
                        "From: " +
                                m.getDisplayOriginatingAddress() +
                                " Msg: " +
                                m.getMessageBody());
            }
        }
    }
}
