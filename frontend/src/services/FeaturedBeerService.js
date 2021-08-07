import axios from 'axios';


const http = axios.create({
    baseURL: "http://localhost:8080"
});

export default {
    getFeaturedBeer(){
        return http.get(`/beers/random`);
    },

}