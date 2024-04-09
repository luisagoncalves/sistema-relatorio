import {Report} from "@/model/Report";
import httpService from "./httpService";

const url = "/reports"

export const save = async (report: Report): Promise<any> => {
  return await httpService.getAxiosClient().post(`${url}`, report);
}

export const update = async (report: Report, id: string | string[] | number): Promise<any> => {
  return await httpService.getAxiosClient().put(`${url}/${id}`, report);
}

export const getAll = async (): Promise<any> => {
  const response = await httpService.getAxiosClient().get(`${url}`);
  return response.data;
}

export const getById = async (id: string | string[]): Promise<any> => {
  return await httpService.getAxiosClient().get(`${url}/${id}`);
}

export const remove = async (id: number): Promise<any> => {
  return await httpService.getAxiosClient().delete(`${url}/${id}`);
}
