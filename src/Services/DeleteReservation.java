package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteReservation extends ReservationExists{
    private final Connection connection;
    private final Scanner scanner;
    public DeleteReservation(Connection connection, Scanner scanner){
        super(connection);
        this.connection = connection;
        this.scanner = scanner;
    }
    public void deleteReservation()throws SQLException {
        System.out.print("Enter Reservation ID to Delete: ");
        int reservationId = this.scanner.nextInt();
        if(!reservationExists(reservationId)){
            System.out.println("Reservation ID not found!!");
        }
        String query = "DELETE FROM reservations WHERE reservationID = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setInt(1,reservationId);

        int affectedrows = preparedStatement.executeUpdate();
        if(affectedrows > 0){
            System.out.println("Reservation Deleted successfully!");
        }else{
            System.out.println("Reservation Deletion Failed!");
        }
        System.out.println();
    }
}
