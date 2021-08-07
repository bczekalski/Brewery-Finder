import axios from 'axios';



export default {
    getBreweries(){
        return axios.get('/breweries');
    },
    getById(id){
        return axios.get(`/breweries/${id}`);
    },
    getByUserId(){
        return axios.get('/account/breweries')
    },
    isUserOwner(id){
        return axios.get(`/breweries/${id}/user`);
    }
}