import axios from 'axios';


const http = axios.create({
    baseURL: "http://localhost:8080"
});

export default {
    getBreweryReviews(breweryId){
        return http.get(`/breweries/${breweryId}/reviews`);
    },
    getBeerReviews(breweryId, beerId){
        return http.get(`/breweries/${breweryId}/beers/${beerId}/reviews`);
    }
}