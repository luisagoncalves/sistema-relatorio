<template>
    <v-toolbar class="bg-transparent">
        <span class="text-h5 mx-4 font-weight-medium">Meus relatórios</span>

        <v-spacer />

        <v-btn 
            prepend-icon="mdi-plus" 
            text="Novo" 
            to="/form/novo" 
            @click="isEditing = true"/>
    </v-toolbar>
</template>
<script lang="ts" setup>
import { useReportStore } from '@/store/reportStore';
import { storeToRefs } from 'pinia';

const reportStore = useReportStore();
const { isEditing } = storeToRefs(reportStore);
</script>
