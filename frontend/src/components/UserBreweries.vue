<template>
  <div id="breweries">
    <div class="brewery-list" v-for="brewery in allBreweries" v-bind:key="brewery.id">
        
        <h2 class="brewery-name">{{ brewery.name }}</h2>
        <router-link id="brewery-button" v-bind:to="{ name: 'brewery-display', params: {breweryId: brewery.id } }">View details.</router-link>
    </div>
  </div>
</template>

<script>
import breweryService from '../services/BreweryService'
export default {
    name: 'user-breweries',
    data(){
        return{
            allBreweries: []
        }
    },
    created() {
      breweryService.getByUserId(this.$store.state.user.id).then((response) => {
          this.allBreweries = response.data;
      })  
    }

}
</script>

<style>

</style>