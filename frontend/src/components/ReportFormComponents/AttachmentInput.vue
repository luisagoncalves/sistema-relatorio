<template>
    <v-file-input color="#3949AB" class="my-2" label="Anexo" @change="reportDefault.anexos"/>
</template>

<script setup lang="ts">
import { useReportStore } from '@/store/reportStore';
import { storeToRefs } from 'pinia';

const reportStore = useReportStore();
const { reportDefault } = storeToRefs(reportStore);
</script>