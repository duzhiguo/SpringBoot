package com.bookmanage.demo.unity;


import java.io.IOException;

public class  BaiAll {
    public   String APPID = "16941192";
    //百度人脸识别应用apikey
    public  String API_KEY = "Pwp9qKPuW5iXC2lst5sq4l5O";
    //百度人脸识别应用sercetkey
    public   String SERCET_KEY = "opL2RYSguV0BlTBal1ffOA9mvFWvSuQc";
    public    String TOKEN = null;

    public  String get_token() throws IOException {
         String access_token_url = "https://aip.baidubce.com/oauth/2.0/token?grant_type=client_credentials" +
                 "&client_id="+API_KEY
                 +"&client_secret="+ SERCET_KEY;
         //System.out.println(access_token_url);

        return TOKEN;
     }

}
