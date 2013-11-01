package com.example.david;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
public class Basicos extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.basicos);
		
		final Button b1 =(Button)findViewById(R.id.check);
		final Button b2 =(Button)findViewById(R.id.radio);
		
		b1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				
				Intent intent=new Intent(Basicos.this,checkbox.class);
				startActivity(intent);
				
			}
			
		});
		
		b2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent2=new Intent(Basicos.this,radio.class);
				startActivity(intent2);
				
			}
			
		});
	}
	

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
