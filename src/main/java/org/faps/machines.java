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

    public void setCarTime(int carTime) {
         this.carTime = carTime;
    }

    public int getTruckTime() {
         return this.truckTime;
    }

    public void setTruckTime(int truckTime) {
         this.truckTime = truckTime;
    }

    public float getChangeTime() {
         return this.changeTime;
    }

    public void setChangeTime(int changeTime) {
         this.changeTime = changeTime;
    }

}
