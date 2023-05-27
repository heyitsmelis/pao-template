package ro.pao.mapper;


import ro.pao.model.Driver;
import ro.pao.model.enums.VehicleType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DriverMapper {

    private static final DriverMapper INSTANCE = new DriverMapper();

    private DriverMapper() {
    }

    public static DriverMapper getInstance() {
        return INSTANCE;
    }


    public static Optional<Driver> mapDriverClass(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Driver.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .firstName(resultSet.getString(2))
                            .lastName(resultSet.getString(3))
                            .userName(resultSet.getString(4))
                            .vehicleType(VehicleType.valueOf(resultSet.getString(5)))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public static List<Driver> mapToClientList(ResultSet resultSet) throws SQLException {
        List<Driver> driverList = new ArrayList<>();
        while (resultSet.next()) {
            driverList.add(
                    Driver.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .firstName(resultSet.getString(2))
                            .lastName(resultSet.getString(3))
                            .userName(resultSet.getString(4))
                            .vehicleType(VehicleType.valueOf(resultSet.getString(5)))
                            .build()
            );
        }

        return driverList;
    }
}