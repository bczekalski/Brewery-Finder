<template>
    <div id='beer-list'>
        <router-link id="breweries-list" v-bind:to="{name: 'breweries-display'}">Return to Brewery List</router-link>
        <h1 id='brewery-name'>{{breweryDetails.name}} Presents: </h1>
        <div id='beers' v-for="beer in allBeers" v-bind:key="beer.id">
        <h1 id='beer-name'>{{beer.name}}</h1>
        <router-link id="beer-button" v-bind:to="{name: 'beer-display', params: {breweryId: breweryDetails.id, beerId: beer.id} }">View Beer Details</router-link>
        </div>
    </div>
</template>

<script>
import beerService from '../services/BeerService'
import breweryService from '../services/BreweryService'
export default {
    name: 'beers-list',
    data(){
        return {
            allBeers: [],
            breweryDetails: {}
        }
    },
    created(){
        beerService.getBeers(this.$route.params.breweryId).then((response) => {
            this.allBeers = response.data;
        })
        breweryService.getById(this.$route.params.breweryId).then((response) => {
            this.breweryDetails = response.data;
        })
    }

}
</script>

<style>

#brewery-name {
    font-size: 5vw;
    font-family: 'Poppins', sans-serif;
}

#beer-name {
    font-size: 3vw;
    font-family: 'Poppins', sans-serif;
}

#beer-list {
  
  text-align: center;
  background-color: white;
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