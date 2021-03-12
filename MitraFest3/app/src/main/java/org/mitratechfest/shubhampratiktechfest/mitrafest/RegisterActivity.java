package org.mitratechfest.shubhampratiktechfest.mitrafest;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;


public class RegisterActivity extends AppCompatActivity {
    Spinner spEvent,spCourse;
    EditText ednm,edclg,edadds,edemail,edmob,edsize,edamt,edtitle,edbranch;
    Button btn;
    TextView tv;
    public String spCourseName=null;
    public String spEventName=null;
    ProgressDialog pd;
    public String c_id;
    String currentDate="";
    String localTime="";
    String r_id="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edbranch=(EditText)findViewById(R.id.editBranch);
        edtitle=(EditText)findViewById(R.id.editPaperTitle);
        ednm=(EditText)findViewById(R.id.editPName);
        edclg=(EditText)findViewById(R.id.editPCollegeName);
        edadds=(EditText)findViewById(R.id.editCollegeAdds);
        edemail=(EditText)findViewById(R.id.editPEmail);
        edmob=(EditText)findViewById(R.id.editMob);
        edsize=(EditText)findViewById(R.id.editSize);
        edamt=(EditText)findViewById(R.id.editPayment);
        spCourse=(Spinner)findViewById(R.id.spinnerCourse);
        spEvent=(Spinner)findViewById(R.id.spinnerEvent);
        btn=(Button)findViewById(R.id.btnRegister);

        //Hide Edittext...
        edbranch.setVisibility(View.GONE);
        edtitle.setVisibility(View.GONE);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        c_id=pref.getString("c_id","xx");



        pd=new ProgressDialog(this);
        pd.setTitle("Registering");
        pd.setMessage("Wait..Registering Participatent..");

        List<String> events=new ArrayList<String>();
        events.add("Creatrix");
        events.add("Hackathon");
        events.add("Robotic Contest");
        events.add("Rubic's Cube");
        events.add("Hot Wheels");
        events.add("Web Designing");
        events.add("Coding & Decoding");
        events.add("Constructo");
        events.add("Techknow-Trivia");
        events.add("Paper Presentation");
        events.add("Kurukshetra");
        events.add("Business Plan");
        events.add("IPL Auction");
        events.add("Contraption");
        events.add("Circuit Experts");
        events.add("Snap Shot");
        events.add("Mix Station");
        events.add("CAD Mania");
        events.add("Lan Gaming");
        events.add("Paint Ball");


