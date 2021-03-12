package org.mitratechfest.shubhampratiktechfest.mitrafest;

/**
 * Created by Pratik Mehkarkar on 03/02/2017.
 */

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Menu3 extends Fragment
{
    TextView about;
    String abt = "<body><h1>Esperanza - means hope</h1>" +
"A ray of hope that brings innovation.<br>" +
"<p>Our very own techfest of PRMITR TechKnow Experts is now <strong>ESPERANZA</strong>." +
"This year Prof.Ram Meghe Institute of Technology and Research ,Badnera organizing this" +
" much awaited event with whole new essence of enthusiasm and exciting winning prizes worth "
+" 5 lakh, a world class competition with participants ,corporates and geeks from all over the " +
"india ,makes it the biggest technical event in central india with the footfall of around" +
" <strong>10,000 visitors</strong>. " +
"The TechKnow Experts has been sensational event since last 7 years, upgrading its standard to whole " +
"new level every year. Now its your time to grab this opportunity and be a part of first ever ESPERANZA and witness the history." +
"This year the ESPERANZA event is dated on <strong>25 Feb,2017 </strong>at the college campus of <strong>PRMITR,Badnera.</strong> </p>"+
"<strong>come|compete|conquer</strong>"+
"<blockquote>Official Esperanza website <a href=\"www.mitrafest.in\">" +
"mitrafest.in<a></blockquote></body>";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        View v=  inflater.inflate(R.layout.fragment_menu_3, container, false);
        about = (TextView)v.findViewById(R.id.con);
        about.setText(Html.fromHtml(abt));
        Typeface descc= Typeface.createFromAsset(getActivity().getAssets(), "fonts/about.ttf");
        about.setTypeface(descc);
        return v;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("About us");
    }
}