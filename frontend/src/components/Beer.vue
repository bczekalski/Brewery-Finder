<template>
  <div id='beer-details'>
    <h2 id='beer-name'>{{beerDetails.name}}</h2>
    <h2 id='beer-type'>{{beerDetails.beerType}}</h2>
    <p id='beer-description'>{{beerDetails.description}}</p>
    <p id='abv'>Alcohol By Volume: {{beerDetails.abv}}%</p>
    <!--{{beer.imageLink}}-->
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

</style>