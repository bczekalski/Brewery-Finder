<template>
<div>
    <h2 id="username">Welcome {{this.$store.state.user.username}}!</h2>
  <router-link id="reviews-button" v-bind:to="{ name: 'user-reviews-display' }">View the reviews you have written. </router-link>
  <router-link id="breweries-button" v-bind:to="{ name: 'user-breweries-display' }" 
  v-if="$store.state.user.authorities[0].name == 'ROLE_BREWER'">Manage your breweries. </router-link>
</div>
</template>

<script>
export default {
    name: 'my-account'

}
</script>

<style>

</style>