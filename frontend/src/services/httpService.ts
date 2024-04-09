import axios, { AxiosHeaders } from 'axios';
import { AxiosInstance } from 'axios';

const instance = axios.create({
  baseURL: 'http://localhost:8080/',
  headers: new AxiosHeaders({
    'Content-Type': 'application/json',
  })
})

const getAxiosClient = (): AxiosInstance => instance;

const httpService = {
  getAxiosClient
}

export default httpService;
