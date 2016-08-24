package com.nrdc.services;


import com.nrdc.entities.Movie;
import com.nrdc.entities.Studio;
import com.nrdc.enums.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.nrdc.repositories.IMovieRepository;

import java.util.Date;
import java.util.List;

@Service

public class MovieService {
    private IMovieRepository repository;

    @Autowired
    public void setRepository(IMovieRepository repository){
        this.repository = repository;
    }

    public Page<Movie> findAll(int page) {
        PageRequest pr = new PageRequest(page, 3);
        return this.repository.findAll(pr);
    }

    public Movie findByName(String name) {
        return this.repository.findByName(name);
    }

    public List<Movie> findByRatingOrderByReleasedDesc(Rating rating) {
        return this.repository.findByRatingOrderByReleasedDesc(rating);
    }
    public Movie findOne(int id) {
        return this.repository.findOne(id);
    }

    public Movie create(Movie m) {
        return this.repository.save(m);
    }

    public void destroy(int id) {
        this.repository.delete(id);
    }

    public Movie update(int id, Movie m) {
        Movie movie = this.repository.findOne(id);
        movie.setName(m.getName());
        movie.setReleased(m.getReleased());
        return this.repository.save(movie);
    }
}
