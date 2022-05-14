package com.example.tipunapi.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullname;
    @Column(name = "username", unique = true)
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "gender")
    private String gender;
    @Column(name = "dob")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dob;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "postUser", fetch = FetchType.EAGER)
    private List<Room> postedRooms;


    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinTable(name = "favorite_room",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "room_id")
    )
    private List<Room> favoriteRooms;
}
