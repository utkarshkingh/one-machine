package org.faps;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import org.faps.main;


import java.time.Duration;
import java.util.Scanner;


@Path("/times")
public class Totaltime {

    
    public float RequiredTime;
    public float ElaspedTime;

    
    
    Totaltime input = new Totaltime();
    char[] sequence = input.getSequence();

    public float RequiredTime() {

        
        for(int i = 0; i < inputString.length(); i++) {

            if(inputString[i]=="c"){

                RequiredTime+=2;
            }
        }

        


    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public boolean status() {
        if(ElaspedTime <=System.Now()){
            return false;
        }
         
        else(){
            return true;
        }
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public void orders(){


    }



}
