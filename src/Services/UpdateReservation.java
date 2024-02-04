package Services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateReservation extends ReservationExists{
    private final Statement statement;
    private final Scanner scanner;
    public UpdateReservation(Statement statement, Scanner scanner){
        super(statement);
        this.statement = statement;
        this.scanner = scanner;
    }
    public void update()throws SQLException{
        System.out.println("Enter Reservation ID to update: ");
        int reservationID = this.scanner.nextInt();
        this.scanner.nextLine();
        if(!reservationExists(reservationID)){
            System.out.println("No such Reservation ID exists !!!");
            return;
        }
        System.out.print("Enter new Guest Name : ");
        String name = this.scanner.nextLine();
        System.out.print("Enter new Room Number: ");
        int roomNo = this.scanner.nextInt();
        System.out.print("Enter new Contact Number :");
        String contactNumber = this.scanner.next();

        String query = "UPDATE reservations SET guestName = '"+name+"', roomNo = "+roomNo+", contactNumber = '"+ contactNumber+"' "+"WHERE reservationID = "+ reservationID+";";
        int affectedRows = this.statement.executeUpdate(query);
        if(affectedRows > 0){
            System.out.println("Reservation Updates Successfully !!!");
        }else{
            System.out.println("Reservation update Failed!!");
        }
    }
}
