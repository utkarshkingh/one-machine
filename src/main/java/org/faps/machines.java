package org.faps;

public class machines {

     
    String name;
     
    int carTime;
     
    int truckTime;
    
    float changeTime;
    
     
    public machines(){

    }                                        

    public machines(String name,int carTime,int truckTime,float changeTime) {

         this.name = name;
         this.carTime= carTime;
         this.truckTime=truckTime;
         this.changeTime=changeTime;

    }



    public String getName() {
         return this.name;
    }

    public void setName(String name) {
         this.name = "machine1";
    }

    public int getCarTime() {
         return this.carTime;
    }

    public int setCarTime(int carTime) {
         return 2;
    }

    public int getTruckTime() {
         return this.truckTime;
    }

    public int setTruckTime(int truckTime) {
         return 4;
    }

    public float getChangeTime() {
         return this.changeTime;
    }

    public float setChangeTime(int changeTime) {
         return 0.5f;
    }

}
