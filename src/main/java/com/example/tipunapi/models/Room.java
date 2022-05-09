package com.example.tipunapi.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "phone_contact")
    private String phone_contact;
    @Column(name = "acreage")
    private double acreage;
    @Column(name = "type")
    private String type;
    @Column(name = "capacity")
    private int capacity;
    @Column(name = "gender_allow")
    private String gender_allow;
    @Column(name = "price")
    private double price;
    @Column(name = "water_price")
    private double water_price;
    @Column(name = "electric_price")
    private double electric_price;
    private String street_name;
    private String building;
    private String district;
    private String province;
    private String commune;
    private String city;


    @OneToMany
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private List<RoomImages> room_image;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User postUser;

    @ManyToMany(mappedBy = "favoriteRooms")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<User> favoriteUsers;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude

    @JoinTable(name = "room_utilities",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "utilities_id")
    )
    private List<Utilities> roomUtilities;
}
