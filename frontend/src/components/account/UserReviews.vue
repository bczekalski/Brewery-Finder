<template>
    <div>
        <div class="container-blur beer-reviews-container" v-for="review in allReviews" v-bind:key="review.id">
            <h2> {{ review.title }} </h2>      
            <h3> By: {{ review.name }} </h3>
            <h3> {{ review.starCount }} Stars</h3>
            <p> {{ review.text }} </p>
        </div>
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
.container-view-my-reviews {
    font-family: 'Poppins', sans-serif;
    font-size: 2vw;
    text-align: left;
    display: block;
    border-radius:3vw;
    padding: 3vw;
    justify-content: space-evenly;
    justify-items: center;
    align-content: space-evenly;
    align-items: center;
    margin-left: 20vw;
    margin-right: 20vw;
}

</style>