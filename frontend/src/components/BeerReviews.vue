<template>
    <div id="beer-reviews">
    <h2 v-if="!allReviews.length">No Reviews! Be the first to write one!</h2>
 <div id='new-beer-form-container'>
         <button v-if="showForm === false" v-on:click.prevent="showForm = true">Add Review</button>
      <form id="add-review-form" v-if="showForm===true" v-on:submit.prevent="addReview">
          <div id = "review-details" v-for="newReview in allReviews" v-bind:key="newReview.id">
    </div>
          <div class="form-element">
              <textarea class="review-text" placeholder="What did you think of this beer?" v-model="newReview.text"/>
          </div>
          <div class="form-element">
              <input type="text" class="review-name" placeholder="what is your name" v-model="newReview.name"/>
          <div class="form-element">
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
    name: 'beer-reviews',
    data(){
        return {
            showForm: false,
            allReviews: {},
            newReview: {
            name: 'name',
            title: 'NA',
            text: '',
            starCount: 3,
            type: 'Beer',
            targetId: this.$route.params.beerId
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
            reviewService.createBeerReview(this.newReview)
            .then(response=> {
                if (response.status === 201) {
                    this.resetForm();
                    this.addReviewToArray();
                }
            })
    }
    },

    created() {
        reviewService.getBeerReviews(this.$route.params.breweryId, this.$route.params.beerId).then((response) => {
            this.allReviews = response.data;
        })
    }

}
</script>

<style>

</style>