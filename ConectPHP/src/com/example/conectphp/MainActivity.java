package com.example.conectphp;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity
{

    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        ConexionPhp handler = new ConexionPhp();
        
        String txt = handler.post("http://192.168.24.192:8080/prueba.php");
        
        TextView t = (TextView)findViewById(R.id.t1);
        t.setText(txt);
    }

    
}