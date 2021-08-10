package com.techelevator.dao;

import static org.junit.Assert.assertEquals;

import javax.sql.DataSource;

import com.techelevator.model.Beer;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import com.techelevator.model.Review;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.techelevator.model.Review;

public class ReviewJdbcDaoTest extends FinalCapstoneDaoTests {

private static final Review REVIEW_1 = new Review (1, "Brandon Czekalski", "I love this place", "Hitchhiker is a really cool brewery.", 4, "Brewery", 4, 1);
private static final Review REVIEW_2 = new Review (2, "Brandon Czekalski", "This place is okay", "Eleventh Hour has really interesting beers, but the atmosphere in the tap room sucks.", 3, "Brewery", 4, 2);
private static final Review REVIEW_4 = new Review (4, "Celeste", "Worst service ever", "Church Brew sucks.", 1, "Brewery", 5, 3);
private static final Review REVIEW_5 = new Review (5, "Brandon Czekalski", "Do not recommend", "Cosmic Void tastes okay.", 2, "Beer", 4, 1);

private static final Beer BEER_1= new Beer(9, "Southern Tier Nu Haze", "IPA", "Citrus and ripe melon notes in this hazy IPA", 6.0F,
            "https://churchbrew.com/wp-content/themes/yeast/img/logo.png", false, 3);
private static final Beer BEER_2 = new Beer(8, "Tropical Seltzer", "Seltzer", "A crisp mango infused seltzer.  One hundred calories of refreshment!", 4.8F,
            "https://churchbrew.com/wp-content/themes/yeast/img/logo.png", false, 3);
private static final Beer BEER_3 = new Beer(1, "Cosmic Void", "IPA", "Brewed and dry hopped with Sabro. Notes of Pineapple, Coconut, Tropical Fruit, and Cedar.", 7.0F,
            "https://hitchhiker.beer/wp-content/uploads/HHBC_CosmicVoid_bc_01102019_CMYK.jpg", false, 1);
private static final Beer BEER_4 = new Beer(3, "Fruit Rush- Raspberry", "Smoothie Sour Shandy", "Brewed with Oats and Wheat. Conditioned on Lemon and Raspberry.", 4.8F,
            "https://hitchhiker.beer/wp-content/uploads/HHBC_FruitRushRaspberry_bc_49375x7-1200x757.jpg", false, 1);

private JdbcTemplate template;
private JdbcReviewDao reviewDao;

    @Before
    public void setup() {
        DataSource dataSource = this.getDataSource();
        template = new JdbcTemplate(dataSource);
        reviewDao = new JdbcReviewDao(template);
        Review testReview = new Review();


    }

}
