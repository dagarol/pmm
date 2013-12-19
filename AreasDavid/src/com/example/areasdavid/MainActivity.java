package com.example.areasdavid;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public boolean onOptionsItemSelected(MenuItem item) 
	{ 
		switch (item.getItemId()) 
		{ 
		case R.id.op1: 
		Intent intent=new Intent(MainActivity.this, Circulo.class);
		startActivity(intent);
		return true; 
		case R.id.op2: 
		Intent intent1=new Intent(MainActivity.this, Cuadrado.class);
		startActivity(intent1);
		return true; 
		case R.id.op3: 
		Intent intent2=new Intent(MainActivity.this, Rectangulo.class);
		startActivity(intent2);
		return true; 
		default: 
		return super.onOptionsItemSelected(item); 
		}

	}
}
