package com.crio.tinyurl;

import java.util.*;
//import java.util.Random;
import java.util.Map.Entry;
//import java.lang.Math.*;

import com.crio.shorturl.ShortUrl;

public class ShortUrlImpl implements ShortUrl {

    HashMap<String,String> map=new HashMap<String,String>();

@Override
public String registerNewUrl(String longUrl)
{   
    if(map.containsKey(longUrl))
    {
        return map.get(longUrl);
    }

 // function to generate a random string of length n 
    int n=9;

        // chose a Character random from this String 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)( AlphaNumericString.length() * Math.random() ); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString.charAt(index)); 
        } 
        String ans = sb.toString();
        String f = "http://short.url/" + ans;

        map.put(longUrl,f);
  
        return f; 
}

int c=0;

@Override
public String getUrl(String shortUrl)
{
    String a=null;

   for(Entry<String, String> entry : map.entrySet() )
   {
       if( entry.getValue() == shortUrl )
        {
            a = entry.getKey();
            c++;
        }  

   }

    return a;
}

@Override
public String delete(String longUrl) {
    return map.remove(longUrl);
}

@Override
public String registerNewUrl(String longUrl, String shortUrl) {
    if ( getUrl(shortUrl) == null )
    return null;
    else {
        map.put(longUrl,shortUrl);
        return shortUrl;
    }
}

@Override
public Integer getHitCount(String longUrl) {
    return c;
}



}

 
