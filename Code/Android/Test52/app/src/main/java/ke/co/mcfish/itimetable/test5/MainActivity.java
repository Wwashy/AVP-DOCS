package ke.co.mcfish.itimetable.test5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private String url = "http://192.168.43.185/name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getData(View v){
        JsonObjectRequest req = new JsonObjectRequest(
                Request.Method.GET,
                this.url,
                null,
                new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject resp) {
                if (resp != null){

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError err) {
                Log.e("MainActivity", err.getMessage(), err.fillInStackTrace());
            }
        });
    }
}
