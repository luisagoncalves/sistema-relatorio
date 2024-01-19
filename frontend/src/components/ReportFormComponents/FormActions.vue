<template>
    <v-card-actions v-if="isEditing">
        <v-btn type="reset" class="mt-2" text="Limpar" />
        <v-spacer />
        <v-btn type="reset" class="mt-2" text="Cancelar" to="/reports" />
        <v-btn type="submit" class="mt-2" text="Salvar" @click.prevent="saveReport()" />
    </v-card-actions>

    <v-card-actions v-if="!isEditing">
        <v-spacer />
        <v-btn to="/reports" class="mt-2" text="Voltar" />
    </v-card-actions>
</template>

<script setup lang="ts">
import router from '@/router';
import { Report } from '@/model/Report';
import { getById, save, update } from '@/services/reportService';
import { useLayoutStore } from '@/store/layoutStore';
import { useReportStore } from '@/store/reportStore';
import { storeToRefs } from 'pinia';
import { onMounted } from 'vue';
import { useRoute } from 'vue-router';

const snackbarStore = useLayoutStore();

const route = useRoute();
const reportStore = useReportStore();
const { reportDefault, isEditing } = storeToRefs(reportStore);

const createReport = () => {
    const report = new Report();
    report.id = reportDefault.value.id;
    report.title = reportDefault.value.title;
    report.description = reportDefault.value.description;
    report.createdAt = reportDefault.value.createdAt;
    report.updatedAt = reportDefault.value.updatedAt;
    return report;
}

const updateReport = () => {
    const report = new Report();
    report.id = reportDefault.value.id;
    report.title = reportDefault.value.title;
    report.description = reportDefault.value.description;
    report.createdAt = reportDefault.value.createdAt;
    report.updatedAt = reportDefault.value.updatedAt;
    return report;
}

const getReportById = async (id: string | string[]) => {
    const response = await getById(id);
    reportDefault.value = response;
}

const saveReport = async () => {
    if (route.params['id'] != null && route.params['id'] != 'novo') {
        await update(updateReport())
            .then(() => snackbarStore.createSnackbar('success', 'Relatório atualizado com sucesso!'))
            .catch(() => snackbarStore.createSnackbar('error', 'Erro ao atualizar relatório. Tente novamente.'));
    } else {
        await save(createReport())
            .then(() => snackbarStore.createSnackbar('success', 'Relatório cadastrado com sucesso!'))
            .catch(() => snackbarStore.createSnackbar('error', 'Erro ao cadastrar relatório. Tente novamente.'));
    }
    router.push('/reports');
}

onMounted(async () => {
    if (route.params['id'] != null && route.params['id'] != 'novo') {
        await getReportById(route.params['id']);
    }
})
</script>