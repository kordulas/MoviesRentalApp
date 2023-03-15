package com.movielibrary.demo.movie.api;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Movies")
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Movie implements Comparable<Movie> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long movieId;
    @Column(name = "Title")
    private String movieTitle;
    @Column(name = "Release_year ")
    private int releaseYear;
    @Column(name = "Movie_genre")
    private String movieGenre;
    @Column(name = "Is_movie_rented")
    private boolean isRented;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "director_Id")
    private Director director;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Movie movie = (Movie) o;
        return movieId != null && Objects.equals(movieId, movie.movieId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public int compareTo(Movie o) {
        return this.movieTitle.compareTo(o.getMovieTitle());
    }
}
