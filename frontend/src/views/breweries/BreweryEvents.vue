<template>
<div>
    <div class="container-events container-blur">
        <router-link id="brewery-details-button" class="link-in-black" v-bind:to="{ name: 'brewery-display', params: {breweryId: brewery.id } }">Back to Brewery</router-link>
        <h2>Upcoming Events for {{brewery.name}}:</h2>
    </div>
    <div class="container-events container-blur" v-for="event in allEvents" :key="event.id">
        <h2>{{event.name}}</h2>
        <p>{{event.description}}</p>
        <h2>{{convertTime(event.startTime)}} - {{convertTime(event.endTime)}}</h2>
        <h2>{{convertDate(event.date)}}</h2>
        <h2 v-for='(l,i) in convertLocation(event.location)' :key="i">{{l}}</h2>
    </div>
  </div>
</template>

<script>
import breweryService from '../../services/BreweryService'
import eventService from '../../services/EventService'
import { DateTime }  from "luxon";
export default {
    name: "brewery-events",
    data(){
        return{
            allEvents: [],
            brewery: {}
        }
    },
    created(){
        eventService.getUpcomingBreweryEvents(this.$route.params.breweryId).then((response) => {
            this.allEvents = response.data;
        }),
        breweryService.getById(this.$route.params.breweryId).then(response => {
                this.brewery = response.data;
        });
    },
    methods: {
        convertTime(time){
            return DateTime.fromFormat(time, 'HH:mm:ss').toFormat('h:mm a');
        },
        convertDate(date){
            return DateTime.fromFormat(date, 'yyyy-mm-dd').toFormat('mm/dd/yyyy');
        },
        convertLocation(location){
            return location.split(':');
        }
    }
};
</script>

<style>
.container-events {
  font-family: 'Poppins', sans-serif;
  font-size: 3vw;
  text-align: center;
  display: block;
  border-radius:3vw;
  padding: 3vw;
  justify-content: space-evenly;
  justify-items: center;
  align-content: space-evenly;
  align-items: center;
}

</style>