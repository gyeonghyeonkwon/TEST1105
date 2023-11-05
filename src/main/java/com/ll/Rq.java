package com.ll;

import java.util.ArrayList;
import java.util.List;

public class Rq {
    String sc;
    String action;
    String queryString;
    List<String>paramNames;
    List<String>paramValues;
    Rq(String sc) {
        paramNames =new ArrayList<>();
        paramValues=new ArrayList<>();
        this.sc = sc;

        String[] scBit = sc.split("\\?", 2);

        action = scBit[0].trim();
        queryString = scBit[1].trim();

        String [] queryStringBit = queryString.split("&");

        for (int i=0; i < queryStringBit.length; i++){
            String queryStringStrBit = queryStringBit[i];
            String []queryStringStrBits= queryStringStrBit.split("=");
            String paramName = queryStringStrBits[0];
            String paramValue = queryStringStrBits[1];

            paramNames.add(paramName);
            paramValues.add(paramValue);
        }
     }

    String getAction() {
        return action;
    }

    int  getParamAsInt(String paramName, int defultValue) {
        int index=paramNames.indexOf(paramName);

        if (index == -1 ) return defultValue;
        String paramValue = paramValues.get(index);
        try {
            return Integer.parseInt(paramValue);
        }
        catch (NumberFormatException e) {
            return defultValue;
        }
    }
}
