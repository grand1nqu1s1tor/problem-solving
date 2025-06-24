package parkinglot;

import java.util.*;

public class ParkingLotService {
    private List<ParkingSlot> slots;
    //activeTickets maps ticket IDs to parked vehicle details, letting us track and manage all ongoing parking sessions.
    // It's used to quickly unpark vehicles by validating and freeing the correct slot.
    private Map<String, Ticket> activeTickets;
    private int nextTicketId = 1;

    public ParkingLotService(List<ParkingSlot> slots) {
        this.slots = slots;
        this.activeTickets = new HashMap<>();
    }

    //Dead simple algo to scan for available spot in O(N) time
    public Ticket parkVehicle(Vehicle vehicle) {
        for (ParkingSlot slot : slots) {
            //Check for an unoccupied slot for type of the vehicle
            if (!slot.isOccupied() && slot.getSlotType() == vehicle.getType()) {
                slot.setOccupied(true);
                slot.setCurrentVehicle(vehicle);

                String ticketId = "TICKET-" + nextTicketId++;
                Ticket ticket = new Ticket(ticketId, vehicle, slot.getNumber());
                activeTickets.put(ticketId, ticket);

                System.out.println("Parked " + vehicle.getLicenseNumber() + " at slot " + slot.getNumber());
                return ticket;
            }
        }
        System.out.println("No available slot for vehicle type: " + vehicle.getType());
        return null;
    }


    /*  FOLLOW UP : OPTIMIZED ALGORTIHM FOR NEAREST SLOT AVAILABLE PARKING
    - Similar typed slots are linked together in the queue
    -
    Map<VehicleType, Queue<ParkingSlot>> slotMap = new HashMap<>();
    slotMap.put(VehicleType.CAR, new LinkedList<>());
    slotMap.put(VehicleType.BIKE, new LinkedList<>());

    - Initializing the slots for the first time
    for (ParkingSlot slot : allSlots) {
        slotMap.get(slot.getSlotType()).offer(slot);
    }
    */

    public void unparkVehicle(String ticketId) {
        Ticket ticket = activeTickets.remove(ticketId);
        if (ticket == null) {
            System.out.println("Invalid ticket: " + ticketId);
            return;
        }

        int slotNumber = ticket.getSlotNumber();

        for (ParkingSlot slot : slots) {
            if (slot.getNumber() == slotNumber) {
                slot.setOccupied(false);
                slot.setCurrentVehicle(null);
                System.out.println("Unparked vehicle from slot " + slotNumber);
                return;
            }
        }

        System.out.println("Slot not found for ticket: " + ticketId);
    }

    public void showAvailableSlots() {
        System.out.println("Available Slots:");
        for (ParkingSlot slot : slots) {
            if (!slot.isOccupied()) {
                System.out.println("Slot " + slot.getNumber() + " [" + slot.getSlotType() + "]");
            }
        }
    }
}

