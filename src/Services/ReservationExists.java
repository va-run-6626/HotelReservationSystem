package Services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReservationExists {
    private final Statement statement;
    protected ReservationExists(Statement statement){
        this.statement = statement;
    }
    protected boolean reservationExists(int reservationID)throws SQLException {
        String query = "SELECT reservationID from reservations WHERE reservationID = "+reservationID+";";
        ResultSet resultSet = this.statement.executeQuery(query);
        return resultSet.next();
    }
}
