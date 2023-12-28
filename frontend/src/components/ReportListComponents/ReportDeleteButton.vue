<template>
  <v-tooltip 
    text="Excluir" 
    location="top">
    <template v-slot:activator="{ props }">
      <v-btn 
        v-bind="props" 
        icon 
        flat 
        class="bg-transparent">
        <v-icon 
          icon="mdi-delete"
          color="#3949AB" />
      </v-btn>
    </template>
  </v-tooltip>
</template>

<script lang="ts" setup>
const emit = defineEmits(['click']);
emit('click');
</script>