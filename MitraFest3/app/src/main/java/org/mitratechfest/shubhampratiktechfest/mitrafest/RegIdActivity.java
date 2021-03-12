package org.mitratechfest.shubhampratiktechfest.mitrafest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RegIdActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_id);

        final String data1 = getIntent().getExtras().getString("ID");
        final String data2 = getIntent().getExtras().getString("name");
        final String data3 = getIntent().getExtras().getString("email");
        final String ename = getIntent().getExtras().getString("eventName");
        final String data5 = getIntent().getExtras().getString("payment");

        TextView tv=(TextView) findViewById(R.id.regId);
        tv.setText(data1);
        Button btn=(Button)findViewById(R.id.btnOk);
        Button btn2=(Button)findViewById(R.id.btnSendMail);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegIdActivity.this, RegisterActivity.class));
                finish();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_SEND);
                i.setData(Uri.parse("email"));
                String[] s={data3};
                i.putExtra(Intent.EXTRA_EMAIL,s);
                i.putExtra(Intent.EXTRA_SUBJECT," ESPERANZA'17 Registration");
                i.putExtra(Intent.EXTRA_TEXT,"Greetings from ESPERANZA'17 !!!\n" +
                        "\n Thank You Mr./Ms." + data2 +", \n\nYou have registered for " +
                        ename+" ,event of ESPERANZA 2017.Congratulations..!! You are going to be part of one of the biggest technical event of Central INDIA. \n" +
                        "\n We have received the payment of Rs." +data5+
                        " \n" +
                        "\n Your Registration Token ID is : " +data1+"\n\n All The Best..!!"+"\n\n Regards,\n ESPERANZA Team"
                        );
                i.setType("message/rfc822");
                Intent chooser=Intent.createChooser(i,"Launch Email");
                startActivity(chooser);
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(RegIdActivity.this,RegisterActivity.class);
        startActivity(intent);
        finish();
    }
}
