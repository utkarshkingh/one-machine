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


    machines obj=new machines();

    demo result2 = new demo();
    char[]okResult = demo.result.toString().toCharArray(); 

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public int RequiredTime()  {
        int requiredTime = 0;
        char lastVehicle = ' ';
        
        

        for (int i = 0; i < okResult.length; i++) {
            char vehicle = okResult[i];
            

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
        return requiredTime;
        
    }
    
}





