<template>
<div id="beer-form">
  <form class="container-add-beer container-blur" v-on:submit.prevent="updateBeer()">
      <div id="update-beer">Update beer: </div><br>
          <div class="form-element">
              <label for="name">Beer name: </label><br>
              <input id="name" type="text" v-model="editedBeer.name" />
          </div>
          <br>
          <div class="form-element">
              <label for="description">Beer description: </label><br>
              <textarea id="description" type="text" v-model="editedBeer.description" />
          </div>
          <br>
          <div class="form-element">
              <label for="beer-type">Beer type: </label><br>
              <input id="beer-type" type="text" v-model="editedBeer.beerType" />
          </div>
          <br>
          <div class="form-element">
              <label for="abv">Beer abv: </label><br>
              <input id="abv" type="text" v-model="editedBeer.abv" />
              <label for="abv">%</label>
          </div>
          <br>
          <div class="form-element">
              <label for="gluten-free">Is this beer Gluten Free? </label>
              <input type="checkbox" id="gluten" v-model="editedBeer.glutenFree" />
          </div>
          <br>
          <div class="form-element">
              <label for="image">Beer image link: </label><br>
              <input id="image" type="text" v-model="editedBeer.imageLink" />
          </div>
          <br>
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
#update-beer{
    font-family: 'Poppins', sans-serif;
    font-size: 40px;
}
#name{
    font-family: 'Poppins', sans-serif;
  font-size: 15px;
}

#description{
    font-family: 'Poppins', sans-serif;
  font-size: 15px;
}

#beer-type{
    font-family: 'Poppins', sans-serif;
  font-size: 15px;
}

#abv{
    font-family: 'Poppins', sans-serif;
  font-size: 15px;
}


.container-add-beer {
  font-family: 'Poppins', sans-serif;
  font-size: 25px;
  text-align: center;
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