<template>
    <v-card-actions>
        <v-btn type="reset" class="mt-2" text="Limpar" color="#3949AB" />
        <v-spacer />
        <v-btn type="reset" class="mt-2" color="#3949AB" text="Cancelar" to="/reports" />
        <v-btn type="submit" class="mt-2" variant="tonal" color="#3949AB" text="Enviar" @click.prevent="saveReport()" />
    </v-card-actions>
</template>

<script setup lang="ts">
import router from '@/router';
import { Report } from '@/model/Report'
import { save } from '@/services/reportService'
import { useReportStore } from '@/store/reportStore';
import { storeToRefs } from 'pinia';

const reportStore = useReportStore();
const { reportDefault } = storeToRefs(reportStore);

const createReport = () => {
    const report = new Report();
    report.id = reportDefault.value.id;
    report.title = reportDefault.value.title;
    report.description = reportDefault.value.description;
    report.createdAt = reportDefault.value.createdAt;
    report.updatedAt = reportDefault.value.updatedAt;
    return report;
}

const saveReport = async () => {
    await save(createReport());
    router.push('/reports')
}

</script>