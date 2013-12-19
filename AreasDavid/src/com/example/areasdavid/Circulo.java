package com.example.areasdavid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Circulo extends Activity
{

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.circulo);	
		
		final EditText radio=(EditText)findViewById(R.id.radio);
		final Button calcula=(Button)findViewById(R.id.boton);
		
		calcula.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) 
			{
				String r=radio.getText().toString();
				
				Intent intent=new Intent(Circulo.this,ResultadoCirculo.class);
				Bundle bundle=new Bundle();
				bundle.putString("radio",r);
				intent.putExtras(bundle);
				startActivity(intent);	
			}
			
		});	
	}	
}
