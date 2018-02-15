package spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.models.Item;
import spring.models.Review;
import spring.models.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepo;

	public void deleteReview(int reviewId) {
		reviewRepo.delete(reviewId);
	}

	public void deleteAllReviews(Item item) {
		for (Review review : item.getReviews()) {
			reviewRepo.delete(review);
		}
	}

}
