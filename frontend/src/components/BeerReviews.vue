<template>
    <div id="beer-reviews">
        <div id='new-beer-form-container'>
            <button v-if="showForm === false" v-on:click.prevent="showForm = true">Add Beer Review</button>
             <form id="add-review-form" v-if="showForm===true" v-on:submit.prevent="addReview2">
              <div id = "review-details" v-for="newBeerReview in allBeerReviews" v-bind:key="newBeerReview.id">   
              </div>
              <div class="form-eleemnt">
                <textarea class="review-text" placeholder="What did you think of this beer?" v-model="newBeerReview.text"/>   
              </div>
              <div class="form-element">
                  <input type="text" class="review-name" placeholder="what is your name" v-model="newBeerReview.name"/>
            <div class="form-element">
              <label for="review-starRating">Rating:</label>
              <select name="review-starRating" id="review-starRating" v-model="newBeerReview.starCount">
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
    name: 'beer-reviews',
    data(){
        return {
            showForm: false,
            allBeerReviews: [],

            newBeerReview: {
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
        addBeerReview() {
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
        reviewService.getBeerReviews(this.$route.params.breweryId, this.$route.params.beerId).then((response) => {
            this.allReviews = response.data;
        })
    }

}
</script>

<style>

</style>