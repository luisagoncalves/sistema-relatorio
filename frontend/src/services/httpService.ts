import axios from 'axios';
import { AxiosInstance } from 'axios';

const instance = axios.create({
  baseURL: 'http://localhost:8080/'
})

const getAxiosClient = (): AxiosInstance => instance;

const httpService = {
  getAxiosClient
}

export default httpService;