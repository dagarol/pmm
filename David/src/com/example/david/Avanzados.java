package com.example.david;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Avanzados extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.avanzados);
		
		final Button b1 =(Button)findViewById(R.id.lista);
		final Button b2 =(Button)findViewById(R.id.spinner);
		
		b1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				
				Intent intent=new Intent(Avanzados.this,ListaPersona.class);
				startActivity(intent);
				
			}
			
		});
		
		b2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent2=new Intent(Avanzados.this,SpinnerPersona.class);
				startActivity(intent2);
				
			}
			
		});
	}

}

