<template>
<div id="beer-form">
  <form class="container-add-brewery container-blur" v-on:submit.prevent="addNewBeer()">
          <div class="form-element">
              <label for="name">Please enter the name of your beer: </label>
              <input id="name" type="text" v-model="newBeer.name" />
          </div>
          <div class="form-element">
              <label for="description">Please enter a description of your beer: </label>
              <textarea id="description" type="text" v-model="newBeer.description" />
          </div>
          <div class="form-element">
              <label for="beer-type">Please enter the type of beer it is: </label>
              <input id="beer-type" type="text" v-model="newBeer.beerType" />
          </div>
          <div class="form-element">
              <label for="abv">Please enter the abv of the beer: </label>
              <input id="abv" type="text" v-model="newBeer.abv" />
              <label for="abv">%</label>
          </div>
          <div class="form-element">
              <label for="gluten-free">Is your beer Gluten Free? </label>
              <input type="checkbox" id="gluten" v-model="newBeer.glutenFree" />
          </div>
          <div class="form-element">
              <label for="image">Please enter a link to an image for the beer: </label>
              <input id="image" type="text" v-model="newBeer.imageLink" />
          </div>
          <input type="submit" value="Save">
          <input type="button" value="Cancel" v-on:click.prevent="resetForm()">
          </form>
</div>
</template>

<script>
import beerService from '../../services/BeerService'
export default {
    name: 'add-beer',
    data(){
        return {
            newBeer: {
                glutenFree: false,
                breweryId: this.$route.params.breweryId
            }
        }
    },
    methods: {
        addNewBeer() {
            beerService.createBeer(this.$route.params.breweryId, this.newBeer).then((response) => {
            if (response.status == 201 ){
                this.$router.push(`/account/breweries/${this.$route.params.breweryId}/beers`);
            }
            })
            .catch(error => {
                alert("Could not add this Beer.");
                console.error(error);
            })
        },
        resetForm() {
            this.newBeer = {glutenFree: false, breweryId: this.$route.params.breweryId}
        }
    }


}
</script>

<style>

.container-add-brewery {
  font-family: 'Poppins', sans-serif;
  font-size: 2vw;
  text-align: left;
  display: block;
  border-radius:3vw;
  padding: 3vw;
  justify-content: space-evenly;
  justify-items: center;
  align-content: space-evenly;
  align-items: center;
  margin-left: 20vw;
  margin-right: 20vw;
}

</style>