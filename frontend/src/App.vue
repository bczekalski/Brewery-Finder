<template>
  <div id="app">
    <div id="nav">

      <router-link id="button" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;

      <router-link id="button" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link> 

      <router-link id="button" v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">Login</router-link> &nbsp;|&nbsp;

      <router-link id="button" v-bind:to="{ name: 'register' }" v-if="$store.state.token == ''">Register</router-link>

      <router-link id="button" v-bind:to="{ name: 'account' }" v-if="$store.state.token != ''">My Account</router-link>
    

    </div>
        <h1>
      Brewery Finder
    </h1>	
    <router-view />
  </div>
</template>

<style>
@import url('https://fonts.googleapis.com/css2?family=Lobster+Two:ital,wght@1,700&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Staatliches&display=swap');

h1 {
  font-family: 'Lobster Two', cursive;
  font-size: 12vw;
  color: white;
  text-align: center;
  text-shadow:
  -.5vw -.5vw 0 #000,
  .5vw -.5vw 0 #000,
  -.5vw .5vw 0 #000,
  .5vw .5vw 0 #000
  ;
}
html {
  background: url("https://images.unsplash.com/photo-1555658636-6e4a36218be7?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1950&q=80")  no-repeat center fixed;
  background-size: cover;
}

#nav {
  text-align: center;
  font-size: 5vw;
  color: white;
}

#button {
  font-family: 'Staatliches', cursive;
  font-size: 5vw;
  color: white;
}

#button:visited {
  font-family: 'Staatliches', cursive;
  font-size: xx-large;
  color: white;
}


</style>