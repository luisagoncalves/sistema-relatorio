<template>
  <v-tooltip text="Editar" location="top">
    <template v-slot:activator="{ props }">
      <v-btn v-bind="props" icon="mdi-pencil" flat :to="`/form/${itemId}`" />
    </template>
  </v-tooltip>
</template>

<script setup lang="ts">
import { useReportStore } from '@/store/reportStore';

defineProps(['itemId']);
</script>
