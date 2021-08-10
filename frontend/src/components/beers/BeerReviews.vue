<template>
  <div id="beer-reviews">
    <div id='new-beer-form-container'>
            <div id="add-review">
                <button v-if="showForm === false" v-on:click.prevent="showForm = true">Add Review</button>
                <h2 id="no-reviews" v-if="!allReviews.length && showForm==false">No reviews! Be the first to write one!</h2>
            </div>
            <form id="add-review-form" v-if="showForm===true" v-on:submit.prevent="addReview">
                <div class="form-element">
                    <label for="title">Please summarize your thoughts:</label>
                    <textarea class="title" placeholder="Review Title" v-model="newReview.title"/>
                </div>
                <div class="form-element">
                    <label for="text">Please provide your detailed thoughts:</label>
                    <textarea class="text" placeholder="Review Body" v-model="newReview.text"/>
                </div>
                <div class="form-element">
                    <label for="name">Enter your name:</label>
                    <input type="text" class="name" placeholder="Name" v-model="newReview.name"/>
                </div>
                <div class="form-element">
                    <label for="star-rating">Select your rating:</label>
                    <select name="star-rating" id="review-star-rating" v-model="newReview.starCount">
                        <option value=1>1</option>
                        <option value=2>2</option>
                        <option value=3>3</option>
                        <option value=4>4</option>
                        <option value=5>5</option>
                    </select>
                </div>
                <div class="buttons-div">
                    <input type="submit" value="Save Review" class="form-btns">
                    <input type="button" value="Cancel" class='form-btns' v-on:click.prevent="resetForm">
                </div>
            </form>
        </div>
    <div id = "review-details" v-for="review in allReviews" v-bind:key="review.id">
        <!-- This is where all the reviews will display-->
        <h2> {{ review.name }} </h2>
    </div>
  </div>
</template>
<script>
import reviewService from '../../services/ReviewService'
export default {
    name: 'beer-reviews',
    data(){
        return {
            showForm: false,
            allReviews: [],
            newReview: {
                type: 'Beer',
                targetId: this.$route.params.beerId
            }
        }
    },

    created() {
        reviewService.getBeerReviews(this.$route.params.beerId).then((response) => {
            this.allReviews = response.data;
        })
    },
    methods: {
        resetForm() {
            this.newReview = {
                        type: 'Beer',
                        targetId: this.$route.params.beerId
            };
            this.showForm = false;
        },

        addReview() {
            reviewService.createBeerReview(this.newReview)
            .then(response=> {
                if (response.status === 201) {
                    this.allReviews.unshift(this.newReview);
                    this.resetForm();
                }
            })
        },
    }
}
</script>

<style>
#beer-reviews {
    
  font-family: 'Poppins', sans-serif;
  font-size: 3vw;
  text-align: center;
  background-color: whitesmoke;
  display: block;
  border-radius:3vw;
  padding: 5vw;
  justify-content: space-evenly;
  justify-items: center;
  align-content: space-evenly;
  align-items: center;
  margin-left: 20vw;
  margin-right: 20vw;
}
</style>