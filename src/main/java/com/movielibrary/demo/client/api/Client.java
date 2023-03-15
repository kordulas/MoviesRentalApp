package com.movielibrary.demo.client.api;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name="clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long id;
    @Column(name = "First_Name", nullable = false, unique = false)
    private String firstName;
    @Column(name = "Last_Name", nullable = false, unique = false)
    private String lastName;
    @Column(name = "Birthday", nullable = false, unique = false)
    private LocalDate birthdate;
    @Column(name = "Pesel_Number", nullable = false, unique = true)
    private Long peselNumber;
    @Column(name = "Contact_Number", unique = true)
    @Nullable
    private String contactNumber;
    @Column(name = "Contact_Email",unique = true)
    private String contactEmail;
}
