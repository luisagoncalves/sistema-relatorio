<template>
    <v-navigation-drawer v-model="openDrawer">
        <v-list density="compact" nav>
            <v-list-item prepend-icon="mdi-file-multiple" title="Meus relatórios" to="/reports" />
        </v-list>
    </v-navigation-drawer>
</template>

<script lang="ts" setup>
import { useLayoutStore } from '@/store/layoutStore';
import { storeToRefs } from 'pinia';

const layoutStore = useLayoutStore();
const { openDrawer } = storeToRefs(layoutStore);
</script>