        //creating Adaptor for Spinner
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,events);
        //DropDown layout style -listView with radio button
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Attaching data adaptor to string
        spEvent.setAdapter(arrayAdapter);

        List<String> course=new ArrayList<String>();
        course.add("Diploma");
        course.add("Engineering");
        course.add("Other");

        //creating Adaptor for Spinner
        ArrayAdapter<String> arrayAdapter2=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,course);
        //DropDown layout style -listView with radio button
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Attaching data adaptor to string
        spCourse.setAdapter(arrayAdapter2);
        spEvent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // On selecting a spinner item
                spEvent.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        spEvent.setBackgroundResource(R.drawable.spinnerbackground);
                        return false;
                    }
                });
                spEventName=parent.getItemAtPosition(position).toString();
                if (spEventName.equals("Tech-Know Docx")) {
                    edbranch.setVisibility(View.VISIBLE);
                    edtitle.setVisibility(View.VISIBLE);
                }
                else {
                    edbranch.setVisibility(View.GONE);
                    edtitle.setVisibility(View.GONE);

                }

                //   Toast.makeText(getApplicationContext(),"Selected OS :"+nm,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spCourse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // On selecting a spinner item
                spCourse.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        spCourse.setBackgroundResource(R.drawable.spinnerbackground);
                        return false;
                    }
                });
                spCourseName=parent.getItemAtPosition(position).toString();
                //   Toast.makeText(getApplicationContext(),"Selected OS :"+nm,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nm=ednm.getText().toString();
                String clg=edclg.getText().toString();
                String adds=edadds.getText().toString();
                String email=edemail.getText().toString();
                String mob=edmob.getText().toString();
                String size=edsize.getText().toString();
                String amt=edamt.getText().toString();
                String branch=edbranch.getText().toString();
                String title=edtitle.getText().toString();

                SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");//dd/MM/yyyy
                Date now = new Date();
                currentDate= sdfDate.format(now);

                Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+1:00"));
                Date currentLocalTime = cal.getTime();
                DateFormat date = new SimpleDateFormat("HH:mm:ss");
                // you can get seconds by adding  "...:ss" to it
                date.setTimeZone(TimeZone.getTimeZone("GMT+1:00"));

                localTime = date.format(currentLocalTime);

                if(branch.equals(""))
                {
                    branch="Unknown";
                }
                if ((title.equals("")))
                {
                    title="Unknown";
                }
                if (spEventName == null) {
                    Toast.makeText(getApplicationContext(), "Please Select Event Name", Toast.LENGTH_SHORT).show();
                } else if (spCourseName == null) {
                    Toast.makeText(getApplicationContext(), "Please Select Course Name", Toast.LENGTH_SHORT).show();
                } else if(nm.equals("")){
                    ednm.setError("Enter Name");
                }else if(clg.equals("")){
                    edclg.setError("Enter College");
                }else if(adds.equals("")){
                    edadds.setError("Enter City");
                }else if(email.equals("")){
                    edemail.setError("Enter Email");
                }else if(mob.equals("")){
                    edmob.setError("Enter Mobile Number");
                }else if(size.equals("")){
                    edsize.setError("Enter Team Size");
                }else if(amt.equals("")){
                    edamt.setError("Enter Amount");
                }else{
                    register(nm,clg,adds,email,mob,size,amt,branch,title);
                }
            }
        });
    }
    public void register(final String nm, final String clg, final String adds, final String email, final String mob, final String size, final String amt,final String branch,final String title)
    {
        pd.show();
        StringRequest postRequest=new StringRequest(Request.Method.POST,Config.urlRegister,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                pd.dismiss();
                try {
                    JSONObject j2 = new JSONObject(response);
                    JSONArray jsonArray = j2.getJSONArray("RegisterDetails");
                    if (jsonArray.length() == 0) {
                        Toast.makeText(getApplicationContext(), "Login Failed..Try Again.", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, RegisterActivity.class));
                        finish();
                    } else {
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject j1 = jsonArray.getJSONObject(i);
                            r_id = j1.getString("r_id");
                        }
                        Intent intent = new Intent(RegisterActivity.this, RegIdActivity.class);
                        intent.putExtra("ID",r_id);
                        intent.putExtra("name",nm);
                        intent.putExtra("email",email);
                        intent.putExtra("eventName",spEventName);
                        intent.putExtra("payment",amt);
                        startActivity(intent);
                        finish();
                    }
                }catch (Exception er) {
                   // Log.e("K1", er.toString());
                    Toast.makeText(getApplicationContext(),"Server error..",Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                pd.dismiss();
                //Log.e("K1", error.toString());
                Toast.makeText(getApplicationContext(),"Unable to Connect..",Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String>map=new HashMap<String,String>();
                map.put("eventName",spEventName);
                map.put("c_id",c_id);
                map.put("p_name",nm);
                map.put("p_mob",mob);
                map.put("p_college_name",clg);
                map.put("p_college_adds",adds);
                map.put("p_email",email);
                map.put("p_course",spCourseName);
                map.put("team_size",size);
                map.put("paper_title",title);
                map.put("p_branch",branch);
                map.put("r_date",currentDate);
                map.put("r_time",localTime);
                map.put("payment",amt);
                return map;
            }
        };
        MyApplication.getInstance().addToReqQueue(postRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.register, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref",MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            editor.clear();
            editor.commit();


            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
