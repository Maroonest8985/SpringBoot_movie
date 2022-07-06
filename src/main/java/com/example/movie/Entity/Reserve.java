package com.example.movie.Entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="Reserve")
public class Reserve {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)


}
