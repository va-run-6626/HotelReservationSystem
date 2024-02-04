package Services;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteReservation extends ReservationExists{
    private final Statement statement;
    private final Scanner scanner;
    public DeleteReservation(Statement statement, Scanner scanner){
        super(statement);
        this.statement = statement;
        this.scanner = scanner;
    }
    public void deleteReservation()throws SQLException {
        System.out.print("Enter Reservation ID to Delete: ");
        int reservationId = this.scanner.nextInt();
        if(!reservationExists(reservationId)){
            System.out.println("Reservation ID not found!!");
        }
        String query = "DELETE FROM reservations WHERE reservationID = "+ reservationId+";";
        int affectedrows = this.statement.executeUpdate(query);
        if(affectedrows > 0){
            System.out.println("Reservation Deleted successfully!");
        }else{
            System.out.println("Reservation Deletion Failed!");
        }
        System.out.println();
    }
}
