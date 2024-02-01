package org.faps;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;



@Path("/total")
public class Totaltime  {

    
    private int elapsedTime = 0;

    machines obj=new machines();
     

    private StringBuilder result = new StringBuilder();
    private char[] order;

    @GET
    @Produces(MediaType.TEXT_PLAIN)

    public int RequiredTime()  {
        int requiredTime = 0;
        char lastVehicle = ' ';
        

        for (int i = 0; i < result.toString().toCharArray().length; i++) {
            char vehicle = result.toString().toCharArray()[i];
            

            if (vehicle == 'c') { 
                requiredTime +=obj.getCarTime();
            } else if (vehicle == 't') {
                requiredTime += obj.getTruckTime();
            }

            if (i > 0 && lastVehicle != ' ' && lastVehicle != vehicle) {
                requiredTime += obj.getChangeTime();
            }

            lastVehicle = vehicle; 
        }
        
        System.out.println("Total required time for the sequence = " +requiredTime);
        elapsedTime = requiredTime;
        return requiredTime;
        
    }
    
}





