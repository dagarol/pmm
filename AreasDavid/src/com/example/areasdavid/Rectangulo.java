package com.example.areasdavid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Rectangulo extends Activity
{
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rectangulo);	
		final EditText ancho=(EditText)findViewById(R.id.ancho);
		final EditText alto=(EditText)findViewById(R.id.alto);
		final Button calcula=(Button)findViewById(R.id.boton);
		
		calcula.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) 
			{
				String an=ancho.getText().toString();
				String al=alto.getText().toString();
				
				Intent intent=new Intent(Rectangulo.this,ResultadoRectangulo.class);
				Bundle bundle=new Bundle();
				bundle.putString("ancho",an);
				bundle.putString("alto",al);
				intent.putExtras(bundle);
				startActivity(intent);	
			}
			
		});	

	}
	
}
