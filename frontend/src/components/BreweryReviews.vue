<template>
    <div id="brewery-reviews">
    <div id = "review-details" v-for="review in allReviews" v-bind:key="review.id">
    <h2 id='reviewer-name'>{{review.reviewName}}</h2>
    </div>
    </div>
</template>

<script>
import reviewService from '../services/ReviewService'
export default {
    name: 'brewery-reviews',
    data(){
        return {
            allReviews: []
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