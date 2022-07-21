package com.zacisrael;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Theater potomacYard = new Theater("Potomac Yard", 8, 12);

        if(potomacYard.reserveSeat("D12")){
            System.out.println( "Please pay for D12");
        } else{
            System.out.println("Seat is already reserved");
        }

        if(potomacYard.reserveSeat("B13")){
            System.out.println( "Please pay for B13");
        } else{
            System.out.println("Seat is already reserved");
        }

       List<Theater.Seat> reverseSeats = new ArrayList<>(potomacYard.getSeats());
        Collections.reverse(reverseSeats);
        printList(reverseSeats);

        List<Theater.Seat> priceSeats = new ArrayList<>(potomacYard.getSeats());
        priceSeats.add(potomacYard.new Seat("B00", 13.00));
        priceSeats.add(potomacYard.new Seat("A00", 13.00));
        Collections.sort(priceSeats, Theater.PRICE_ORDER);
        printList(priceSeats);



       // Collections.shuffle(seatCopy); // shows any list in a random order
      //  Collections.reverse(seatCopy); // reverses order of any list
//        Theater.Seat minSeat = Collections.min(seatCopy); // gets the minimum seat number / the first element in the sorted list
//        Theater.Seat maxSeat = Collections.max(seatCopy); // gets the maximum seat number / the last element in the sorted list



    }

    public static void printList(List<Theater.Seat> list){

        for (Theater.Seat seat: list) {
            System.out.print(" " + seat.getSeatNumber() + " " + seat.getPrice());
        }
        System.out.println();
        System.out.println("==============================");
    }


}
