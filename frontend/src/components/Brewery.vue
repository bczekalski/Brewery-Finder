<template>
  <div id="breweries">
    <div class="brewery-list">
        <div class="container-breweries">
            <h2 class="brewery-name">{{ brewery.name }}</h2>
            <div class="brewery-details">
                <div class="brewery-history a">History: {{ brewery.history }}</div>
                <div class="contact-info a">Contact Information: {{ brewery.contactInfo }}</div>
                <div class="operation-time a">Hours: {{ brewery.operationTime }}</div>
                <div class="full-address a">
                <div class="address-line-1">Address: {{ brewery.address }}</div>
                <div class="address-line-2"> 
                    </div>
                    {{brewery.city}},  {{brewery.state}}  {{brewery.zipCode}}  </div>
                <div><a class="brewery-website a" :href="brewery.website" target="_blank" :alt="brewery-website" >Website</a></div>
                <div><img class="logo-image a" :src="brewery.image" alt="Brewery Logo"></div>
            <router-link id="reviews-button" v-bind:to="{ name: 'brewery-review-display', params: {breweryId: brewery.id } }">View reviews</router-link>
            </div>
        </div>
        <br><br><br>
    </div>
  </div>
</template>

<script>
import breweryService from "../services/BreweryService.js"
export default {
    name: "breweries",
    data() {
        return {
            brewery: {},
            website: ''
        }
        },
        created(){
            breweryService.getById(this.$route.params.breweryId)
            .then(response => {
                this.brewery = response.data;
            }); 
        }
    }

    

</script>


<style>
.container-breweries {
  font-family: 'Poppins', sans-serif;
  font-size: 3vw;
  text-align: center;
  background-color: white;
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
.brewery-details {
    font-size: 1.5vw;
}

.brewery-history {
    font-style:italic;
    text-align: left;
}

.a {
    padding: 1.5vw;
}

.logo-image {
    width: 35vw;
}


</style>