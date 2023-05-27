package ro.pao.mapper;


import ro.pao.model.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ClientMapper {

    private static final ClientMapper INSTANCE = new ClientMapper();

    private ClientMapper() {
    }

    public static ClientMapper getInstance() {
        return INSTANCE;
    }


    public static Optional<Client> mapClientClass(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Client.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .firstName(resultSet.getString(2))
                            .lastName(resultSet.getString(3))
                            .userName(resultSet.getString(4))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public static List<Client> mapToClientList(ResultSet resultSet) throws SQLException {
        List<Client> clientList = new ArrayList<>();
        while (resultSet.next()) {
            clientList.add(
                    Client.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .firstName(resultSet.getString(2))
                            .lastName(resultSet.getString(3))
                            .userName(resultSet.getString(4))
                            .build()
            );
        }

        return clientList;
    }
}
