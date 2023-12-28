<template>
    <ReportListToolbar />
    <v-card flat class="mx-4">
        <v-data-table 
            no-data-text="Nenhum relatório encontrado." 
            items-per-page-text="Total por página" 
            :headers="headers"
            :items="reports" 
            :loading="isLoading" 
            loading-text="Buscando relatórios..." 
            item-key="id">

            <template v-slot:[`item.acoes`]="{ item }">
                <ReportViewButton />
                <ReportEditButton  />
                <ReportDeleteButton @click="removeReport(item.id)" /> 
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
import { Ref, ref, onMounted } from 'vue';

const isLoading: Ref<boolean> = ref(true);

const reports = ref<Report[]>([]);

const headers: any = [
    { title: 'Título', value: 'title', key: 'title', sortable: true, align: 'start' },
    { title: 'Data de Cadastro', value: 'createdAt', key: 'createdAt' },
    { title: 'Data de Atualização', value: 'updatedAt', key: 'updatedAt' },
    { title: 'Ações', value: 'id', key: 'acoes' }
]

const listingReports = async () => {
    const response = await getAll();
    reports.value = response;

    if (reports.value.length > 0) {
        setTimeout(() => {
            isLoading.value = false;
        }, 1000)
    }
}

const removeReport = async (id: number) => {
    await remove(id);
}

onMounted(() => {
    listingReports();
})
</script>