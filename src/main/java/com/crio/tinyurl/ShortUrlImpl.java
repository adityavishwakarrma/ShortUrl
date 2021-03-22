package com.crio.shorturl;

import java.util.*;
import java.lang.Math.*;

String registerNewUrl(String longUrl)
{
    
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
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        } 
        String ans = sb.toString();
        String f = "http://short.url/" + ans;

        map.put(id++,f);
  
        return f; 
}


String registerNewUrl(String longUrl, String shortUrl)