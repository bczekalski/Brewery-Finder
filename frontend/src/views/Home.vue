<template>
  <section>

    <figure class="image center">
      <!-- <img src ="images/c61ca5bebd5fac190227f602ab0d6fe8.png" style="max-width: 128px;"> -->
    </figure>
    <div id="grid">
      <div id="list" class="container-home">
        <div>
          <router-link id="home-page-button" v-bind:to="{ name: 'breweries-display' }">List of Breweries</router-link>
        </div>
      </div>    
      <div id="beer" class="container-home">
        <div>
          <router-link id="home-page-button" v-bind:to="{ name: 'featured-beer' }">Featured Beer</router-link>
        </div>
      </div>
      <div id="events" class="container-home">
        <router-link id="home-page-button" v-bind:to="{ name: 'events' }">Brewery Events</router-link>
      </div>
    </div>
  </section>
</template>



<script>
export default {
  name: "home"
};
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap');

.container-home {
  font-family: 'Poppins', sans-serif;
  font-size: 3vw;
  text-align: center;
  background-color: white;
  display: block;
  border-radius:3vw;
  padding: 3vw;
  justify-content: space-evenly;
  justify-items: center;
  align-content: space-evenly;
  align-items: center;
}


#list {
    grid-area: "list";
}

#beer {
    grid-area: "beer";
}

#events {
    grid-area: "events";
}

#grid {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    grid-template-areas: "list beer events";
    row-gap: 20px;
    column-gap: 1fr;
    align-items: center;
    justify-content: space-evenly;
    justify-items: center;
    align-content: space-evenly;
}

#home-page-button {
  color: black;
}

@media screen and (max-width: 450px){
    #grid{
        display: grid;
        row-gap: 20px;
        column-gap: 20px;
        align-items: center;
        justify-content: space-evenly;
        justify-items: center;
        align-content: space-evenly;
        grid-template-columns: 1fr;
        grid-template-areas: "list"
        "beer"
        "events"
        ;
    }
}

</style>
