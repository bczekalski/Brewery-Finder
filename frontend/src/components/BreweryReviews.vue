<template>
    <div id="brewery-reviews">
    <div id='new-brewery-form-container'>
         <button v-if="showForm === false" v-on:click.prevent="showForm = true">Add Review</button>
      <form id="add-review-form" v-if="showForm===true" v-on:submit.prevent="addReview">
          <div id = "review-details" v-for="newReview in allReviews" v-bind:key="newReview.id">
    </div>
          <div class="form-element">
              <textarea class="review-text" placeholder="What did you think of this brewery?" v-model="newReview.text"/>
          </div>
          <div class="form-element">
              <input type="text" class="review-name" placeholder="what is your name" v-model="newReview.name"/>
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
            allReviews: [],
            errorMsg: '',
            
           newReview: {
                id: 1,
                name: '',
                text: '',
                starCount: 1,
                type: '',
                userId: 0
            }
        }
    },

     methods: {
        resetForm() {
            this.showForm = false;
        },
        addReview() {
            reviewService.createReview(this.newReview)
            .then(response=> {
                if (response.status === 201) {
                        this.allReviews.push(this.newReview);
                    this.resetForm();
                }
            })
            .catch(error=> {
                this.errorMsg = error;
            })
        }
        },

    created() {
        reviewService.getBreweryReviews(this.$route.params.breweryId).then((response) => {
            this.allReviews = response.data;
        
        })
    }

}
        
</script>

<style>

</style>