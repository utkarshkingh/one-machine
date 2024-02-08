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
public class process {

     StringBuilder result = new StringBuilder();
     boolean stopAppending = false;
     machines obj = new machines("machine1" ,4,7,1,true);
    
    

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response seeorder(){

         return Response.ok("Your orders are :"+ result.toString()).build() ;

    }

    @GET
    @Path("/total")
    @Produces(MediaType.TEXT_PLAIN)
    public Response Totaltime()  {


    
        int requiredTime = 0;
        char lastVehicle = ' ';
           
        for (int i = 0; i < result.toString().toCharArray().length; i++) {
            char vehicle = result.toString().toCharArray()[i];
                       
           if (vehicle == 'c' ) {

                requiredTime +=obj.getCarTime();
                               
            } else if (vehicle == 't') {
                requiredTime += obj.getTruckTime();
            }

            if (i > 0 && lastVehicle != ' ' && lastVehicle != vehicle) {
                requiredTime += obj.getChangeTime();
            }

            lastVehicle = vehicle;
        }
        
        return Response.ok("Your total time is :"+ requiredTime+"hrs").build() ;
        
        
    }

private int calculateTotalTimeForLastItem() {
    int thisTime = 0;
    char lastVehicle = result.charAt(result.length() - 1); 

    if (lastVehicle == 'c') {
        thisTime += obj.getCarTime();
    } else if (lastVehicle == 't') {
        thisTime += obj.getTruckTime();
    }

    
    if (result.length() >= 2 && result.charAt(result.length() - 2) == 'c' && lastVehicle == 't') {
        thisTime +=  obj.getChangeTime() ; 
    }

    return thisTime;
}



    

    Timer timer = new Timer();

    @POST
    @Path("/postorder")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response postOrder(String input) {
        long startTime = System.nanoTime();
        
        if (!stopAppending) {
            if (obj.status == false) { // true=free
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Machine is busy. Please try again after " + calculateTotalTimeForLastItem() + " seconds").build();
            }
            //long startTime = System.nanoTime();
            result.append(input);
            
            
            obj.status = false;
    
            TimerTask task = new TimerTask() {
                public void run() {
                    obj.status = true;
                    this.cancel();
                    
                }
            };
    
            timer.schedule(task, calculateTotalTimeForLastItem()*1000);
            

            if (input.contains("x")) {
                stopAppending = true;
                long endTime = System.nanoTime();
                long duration = (endTime - startTime);
                return Response.ok("Total elapsed time is  " + duration).build();

            }
        }
    
        return Response.ok("Order received: " + input).build();
    }
    
}

