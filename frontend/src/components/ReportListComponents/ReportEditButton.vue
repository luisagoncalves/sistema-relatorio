<template>
  <v-tooltip text="Editar" location="top">
    <template v-slot:activator="{ props }">
      <v-btn v-bind="props" icon="mdi-pencil" flat :to="`/form/${reportId}`" @click="isEditing = true" />
    </template>
  </v-tooltip>
</template>

<script setup lang="ts">
import { useReportStore } from '@/store/reportStore';
import { storeToRefs } from 'pinia';

defineProps(['reportId'])

const reportStore = useReportStore();
const { isEditing } = storeToRefs(reportStore);
</script>