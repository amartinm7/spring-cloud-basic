package com.amm.cloud.basic.bk.ratingservice.interfaces;

import com.amm.cloud.basic.bk.ratingservice.domain.Rating;
import com.amm.cloud.basic.bk.ratingservice.infrastructure.exception.RatingIdMismatchException;
import com.amm.cloud.basic.bk.ratingservice.infrastructure.exception.RatingNotFoundException;
import com.amm.cloud.basic.bk.ratingservice.domain.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import java.util.List;


public class RatingController {
    @Autowired
    private RatingRepository ratingRepository;

    @GetMapping
    public List<Rating> findRatingsByBookId(
            @RequestParam(required = false, defaultValue = "0") Long bookId) {
        return ratingRepository.findByRatingById(bookId);
    }

    @PostMapping
    public Rating createRating(@RequestBody Rating rating) {
        return ratingRepository.save(rating);
    }

    @DeleteMapping("/{ratingId}")
    public void deleteRating(@PathVariable Long ratingId) {
        ratingRepository.deleteById(ratingId);
    }

    @PatchMapping("/{ratingId}")
    public Rating updateRating(@RequestBody Rating rating, @PathVariable Long id) {
        if (rating.getId() != id) {
            throw new RatingIdMismatchException();
        }
        ratingRepository.findById(id)
                .orElseThrow(RatingNotFoundException::new);
        return ratingRepository.save(rating);
    }

}
