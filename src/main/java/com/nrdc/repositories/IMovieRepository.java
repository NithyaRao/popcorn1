package com.nrdc.repositories;


import com.nrdc.entities.Movie;
import com.nrdc.enums.Rating;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IMovieRepository extends PagingAndSortingRepository<Movie, Integer>{
    public Movie findByName(String name);
    public List<Movie> findByRatingOrderByReleasedDesc(Rating rating);

}
