package org.faps;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.time.Duration;
import java.util.Scanner;


@Path("/times")
public class demo {

    private StringBuilder result = new StringBuilder();
    private boolean stopAppending = false;


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public void seeorder(){

        System.out.println(result);
    }

    @POST
    @Path("/postorder")
    @Consumes(MediaType.TEXT_PLAIN)
    public String postOrder(String input) {
        if (!stopAppending) {
            result.append(input);

            // Check if the input contains the character 'x'
            if (input.contains("x")) {
                stopAppending = true;
            }
        }

        return result.toString();
        
    }
}


        



        

        


         
      
    
    
    



