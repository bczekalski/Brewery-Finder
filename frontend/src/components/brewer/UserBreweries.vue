<template>
  <div id="breweries">
    <div class="brewery-list container-breweries-brewer container-blur" v-for="brewery in allBreweries" v-bind:key="brewery.id">
        
        <h2 class="brewery-name">{{ brewery.name }}</h2>
        <router-link id="brewery-button" class="link-in-black" v-bind:to="{ name: 'brewer-brewery-display', params: {breweryId: brewery.id } }">View details</router-link> |
        <router-link id="brewery-beers" class="link-in-black" v-bind:to="{name: 'user-beers-display', params: {breweryId: brewery.id } }">View Beer List</router-link>
    </div>
  </div>
</template>

<script>
import breweryService from '../../services/BreweryService'
export default {
    name: 'user-breweries',
    data(){
        return{
            allBreweries: []
        }
    },
    created() {
      breweryService.getByUserId().then((response) => {
          this.allBreweries = response.data;
      })  
    }

}
</script>

<style>

.container-breweries-brewer {
  font-family: 'Poppins', sans-serif;
  font-size: 3vw;
  text-align: center;
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