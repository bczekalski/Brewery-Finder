<template>
  <div id="beer-reviews">
    <div id='new-beer-form-container' class="beer-review-container container-blur">
            <div id="add-review" v-if="$store.state.token != ''">
                <div class="center-button">
                    <button v-if="showForm === false" v-on:click.prevent="showForm = true">Click here to add a review!</button>
                </div>
                <h2 id="no-reviews" v-if="!allReviews.length && showForm==false">There are no reviews on this beer yet. Be the first to write one!</h2>
            </div>
            <form class="add-review-form" v-if="showForm===true" v-on:submit.prevent="addReview">
                <div id="add-beer-review">Add beer review: </div>
      <br>
                <div class="form-element">
                    <label for="title">Title of your review: </label>
                    <br>
                    <textarea class="title" v-model="newReview.title"/>
                    <br>
                </div>
                <br>
                <div class="form-element">
                    <label for="text">Detailed thoughts on this beer: </label>
                    <br>
                    <textarea class="text" v-model="newReview.text"/>
                    <br>
                </div>
                <br>
                <div class="form-element">
                    <label for="name">Enter your name: </label>
                    <br>
                    <input type="text" class="name" v-model="newReview.name"/>
                    <br>
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
                        <br>
                    </select>
                </div>
                <br>
                <div class="buttons-div">
                    <input type="submit" value="Save Review" class="form-btns">
                    <input type="button" value="Cancel" class='form-btns' v-on:click.prevent="resetForm">
                </div>
            </form>
        </div>
    <div id = "review-details" class="container-blur beer-reviews-container" v-for="review in allReviews" v-bind:key="review.id">
        <!-- This is where all the reviews will display-->
        <h2> "{{ review.title }}" </h2>      
        <h3> By: {{ review.name }} </h3>
        <div id='rating'>
            <h3>Rating:</h3>
            <img class="rating-beer-pint" src="../../images/beer-mugs.png" v-for="n in review.starCount" v-bind:key="n"/>
            <img class="rating-beer-pint" src="../../images/empty-mugs.png" v-for="n in emptyMugCount(review.starCount)" v-bind:key="n"/>
        </div>  
        <p> "{{ review.text }}" </p>
    </div>
    <br><br>
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

#no-reviews{
    font-family: 'Poppins', sans-serif;
  font-size: 2vw;
  
  
}
.rating-beer-pint{
margin: auto;
height: 7vw;
}

div > center-button{
  font-family: 'Poppins', sans-serif;
}
#add-beer-review{
    font-family: 'Poppins', sans-serif;
  font-size: 40px;
}

.title{
  font-family: 'Poppins', sans-serif;
  font-size: 15px;
}

.text{
  font-family: 'Poppins', sans-serif;
  font-size: 15px;
}

.name{
  font-family: 'Poppins', sans-serif;
  font-size: 15px;
}

.form-btns{
  font-family: 'Poppins', sans-serif;
  font-size: 20px;
}

.add-review-form{
    margin-right: 2vw;
    margin-left: 2vw;
    margin-top: 2w;
    margin-bottom: 6vw;
}

#review-star-rating{
  font-family: 'Poppins', sans-serif;
  font-size: 15px;
}



#new-beer-form-container{

font-family: 'Poppins', sans-serif;
  font-size: 2vw;
  text-align: center;
  display: block;
  border-radius: 3vw;
  padding: 5vw;
  justify-content: space-evenly;
  justify-items: center;
  align-content: space-evenly;
  align-items: center;
  margin-left: 20vw;
  margin-right: 20vw;
  margin-bottom: 20px;
  margin-top: 20px;


}


.center-button {
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: 50%;
    justify-content: space-evenly;
    justify-items: center;
    align-content: space-evenly;
    align-items: center;
    text-align: center;
    padding: 3vw;
}


.beer-reviews-container {
  font-family: 'Poppins', sans-serif;
  font-size: 3vw;
  text-align: center;
  display: block;
  border-radius: 3vw;
  padding: 5vw;
  justify-content: space-evenly;
  justify-items: center;
  align-content: space-evenly;
  align-items: center;
  margin-left: 20vw;
  margin-right: 20vw;
 
}

#review-details{
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