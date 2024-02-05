package org.faps;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;


@Path("/calculate")
public class calculator {

     StringBuilder result = new StringBuilder();
     boolean stopAppending = false;

    

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response seeorder(){

         return Response.ok("Your orders are :"+ result.toString()).build() ;

    }

    @GET
    @Path("/total")
    @Produces(MediaType.TEXT_PLAIN)
    public Response Totaltime()  {

    
    machines obj = new machines("machine1" ,2,4,0.5f);

    
        int requiredTime = 0;
        char lastVehicle = ' ';
           
        for (int i = 0; i < result.toString().toCharArray().length; i++) {
            char vehicle = result.toString().toCharArray()[i];
            

            if (vehicle == 'c') { 
                requiredTime +=2;
            } else if (vehicle == 't') {
                requiredTime += 4;
            }

            if (i > 0 && lastVehicle != ' ' && lastVehicle != vehicle) {
                requiredTime += 0.5f;
            }

            lastVehicle = vehicle; 
        }
        
        return Response.ok("Your total time is :"+ requiredTime).build() ;
        
        
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

