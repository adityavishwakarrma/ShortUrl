package com.crio.shorturl;

import java.util.*;
//import java.util.Random;
import java.util.Map.Entry;
//import java.lang.Math.*;

//import com.crio.shorturl.*;

public class ShortUrlImpl implements ShortUrl {
                                        // longUrl  shortUrl
    HashMap<String,String> map1=new HashMap<String,String>();
                                        // shortUrl longUrl
    HashMap<String,String> map2=new HashMap<String,String>();

    

@Override
public String registerNewUrl(String longUrl)
{   
    if(map1.containsKey(longUrl))
    {   
        
        return map1.get(longUrl);
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

        map1.put(longUrl,f);
        map2.put(f, longUrl);
  
        return f; 
}



@Override
public String getUrl(String shortUrl)
{
    String a = new String();
   for(Entry<String, String> entry : map1.entrySet() )
   {
       if( entry.getValue() == shortUrl )
        {
            a = entry.getKey();
        }  

   }

    return a;
}

@Override
public String delete(String longUrl) {
    map2.remove(registerNewUrl(longUrl));
    return map1.remove(longUrl);
}

 

@Override
public String registerNewUrl(String longUrl, String shortUrl) {
    
    if ( getUrl(shortUrl) == null )
    return null;
    else {
        map1.put(longUrl,shortUrl);
        map2.put(shortUrl, longUrl);
        return shortUrl;
    }
}


@Override
public Integer getHitCount(String longUrl) {

    int c=0;

    for(Entry<String, String> entry : map2.entrySet() )
    {
        if( entry.getValue() == longUrl )
         {
            break;
         }  
         c++;
    }
    return c;
}



}

 