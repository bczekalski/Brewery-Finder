<template>
  <div id="brewery-reviews">
    <div id='new-brewery-form-container' class="brewery-review-container container-blur">
            <div id="add-review" class="center-button" v-if="$store.state.token != ''">
                <button v-if="showForm === false" v-on:click.prevent="showForm = true">Click here to add a review!</button>
                <h2 id="no-reviews" v-if="!allReviews.length && showForm==false">No reviews! Be the first to write one!</h2>
            </div>
            <form id="add-review-form" v-if="showForm===true" v-on:submit.prevent="addReview">
                <div class="form-element">
                    <label for="title">Title of your review: </label>
                    <br>
                    <textarea class="title" v-model="newReview.title"/>
                </div>
                <br>
                <div class="form-element">
                    <label for="text">Detailed thoughts on this brewery: </label>
                    <br>
                    <textarea class="text" v-model="newReview.text" />
                </div>
                <br>
                <div class="form-element">
                    <label for="name">Enter your name: </label>
                    <br>
                    <input type="text" class="name" v-model="newReview.name"/>
                </div>
                <br>
                <div class="form-element">
                    <label for="star-rating">Select your rating:    </label>
                    
                    <select name="star-rating" id="review-star-rating" v-model="newReview.starCount">
                        <option value=1>1</option>
                        <option value=2>2</option>
                        <option value=3>3</option>
                        <option value=4>4</option>
                        <option value=5>5</option>
                    </select>
                    <br>
                </div>
                <br>
                <div class="buttons-div">
                    <input type="submit" value="Save Review" class="form-btns">
                    <input type="button" value="Cancel" class='form-btns' v-on:click.prevent="resetForm">
                </div>
            </form>
        </div>
    <div id = "review-details" class="brewery-review-container container-blur" v-for="review in allReviews" v-bind:key="review.id">
        <!-- This is where all the reviews will display-->
        <h2> "{{ review.title }}" </h2>        
        <h3> By:  {{ review.name }} </h3>
        <h3> {{ review.starCount }} Stars </h3>
        <p> "{{ review.text }}"</p>
    </div>
    <br><br>
  </div>
</template>

<script>
import reviewService from '../../services/ReviewService'
export default {
    name: 'brewery-reviews',
    data(){
        return {
            showForm: false,
            allReviews: [],
            newReview: {
                type: 'Brewery',
                targetId: this.$route.params.breweryId
            }
        }
    },
    created() {
        reviewService.getBreweryReviews(this.$route.params.breweryId).then((response) => {
            this.allReviews = response.data;
        })
    },
    methods: {
        resetForm() {
            this.newReview = {
                        type: 'Brewery',
                        targetId: this.$route.params.breweryId
            };
            this.showForm = false;
        },

        addReview() {
            reviewService.createReview(this.newReview)
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

.brewery-review-container {
    font-family: 'Poppins', sans-serif;
    font-size: 2vw;
    text-align: center;
    display: block;
    border-radius:3vw;
    padding: 1.5vw;
    padding-bottom: 4vw;
    justify-content: space-evenly;
    justify-items: center;
    align-content: space-evenly;
    align-items: center;
    margin-left: 20vw;
    margin-right: 20vw;
}


</style>