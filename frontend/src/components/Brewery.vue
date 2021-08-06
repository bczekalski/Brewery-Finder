<template>
   <div class="brewery-list">
        <h2 class="brewery-name">{{ breweryDetails.name }}</h2>
        <div class="brewery-details">
        <p class="brewery-history">{{ breweryDetails.history }}</p>
        <p class="contact-info">{{ breweryDetails.contactInfo }}</p>
        <p class="operation-time">{{ breweryDetails.operationTime }}</p>
        <p class="full-address">{{ breweryDetails.address }}</p>
        </div>
      </div>
</template>

<script>
import breweryService from "../services/BreweryService"
export default {
    name: 'brewery',
    data() {
        return {
            breweryDetails: {}
        }
    },
    created() {
        breweryService.getById(1)
        .then(response => {
            this.breweryDetails = response.data;
        });
    }
}
</script>

<style>

</style>