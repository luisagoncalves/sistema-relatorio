import { Report } from "@/model/Report";
import httpService from "./httpService";

const url = "/reports"

export const save = async (report: Report) => {
  try {
    const response = await httpService.getAxiosClient().post(`${url}`, report);
    return response.data;
  } catch (error) {
    console.log(error);
  }
}

export const getAll = async () => {
  try {
    const response = await httpService.getAxiosClient().get(`${url}`);
    return response.data;
  } catch (error) {
    console.log(error);
  }
}