package com.asad.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users3")
public class User {

    @Id
    @GeneratedValue(generator="user_id_sequence")
    @SequenceGenerator(name="user_id_sequence",
            sequenceName="user_id_sequence", allocationSize=1)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
}
