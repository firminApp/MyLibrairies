package com.firminapp.owomithirdparty.sdk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.firminapp.owomithirdparty.R;
import com.firminapp.owomithirdparty.listeners.AuthListener;

import org.json.JSONException;
import org.json.JSONObject;

public class TestActivity extends AppCompatActivity {
    JSONObject data;
    private String TAG=TestActivity.class.getSimpleName();
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        tv=(TextView)findViewById(R.id.tv) ;
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject object=new JSONObject();
                try {
                    object.put("statut","success");
                    object.put("data",null);
                    new InitThirdParty(TestActivity.this,"123",object).onSubmit("123", new AuthListener() {
                        @Override
                        public void onProcced() {
                            tv.setText("processing...");
                            Log.e(TAG,"processing");
                        }

                        @Override
                        public JSONObject onFinish(JSONObject data) {
                            tv.setText("finish...");
                            Log.e(TAG,data.toString());
                            return null;
                        }

                        @Override
                        public String onError(String error) {
                            Log.e(TAG,error);
                            tv.setText("error...");
                            return null;
                        }
                    });

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });


    }
}
