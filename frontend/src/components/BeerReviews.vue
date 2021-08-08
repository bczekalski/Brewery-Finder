<template>
    <div id="beer-reviews">
    <h2 v-if="!allReviews.length">No Reviews! Be the first to write one!</h2>
    <div id = "review-details" v-for="review in allReviews" v-bind:key="review.id">
    <h2 id='reviewer-name'>{{review.name}}</h2>
    </div>
    </div>
</template>

<script>
import reviewService from '../services/ReviewService'
export default {
    name: 'beer-reviews',
    data(){
        return {
            allReviews: []
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