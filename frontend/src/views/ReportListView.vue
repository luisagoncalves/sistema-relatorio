<template>
  <ReportListToolbar :total-elements="totalReports"/>
  <v-card flat class="mx-4">
    <v-data-table-server
      :headers="headers"
      :items="reports"
      v-model:items-per-page="itemsPerPage"
      :items-length="totalReports"
      :loading="loadingItems"
      loading-text="Buscando relatórios..."
      no-data-text="Nenhum relatório encontrado."
      items-per-page-text="Total por página"
      :page-text="pageText"
      @update:options="listingReports"
      :hover="true">

      <template v-slot:[`item.title`]="{item}">
        <ReportViewButton :titulo="item.title" :item-id="item.id" :descricao="item.description"/>
      </template>

      <template v-slot:[`item.acoes`]="{item}">
        <ReportEditButton :item-id="item.id" />
        <ReportDeleteButton :item-id="item.id" @delete-item="removeReport"/>
      </template>
    </v-data-table-server>
  </v-card>
</template>
<script setup lang="ts">
import ReportEditButton from '@/components/ReportListComponents/ReportEditButton.vue'
import ReportDeleteButton from '@/components/ReportListComponents/ReportDeleteButton.vue'
import ReportViewButton from '@/components/ReportListComponents/ReportViewButton.vue'
import ReportListToolbar from '@/components/ReportListComponents/ReportListToolbar.vue';
import {getAll, remove} from '@/services/reportService';
import {ref} from 'vue';
import {useLayoutStore} from "@/store/layoutStore";

const snackbarStore = useLayoutStore();

const loadingItems = ref(true);
const totalReports = ref(0);
const itemsPerPage = ref(5);
const reports = ref([]);
const pageText = ref('');

const headers: any = [
  {title: 'Título', value: 'id', key: 'title', align: 'start'},
  {title: 'Ações', value: 'id', key: 'acoes', sortable: false}
]

const listingReports = async (filter?: any) => {
  const response = await getAll(filter?.page, filter?.itemsPerPage);
  reports.value = response.content;
  totalReports.value = response.totalElements;
  loadingItems.value = false;
  pageText.value = `${response.numberOfElements} de ${itemsPerPage.value} `
}

const removeReport = async (id: number) => {
  const response = await remove(id);
  if (response.status == 200) {
    snackbarStore.createSnackbar('success', 'Relatório excluído com sucesso!');
  }
  await listingReports();
}
</script>
