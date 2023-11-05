package com.ll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rq {
    String sc;
    String action;
    String queryString;

    Map<String,String>paramsMap;
    Rq(String sc) {
        paramsMap = new HashMap<>();
        this.sc = sc;

        String[] scBit = sc.split("\\?", 2);

        action = scBit[0].trim();
        //queryString = scBit[1].trim();

        if (scBit.length ==1) {
            return;
        }
        queryString =scBit[1].trim();

        String [] queryStringBit = queryString.split("&");

        for (int i=0; i < queryStringBit.length; i++){
            String queryStringStrBit = queryStringBit[i];
            String []queryStringStrBits= queryStringStrBit.split("=");
            String paramName = queryStringStrBits[0];
            String paramValue = queryStringStrBits[1];

            paramsMap.put(paramName,paramValue);

        }
     }

    String getAction() {
        return action;
    }

    int  getParamAsInt(String paramName, int defultValue) {
        String paramValue = paramsMap.get(paramName);

        if (paramValue != null) {
            try {
                return Integer.parseInt(paramValue);
            }
            catch (NumberFormatException e) {
                return defultValue;
            }
        }
        return defultValue;
    }
}
