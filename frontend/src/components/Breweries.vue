<template>
  <div id="breweries">
    <div class="brewery-list" v-for="brewery in allBreweries" v-bind:key="brewery.id">
        <h2 class="brewery-name">{{ brewery.name }}</h2>
        <div class="brewery-details">
        <p class="brewery-history">{{ brewery.history }}</p>
        <p class="contact-info">{{ brewery.contactInfo }}</p>
        <p class="operation-time">{{ brewery.operationTime }}</p>
        <p class="full-address">{{ brewery.address }}</p>
        <a href="brewery.website" target="_blank" :alt="brewery-website" class="brewery-website"> Website</a>
        <img src="brewery.image" alt="Brewery Logo">
        </div>
    </div>
  </div>
</template>

<script>
import breweryService from "../services/BreweryService.js"
export default {
    name: "breweries",
    data() {
        return {
            allBreweries: []
        }
        },
        created(){
            breweryService.getBreweries()
            .then(response => {
                this.allBreweries = response.data;
            }); 
            }
        }
</script>


<style>

</style>