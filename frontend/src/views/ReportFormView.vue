<template>
  <v-container>
    <v-card flat>
      <v-card-title v-if="route.params['id'] != 'novo'">Dados do relatório</v-card-title>
      <v-card-title v-else>Novo relatório</v-card-title>

      <v-card-item>
        <v-form ref="form">
          <v-text-field color="#3949AB" class="my-2" clearable label="Título" :rules="titleRules" required
                        v-model="report.title"/>
          <v-textarea color="#3949AB" class="my-2" clearable label="Descrição" :counter="1000" :rules="descriptionRules"
                      required v-model="report.description"/>
          <v-file-input color="#3949AB" class="my-2" clearable label="Anexo" @change="report.attachments"/>
        </v-form>
      </v-card-item>

      <v-card-actions>
        <v-btn type="reset" class="mt-2" text="Limpar" @click="resetForm()"/>
        <v-spacer/>
        <v-btn type="reset" class="mt-2" text="Cancelar" to="/reports" />
        <v-btn class="mt-2" text="Salvar" @click="saveReport()" />
      </v-card-actions>
    </v-card>
  </v-container>
</template>

<script setup lang="ts">
import {useRoute} from 'vue-router';
import {onBeforeMount, ref} from "vue";
import {getById, save, update} from "@/services/reportService";
import {Report} from "@/model/Report";
import router from "@/router";
import {useLayoutStore} from "@/store/layoutStore";

const snackbarStore = useLayoutStore();
const route = useRoute();

const titleRules = [
  (v: string | any[]) => !!v || 'Campo obrigatório.',
];

const descriptionRules = [
  (v: string | any[]) => !!v || 'Campo obrigatório.',
  (v: string | any[]) => v.length <= 255 || 'O limite de 255 caracteres foi atingido.',
];

const report = ref<Report>({
  id: undefined,
  title: '',
  description: '',
  attachments: [],
})

const createReport = () => {
  let reportSend = new Report();
  reportSend.id = report.value.id;
  reportSend.title = report.value.title;
  reportSend.description = report.value.description;
  return reportSend;
}

const updateReport = () => {
  let reportSend = new Report();
  reportSend.id = report.value.id;
  reportSend.title = report.value.title;
  reportSend.description = report.value.description;
  return reportSend;
}

const getReportById = async (id: string | string[]) => {
  const reportSearched = await getById(id);
  report.value.id = reportSearched.data.id;
  report.value.title = reportSearched.data.title;
  report.value.description = reportSearched.data.description;
  report.value.attachments = reportSearched.data.attachments;
}

const form = ref();
const saveReport = async () => {
  if(form.value.validate()){
    if (route.params['id'] != 'novo' ) {
      const response = await update(updateReport(), route.params['id'])
      if (response.status == 200) {
        snackbarStore.createSnackbar('success', 'Relatório atualizado com sucesso!');
        await router.push('/reports');
      } else {
        snackbarStore.createSnackbar('error', 'Erro ao atualizar relatório. Tente novamente.');
      }
    } else {
      const response = await save(createReport());
      if (response.status == 201) {
        snackbarStore.createSnackbar('success', 'Relatório cadastrado com sucesso!');
        await router.push('/reports');
      } else {
        snackbarStore.createSnackbar('error', 'Erro ao cadastrar relatório. Tente novamente.');
      }
    }
  }
}

const resetForm = () => {
  form.value.reset();
}

onBeforeMount(async () => {
  const reportId = route.params['id'];
  if (reportId != 'novo') {
    await getReportById(reportId);
  }
})
</script>
