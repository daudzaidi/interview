package DesignQuestions.ParkingManagementSystem;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shalvi on 19/06/16.
 */
public class ParkingSystem {
    Map<Vehicle,Ticket> ticketsIssuedToVehicleMap = new HashMap<>();
    SlotAllocator slotAllocator;
    PriceAllocator priceAllocator;
    TicketIssuer ticketIssuer;

    public volatile ParkingSystem parkingSystemInstance = null;

    private ParkingSystem(){};

    public ParkingSystem getParkingSystemInstance(){

        if(parkingSystemInstance == null){
            synchronized (ParkingSystem.class){
                if(parkingSystemInstance == null){
                    parkingSystemInstance = new ParkingSystem();
                }
            }
        }
        return parkingSystemInstance;
    }

    public double returnPrice(Vehicle vehicle){
        return 0;
    }

    public void issueTicket(Vehicle vehicle){

    }
}
