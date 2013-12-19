package com.example.areasdavid;
 
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Bundle;
import android.view.View;

public class ResultadoCuadrado extends Activity 
{
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(new DibujaCuadrado(this));		
	}
	
	public class DibujaCuadrado extends View
	{
		Bundle bundle;
		public DibujaCuadrado(Context contexto)
		{
			super(contexto);
			bundle=getIntent().getExtras();
		}
		
		public void onDraw(Canvas canvas)
		{
			String lado=bundle.getString("lado");
			int ladoentero=Integer.parseInt(lado);
			int area=(int) (ladoentero*ladoentero);
			
			Paint pincel=new Paint();
			pincel.setColor(Color.BLUE);
			pincel.setStrokeWidth(15);
			pincel.setStyle(Style.STROKE);
			
			Paint pincelTexto=new Paint();
			pincelTexto.setColor(Color.BLACK);
			pincelTexto.setTextSize(30);
			canvas.drawRect(100,100,ladoentero,ladoentero, pincel);
			canvas.drawText("Area: "+area,10,30,pincelTexto);
		}
			
	}

}
