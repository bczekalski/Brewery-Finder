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

</style>