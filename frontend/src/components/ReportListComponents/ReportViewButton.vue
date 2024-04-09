<template>
  <v-tooltip text="Visualizar" location="top">
    <template v-slot:activator="{ props }">
      <v-btn v-bind="props" @click="generatingPdf" flat>{{ titulo }}</v-btn>
    </template>
  </v-tooltip>
</template>
<script setup lang="ts">
defineProps(['titulo', 'itemId']);

const generatingPdf = () => {
  alert("Vai gerar PDF")
}
</script>
