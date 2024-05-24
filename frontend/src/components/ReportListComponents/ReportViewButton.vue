<template>
  <v-tooltip text="Visualizar" location="top">
    <template v-slot:activator="{ props }">
      <v-btn v-bind="props" variant="text" @click="isActive = true" color="primary"> {{ titulo }}</v-btn>
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
        <v-data-table
          :headers="headers"
          :items="attachments"
          item-value="description"
          no-data-text="Nenhum arquivo anexado."
        >
          <template v-slot:[`item.description`]="{item}">
            <v-tooltip text="Visualizar" location="top">
              <template v-slot:activator="{ props }">
                <a href="#" @click="openFile(item)" v-bind="props">{{ item.description }}</a>
              </template>
            </v-tooltip>
          </template>
          <template #bottom></template>
        </v-data-table>
      </v-card-item>

      <v-card-actions class="d-flex justify-end">
        <v-btn @click="isActive = false" color="primary">Fechar</v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>
<script setup lang="ts">
import {onMounted, ref} from 'vue';
import {Attachment} from "@/model/Attachment";
import FileSaver from 'file-saver';
import {getAttachmentByReportId} from '@/services/attachmentService';

const props = defineProps(['titulo', 'itemId', 'descricao']);

const isActive = ref(false);
const headers = [{title: 'Anexos', key: 'description'}];
const openFile = async (file: Attachment) => {
  if (file.id != undefined) {
    file.type = file.fileBase64.substring(file.fileBase64.indexOf(':') + 1, file.fileBase64.indexOf(';'));
    file.fileBase64 = file.fileBase64.substring(file.fileBase64.indexOf(',') + 1);
  }
  let blob = converterBase64ParaBlob(file.fileBase64, file.type);
  const blobUrl = URL.createObjectURL(blob);
  return FileSaver.saveAs(blobUrl, file.description);
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

const attachments = ref([]);
const getAttachments = async (id: any) => {
  const response = await getAttachmentByReportId(id);
  if (response.status == 200) {
    attachments.value = response.data;
  }
}

onMounted(async () => {
  await getAttachments(props.itemId);
})
</script>
