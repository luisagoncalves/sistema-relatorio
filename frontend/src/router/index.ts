// Composables
import { createRouter, createWebHistory } from 'vue-router'
import ReportListView from '@/views/ReportListView.vue'

const routes = [
  {
    path: '/',
    component: () => import('@/layouts/default/Default.vue'),
    children: [
      {
        path: '/reports',
        name: 'ReportListView',
        component: ReportListView
      },
      {
        path: '/form/:id',
        name: 'ReportFormView',
        component: () => import('@/views/ReportFormView.vue')
      },
    ],
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
})

export default router
