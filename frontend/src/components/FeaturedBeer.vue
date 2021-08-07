<template>
<div class="container-featured-beer">
    <h2>Featured Beer</h2>
 <h4 id='beer-brand'>{{ featuredBeer.brands}}</h4>
 <h4 id='product-name'>{{ featuredBeer.product_name }}</h4>
 <div><img class='beer-image' :src="featuredBeer.image_url" ></div>
 <!-- <h2>{{ featuredBeer.allergens }}</h2> -->
 
</div>
</template>

<script>
import featuredBeerService from '../services/FeaturedBeerService'
export default {
    name: 'featured-beer',
    data(){
        return {
            featuredBeer: {}
        }
    },
    created(){
        featuredBeerService.getFeaturedBeer().then((response) => {
            this.featuredBeer = response.data;
        })
    }
}
</script>

<style>

.container-featured-beer {
  font-family: 'Poppins', sans-serif;
  font-size: 3vw;
  text-align: center;
  background-color: white;
  display: block;
  border-radius:3vw;
  padding: 2vw;
  justify-content: space-evenly;
  justify-items: center;
  align-content: space-evenly;
  align-items: center;
  margin-left: 30vw;
  margin-right: 30vw;
}

#beer-brand {
    font-size: 2vw;
}

#product-name {
    font-size: 2vw;
}

</style>