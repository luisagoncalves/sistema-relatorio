<template>
  <v-tooltip 
    text="Visualizar" 
    location="top">
    <template v-slot:activator="{ props }">
      <v-btn 
        v-bind="props" 
        icon 
        flat 
        class="bg-transparent">
        <v-icon 
          icon="mdi-eye" 
          color="#3949AB" />
      </v-btn>
    </template>
  </v-tooltip>
</template>