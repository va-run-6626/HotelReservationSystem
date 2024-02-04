package Services;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StartApplication {
    private final Statement statement;
    public StartApplication(Statement statement){
        this.statement = statement;
    }
    public void startApplication(){
        try{
            Scanner sc = new Scanner(System.in);
            ReservationServices reservationServices = new ReservationServices(this.statement, sc);
            CloseApplication closeApplication = new CloseApplication();
            while(true){
                System.out.println();
                System.out.println("HOTEL MANAGEMENT SYSTEM");
                System.out.println("1. Reserve a Room");
                System.out.println("2. View Reservations");
                System.out.println("3. Get Room Number");
                System.out.println("4. Update Reservations");
                System.out.println("5. Delete Reservations");
                System.out.println("0. Exit");
                System.out.print("Choose an Option : ");
                int choice = sc.nextInt();
                switch (choice){
                    case 1:{
                        reservationServices.allotRoom();
                        break;
                    }
                    case 2:{
                        reservationServices.lookUP();
                        break;
                    }
                    case 3:{
                        reservationServices.getRoomNumber();
                        break;
                    }
                    case 4:{
                        reservationServices.updateReservation();
                        break;
                    }
                    case 5:{
                        reservationServices.deleteReservation();
                        break;
                    }
                    case 0:{
                        closeApplication.exit();
                        sc.close();
                        return;
                    }
                    default:{
                        System.out.println("Invalid choce --> Try Again!!");
                    }
                }
            }
        }catch (SQLException  e){
            e.printStackTrace();
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
