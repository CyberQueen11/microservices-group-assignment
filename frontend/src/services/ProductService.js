import axios from 'axios';

const BASE_URL = 'http://localhost:8081'; // Spring Boot backend

export const getAllProducts = async () => {
    return axios.get(`${BASE_URL}/getAllProducts`);
};

export const createProduct = async (product) => {
    return axios.post(`${BASE_URL}/insertOne`, product);
};

export const updateProduct = async (product) => {
    return axios.put(`${BASE_URL}/update`, product);
};

export const deleteProduct = async (product) => {
    return axios.delete(`${BASE_URL}/delete`, { data: product });
};
