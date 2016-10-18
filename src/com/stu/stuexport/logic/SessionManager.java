package com.stu.stuexport.logic;

import java.util.HashMap;

import com.stu.stuexport.model.UserConfig;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SessionManager
{
    
    private static SharedPreferences pref         = null;
    private static Editor            editor       = null;
    private static Context           _context     = null;
    private static SessionManager    _instance    = null;
    private final int                PRIVATE_MODE = 0;
    private static final String      PREF_NAME    = "shop123_manager";
    private static final String      IS_LOGIN     = "IsLoggedIn";
    public static final String       KEY_ACCOUNT  = "shop_account";
    public static final String       KEY_PASSWARD = "shop_passward";
    public static final String       KEY_SESSION  = "shop_session";
    public static final String       KEY_ADDRESS  = "shop_address";
    public static final String       KEY_FIRST_RUN  = "shop_first_run";
    
    // Constructor
    public SessionManager( Context aContext )
    {
        _context = aContext;
        pref = _context.getSharedPreferences( PREF_NAME, PRIVATE_MODE );
        editor = pref.edit();
    }
    
    public static void construct( Context aContext )
    {
        if( _instance == null )
        {
            _instance = new SessionManager( aContext );
        }
    }
    
    public static SessionManager intance()
    {
        return _instance;
    }
    /**
     * Create login session
     * */
    public void createLoginSession( String aName, String aPassword, String aSession )
    {
        editor.putBoolean( IS_LOGIN, true );
        editor.putString( KEY_ACCOUNT, aName );
        editor.putString( KEY_PASSWARD, aPassword );
        editor.putString( KEY_SESSION, aSession );
        editor.commit();
    }
    
    public void createUserAddress( UserConfig aUser )
    {
    }
    
    /**
     * Check login method wil check user login status If false it will redirect
     * user to login page Else won't do anything
     * */
    public void checkLogin()
    {
        if( !this.isLoggedIn() )
        {
        }
    }
    
    /**
     * Get stored session data
     * */
    public HashMap< String , String > getUserDetails()
    {
        HashMap< String , String > user = new HashMap< String , String >();
        user.put( KEY_ACCOUNT, pref.getString( KEY_ACCOUNT, null ) );
        user.put( KEY_PASSWARD, pref.getString( KEY_PASSWARD, null ) );
        user.put( KEY_SESSION, pref.getString( KEY_SESSION, null ) );
        return user;
    }
    
    public void reloadUserAddress()
    {
        if( isLoggedIn() )
        {
            String str_user_address = pref.getString( KEY_ADDRESS, null );
            
            if( str_user_address != null )
            {
                String[] address_detail = str_user_address.split( "," );
                
            }
        }
    }
    
    public void setFirstRun()
    {
        editor.putBoolean( KEY_FIRST_RUN, false );
        editor.commit();
    }
    
    public boolean isFirstRun()
    {
        return pref.getBoolean( KEY_FIRST_RUN, true );
    }
    /**
     * Clear session details
     * */
    public void logoutUser()
    {
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();
    }
    
    /**
     * Quick check for login
     * **/
    // Get Login State
    public boolean isLoggedIn()
    {
        return pref.getBoolean( IS_LOGIN, false );
    }
    
    
}
