package com.example.areasdavid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Cuadrado extends Activity
{
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cuadrado);	
		final EditText lado=(EditText)findViewById(R.id.lado);
		final Button calcula=(Button)findViewById(R.id.boton);
		
		calcula.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) 
			{
				String l=lado.getText().toString();
				
				Intent intent=new Intent(Cuadrado.this,ResultadoCuadrado.class);
				Bundle bundle=new Bundle();
				bundle.putString("lado",l);
				intent.putExtras(bundle);
				startActivity(intent);	
			}
			
		});	
	}
	
}
