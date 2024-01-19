<template>
  <v-app>
    <default-bar />

    <default-nav-drawer />

    <default-view />

    <snackbar-view />
  </v-app>
</template>

<script lang="ts" setup>
  import DefaultBar from './AppBar.vue'
  import DefaultNavDrawer from './NavigationDrawer.vue'
  import DefaultView from './View.vue'
  import SnackbarView from '@/components/Snackbar.vue';
</script>
