<template>
    <v-navigation-drawer v-model="openDrawer">
        <v-list density="compact" nav>
            <v-list-item prepend-icon="mdi-file-multiple" title="Meus relatórios" to="/reports" color="#3949AB" />
            <v-list-item prepend-icon="mdi-file-plus" title="Novo relatório" to="/form" color="#3949AB" />
        </v-list>
    </v-navigation-drawer>
</template>

<script lang="ts" setup>
import { useLayoutStore } from '@/store/layoutStore';
import { storeToRefs } from 'pinia';

const layoutStore = useLayoutStore();
const { openDrawer } = storeToRefs(layoutStore);

const items = ['Novo relatório', 'Meus relatórios']
</script>
