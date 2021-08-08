import axios from 'axios';



export default {
    getBreweryReviews(breweryId){
        return axios.get(`/breweries/${breweryId}/reviews`);
    },
    getBeerReviews(breweryId, beerId){
        return axios.get(`/breweries/${breweryId}/beers/${beerId}/reviews`);
    },

    createReview1(review){
        return axios.post('/breweries/${breweryId}/reviews', review);
      },

      createBeerReview(review){
        return axios.post('/breweries/${breweryId}/beers/${beerId}/reviews', review);
      },

    getUserReviews(userId){
        return axios.get('/account/reviews', {
            params: {
                id: userId
            }
        });
    }
}