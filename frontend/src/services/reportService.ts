import { Report } from "@/model/Report";
import httpService from "./httpService";

const url = "/reports"

export const save = async (report: Report): Promise<any> => {
  try {
    const response = await httpService.getAxiosClient().post(`${url}`, report);
    return response.data;
  } catch (error) {
    console.log(error);
  }
}

export const getAll = async (): Promise<any> => {
  try {
    const response = await httpService.getAxiosClient().get(`${url}`);
    return response.data;
  } catch (error) {
    console.log(error);
  }
}

export const remove = async (id: number): Promise<any> => {
  try {
    const response = await httpService.getAxiosClient().delete(`${url}/${id}`);
    return response.data;
  } catch (error) {
    console.log(error);
  }
}