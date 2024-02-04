package Services;

import java.sql.*;

public class ReservationExists {
    private final Connection connection;
    protected ReservationExists(Connection connection){
        this.connection = connection;
    }
    protected boolean reservationExists(int reservationID)throws SQLException {
        String query = "SELECT reservationID from reservations WHERE reservationID = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setInt(1,reservationID);

        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }
}
