<template>
  <div id='user-reviews'>
      
      <h2 v-for="review in allReviews" v-bind:key="review.id">{{review.name}}

      </h2>

      </div>
</template>

<script>
import reviewService from '../../services/ReviewService'
export default {
    name: 'user-reviews',
    data () {
        return {
            allReviews: []
        }
    },
    created() {
        reviewService.getUserReviews(this.$store.state.user.id).then((response) => {
            this.allReviews = response.data;
        })
    }

}
</script>

<style>


</style>