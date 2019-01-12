package com.amm.cloud.basic.bk.ratingservice.interfaces;

import com.amm.cloud.basic.bk.ratingservice.domain.Rating;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private List<Rating> ratingList = Arrays.asList(
            new Rating(1L, 1L, 2),
            new Rating(2L, 1L, 3),
            new Rating(3L, 2L, 4),
            new Rating(4L, 2L, 5)
    );

    @GetMapping("/{ratingId}")
    public Rating findRatingsByBookId(@PathVariable Long ratingId) {
        return ratingList.stream().filter(b -> b.getId().equals(ratingId)).findFirst().orElse(new Rating(1L, 1L, 2));
    }

    @GetMapping("/all")
    public List<Rating> findAllRatings() {
        return ratingList;
    }

}
