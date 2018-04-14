package com.jies.test.resource;


import org.springframework.stereotype.Component;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Random;

/**
* Created by peijie on 17/6/1.
*/

@ResourceImpl
@Component
@Path("/test")
@Produces({"application/json;charset=UTF-8"})
public class TestService implements ITestRsource{
    @Override
    public Integer test() {
        Random r = new Random();
        return r.nextInt();
    }
    public static void main(String [] args){
        String aaa = "";
        String str [] = aaa.split("\\n");
        String b = "";
        for(String s : str){
            b = b + s + ",";
        }
        System.out.println(b);
        System.out.println(4 & 1);
    }
}
