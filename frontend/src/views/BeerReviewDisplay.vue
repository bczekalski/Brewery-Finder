<template>
<div id='beer-review-list'>
  <beer-reviews />
  </div>
</template>

<script>
import BeerReviews from '../components/BeerReviews'
export default {
    name: 'beer-review-display',
    components: {
        BeerReviews
    }

}
</script>

<style>

</style>