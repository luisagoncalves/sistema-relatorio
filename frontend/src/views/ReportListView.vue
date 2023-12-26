<template>
    <ReportListToolbar/>
    <v-card flat class="mx-4">
        <v-data-table 
            no-data-text="Nenhum relatório encontrado."
            items-per-page-text="Total por página"
            :page-text="pageText"
            :headers="headers"
            :items="items"
            :loading="isLoading"
            loading-text="Buscando relatórios..."
            item-key="id">

        </v-data-table>
    </v-card>
    
</template>
<script setup lang="ts">
import ReportListToolbar from '@/components/ReportListToolbar.vue';
import { Report } from '@/model/Report';
import { Ref, ref, onMounted } from 'vue';

const pageText: any = ref('-');
const isLoading: Ref<boolean> = ref(true);

const listingItems = () => {
    if (items.length == 0) {
        setTimeout(() => {
            isLoading.value = false;
        }, 3000)
    }
}

const items: Report[] = [];

const headers: any = [
    { title: 'Título', value: 'title', key: 'title', sortable: true , align: 'start' },
    { title: 'Data de Cadastro', value: 'dataCadastro', key: 'dataCadastro' },
    { title: 'Data de Atualização', value: 'dataAtualizacao', key: 'dataAtualizacao' }
]

onMounted(() => {
    listingItems();
})
</script>