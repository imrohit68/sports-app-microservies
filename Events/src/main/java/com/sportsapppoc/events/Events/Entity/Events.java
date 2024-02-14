package com.sportsapppoc.events.Events.Entity;

import com.sportsapppoc.events.Events.Enum.SportsCategories;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String mobileNumber;
    private LocalDateTime eventCreatedTime;
    private LocalDateTime eventTime;
    private String imageUrl;
    @Enumerated(EnumType.STRING)
    private SportsCategories sportsName;
    private String latitude;
    private String longitude;
}
