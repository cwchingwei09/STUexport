package com.stu.stuexport;

import java.io.File;

import com.stu.stuexport.defs.Debug;
import com.stu.stuexport.logic.SessionManager;
import com.stu.stuexport.ui.PagePortal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.Window;

public class MainActivity extends Activity
{
	private Handler mHandler = new Handler();
    public void onCreate( Bundle savedInstanceState )
    {
        Debug.println( "Activity onCreate" );
        super.onCreate( savedInstanceState );
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        setContentView( R.layout.activity_main );
        constructResource();
        if( !_initialized )
        {
            _initialized = true;
            try
			{
				initialize();
			}
			catch ( InterruptedException e )
			{
				e.printStackTrace();
			}
            
        }
    }
    
    public void onStart()
    {
        Debug.println( "Activity onStart()" );
        super.onStart();
    }
    
    public void onRestart()
    {
        Debug.println( "Activity onRestart()" );
        super.onRestart();
        finish();
    }
    
    public void onResume()
    {
        Debug.println( "Activity onResume()" );
        super.onResume();
    }
    
    public void onPause()
    {
        Debug.println( "Activity onPause()" );
        super.onPause();
    }
    
    public void onStop()
    {
        Debug.println( "Activity onStop()" );
        super.onStop();
    }
    
    public void onDestroy()
    {
        Debug.println( "Activity onDestroy()" );
        releaseResource();
        super.onDestroy();
    }
    
    private void initialize() throws InterruptedException
    {
        Debug.println( "Activity initialize()" );
//        new AsyncService().execute();
        
//        if( !SessionManager.intance().isFirstRun() )
//        {
        mHandler.postDelayed(mUpdateTimeTask, 3000);
        
//        }
    }
    private Runnable mUpdateTimeTask = new Runnable() 
    {
    	   public void run() 
    	   {
    		   Intent intent = new Intent( MainActivity.this, PagePortal.class );
    	       startActivity( intent );
    	   }
    	};
    private void constructResource()
    {
        if( Environment.getExternalStorageState().equals( Environment.MEDIA_MOUNTED ) )
        {
            
        }
        else
        {
            _initialized = true;
        }
    }
    
    private void releaseResource()
    {
    }
    
    private boolean _initialized = false;
    /*
    class AsyncService extends AsyncTask< String , String , String >
    {
        
        @ Override
        protected String doInBackground( String... params )
        {
            if( NetWorkUtil.checkInternetConnection( ShopActivity.this ) )
            {
                if( MemoryUtil.checkMemoryExist() )
                {
                    loadPromotionMessage();
                    loadProductionInformation();
                    loadCategory();
                    loadBranches();
                }
                else
                {
                    Debug.println( "NO MEMORY STORE" );
                }
            }
            else
            {
                Debug.println( "NO connection" );
            }
            return null;
        }
        
        @ Override
        protected void onPostExecute( String result )
        {
            SystemConfig.instance().reload();
            Intent intent = new Intent( ShopActivity.this, PagePortal.class );
            startActivity( intent );
        }
    }
    
    private void loadPromotionMessage()
    {
        String result = null;
        String table_name = PromotionMessageStateStore.getInstance().getDBTableName();
        result = JSONServer.doSyncNewsPromotion( this, table_name, SystemConfig.instance().getTableUpdatedTime( table_name ) );
        if( !result.equals( "" ) && result != null )
        {
            JSONMessageHandler.instance().storeResultPromoMsg( result );
        }
    }
    
    private void loadProductionInformation()
    {
        String result = null;
        String table_name = ProductInformationStateStore.getInstance().getDBTableName();
        result = JSONServer.doSyncProductionInformation( this, table_name, SystemConfig.instance().getTableUpdatedTime( table_name ) );
        if( !result.equals( "" ) && result != null )
        {
            JSONMessageHandler.instance().storeResultProductInfo( result );
        }
    }
    
    private void loadCategory()
    {
        String result = null;
        String table_name = ProductCategoryStateStore.getInstance().getDBTableName();
        result = JSONServer.doSyncCategory( this, table_name, SystemConfig.instance().getTableUpdatedTime( table_name ) );
        if( !result.equals( "" ) && result != null )
        {
            JSONMessageHandler.instance().storeResultProductCategory( result );
        }
    }
    
    private void loadBranches() // //////////BUG
    {
        String result = null;
        String table_name = ShopBranchesStateStore.getInstance().getDBTableName();
        result = JSONServer.doSyncBranches( this, table_name, SystemConfig.instance().getTableUpdatedTime( table_name ) );
        if( !result.equals( "" ) && result != null )
        {
            JSONMessageHandler.instance().storeResultShopBranches( result );
        }
    }
    */
    private   boolean   _licence = false;
}
