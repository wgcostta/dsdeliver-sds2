import axios from "axios";

const API_URL = 'https://devsuperior-2021.herokuapp.com'
const mapboxToken = process.env.REACT_APP_ACCESS_TOKE_MAP

export function fetchProducts() {
  return axios(`${API_URL}/products`)
}

export function fetchLocalMapBox(local: string){
  return axios(`https://api.mapbox.com/geocoding/v5/mapbox.places/${local}.json?access_token=${mapboxToken}`)
}