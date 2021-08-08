<template>
  <div id='admin-menu'>
    <router-link id="map-button" v-bind:to="{ name: 'manage-brewers-display' }">Map a Brewer to a Brewery.</router-link>
    <router-link id="add-button" v-bind:to="{ name: 'add-brewery-display' }">Add a new Brewery.</router-link>
  </div>
</template>

<script>
export default {
    name: 'admin'

}
</script>

<style>

</style>