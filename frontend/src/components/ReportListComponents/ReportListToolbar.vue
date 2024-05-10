<template>
  <v-toolbar class="bg-transparent">
    <span class="text-h5 mx-4 font-weight-medium">Meus relatórios</span>
    <v-chip>{{ props.totalElements }}</v-chip>
    <v-spacer/>
    <v-btn
      variant="tonal"
      color="success"
      prepend-icon="mdi-plus"
      text="Novo"
      to="/form/novo"
      @click="!isEditing"
    />
  </v-toolbar>
</template>
<script lang="ts" setup>
import {useReportStore} from '@/store/reportStore';
import {storeToRefs} from 'pinia';

const props = defineProps({
  totalElements: Number
});
const reportStore = useReportStore();
const {isEditing} = storeToRefs(reportStore);
</script>
