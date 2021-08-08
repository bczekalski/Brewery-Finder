<template>
    <div class="container-beer-list container-blur">
        <router-link class="link-in-black" id=“breweries-list” v-bind:to="{name: 'breweries-display'}">Return to Brewery List</router-link>
        <h1 class="beer-list-header">{{breweryDetails.name}} Presents: </h1>
        <div v-for="beer in allBeers" v-bind:key="beer.id">
            <h1 class='beer-name-in-list'>{{beer.name}}</h1>
            <router-link id="beer-button" class="link-in-black details-link" v-bind:to="{name: 'beer-display', params: {breweryId: breweryDetails.id, beerId: beer.id} }">View Beer Details</router-link>
            <br>
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

.beer-list-header {
    font-size: 4vw;
}

.beer-name-in-list {
    font-size: 3vw;
}

.details-link {
    font-size: 2vw;
}

.container-beer-list {
    font-family: 'Poppins', sans-serif;
    font-size: 3vw;
    text-align: center;
    display: block;
    border-radius: 3vw;
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