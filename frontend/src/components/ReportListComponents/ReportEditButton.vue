<template>
  <v-tooltip 
    text="Editar" 
    location="top">
    <template v-slot:activator="{ props }">
      <v-btn 
        v-bind="props" 
        icon 
        flat 
        class="bg-transparent">
        <v-icon 
          icon="mdi-pencil"
          color="#3949AB" />
      </v-btn>
    </template>
  </v-tooltip>
</template>