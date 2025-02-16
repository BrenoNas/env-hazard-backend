package com.breno.envhazardtracker.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "hazard_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class HazardTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, unique = true, length = 100)
    private String name;
}
