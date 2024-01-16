<template>
    <ReportListToolbar />
    <v-card flat class="mx-4">
        <v-data-table 
            no-data-text="Nenhum relatório encontrado." 
            items-per-page-text="Total por página" 
            :headers="headers"
            :items="reports" 
            item-key="id">

            <template v-slot:[`item.title`]="{ item }">
                <ReportViewButton :titulo="item.title" :report-id="item.id" />
            </template>

            <template v-slot:[`item.acoes`]="{ item }">
                <ReportEditButton :report-id="item.id" />
                <ReportDeleteButton @delete-item="removeReport(item.id)" /> 
            </template>
        </v-data-table>
    </v-card>
</template>
<script setup lang="ts">
import ReportEditButton from '@/components/ReportListComponents/ReportEditButton.vue'
import ReportDeleteButton from '@/components/ReportListComponents/ReportDeleteButton.vue'
import ReportViewButton from '@/components/ReportListComponents/ReportViewButton.vue'
import ReportListToolbar from '@/components/ReportListComponents/ReportListToolbar.vue';
import { Report } from '@/model/Report';
import { getAll, remove } from '@/services/reportService';
import { ref, onMounted } from 'vue';

const reports = ref<Report[]>([]);

const headers: any = [
    { title: 'Título', value: 'id', key: 'title', align: 'start' },
    { title: 'Ações', value: 'id', key: 'acoes', sortable: false }
]

const listingReports = async () => {
    const response = await getAll();
    reports.value = response;
}

const removeReport = async (id: number) => {
    await remove(id);
    await listingReports();
}

onMounted(() => {
    listingReports();
})
</script>