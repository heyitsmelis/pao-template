package ro.pao.model;


import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.pao.model.abstracts.AbstractEntity;
import ro.pao.model.enums.VehicleType;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@SuperBuilder
public class Driver extends AbstractEntity {
    private UUID driver_id;
    private String firstName;
    private String lastName;
    private String userName;
    private VehicleType vehicleType;

    public String getDriverStringField() {
        return null;
    }
}
