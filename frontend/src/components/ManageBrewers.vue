<template>
  <form v-on:submit.prevent="updateBrewer">
      <div class="form-element">
            <label for="brewery">Please select a brewer to manage this brewery:</label>
            <select id="brewery" type="text" v-model="breweryToUpdate">
                <option v-bind:value="brewery" v-for="brewery in allBreweries" v-bind:key="brewery.id">
                    {{ brewery.name }}</option>
            </select>
        </div>
      
      <div class="form-element">
            <label for="brewer">Please select a brewer to manage this brewery:</label>
            <select id="brewer" type="text" v-model="breweryToUpdate.ownerId">
                <option v-bind:value="user.id" v-for="user in brewerList" v-bind:key="user.id">
                    {{ user.username }}</option>
            </select>
        </div>
    <input type="submit" value="Save">
    <input type="button" value="Cancel" v-on:click.prevent="resetForm()">
        

  </form>
</template>

<script>
import breweryService from '../services/BreweryService'
export default {
    name: 'manage-brewers',
    data(){
        return{
            allBreweries:[],
            brewerList: [],
            breweryToUpdate: {}
        }
    },
    created() {
        breweryService.getBreweries().then((response) => {
            this.allBreweries = response.data;
        }),
        breweryService.getBrewers().then((response) => {
            this.brewerList = response.data;
        })
    },
    methods: {
        updateBrewer(){
            breweryService.updateBrewer(this.breweryToUpdate).then((response) => {
                if (response.status === 200){
                    this.$router.push(`/`);
                }
            }).catch((error) => {
                this.handleErrorResponse(error, "updating");
            })
        },
        resetForm(){
            this.$router.push(`/account/admin`);
        }
    }


}
</script>

<style>

</style>