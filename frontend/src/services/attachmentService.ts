import httpService from "./httpService";

const url = "/attachments";

export const getAttachmentByReportId = async (id: string | string[]): Promise<any> => {
  return await httpService.getAxiosClient().get(`${url}/${id}`);
}

export const deleteById = async (id: number | undefined): Promise<any> => {
  return await httpService.getAxiosClient().delete(`${url}/${id}`);
}

