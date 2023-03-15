package com.movielibrary.demo.library_card.api;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Library_Cards")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class LibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long cardId;
    @Column(name = "Card_Owner_Id")
    private Long cardOwnerId;
    @Column
    private LocalDate createDate;
    @Column
    private LocalDate expirationDate;
}
