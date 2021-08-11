<template>
  <div id="brewery-reviews">
    <div id='new-brewery-form-container' class="brewery-review-container container-blur">
        <router-link id="brewery-details-button" class="link-in-black" v-bind:to="{ name: 'brewery-display', params: {breweryId: this.$route.params.breweryId } }">Back to Brewery</router-link>
            <div id="add-review" class="center-button" v-if="$store.state.token != ''">
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
    <div id = "review-details" class="brewery-review-container container-blur" v-for="review in allReviews" v-bind:key="review.id">
        <!-- This is where all the reviews will display-->
        <h2> {{ review.title }} </h2>        
        <h3> By:  {{ review.name }} </h3>
        <div id='rating'>
            <h3>Rating</h3>
        <img src="../../images/beer-mugs.png" v-for="n in review.starCount" v-bind:key="n"/>
        <img src="../../images/empty-mugs.png" v-for="n in emptyMugCount(review.starCount)" v-bind:key="n"/>
        </div>
        <p> {{ review.text }} </p>
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
                    this.resetForm();
                    window.location.reload();
                }
            })
        },
        emptyMugCount(count){
            return 5-count;
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