package org.faps;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import java.util.Timer;
import java.util.TimerTask;


@Path("/calculate")
public class calculator {

     StringBuilder result = new StringBuilder();
     boolean stopAppending = false;
     machines obj = new machines("machine1" ,2,4,0.5f,true);

    

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response seeorder(){

         return Response.ok("Your orders are :"+ result.toString()).build() ;

    }


    public void processOrder(char vehicle) {
        if (obj.status) {
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                public void run() {
                    // Process order here
                    System.out.println("Processing order for vehicle: " + vehicle);
                    obj.status = true; // Set the machine status to free after processing
                    timer.cancel();
                }
            };
            timer.schedule(task, calculateProcessingTime(vehicle));
            obj.status = false; // Set the machine status to busy
        }
    }


    @GET
    @Path("/total")
    @Produces(MediaType.TEXT_PLAIN)
    public Response Totaltime()  {


    
        int requiredTime = 0;
        char lastVehicle = ' ';
           
        for (int i = 0; i < result.toString().toCharArray().length; i++) {
            char vehicle = result.toString().toCharArray()[i];
                       
           if (vehicle == 'c' && obj.status==true  ) {

                requiredTime =obj.getCarTime();
                               
            } else if (vehicle == 't') {
                requiredTime += obj.getTruckTime();
            }

            if (i > 0 && lastVehicle != ' ' && lastVehicle != vehicle) {
                requiredTime += obj.getChangeTime();
            }

            lastVehicle = vehicle; 
        }
        
        return Response.ok("Your total time is :"+ requiredTime).build() ;
        
        
    }

    @POST
    @Path("/postorder")
    @Consumes(MediaType.TEXT_PLAIN)
    public  String postOrder(String input) {


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

