<template>
    <v-textarea class="my-2" label="Descrição" :counter="1000" :rules="rules" required />
</template>

<script setup lang="ts">
const rules = [
    (v: string | any[]) => !!v || 'Campo obrigatório.',
    (v: string | any[]) => v.length <= 1000 || 'O limite de 1000 caracteres foi atingido.'
];
</script>