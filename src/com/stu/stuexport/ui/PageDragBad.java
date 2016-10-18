package com.stu.stuexport.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;

import com.stu.stuexport.R;
import com.stu.stuexport.defs.Debug;

public class PageDragBad extends Activity
{
	/** Called when the activity is first created. */
	@Override
	public void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.app_page_bad );

		final Button btn = (Button) findViewById( R.id.btn );
//		final Button back = (Button) findViewById( R.id.back );
//		back.setVisibility( View.GONE );
		Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        
        final int top_split = (int)( 0.175 * width ) ;
        System.out.println("top_split: " + top_split);
        
		AlertDialog.Builder builder = new Builder( this );
		builder.setMessage("腰閃到了！！！");
		builder.setTitle("金害喔！！！");
		builder.setPositiveButton("下一步", new OnClickListener() 
		{
			@Override
			public void onClick( DialogInterface dialog, int whichButton )
            {
				_pd = ProgressDialog.show(PageDragBad.this, "請稍後", "請稍後....", true, false);
				
				String video_path = "http://www.youtube.com/watch?v=RoqauNRYHE4";
			    Uri uri = Uri.parse(video_path);
			        
			    // With this line the Youtube application, if installed, will launch immediately.
			    // Without it you will be prompted with a list of the application to choose.
			    uri = Uri.parse("vnd.youtube:"  + uri.getQueryParameter("v"));
			    
			    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
			    startActivity(intent);
			    
				_dialog.dismiss();
            }
		});
		builder.setNegativeButton("上一步", new OnClickListener() 
		{

			@Override
			public void onClick( DialogInterface dialog, int whichButton )
            {
				_dialog.dismiss();
				finish();
            }
		});
		if( _dialog == null )
		{
			_dialog = builder.create();
		}
		
		btn.setOnTouchListener( new OnTouchListener()
		{
			int[] temp = new int[] { 0, 0 };

			public boolean onTouch( View v, MotionEvent event )
			{

				int eventaction = event.getAction();

				int x = (int) event.getRawX();
				int y = (int) event.getRawY();

				switch ( eventaction )
				{

					case MotionEvent.ACTION_DOWN: // touch down so check if the
						temp[0] = (int) event.getX();
						temp[1] = y - v.getTop();
						break;

					case MotionEvent.ACTION_MOVE: // touch drag with the ball
						
						
						if (  v.getLeft() <= top_split )
						{
							showDialog();
//							back.setVisibility( View.VISIBLE );
							btn.setOnTouchListener( null );
						}
						else
						{
							v.layout( x - temp[0], y - temp[1], x + v.getWidth() - temp[0], y - temp[1]
									+ v.getHeight() );
						}
//						System.out.println( "x= " + v.getTop() + ", y= " + v.getLeft() );
						// v.postInvalidate();
						break;

					case MotionEvent.ACTION_UP:
						break;
				}

				return false;
			}

		} );

	}

	private void showDialog()
	{
		
		if( !_dialog.isShowing() )
		{
			_dialog.show();
		}
		
	}
    
    public void onRestart()
    {
        super.onRestart();
        if( _pd != null )
        {
        	_pd.dismiss();
        }
        finish();
    }
    
	private AlertDialog _dialog = null;
	private ProgressDialog _pd = null;
}
