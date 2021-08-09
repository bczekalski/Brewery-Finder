<template>
  <div id='edit-brewery'>
      <form v-on:submit.prevent="updateBrewery">
          <div class="form-element">
              <label for="name">Name:</label>
              <input id="name" type="text" v-model="editedBrewery.name" />
          </div>
          <div class="form-element">
              <label for="history">History:</label>
              <textarea id="history" type="text" v-model="editedBrewery.history" />
          </div>
          <div class="form-element">
              <label for="contact-info">Contact Info:</label>
              <input id="contact-info" type="text" v-model="editedBrewery.contactInfo" />
          </div>
          <div class="form-element">
              <label for="operation-time">Operation Time:</label>
              <input id="operation-time" type="text" v-model="editedBrewery.operationTime" />
          </div>
          <div class="form-element">
              <label for="address">Street Address:</label>
              <input id="address" type="text" v-model="editedBrewery.address" />
          </div>
          <div class="form-element">
              <label for="city">City:</label>
              <input id="city" type="text" v-model="editedBrewery.city" />
          </div>
          <div class="form-element">
              <label for="state">State:</label>
              <input id="state" type="text" v-model="editedBrewery.state" />
          </div>
          <div class="form-element">
              <label for="zip">Zip Code:</label>
              <input id="zip" type="text" v-model="editedBrewery.zipCode" />
          </div>
          <div class="form-element">
              <label for="website">Link to Website:</label>
              <input id="website" type="text" v-model="editedBrewery.website" />
          </div>
          <div class="form-element">
              <label for="image">Link to Image:</label>
              <input id="image" type="text" v-model="editedBrewery.image" />
          </div>
          <div class="form-element">
              <label for="food">Please select what food type you offer:</label>
              <select id="food" type="text" v-model="editedBrewery.foodId">
                  <option v-bind:value="food.id" v-for="food in foodList" v-bind:key="food.id">
                      {{ food.name }}</option>
              </select>
          </div>
          <input type="submit" value="Save">
          <input type="button" value="Cancel" v-on:click.prevent="resetForm()">
          </form>
  </div>
</template>

<script>
import breweryService from '../../services/BreweryService'
export default {
    name: 'edit-brewery',
    data(){
        return {
            editedBrewery: {},
            foodList: []
        }
    },
    created() {
        breweryService.getById(this.$route.params.breweryId).then((response) => {
            this.editedBrewery = response.data;
        }),
        breweryService.getFoodList(this.$route.params.breweryId).then((response) => {
            this.foodList = response.data;
        })
    },
    methods: {
        updateBrewery(){
            breweryService.updateBrewery(this.editedBrewery).then((response) => {
            if (response.status == 200 ){
                this.$router.push(`/account/breweries/${this.editedBrewery.id}`);
            }
            })
            .catch(error => {
                this.handleErrorResponse(error, "updating");
            })
        },
        resetForm() {
            breweryService.getById(this.$route.params.breweryId).then((response) => {
            this.editedBrewery = response.data;
        })
        }
    }

}
</script>

<style>

</style>