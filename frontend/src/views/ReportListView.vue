<template>

    <v-card>
        <ReportListToolbar />

        <v-data-table 
            no-data-text="Nenhum relatório encontrado."
            :headers="headers"
            :items="items"
            item-key="id">

        </v-data-table>
    </v-card>
    
</template>
<script setup lang="ts">
import ReportListToolbar from '@/components/ReportListToolbar.vue';
import Report from '@/model/Report';

const items: Report[] = [];

const headers: any = [
    { title: 'Título', value: 'title', key: 'title', sortable: true , align: 'start' },
    { title: 'Data de Cadastro', value: 'dataCadastro', key: 'dataCadastro' },
    { title: 'Data de Atualização', value: 'dataAtualizacao', key: 'dataAtualizacao' }
]
</script>