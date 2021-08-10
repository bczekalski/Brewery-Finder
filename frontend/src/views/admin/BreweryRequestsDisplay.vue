<template>
  <div id="breweries">
      
    <div class="brewery-list">
        <div class="container-brewery container-blur">
        <router-link id="admin-button" class="link-in-black" v-bind:to="{ name: 'admin-display' }" >Return to Admin Menu </router-link>
        </div>
        <div v-for="brewery in allBreweries" v-bind:key="brewery.id">
        <div class="container-brewery container-blur" v-if="brewery.active == false">
            <button v-on:click.prevent="activateBrewery(brewery)">Approve this brewery request?</button>
            <h2 class="brewery-name">{{ brewery.name }}</h2>
            <div class="brewery-details">
                <div class="brewery-history a">History: {{ brewery.history }}</div>
                <div class="contact-info a">Contact Information: {{ brewery.contactInfo }}</div>
                <div id="hours-text" class="operation-time a">Hours: 
                    <ul class="hours-list">
                    <li v-for="day in splitJoin(brewery.operationTime)" v-bind:key="day"> {{ day }} </li>
                    </ul>
                    </div>
                <div class="full-address a">
                <div class="address-line-1">Address: {{ brewery.address }}</div>
                <div class="address-line-2"> 
                    </div>
                    {{brewery.city}},  {{brewery.state}}  {{brewery.zipCode}}  </div>
                
                <div><a :href="brewery.website"><img class="logo-image a" :src="brewery.image" alt="Brewery Logo" :href="brewery.website"></a></div>
            <router-link id="reviews-button" class="link-in-black" v-bind:to="{ name: 'brewery-review-display', params: {breweryId: brewery.id } }">View reviews</router-link>
            </div>
            <br><br><br>
        </div>
        </div>
    </div>
  </div>
</template>

<script>
import breweryService from '../../services/BreweryService'
export default {
    name: 'brewery-requests-display',
    data(){
        return{
            allBreweries: []
        }
    },
    created() {
        breweryService.getBreweries()
            .then(response => {
                this.allBreweries = response.data;
            }); 
    },
    methods: {
        activateBrewery(brewery){
            brewery.active = true;
            breweryService.updateBrewery(brewery);
            /*var allActive = true;
            for (let i = 0; i<this.allBreweries.length; i++){
                if (this.allBreweries[i].active == false){
                    allActive = false;
                }
            }
            if(allActive){
                this.$router.push('/')
            }else{
                window.location.reload();
            }*/
        },
        splitJoin(time){
            return time.split(', ')
    }
    }

}
</script>

<style>

</style>