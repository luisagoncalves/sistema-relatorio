<template>
  <ReportListToolbar :total-elements="totalReports"/>

  <div class="d-flex justify-end">
    <v-text-field max-width="550" clearable placeholder="Título ou descrição" variant="underlined"
                  label="Pesquisar" @keydown.enter="searchingTitle" v-model="search">
    </v-text-field>

    <v-btn icon="mdi-magnify" variant="tonal" color="primary" @click="searchingTitle" class="ma-4" />
  </div>
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
    :search="search"
    @update:options="listingReports"
    :hover="true">
    <template v-slot:[`item.id`]="{item}">
      <ReportViewButton :titulo="item.title" :item-id="item.id" :descricao="item.description"/>
    </template>

    <template v-slot:[`item.acoes`]="{item}">
      <ReportEditButton :item-id="item.id"/>
      <ReportDeleteButton :item-id="item.id" @delete-item="removeReport"/>
    </template>
  </v-data-table-server>
</template>
<script setup lang="ts">
import ReportEditButton from '@/components/ReportListComponents/ReportEditButton.vue'
import ReportDeleteButton from '@/components/ReportListComponents/ReportDeleteButton.vue'
import ReportViewButton from '@/components/ReportListComponents/ReportViewButton.vue'
import ReportListToolbar from '@/components/ReportListComponents/ReportListToolbar.vue';
import {getAll, remove} from '@/services/reportService';
import {ref} from 'vue';

const loadingItems = ref(true);
const totalReports = ref(0);
const itemsPerPage = ref(5);
const reports = ref([]);
const pageText = ref('');
const search = ref('');
const titleSearched = ref('');

const headers: any = [
  {title: 'Título', value: 'id', key: 'id', align: 'start'},
  {title: 'Ações', value: 'id', key: 'acoes', sortable: false}
]

const listingReports = async (filter?: any) => {
  const response = await getAll(filter?.search, filter?.page, filter?.itemsPerPage);
  reports.value = response.content;
  totalReports.value = response.totalElements;
  loadingItems.value = false;
  pageText.value = `${response.numberOfElements} de ${itemsPerPage.value}`
}

const searchingTitle = () => {
  search.value = titleSearched.value;
}

const removeReport = async (id: number) => {
  await remove(id).then(async () => {
    await listingReports();
  });
}
</script>
