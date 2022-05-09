package com.example.tipunapi.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "utilities")
public class Utilities implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String icon;

    @ManyToMany(mappedBy = "roomUtilities")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Room> rooms;
}
