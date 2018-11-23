package com.projects.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.projects.data.entity.Guest;

@Repository
public interface GuestRepository extends PagingAndSortingRepository<Guest, Long> {


}