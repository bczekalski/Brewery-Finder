<template>
  <form v-on:submit.prevent="addNewBrewery">
          <div class="form-element">
              <label for="name">Name:</label>
              <input id="name" type="text" v-model="newBrewery.name" />
          </div>
          <div class="form-element">
              <label for="history">History:</label>
              <textarea id="history" type="text" v-model="newBrewery.history" />
          </div>
          <div class="form-element">
              <label for="contact-info">Contact Info:</label>
              <input id="contact-info" type="text" v-model="newBrewery.contactInfo" />
          </div>
          <div class="form-element">
              <label for="operation-time">Operation Time:</label>
              <textarea id="operation-time" type="text" v-model="newBrewery.operationTime" />
          </div>
          <div class="form-element">
              <label for="address">Street Address:</label>
              <input id="address" type="text" v-model="newBrewery.address" />
          </div>
          <div class="form-element">
              <label for="city">City:</label>
              <input id="city" type="text" v-model="newBrewery.city" />
          </div>
          <div class="form-element">
              <label for="state">State:</label>
              <input id="state" type="text" v-model="newBrewery.state" />
          </div>
          <div class="form-element">
              <label for="zip">Zip Code:</label>
              <input id="zip" type="text" v-model="newBrewery.zipCode" />
          </div>
          <div class="form-element">
              <label for="website">Link to Website:</label>
              <input id="website" type="text" v-model="newBrewery.website" />
          </div>
          <div class="form-element">
              <label for="image">Link to Image:</label>
              <input id="image" type="text" v-model="newBrewery.image" />
          </div>
          <div class="form-element">
              <label for="food">Please select what food type you offer:</label>
              <select id="food" type="text" v-model="newBrewery.foodId">
                  <option v-bind:value="food.id" v-for="food in foodList" v-bind:key="food.id">
                      {{ food.name }}</option>
              </select>
          </div>
          <div class="form-element">
              <label for="brewer">Please select a brewer to manage this brewery:</label>
              <select id="brewer" type="text" v-model="newBrewery.ownerId">
                  <option v-bind:value="user.id" v-for="user in brewerList" v-bind:key="user.id">
                      {{ user.username }}</option>
              </select>
          </div>
          <input type="submit" value="Save">
          <input type="button" value="Cancel" v-on:click.prevent="resetForm()">
          </form>
</template>

<script>
import BreweryService from '../services/BreweryService'
import breweryService from '../services/BreweryService'
export default {
    name: 'add-brewery',
    data(){
        return {
            newBrewery: {
                operationTime: 'Mon: Closed, Tues: Closed, Wed: Closed, Thur: Closed, Fri: Closed, Sat: Closed, Sun: Closed'
            },
            foodList: [],
            brewerList: []
        }
    },
    created() {
        breweryService.getFoodList(this.$route.params.breweryId).then((response) => {
            this.foodList = response.data;
        }),
        BreweryService.getBrewers().then((response) => {
            this.brewerList = response.data;
        })
    },
    methods: {
        addNewBrewery() {
            BreweryService.createBrewery(this.newBrewery).then((response) => {
            if (response.status == 201 ){
                this.$router.push(`/breweries/${response.data}`);
            }
            })
            .catch(error => {
                this.handleErrorResponse(error, "adding");
            })
        },
        resetForm() {
            this.newBrewery = {
                operationTime: 'Mon: Closed, Tues: Closed, Wed: Closed, Thur: Closed, Fri: Closed, Sat: Closed, Sun: Closed'
            }
        }
    }


}
</script>

<style>

</style>