<template>
    <div id='beer-list'>
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

</style>