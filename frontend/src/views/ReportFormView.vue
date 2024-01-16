<template>
    <v-container>
        <v-card flat>
            <v-card-title v-if="reportDefault.id != null && route.params['id'] != 'novo'">Relatório {{ reportDefault.id }}</v-card-title>
            <v-card-title v-else>Novo relatório</v-card-title>
            <v-card-item>
                <v-form @submit.prevent :readonly="!isEditing">
                    <TitleInput />
                    <DescriptionInput />
                    <AttachmentInput />
                    <FormActions />
                </v-form>
            </v-card-item>
        </v-card>
    </v-container>
</template>

<script setup lang="ts">
import TitleInput from '@/components/ReportFormComponents/TitleInput.vue';
import DescriptionInput from '@/components/ReportFormComponents/DescriptionInput.vue';
import AttachmentInput from '@/components/ReportFormComponents/AttachmentInput.vue';
import FormActions from '@/components/ReportFormComponents/FormActions.vue';
import { useReportStore } from '@/store/reportStore';
import { storeToRefs } from 'pinia';
import { useRoute } from 'vue-router';

const reportStore = useReportStore();
const { reportDefault, isEditing } = storeToRefs(reportStore);
const route = useRoute();
</script>