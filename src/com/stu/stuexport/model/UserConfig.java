package com.stu.stuexport.model;


public class UserConfig
{
    public String getViewWidth()
    {
        return view_width;
    }
    public void setViewWidth( String aUserAddressZip )
    {
    	view_width = aUserAddressZip;
    }
    public String getViewHeight()
    {
        return view_height;
    }
    public void setViewHeight( String aUserAddressCity )
    {
    	view_height = aUserAddressCity;
    }
    public String getUserAddressCounty()
    {
        return user_address_county;
    }
    public void setUserAddressCounty( String aUserAddressCounty )
    {
        user_address_county = aUserAddressCounty;
    }
    public String getUserAddressRoadNo()
    {
        return user_address_road_no;
    }
    public void setUserAddressRoadNo( String aUserAddressRoadNo )
    {
        user_address_road_no = aUserAddressRoadNo;
    }
    public String getUserAddress()
    {
        return "";
    }
    public String getUserCellPhone()
    {
        return user_cellphone;
    }
    public void setUserCellPhone( String aUserCellPhone )
    {
        user_cellphone = aUserCellPhone;
    }
    
    private static String view_width      = null;
    private static String view_height     = null;
    private static String user_address_county  = null;
    private static String user_address_road_no = null;
    private static String user_cellphone       = null;
}
