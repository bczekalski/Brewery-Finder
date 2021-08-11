<template>
  <form class="container-assign-brewer container-blur" v-on:submit.prevent="updateBrewer">
      <div class="form-element">
            <label for="brewery-selector">Select a brewery: </label><br>
            <select id="brewery-selector-bttn" type="text" v-model="breweryToUpdate">
                <option v-bind:value="brewery" v-for="brewery in allBreweries" v-bind:key="brewery.id">
                    {{ brewery.name }}</option>
            </select>
        </div>
      <br>
      <div class="form-element">
            <label for="brewer-selector">Select a brewer to manage this brewery: </label><br>
            <select id="brewer-selector-bttn" type="text" v-model="breweryToUpdate.ownerId">
                <option v-bind:value="user.id" v-for="user in brewerList" v-bind:key="user.id">
                    {{ user.username }}</option>
            </select>
        </div>
        <br>
    <input type="submit" value="Save">
    <input type="button" value="Cancel" v-on:click.prevent="resetForm()">
        

  </form>
</template>

<script>
import breweryService from '../../services/BreweryService'
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
.brewer-selector-bttn{
   font-family: 'Poppins', sans-serif;
}

.brewery-selector-bttn{
   font-family: 'Poppins', sans-serif; 
}


.container-assign-brewer {
    font-family: 'Poppins', sans-serif;
    font-size: 2vw;
    text-align: center;
    display: block;
    border-radius: 3vw;
    padding: 1.5vw;
    justify-content: space-evenly;
    justify-items: center;
    align-content: space-evenly;
    align-items: center;
    margin-left: 20vw;
    margin-right: 20vw;
}

</style>