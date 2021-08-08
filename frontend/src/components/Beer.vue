<template>
  <div id='beer-details'>
     <router-link id="beers-button" v-bind:to="{ name: 'beers-display', params: {breweryId: breweryDetails.id } }">Return to Beer List</router-link>
    <h2 id='beer-name'>{{beerDetails.name}}</h2>
    <h2 id='beer-type'>{{beerDetails.beerType}}</h2>
    <p id='beer-description'>{{beerDetails.description}}</p>
    <p id='abv'>Alcohol By Volume: {{beerDetails.abv}}%</p>
    <!--{{beer.imageLink}}-->
    <router-link id="reviews-button" v-bind:to="{ name: 'beer-review-display', params: {breweryId: breweryDetails.id, beerId: beerDetails.id} }">View reviews</router-link>
  </div>
</template>

<script>
import beerService from '../services/BeerService'
import breweryService from '../services/BreweryService'
export default {
    name: 'beers-list',
    data(){
        return {
            beerDetails: {},
            breweryDetails: {}
        }
    },
    created(){
        beerService.getBeersById(this.$route.params.breweryId, this.$route.params.beerId).then((response) => {
            this.beerDetails = response.data;
        })
        breweryService.getById(this.$route.params.breweryId).then((response) => {
            this.breweryDetails = response.data;
        })
    }

}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Oswald:wght@300&display=swap');

#beer-name {
    font-family: 'Oswald', sans-serif;
    font-size: 5vw;
}


#beer-details {
  font-family: 'Poppins', sans-serif;
  font-size: 2vw;
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

#beer-description {
    font-style: italic;
}
</style>