package com.crio.shorturl;

import java.util.HashMap;
import java.util.Map.Entry;
 
public class ShortUrlImpl implements ShortUrl {
                                        // longUrl  shortUrl
    HashMap<String,String> map1=new HashMap<String,String>();
   
    HashMap<String,Integer> map2 = new HashMap<String,Integer>();

@Override
public String registerNewUrl(String longUrl)
{   
    if(map1.containsKey(longUrl))
    {   
        for(Entry<String, Integer> entry : map2.entrySet())
        {
            if(entry.getKey()==longUrl)
            map2.put(longUrl, entry.getValue()+1) ;
        }

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
                = (int)( AlphaNumericString.length() * java.lang.Math.random() ); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString.charAt(index)); 
        } 

        String shortUrl = "http://short.url/" + sb.toString();

        map1.put(longUrl,shortUrl);
        
        map2.put(longUrl, 1);
  
        return shortUrl; 
}



@Override
public String getUrl(String shortUrl)
{
    String a = null;
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
    return map1.remove(longUrl);
}

 

@Override
public String registerNewUrl(String longUrl, String shortUrl) {
        if(map1.containsValue(shortUrl))
        {
            return null;
        }
       
        map1.put(longUrl,shortUrl);
        
        return shortUrl;
}


@Override
public Integer getHitCount(String longUrl) {
    if(map2.containsKey(longUrl))
    return map2.get(longUrl);
    else return 0;
}



}

 