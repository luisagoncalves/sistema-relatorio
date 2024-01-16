<template>
  <v-tooltip text="Visualizar" location="top">
    <template v-slot:activator="{ props }">
      <v-btn v-bind="props" :to="`/form/${reportId}`" @click="isEditing = false">{{ titulo }}</v-btn>
    </template>
  </v-tooltip>
</template>
<script setup lang="ts">
import { useReportStore } from '@/store/reportStore';
import { storeToRefs } from 'pinia';

defineProps(['titulo', 'reportId']);

const reportStore = useReportStore();
const { isEditing } = storeToRefs(reportStore);
</script>