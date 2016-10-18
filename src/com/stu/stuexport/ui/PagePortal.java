package com.stu.stuexport.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

import com.stu.stuexport.MainActivity;
import com.stu.stuexport.R;

public class PagePortal extends Activity
{	
	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        setContentView( R.layout.app_page_portal );
        
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        
        System.out.println( "x= " + width + ", y= " + height );
        _btn_good = ( Button ) findViewById( R.id.btn_good );
        _btn_bad = ( Button ) findViewById( R.id.btn_bad );
        
        _btn_good.setOnClickListener( new OnClickListener()
		{
			
			@Override
			public void onClick( View v )
			{
				Intent intent = new Intent( PagePortal.this, PageDragGood.class );
	    	    startActivity( intent );
			}
		} );
        
        _btn_bad.setOnClickListener( new OnClickListener()
		{
			
			@Override
			public void onClick( View v )
			{
				Intent intent = new Intent( PagePortal.this, PageDragBad.class );
	    	    startActivity( intent );
			}
		} );
	}
	
	private Button _btn_good = null;
	private Button _btn_bad = null;
}
