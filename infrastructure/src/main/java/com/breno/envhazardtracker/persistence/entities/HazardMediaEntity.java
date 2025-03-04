package com.breno.envhazardtracker.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "hazard_media")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class HazardMediaEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 4766390322412690405L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @ManyToOne
    @JoinColumn(name = "hazard_id", nullable = false)
    private HazardEntity hazard;

    @ManyToOne
    @JoinColumn(name = "media_id", nullable = false)
    private MediaEntity media;

}
