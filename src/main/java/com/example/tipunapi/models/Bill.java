package com.example.tipunapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String createDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User billUser;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;
}
