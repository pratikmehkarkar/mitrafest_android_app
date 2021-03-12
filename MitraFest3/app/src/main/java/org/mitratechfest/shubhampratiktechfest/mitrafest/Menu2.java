package org.mitratechfest.shubhampratiktechfest.mitrafest;

/**
 * Created by Pratik Mehkarkar on 03/02/2017.
 */

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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




public class Menu2 extends Fragment {
    EditText edId,edPass;
    Button btn;
    TextView note;
    ProgressDialog pd;
    String nt = "<body><h1>Important Note:</h1>" +
            "<p>Purpose of Participant Registration service is strictly for registered/selected coordinators of <strong>ESPERANZA'17</strong>." +
            " Registered/selected Coordinators should contact their respective head and co-head of committee for their login credentials.</p></body>";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments

        View v = inflater.inflate(R.layout.fragment_menu_2, container, false);
        note = (TextView)v.findViewById(R.id.note);
        note.setText(Html.fromHtml(nt));
        Typeface not = Typeface.createFromAsset(getActivity().getAssets(), "fonts/about.ttf");
        note.setTypeface(not);

        SharedPreferences pref = getActivity().getSharedPreferences("MyPref", 0);
        String ok = pref.getString("c_id", "default");
        if (!(ok.equals("default"))) {
            Intent in = new Intent(getActivity(), RegisterActivity.class);
            in.putExtra("c_id", ok);
            startActivity(in);
            getActivity().finish();
        } else {

            edId = (EditText) v.findViewById(R.id.editLoginId);
            edPass = (EditText) v.findViewById(R.id.editPass);

            btn = (Button) v.findViewById(R.id.btnLogin);

            pd = new ProgressDialog(getActivity());
            pd.setTitle("Login");
            pd.setMessage("Wait..");
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id = edId.getText().toString();
                    String pass = edPass.getText().toString();
                    if (id == null) {
                        Toast.makeText(getActivity(), "Enter Login ID", Toast.LENGTH_SHORT).show();
                    } else if (pass == "") {
                        edPass.setError("Enter Password");
                    } else {
                        login(id, pass);
                    }
                }
            });
        }
            return v;
        }

    public void login(final String id, final String pass)
    {
        pd.show();
        StringRequest postRequest=new StringRequest(Request.Method.POST,Config.urlLogin,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                pd.dismiss();
                try {
                    JSONObject j2=new JSONObject(response);
                    JSONArray jsonArray = j2.getJSONArray("UserDetails");
                    if(jsonArray.length()==0)
                    {
                        Toast.makeText(getActivity(), "Login Failed..Try Again.", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getActivity(),MainActivity.class));
                    }
                    else {
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject j1 = jsonArray.getJSONObject(i);
                            String c_id = j1.getString("c_id");
                            SharedPreferences pref = getActivity().getSharedPreferences("MyPref", 0);
                            SharedPreferences.Editor editor = pref.edit();
                            editor.putString("c_id",c_id);
                            editor.commit();

                            Intent in = new Intent(getActivity(), RegisterActivity.class);
                            in.putExtra("c_id", c_id);
                            startActivity(in);
                            getActivity().finish();

                        }
                    }

                }catch (Exception er) {
                    Toast.makeText(getActivity(),"Try again..",Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                pd.dismiss();
                //Log.e("K1", error.toString());
                Toast.makeText(getActivity(),"Unable to Connect..",Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String>map=new HashMap<String,String>();
                map.put("c_id",id);
                map.put("pass",pass);
                return map;
            }
        };
        MyApplication.getInstance().addToReqQueue(postRequest);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Event Registration");
    }
}