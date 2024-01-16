<template>
  <v-tooltip 
    text="Excluir" 
    location="top">
    <template v-slot:activator="{ props }">
      <v-btn 
        v-bind="props" 
        icon="mdi-delete"
        flat
        @click="deleteItem" />
    </template>
  </v-tooltip>
</template>

<script lang="ts" setup>
const emit = defineEmits(['deleteItem']);

const deleteItem = async () => {
  await emit('deleteItem');
}
</script>