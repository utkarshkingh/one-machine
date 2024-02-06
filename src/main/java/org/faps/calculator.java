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

/* 
    public Response processOrder(char vehicle) {
        if (obj.status) {
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                public void run() {
                    
                    System.out.println("Processing order for vehicle: " + vehicle);
                    obj.status = true; 
                    timer.cancel();
                
                }
            };
            timer.schedule(task, calculateTotalTimeForLastItem());
            obj.status=false;

        }
        return Response.ok("Machine busy").build()  ;
    }

    */


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



    /* 
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
        
        
    }    */

@POST
@Path("/postorder")
@Consumes(MediaType.TEXT_PLAIN)
public Response postOrder(String input) {
    if (!stopAppending) {
        if (obj.status==false) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Machine is busy. Please try again later.").build();
        }

        result.append(input); 

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                
                obj.status=false; 
                timer.cancel();                
            }
        };
      
        timer.schedule(task,calculateTotalTimeForLastItem());
        obj.status=true; 

       
        if (input.contains("x")) {
            stopAppending = true;
        }
    }

    return Response.ok("Order received: " + input).build(); 
}
}

