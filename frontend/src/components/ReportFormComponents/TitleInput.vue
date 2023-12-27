<template>
    <v-text-field color="#3949AB" class="my-2" label="Título" :rules="rules" required v-model="reportDefault.title"/>
</template>

<script setup lang="ts">
import { useReportStore } from '@/store/reportStore';
import { storeToRefs } from 'pinia';

const reportStore = useReportStore();
const { reportDefault } = storeToRefs(reportStore);

const rules = [
    (v: string | any[]) => !!v || 'Campo obrigatório.',
];
</script>