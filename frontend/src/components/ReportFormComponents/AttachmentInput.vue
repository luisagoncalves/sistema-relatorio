<template>
    <v-file-input color="#3949AB" class="my-2" label="Anexo" @change="reportDefault.attachments"/>
</template>

<script setup lang="ts">
import { useReportStore } from '@/store/reportStore';
import { storeToRefs } from 'pinia';
import { onMounted } from 'vue';

const reportStore = useReportStore();
const { reportDefault } = storeToRefs(reportStore);

onMounted(() => {
    reportDefault.value.attachments = undefined;
})
</script>