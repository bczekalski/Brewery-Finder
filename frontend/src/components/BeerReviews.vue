<template>
    <div id="brewery-reviews">
    <div id = "review-details" v-for="review in allBeerReviews" v-bind:key="review.id">
    <h2 id='reviewer-name'>{{review.reviewName}}</h2>
    </div>
    </div>
</template>

<script>
import reviewService from '../services/ReviewService'
export default {
    name: 'beer-reviews',
    data(){
        return {
            allBeerReviews: []
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