package com.amm.cloud.basic.bk.ratingservice.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RatingRepository extends CrudRepository<Rating,Long> {
    List<Rating> findByRatingById(Long bookId);
}
