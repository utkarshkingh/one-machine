package org.faps;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.time.Duration;
import java.util.Scanner;


public class Totaltime  {

    
    private int elapsedTime = 0;

    main obj=new main();
    char[] order=obj.getArray();

    machines machine = new machines();

    public int RequiredTime()  {
        int requiredTime = 0;
        char lastVehicle = ' ';

        for (int i = 0; i < order.length; i++) {
            char vehicle = order[i];

            if (vehicle == 'c') {
                requiredTime += 2;
            } else if (vehicle == 't') {
                requiredTime += 4;
            }

            if (i > 0 && lastVehicle != ' ' && lastVehicle != vehicle) {
                requiredTime += 0.5f;
            }

            lastVehicle = vehicle;
        }
        
        System.out.println("Total required time for the sequence = " +requiredTime);
        elapsedTime = requiredTime;
        return requiredTime;
        
    }
    
}





