package org.faps;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;


@Path("/times")
public class demo {

    static StringBuilder result = new StringBuilder();
    private static boolean stopAppending = false;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response seeorder(){

         return Response.ok("Your orders are :"+result.toString()).build() ;

    }

/* --------------------------------------------------------------------------- */

   /*  @GET
    @Produces(MediaType.TEXT_PLAIN)
    public int getTotalTime(){

        return 0 ;
          
    } */

    /* --------------------------------------------------------------------------- */

    @POST
    @Path("/postorder")
    @Consumes(MediaType.TEXT_PLAIN)
    public static char[] postOrder(String input)
    {
        
        if (!stopAppending) {
            result.append(input);

            // Check if the input contains the character 'x'
            if (input.contains("x")) {
                stopAppending = true;
            }
        }

        
         return result.toString().toCharArray();
         
        
        
    }  

}
