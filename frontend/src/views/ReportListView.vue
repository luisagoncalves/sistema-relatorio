<template>
  <ReportListToolbar/>
  <v-card flat class="mx-4">
    <v-data-table
      no-data-text="Nenhum relatório encontrado."
      items-per-page-text="Total por página"
      :headers="headers"
      :items="reports"
      item-key="id">

      <template v-slot:[`item.title`]="{item}">
        <ReportViewButton :titulo="item.title" :item-id="item.id"/>
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

const reports = ref([]);

const headers: any = [
  {title: 'Título', value: 'id', key: 'title', align: 'start'},
  {title: 'Ações', value: 'id', key: 'acoes', sortable: false}
]

const listingReports = async () => {
  const response = await getAll();
  reports.value = response.content;
}

const removeReport = async (id: number) => {
  await remove(id);
  await listingReports();
}

onMounted(() => {
  listingReports();
})
</script>
