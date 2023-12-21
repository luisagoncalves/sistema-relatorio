<template>
    <ReportListToolbar />

    <v-data-table 
        no-data-text="Nenhum relatório encontrado."
        :headers="headers"
        :items="items">

    </v-data-table>
</template>
<script setup lang="ts">
import ReportListToolbar from '@/components/ReportListToolbar.vue';

const items: any[] = [];

const headers: any = [
    { title: 'Título', value: 'title', key: 'title', sortable: true , align: 'start' },
    { title: 'Data de Cadastro', value: 'dataCadastro', key: 'dataCadastro' },
    { title: 'Data de Atualização', value: 'dataAtualizacao', key: 'dataAtualizacao' }
]
</script>