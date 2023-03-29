package ro.pao.model;


import lombok.*;
import ro.pao.model.abstracts.AbstractEntity;
import ro.pao.model.enums.VehicleType;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Driver extends AbstractEntity {
    private String firstName;
    private String lastName;
    private String userName;
    private UUID accountId;
    private VehicleType vehicleType;
}
