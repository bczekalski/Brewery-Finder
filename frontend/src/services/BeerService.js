import axios from 'axios';


export default {
    getBeers(id){
        return axios.get(`/breweries/${id}/beers`);
    },
    getBeersById(breweryId, id){
        return axios.get(`/breweries/${breweryId}/beers/${id}`);
    }
}