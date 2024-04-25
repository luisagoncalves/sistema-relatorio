<template>
   <v-snackbar location="top" v-model="snackbar.isActive" :color="snackbar.color" >
      {{ snackbar.text }}
      <template v-slot:actions>
        <v-btn
          variant="text"
          @click="snackbar.isActive = false"
        >
          Fechar
        </v-btn>
      </template>
   </v-snackbar>
</template>

<script setup lang="ts">
import { useLayoutStore } from '@/store/layoutStore';
import { storeToRefs } from 'pinia';

const snackbarStore = useLayoutStore();
const { snackbar } = storeToRefs(snackbarStore);
</script>
