<template>
  <v-tooltip text="Visualizar" location="top">
    <template v-slot:activator="{ props }">
      <v-btn v-bind="props" flat @click="isActive = true">{{ titulo }}</v-btn>
    </template>
  </v-tooltip>
  <v-dialog max-width="800" v-model="isActive">
    <v-card>
      <v-card-item>
        <v-card-title>
          {{ titulo }}
        </v-card-title>
      </v-card-item>

      <v-card-text class="my-2">
        {{ descricao }}
      </v-card-text>

      <v-card-item>
        <v-table>
          <thead>
          <tr>
            <th>Anexos</th>
            <th></th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="file in anexos" :key="file.id">
            <td>
              <a href="#" @click="openFile(file)">{{ file.description }}</a>
            </td>
          </tr>
          </tbody>
        </v-table>
      </v-card-item>

      <v-card-actions class="d-flex justify-end">
        <v-btn @click="isActive = false">Fechar</v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>
<script setup lang="ts">
import {ref} from 'vue';
import {Attachment} from "@/model/Attachment";

defineProps(['titulo', 'itemId', 'descricao', 'anexos']);

const isActive = ref(false);

const openFile = async (file: Attachment) => {
  if (file.id != undefined) {
    file.type = file.fileBase64.substring(file.fileBase64.indexOf(':') + 1, file.fileBase64.indexOf(';'));
    file.fileBase64 = file.fileBase64.substring(file.fileBase64.indexOf(',') + 1);
  }
  let blob = converterBase64ParaBlob(file.fileBase64, file.type);
  const blobUrl = URL.createObjectURL(blob);
  return window.open(blobUrl);
}

const converterBase64ParaBlob = (base64: string, tipoArquivo: string): Blob => {
  const tipo = tipoArquivo;
  const base64Decodificado = window.atob(base64);
  const uInt8Array = new Uint8Array(base64Decodificado.length);
  for (let i = 0; i < base64Decodificado.length; ++i) {
    uInt8Array[i] = base64Decodificado.charCodeAt(i);
  }
  return new Blob([uInt8Array], {type: tipo});
};
</script>
