package Services;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ReservationServices {
    private ReserveRoom reserveRoom;
    private ReservationsLookUp reservationsLookUp;
    private UpdateReservation updateReservation;
    private DeleteReservation deleteReservation;

    public ReservationServices(Connection connection, Scanner scanner){
        this.reserveRoom = new ReserveRoom(connection,scanner);
        this.reservationsLookUp = new ReservationsLookUp(connection,scanner);
        this.updateReservation = new UpdateReservation(connection,scanner);
        this.deleteReservation = new DeleteReservation(connection,scanner);
    }
    public void allotRoom()throws SQLException {
        this.reserveRoom.allotRoom();
    }

    public void lookUP() throws SQLException{
        this.reservationsLookUp.lookUp();
    }

    public void getRoomNumber() throws SQLException{
        this.reservationsLookUp.getRoomNumber();
    }

    public void updateReservation() throws SQLException{
        this.updateReservation.update();
    }
    public void deleteReservation() throws SQLException{
        this.deleteReservation.deleteReservation();
    }

}
