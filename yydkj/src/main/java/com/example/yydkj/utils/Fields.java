package com.example.yydkj.utils;


public class Fields {
    //所有的sp的属性都在这里
    public static final class sharePreferences{
        public static final String filename = "oschina20";
        public static String Cookie = "Cookie";
        public static String UserId ="UserId";
        public static String name ="name";

    }

    public static final class Event{
        public static final int STATUS_END = 1;
        public static final int STATUS_ING = 2;
        public static final int STATUS_SING_UP = 3;

        public static final int EVENT_TYPE_OSC = 1;
        public static final int EVENT_TYPE_TEC = 2;
        public static final int EVENT_TYPE_OTHER = 3;
        public static final int EVENT_TYPE_OUTSIDE = 4;
    }

    //所有请求地址
    public static class uri{
        //资讯头部的url
        public static final String NEWHEADURL = "http://www.oschina.net/action/apiv2/banner?catalog=1";
        //资讯的body的url
        public static final String NEWBODYURL = "http://www.oschina.net/action/apiv2/news?pageToken=";

        public static final String BLOGURL = "http://www.oschina.net/action/apiv2/blog?catalog=3&pageToken=";
    }

    //所有的showactivity的参数
    public  static final class showActivity{
        public static final String bundle = "bundle";//数据包
        public static final String className = "className";//显示的fragment的类
        public static final String isShowActionbar = "isShowActionbar";//actionbar显示
        public static final String title = "title";//标题
        public static final String isArrow = "isArrow";//是否显示箭头


    }
}
