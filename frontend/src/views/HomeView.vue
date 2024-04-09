<template>
  <v-container>
    <v-card flat>
      <v-card-item class="d-flex justify-center my-11">
        <v-img :src="homeImg" width="250"></v-img>
      </v-card-item>
      <v-card-text class="text-center mt-4">
        <a class="text-primary text-decoration-none" href="/form/novo">Criar novo relatório
          <v-icon>mdi-plus</v-icon>
        </a>
      </v-card-text>
    </v-card>
  </v-container>
</template>
<script setup lang="ts">
import homeImg from "@/assets/img/home.svg"
</script>
