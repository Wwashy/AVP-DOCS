package ke.co.lefins.nightplus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URLEncoder;

public class SmsReceiver extends BroadcastReceiver {

    // private SmsManager smsMgr;

    @Override
    public void onReceive(Context context, Intent intent) {
        SmsMessage[] messages =
                Telephony.Sms.Intents.getMessagesFromIntent(intent);
        if (messages != null && messages.length > 0){
            //if (this.smsMgr == null){
                //this.smsMgr = SmsManager.getDefault();
            //}

            // There are incoming messages.
            for (SmsMessage msg : messages) {
                // Send the messages to the server for action.
                this.sendSms(msg.getOriginatingAddress(), msg.getDisplayMessageBody());
            }
        }
    }

    private void sendSms(final String from, final String msg){
        try {
            String xms = msg == null || msg.trim().equalsIgnoreCase("") ?
                    "null" :
                    msg;
            String url = "room/processsms/" +
                    URLEncoder.encode(from, "UTF-8") +
                    "/" +
                    URLEncoder.encode(xms, "UTF-8");
            HttpHelper httpStatus = new HttpHelper(url, null);
            httpStatus.processVals(new IExecute() {
                @Override
                public void run(String val) {
                    //SmsManager smsMgr = SmsManager.getDefault();
                    // smsMgr.sendTextMessage(from, null, msg, null, null);
                    //smsMgr.sendTextMessage(from, null, val, null, null);
                }
            });
        }catch (Exception e){
            Log.e("SmsReceiver",  e.getMessage(), e);
        }
    }
}
