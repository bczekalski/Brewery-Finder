import axios from 'axios';



export default {
    getBreweryReviews(breweryId){
        return axios.get(`/breweries/${breweryId}/reviews`);
    },
    getBeerReviews(breweryId, beerId){
        return axios.get(`/breweries/${breweryId}/beers/${beerId}/reviews`);
    },
    getUserReviews(userId){
        return axios.get('/account/reviews', {
            params: {
                id: userId
            }
        });
    }
}