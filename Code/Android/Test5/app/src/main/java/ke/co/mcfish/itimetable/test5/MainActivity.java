package ke.co.mcfish.itimetable.test5;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText phone;

    private EditText smsMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.phone = (EditText)findViewById(R.id.phoneNoET);
        this.smsMsg = (EditText) findViewById(R.id.msgET);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) !=
                PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.SEND_SMS
            }, 0);
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS) !=
                PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.RECEIVE_SMS
            }, 0);
        }
    }

    public void sendSms(View v){
        String no = this.phone.getText().toString();
        String msg = this.smsMsg.getText().toString();
        SmsManager mgr = SmsManager.getDefault();
        mgr.sendTextMessage(no, null, msg, null, null);
    }
}
