import axios from 'axios';


const http = axios.create({
    baseURL: "http://localhost:8080"
});

export default {
    getBeers(id){
        return http.get(`/breweries/${id}/beers`);
    },
    getBeersById(breweryId, id){
        return http.get(`/breweries/${breweryId}/beers/${id}`);
    }
}