package domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Location {

    enum LocationType {
        DINING,
        CLASSROOM,
        LIBRARY,
        GYM
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "location_type")
    private LocationType locationType;

}
