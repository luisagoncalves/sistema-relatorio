<template>
  <v-tooltip text="Visualizar" location="top">
    <template v-slot:activator="{ props }">
      <v-btn v-bind="props" flat @click="isActive = true">{{ titulo }}</v-btn>
    </template>
  </v-tooltip>
  <v-dialog max-width="800" v-model="isActive">
    <v-card>
      <div class="d-flex justify-space-between ma-2">
        <v-card-title>
          {{ titulo }}
        </v-card-title>

        <v-btn flat>
          <v-icon @click="isActive = false">mdi-close</v-icon>
        </v-btn>
      </div>
      <v-card-text class="my-2">
        {{ descricao }}
      </v-card-text>
    </v-card>
  </v-dialog>
</template>
<script setup lang="ts">
import { ref } from 'vue';

defineProps(['titulo', 'itemId', 'descricao']);

const isActive = ref(false);
</script>
