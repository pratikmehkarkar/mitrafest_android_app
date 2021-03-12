package org.mitratechfest.shubhampratiktechfest.mitrafest;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Eventdetails extends AppCompatActivity {

   public TextView textViewResult,text,desc,prize,contact,rules,fees;

    private ProgressDialog loading;
	public int x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventdetails);

        textViewResult = (TextView) findViewById(R.id.textViewResult);
        text = (TextView) findViewById(R.id.textView2);
        desc = (TextView) findViewById(R.id.description);
        prize = (TextView) findViewById(R.id.prize);
        rules  = (TextView) findViewById(R.id.rules);
        contact = (TextView)findViewById(R.id.contact);
        fees = (TextView)findViewById(R.id.fees);
        loading=new ProgressDialog(this);
        loading.setMessage("Loading");
        loading.setTitle("Please Wait");
        Typeface about= Typeface.createFromAsset(getAssets(), "fonts/JACKPORTCOLLEGENCV.ttf");
        text.setTypeface(about);

        Typeface descc= Typeface.createFromAsset(getAssets(), "fonts/about.ttf");
        desc.setTypeface(descc);
        contact.setTypeface(descc);
        prize.setTypeface(descc);
        rules.setTypeface(descc);
        fees.setTypeface(descc);

        Intent mIntent = getIntent();

        int intValue = mIntent.getIntExtra("intVariableName", 0);

        if(intValue == 0)
        {
            Toast.makeText(Eventdetails.this,"Error",Toast.LENGTH_LONG).show();
        }
        // error handling (Will come in this if when button id is invalid)
        else if(intValue == R.id.create)
        {
            x=101;
            // Do work related to button 3
        }
        else if(intValue == R.id.hack)
        {
            x=111;
            // Do work related to button 3
        }
        else if(intValue == R.id.robotic)
        {
            x=112;
            // Do work related to button 3
        }
        else if(intValue == R.id.rubik)
        {
            x=113;
            // Do work related to button 3
        }
        else if(intValue == R.id.hotw)
        {
            x=107;
            // Do work related to button 3
        }
        else if(intValue == R.id.web)
        {
            x=105;
            // Do work related to button 3
        }
        else if(intValue == R.id.code)
        {
            x=106;
            // Do work related to button 3
        }
        else if(intValue == R.id.lang)
        {
            x=118;
            // Do work related to button 3
        }
        else if(intValue == R.id.cons)
        {
            x=104;
            // Do work related to button 3
        }
        else if(intValue == R.id.tech)
        {
            x=117;
            // Do work related to button 3
        }
        else if(intValue == R.id.techdocx)
        {
            x=103;
            // Do work related to button 3
        }
        else if(intValue == R.id.robow)
        {
            x=102;
            // Do work related to button 3
        }
        else if(intValue == R.id.businessplan)
        {
            x=116;
            // Do work related to button 3
        }
        else if(intValue == R.id.iplau)
        {
            x=109;
            // Do work related to button 3
        }
        else if(intValue == R.id.cont)
        {
            x=108;
            // Do work related to button 3
        }
        else if(intValue == R.id.circuitexp)
        {
            x=110;
            // Do work related to button 3
        }
        else if(intValue == R.id.sshot)
        {
            x=115;
            // Do work related to button 3
        }
        else if(intValue == R.id.mixx)
        {
            x=114;
            // Do work related to button 3
        }
        else if(intValue == R.id.lanGaming)
        {
            x=119;
            // Do work related to button 3
        }
        else if(intValue == R.id.paintBall)
        {
            x=120;
            // Do work related to button 3
        }
        getCreatrixData(x);


    }
   public void getCreatrixData(final int x)
    {
        loading.show();
        StringRequest postRequest=new StringRequest(Request.Method.POST,Config.urleventDetails,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                loading.dismiss();
                try {
                    JSONObject j2=new JSONObject(response);
                    JSONArray jsonArray = j2.getJSONArray("EventDetails");
                    if(jsonArray.length()==0)
                    {
                        Toast.makeText(getApplicationContext(), "Try Again.", Toast.LENGTH_SHORT).show();
                     //   startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    }
                    else {
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject j1 = jsonArray.getJSONObject(i);
                            String e_nam = j1.getString("e_name");
                            String e_desc=j1.getString("e_desc");
                            String prize_1=j1.getString("prize");
                            String rule=j1.getString("rules");
                           String fee = j1.getString("e_fee");
                            String contac=j1.getString("contact");

                            text.setText(e_nam);
                            desc.setText(e_desc);
                            prize.setText(prize_1);
                            rules.setText(rule);
                            contact.setText(contac);
                            fees.setText(fee);

                        }
                    }

                }catch (Exception er) {
                    Toast.makeText(getApplicationContext(),"Try again..",Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                loading.dismiss();
                Log.e("K1", error.toString());
                Toast.makeText(getApplicationContext(),"Unable to Connect..",Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String>map=new HashMap<String,String>();
                map.put("e_id",""+x);
                return map;
            }
        };
        MyApplication.getInstance().addToReqQueue(postRequest);
    }


}