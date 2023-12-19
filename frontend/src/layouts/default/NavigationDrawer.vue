<template>
    <v-navigation-drawer v-model="openDrawer" />
</template>

<script lang="ts" setup>
import { useLayoutStore } from '@/store/layoutStore';
import { storeToRefs } from 'pinia';

const layoutStore = useLayoutStore();
const { openDrawer } = storeToRefs(layoutStore);
</script>
