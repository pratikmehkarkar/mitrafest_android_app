package org.mitratechfest.shubhampratiktechfest.mitrafest;

/**
 * Created by Pratik Mehkarkar on 03/02/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;




public class Menu1 extends Fragment {

    ImageButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16,btn17,btn18,btn19,btn20;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        View v=  inflater.inflate(R.layout.fragment_menu_1, container, false);
        btn1 = (ImageButton)v.findViewById(R.id.create);
        btn2 = (ImageButton)v.findViewById(R.id.hack);
        btn3 = (ImageButton)v.findViewById(R.id.robotic);
        btn4 = (ImageButton)v.findViewById(R.id.rubik);
        btn5 = (ImageButton)v.findViewById(R.id.hotw);
        btn6 = (ImageButton)v.findViewById(R.id.web);
        btn7 = (ImageButton)v.findViewById(R.id.code);
        btn8 = (ImageButton)v.findViewById(R.id.lang);
        btn9 = (ImageButton)v.findViewById(R.id.cons);
        btn10 = (ImageButton)v.findViewById(R.id.tech);
        btn11 = (ImageButton)v.findViewById(R.id.techdocx);
        btn12 = (ImageButton)v.findViewById(R.id.robow);
        btn13 = (ImageButton)v.findViewById(R.id.businessplan);
        btn14 = (ImageButton)v.findViewById(R.id.iplau);
        btn15 = (ImageButton)v.findViewById(R.id.cont);
        btn16 = (ImageButton)v.findViewById(R.id.circuitexp);
        btn17 = (ImageButton)v.findViewById(R.id.sshot);
        btn18 = (ImageButton)v.findViewById(R.id.mixx);
        btn19 = (ImageButton)v.findViewById(R.id.lanGaming);
        btn20 = (ImageButton)v.findViewById(R.id.paintBall);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getActivity(),Eventdetails.class);
                i1.putExtra("intVariableName", v.getId());
                startActivity(i1);

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(getActivity(),Eventdetails.class);
                i2.putExtra("intVariableName", v.getId());
                startActivity(i2);

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3=new Intent(getActivity(),Eventdetails.class);
                i3.putExtra("intVariableName", v.getId());
                startActivity(i3);

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4=new Intent(getActivity(),Eventdetails.class);
                i4.putExtra("intVariableName", v.getId());
                startActivity(i4);

            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i5=new Intent(getActivity(),Eventdetails.class);
                i5.putExtra("intVariableName", v.getId());
                startActivity(i5);

            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i6=new Intent(getActivity(),Eventdetails.class);
                i6.putExtra("intVariableName", v.getId());
                startActivity(i6);

            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i7=new Intent(getActivity(),Eventdetails.class);
                i7.putExtra("intVariableName", v.getId());
                startActivity(i7);

            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i8=new Intent(getActivity(),Eventdetails.class);
                i8.putExtra("intVariableName", v.getId());
                startActivity(i8);

            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i9=new Intent(getActivity(),Eventdetails.class);
                i9.putExtra("intVariableName", v.getId());
                startActivity(i9);

            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),Eventdetails.class);
                i.putExtra("intVariableName", v.getId());
                startActivity(i);

            }
        });
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),Eventdetails.class);
                i.putExtra("intVariableName", v.getId());
                startActivity(i);

            }
        });
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),Eventdetails.class);
                i.putExtra("intVariableName", v.getId());
                startActivity(i);

            }
        });
        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),Eventdetails.class);
                i.putExtra("intVariableName", v.getId());
                startActivity(i);

            }
        });
        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),Eventdetails.class);
                i.putExtra("intVariableName", v.getId());
                startActivity(i);

            }
        });
        btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),Eventdetails.class);
                i.putExtra("intVariableName", v.getId());
                startActivity(i);

            }
        });
        btn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),Eventdetails.class);
                i.putExtra("intVariableName", v.getId());
                startActivity(i);

            }
        });
        btn17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),Eventdetails.class);
                i.putExtra("intVariableName", v.getId());
                startActivity(i);

            }
        });
        btn18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),Eventdetails.class);
                i.putExtra("intVariableName", v.getId());
                startActivity(i);

            }
        });
        btn19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),Eventdetails.class);
                i.putExtra("intVariableName", v.getId());
                startActivity(i);

            }
        });
        btn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),Eventdetails.class);
                i.putExtra("intVariableName", v.getId());
                startActivity(i);

            }
        });

        return v;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Home");
    }

}