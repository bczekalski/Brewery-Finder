<template>
<div id="beer-form">
  <form class="container-add-beer container-blur" v-on:submit.prevent="updateBeer()">
          <div class="form-element">
              <label for="name">Please enter the name of your beer: </label>
              <input id="name" type="text" v-model="editedBeer.name" />
          </div>
          <div class="form-element">
              <label for="description">Please enter a description of your beer: </label>
              <textarea id="description" type="text" v-model="editedBeer.description" />
          </div>
          <div class="form-element">
              <label for="beer-type">Please enter the type of beer it is: </label>
              <input id="beer-type" type="text" v-model="editedBeer.beerType" />
          </div>
          <div class="form-element">
              <label for="abv">Please enter the abv of the beer: </label>
              <input id="abv" type="text" v-model="editedBeer.abv" />
              <label for="abv">%</label>
          </div>
          <div class="form-element">
              <label for="gluten-free">Is your beer Gluten Free? </label>
              <input type="checkbox" id="gluten" v-model="editedBeer.glutenFree" />
          </div>
          <div class="form-element">
              <label for="image">Please enter a link to an image for the beer: </label>
              <input id="image" type="text" v-model="editedBeer.imageLink" />
          </div>
          <input type="submit" value="Save">
          <input type="button" value="Cancel" v-on:click.prevent="resetForm()">
          </form>
</div>
</template>

<script>
import beerService from '../../services/BeerService'
export default {
    name: 'edit-beer',
    data(){
        return {
            editedBeer: {}
        }
    },
    created(){
        beerService.getBeersById(this.$route.params.breweryId, this.$route.params.beerId).then((response) => {
            this.editedBeer = response.data;
        })

    },
    methods: {
        updateBeer() {
            beerService.updateBeer(this.$route.params.breweryId, this.editedBeer).then((response) => {
            if (response.status == 200 ){
                this.$router.push(`/breweries/${this.$route.params.breweryId}/beers/${this.editedBeer.id}`);
            }
            })
            .catch(error => {
                alert("Could not edit this Beer.");
                console.error(error);
            })
        },
        resetForm() {
            beerService.getBeersById(this.$route.params.breweryId, this.$route.params.beerId).then((response) => {
                this.editedBeer = response.data;
            })
        }
    }


}
</script>

<style>

.container-add-beer {
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