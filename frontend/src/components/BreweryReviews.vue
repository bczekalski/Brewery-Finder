<template>
    <div class="brewery-review-container container-blur" id="brewery-reviews">
        <div class="brewery-review-container blur-container">
            <div id="add-review">
                <button v-if="showForm === false" v-on:click.prevent="showForm = true">Add Review</button>
                <h2 id="no-reviews" v-if="!allReviews.length">No reviews! Be the first to write one!</h2>
            </div>
            <form id="add-review-form" v-if="showForm===true" v-on:submit.prevent="addReview">
                <div id = "review-details" v-for="newReview in allReviews" v-bind:key="newReview.id">
                </div>
                <div class="form-element">
                    <textarea class="review-text" placeholder="What did you think of this brewery?" v-model="newReview.text"/>
                </div>
                <div class="form-element">
                    <input type="text" class="review-name" placeholder="what is your name" v-model="newReview.name"/>
                </div>
                <div class="form-element">
                    <input type="text" class="review-name" placeholder="are you reviewing a beer or brewery?" v-model="newReview.type"/>
                    <div class="form-element">
                        <label for="review-starRating">Rating:</label>
                        <select name="review-starRating" id="review-starRating" v-model="newReview.starCount">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>
                    </div>
                </div>
                <div class="buttons-div">
                    <input type="submit" value="Save Review" class='form-btns' v-on:click="addReview">
                    <input type="button" value="Cancel" class='form-btns' v-on:click.prevent="resetForm">
                </div>
            </form>
        </div>
    </div>
</template>

<script>
import reviewService from '../services/ReviewService'
export default {
    name: 'brewery-reviews',
    data(){
        return {
            showForm: false,
            allReviews: {},
           newReview: {
            name: 'name',
            title: 'NA',
            text: '',
            starCount: 3,
            type: 'Brewery',
            targetId: this.$route.params.breweryId
            }
        }
    },
     methods: {
        resetForm() {
            this.showForm = false;
        },

        addReviewToArray() {
            this.allReviews.push(this.newReview);
        },

        addReview() {
            reviewService.createReview1(this.newReview)
            .then(response=> {
                if (response.status === 201) {
                    this.resetForm();
                    this.addReviewToArray();
                }
            })
        },
    created() {
        reviewService.getBreweryReviews(this.$route.params.breweryId).then((response) => {
            this.allReviews = response.data;
        })
    }
}
}
</script>
<style>


.brewery-review-container {
    font-family: 'Poppins', sans-serif;
    font-size: 2vw;
    text-align: left;
    display: block;
    border-radius:3vw;
    padding: 3vw;
    justify-content: space-evenly;
    justify-items: center;
    align-content: space-evenly;
    align-items: center;
    margin-left: 20vw;
    margin-right: 20vw;
}


</style>