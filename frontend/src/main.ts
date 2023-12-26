/**
 * main.ts
 *
 * Bootstraps Vuetify and other plugins then mounts the App`
 */

// Components
import App from './App.vue'
import { VDataTable } from 'vuetify/lib/labs/components.mjs'

// Composables
import { createApp } from 'vue'

// Plugins
import { registerPlugins } from '@/plugins'

const app = createApp(App);

app.component('VDataTable', VDataTable);

registerPlugins(app);

app.mount('#app')
