<template>
  <ReportListToolbar/>
  <v-card flat class="mx-4">
    <v-data-table
      :headers="headers"
      :items="reports"
      :loading="loadingItems"
      loading-text="Buscando relatórios..."
      no-data-text="Nenhum relatório encontrado."
      items-per-page-text="Total por página"
      :items-per-page="itemsPerPage"
      :search="search">
      
      <template v-slot:top>
        <v-text-field
          v-model="search"
          variant="outlined"
          class="mx-4"
          max-width="20"
          placeholder="Pesquisa"
          prepend-inner-icon="mdi-magnify"
        ></v-text-field>
      </template>

      <template v-slot:[`item.title`]="{item}">
        <ReportViewButton :titulo="item.title" :item-id="item.id" :descricao="item.description"/>
      </template>

      <template v-slot:[`item.acoes`]="{item}">
        <ReportEditButton :item-id="item.id" />
        <ReportDeleteButton :item-id="item.id" @delete-item="removeReport"/>
      </template>
    </v-data-table>
  </v-card>
</template>
<script setup lang="ts">
import ReportEditButton from '@/components/ReportListComponents/ReportEditButton.vue'
import ReportDeleteButton from '@/components/ReportListComponents/ReportDeleteButton.vue'
import ReportViewButton from '@/components/ReportListComponents/ReportViewButton.vue'
import ReportListToolbar from '@/components/ReportListComponents/ReportListToolbar.vue';
import {getAll, remove} from '@/services/reportService';
import {onMounted, ref} from 'vue';

const loadingItems = ref(true);
const itemsPerPage = ref(5);
const search = ref('');
const reports = ref([]);

const headers: any = [
  {title: 'Título', value: 'id', key: 'title', align: 'start'},
  {title: 'Ações', value: 'id', key: 'acoes', sortable: false}
]

const listingReports = async (page: number = 0) => {
  const response = await getAll(page);
  reports.value = response.content;
  loadingItems.value = false;
}

const removeReport = async (id: number) => {
  await remove(id);
  await listingReports();
}

onMounted(() => {
  listingReports();
})
</script>
