package Services;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ReserveRoom {
    private final Statement statement;
    private final Scanner scanner;
    public ReserveRoom(Statement statement, Scanner scanner){
            this.statement = statement;
            this.scanner = scanner;
    }
    public void allotRoom() throws SQLException{
        System.out.print("Enter Guest Name :");
        String name = this.scanner.next();
        this.scanner.nextLine();
        System.out.print("Enter Room Number: ");
        int roomNumber = scanner.nextInt();
        System.out.print("Enter Contact Number: ");
        String contactNumber = scanner.next();

        String query = "INSERT INTO reservations (guestName,roomNo,contactNumber)VALUES('"+name+"', "+
                roomNumber+",'"+contactNumber+"');";
        int affectedRows = this.statement.executeUpdate(query);
        if(affectedRows > 0){
            System.out.println("Reservation Successful!!");
        }else{
            System.out.println("Reservation Failed!");
        }
        System.out.println();
    }
}
