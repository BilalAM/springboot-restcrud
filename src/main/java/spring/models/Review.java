package spring.models;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name = "Review")
public class Review {

	@Id
	@Column(name = "reviewId")
	private int reviewId;

	@Column(name = "reviewText")
	private String reviewText;

	@Column(name = "reviewTimeStamp")
	private String timeStamp;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reviewItemId", nullable = false)
	private Item reviewedItem;

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Item getReviewedItem() {
		return reviewedItem;
	}

	public void setReviewedItem(Item reviewedItem) {
		this.reviewedItem = reviewedItem;
	}

}
