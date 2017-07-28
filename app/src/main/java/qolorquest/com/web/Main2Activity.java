package qolorquest.com.web;

import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import static qolorquest.com.web.R.id.imageid;

public class Main2Activity extends AppCompatActivity {
EditText otp;
    Button otpb;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        otp = (EditText)findViewById(R.id.editText2);
        otpb = (Button) findViewById(R.id.button2);
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
       final int keycode = settings.getInt("key",0);
        otpb.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)

            {


                if (!TextUtils.isEmpty(otp.getText()))


                {
                    final int getkey = Integer.parseInt(otp.getText().toString());
                    if (keycode == getkey) {
                        String uri = "@drawable/verfied";  // where myresource (without the extension) is the file

                        int imageResource = getResources().getIdentifier(uri, null, getPackageName());

                        image = (ImageView) findViewById(imageid);
                        Drawable res = getResources().getDrawable(imageResource);
                        image.setImageDrawable(res);

                    } else {
                        String uri = "@drawable/reject";  // where myresource (without the extension) is the file

                        int imageResource = getResources().getIdentifier(uri, null, getPackageName());

                        image = (ImageView) findViewById(imageid);
                        Drawable res = getResources().getDrawable(imageResource);
                        image.setImageDrawable(res);
                    }

                } else

                {
                    Toast.makeText(getApplicationContext(),"please enter a valid otp",Toast.LENGTH_SHORT).show();
                }

            }
                    //Use


        });
    }
}
