<template>
    <v-container>
        <v-card>
            <v-card-title>Novo relatório</v-card-title>
            <v-card-item>
                <v-form @submit.prevent>
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

</script>