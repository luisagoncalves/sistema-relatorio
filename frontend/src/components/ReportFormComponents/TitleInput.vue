<template>
    <v-text-field class="my-2" label="Título" :rules="rules" required />
</template>

<script setup lang="ts">
const rules = [
    (v: string | any[]) => !!v || 'Campo obrigatório.',
];
</script>