<template>
    <v-textarea color="#3949AB" class="my-2" label="Descrição" :counter="1000" :rules="rules" required v-model="reportDefault.description"/>
</template>

<script setup lang="ts">
import { useReportStore } from '@/store/reportStore';
import { storeToRefs } from 'pinia';

const reportStore = useReportStore();
const { reportDefault } = storeToRefs(reportStore);

const rules = [
    (v: string | any[]) => !!v || 'Campo obrigatório.',
    (v: string | any[]) => v.length <= 1000 || 'O limite de 1000 caracteres foi atingido.'
];

</script>