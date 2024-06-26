import {Report} from "@/model/Report";
import httpService from "./httpService";
import {useLayoutStore} from "@/store/layoutStore";
import router from "@/router";

const url = "/api/reports"

export const save = async (report: Report): Promise<any> => {
  return await httpService.getAxiosClient().post(`${url}`, report)
    .then(async () => {
      useLayoutStore().createSnackbar('success', 'Relatório atualizado com sucesso!');
      await router.push('/reports');
    })
    .catch(() => {
      useLayoutStore().createSnackbar('error', 'Preencha os campos obrigatórios!');
    });
}

export const update = async (report: Report, id: string | string[] | number): Promise<any> => {
  return await httpService.getAxiosClient().put(`${url}/${id}`, report)
    .then(async () => {
      useLayoutStore().createSnackbar('success', 'Relatório cadastrado com sucesso!');
      await router.push('/reports');
    })
    .catch(() => {
      useLayoutStore().createSnackbar('error', 'Preencha os campos obrigatórios!');
    });
}

export const getAll = async (search: string = '', page: number = 0, pageSize: number = 5): Promise<any> => {
  if (page > 0) page--;
  const response = await httpService.getAxiosClient().get(`${url}?search=${search}&page=${page}&pageSize=${pageSize}`);
  return response.data;
}

export const getById = async (id: string | string[]): Promise<any> => {
  return await httpService.getAxiosClient().get(`${url}/${id}`);
}

export const remove = async (id: number): Promise<any> => {
  return await httpService.getAxiosClient().delete(`${url}/${id}`)
    .then(() => {
      useLayoutStore().createSnackbar('success', 'Relatório excluído com sucesso!');
    })
    .catch(() => {
      useLayoutStore().createSnackbar('error', 'Erro ao excluir relatório! Tente novamente.');
  });
}
