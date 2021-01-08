import axios from "axios";

const API_URL = 'https://devsuperior-2021.herokuapp.com'

export function fetchProducts() {
  return axios(`${API_URL}/products`)
}