package com.example.areasdavid;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Bundle;
import android.view.View;

public class ResultadoCirculo extends Activity
{
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(new DibujaCirculo(this));		
	}
	
	public class DibujaCirculo extends View
	{
		Bundle bundle;
		final double PI= 3.1416; 
		public DibujaCirculo(Context contexto)
		{
			super(contexto);
			bundle=getIntent().getExtras();
		}
		
		public void onDraw(Canvas canvas)
		{
			String radio=bundle.getString("radio");
			int radioentero=Integer.parseInt(radio);
			int area=(int) (PI*radioentero*radioentero);
			
			Paint pincel=new Paint();
			pincel.setColor(Color.BLUE);
			pincel.setStrokeWidth(15);
			pincel.setStyle(Style.STROKE);
			
			Paint pincelTexto=new Paint();
			pincelTexto.setColor(Color.BLACK);
			pincelTexto.setTextSize(30);
			canvas.drawCircle(300,300,radioentero,pincel);
			canvas.drawText("Area: "+area,10,30,pincelTexto);
		}
			
	}
}
