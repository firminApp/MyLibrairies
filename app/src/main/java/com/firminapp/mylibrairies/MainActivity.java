package com.firminapp.mylibrairies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.firminapp.owomithirdparty.OwomiThirdParty;
import com.firminapp.owomithirdparty.listeners.AuthListener;
import com.firminapp.owomithirdparty.operations.Authientification;
import com.firminapp.owomithirdparty.operations.Operation;
import com.firminapp.owomithirdparty.sdk.TestActivity;

import org.json.JSONObject;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
private TextView tv;
private String TAG=MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.test);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle=new Bundle();
                Operation operation=new Authientification(bundle,"1234");
                OwomiThirdParty otp=new OwomiThirdParty(MainActivity.this,operation);
                otp.initAuthThirdParty(new AuthListener() {
                    @Override
                    public void onProcced() {
                        Log.e(TAG, "processing");
                    }

                    @Override
                    public JSONObject onFinish(JSONObject data) {
                        Log.e(TAG, data.toString());
                        return null;
                    }

                    @Override
                    public String onError(String error) {
                        Log.e(TAG,error);
                        return null;
                    }
                });
              // startActivity(new Intent(MainActivity.this,TestActivity.class));
            }
        });

    }
}
