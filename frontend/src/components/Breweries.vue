<template>
  <div id="breweries">
    <div class="brewery-list" v-for="brewery in allBreweries" v-bind:key="brewery.id">
        
        <h2 class="brewery-name">{{ brewery.name }}</h2>
        
        <router-link id="brewery-button" v-bind:to="{ name: 'brewery-display', params: {breweryId: brewery.id } }">View details</router-link>
        <br>
        <router-link id="beers-button" v-bind:to="{ name: 'beers-display', params: {breweryId: brewery.id } }">View beers</router-link>
        
    </div>
  </div>
</template>

<script>
import breweryService from "../services/BreweryService.js"
export default {
    name: "breweries",
    data() {
        return {
            allBreweries: [],
            website: ''
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
.container-breweries {
  font-family: 'Poppins', sans-serif;
  font-size: 3vw;
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
.brewery-details {
    font-size: 1.5vw;
}

.brewery-history {
    font-style:italic;
    text-align: left;
}

.a {
    padding: 1.5vw;
}

.logo-image {
    width: 35vw;
}


</style>