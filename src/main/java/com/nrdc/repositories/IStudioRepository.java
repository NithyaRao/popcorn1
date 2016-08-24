package com.nrdc.repositories;


import com.nrdc.entities.Studio;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IStudioRepository extends PagingAndSortingRepository<Studio, Integer>{
}
