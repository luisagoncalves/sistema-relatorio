<template>
  <v-dialog v-model="dialogStatus" width="500" transition="dialog-bottom-transition">
    <template v-slot:activator="{ props: dialog }">
      <v-tooltip text="Excluir" location="top">
        <template v-slot:activator="{ props: tooltip }">
          <v-btn
            v-bind="mergeProps(dialog, tooltip)"
            icon="mdi-delete"
            variant="text" color="red" size="small"/>
        </template>
      </v-tooltip>
    </template>

    <v-card>
      <v-card-item>
        <v-card-title>
          Excluir relatório
        </v-card-title>
      </v-card-item>

      <v-card-text>
        Ao confirmar, não será possível recuperar o relatório.
      </v-card-text>

      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn @click="dialogStatus = false">Cancelar</v-btn>
        <v-btn @click="deleteItem">Confirmar</v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script lang="ts" setup>
import {mergeProps, ref} from "vue";

const dialogStatus = ref(false);
const props = defineProps(['itemId']);
const emit = defineEmits(['deleteItem']);

const deleteItem = () => {
  emit('deleteItem', props.itemId);
  dialogStatus.value = false;
}

</script>
