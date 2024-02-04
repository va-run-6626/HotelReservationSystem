

import Initialization.DataBase;
import Services.StartApplication;

import java.sql.SQLException;

public class HotelReservationSystem{
    private final DataBase database;
    public HotelReservationSystem() throws SQLException, ClassNotFoundException {
        this.database = new DataBase();
        this.database.initalizeDatabase();
        StartApplication startApplication = new StartApplication(database.getStatement());
        startApplication.startApplication();
        this.database.closeDatabase();
    }

    public static void main(String[] args) {
        try {
            HotelReservationSystem hotelReservationSystem = new HotelReservationSystem();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
