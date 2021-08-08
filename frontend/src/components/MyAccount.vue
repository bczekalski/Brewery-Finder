<template>
<div class="container-blur container-account">
    <h2 id="username">Welcome {{this.$store.state.user.username}}!</h2>
    <router-link id="reviews-button" class="link-in-black" v-bind:to="{ name: 'user-reviews-display' }"
  v-if="$store.state.user.authorities[0].name == 'ROLE_USER'">View the reviews you have written. </router-link>
    <router-link id="breweries-button" class="link-in-black" v-bind:to="{ name: 'user-breweries-display' }" 
  v-if="$store.state.user.authorities[0].name == 'ROLE_BREWER'">Manage your breweries. </router-link>
    <router-link id="admin-button" class="link-in-black" v-bind:to="{ name: 'admin-display' }" 
  v-if="$store.state.user.authorities[0].name == 'ROLE_ADMIN'">Admin functions. </router-link>

</div>
</template>

<script>
export default {
    name: 'my-account'

}
</script>

<style>

.container-account {
    font-family: 'Poppins', sans-serif;
    font-size: 3vw;
    text-align: center;
    display: block;
    border-radius: 3vw;
    padding: 1.5vw;
    padding-bottom: 4vw;
    justify-content: space-evenly;
    justify-items: center;
    align-content: space-evenly;
    align-items: center;
    margin-left: 20vw;
    margin-right: 20vw;
}

</style>