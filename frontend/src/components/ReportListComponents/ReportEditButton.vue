<template>
  <v-tooltip text="Editar" location="top">
    <template v-slot:activator="{ props }">
      <v-btn v-bind="props" icon="mdi-pencil" variant="text" color="blue" size="small" :to="`/form/${itemId}`" />
    </template>
  </v-tooltip>
</template>

<script setup lang="ts">
defineProps(['itemId']);
</script>
