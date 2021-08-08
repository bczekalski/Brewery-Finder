<template>
  <div id="breweries-display">
        <breweries />
  </div>
</template>

<script>
import Breweries from "@/components/Breweries.vue";
export default {
    name: "breweries-display",
    components: {
        Breweries
    }
}
</script>

<style>

#breweries-display {
  font-family: 'Poppins', sans-serif;
  font-size: 3vw;
  text-align: center;
  backdrop-filter: blur(12px);
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

</style>