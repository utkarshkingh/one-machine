package org.faps;

import java.util.Scanner;

public class resources {

     
    String name;
    int carTime;
    int truckTime;
    float changeTime;
    boolean status = true;  //true = machine free

    Scanner sc=new Scanner(System.in);
    
    
     
    public resources(){

    }                                        

    public resources(String name,int carTime,int truckTime,float changeTime,boolean status) {

         this.name = name;
         this.carTime= carTime;
         this.truckTime=truckTime;
         this.changeTime=changeTime;
         this.status=status;

    }




public boolean isFree() {
     return status;
 }

    public String getName() {
         return this.name;
    }

    public void setName(String name) {
         this.name =name;
    }

    public int getCarTime() {
         return this.carTime;
    }

    public int setCarTime(int carTime) {
         return this.carTime;
    }

    public int getTruckTime() {
         return this.truckTime;
    }

    public int setTruckTime(int truckTime) {
         return this.truckTime;
    }

    public float getChangeTime() {
         return this.changeTime;
    }

    public float setChangeTime(int changeTime) {
         return this.changeTime;
    }

}
