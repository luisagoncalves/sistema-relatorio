import axios, { AxiosHeaders, AxiosRequestConfig, AxiosRequestHeaders, InternalAxiosRequestConfig } from 'axios';
import { AxiosInstance } from 'axios';

interface AdaptAxiosRequestConfig extends AxiosRequestConfig {
  headers: AxiosRequestHeaders
}

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