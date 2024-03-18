package com.system.Attendance.domain;

import com.system.Attendance.enums.LocationType;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
public class Location implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private LocationType locationType;

    public Location() {
    }

    public Location(String name, String description, LocationType locationType) {
        this.name = name;
        this.description = description;
        this.locationType = locationType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }
}
