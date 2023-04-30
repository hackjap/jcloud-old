import { createRouter, createWebHistory } from "vue-router";
import Pod from "@/views/Pod.vue";
import Deployment from "@/views/Deployment";
import Node from "@/views/Node";
const routes = [
  {
    path: "/",
    name: "pod",
  },
  {
    path: "/pod",
    name: "pod",
    component: Pod,
  },
  {
    path: "/deployment",
    name: "deployment",
    component: Deployment,
  },
  {
    path: "/node",
    name: "node",
    component:  Node,
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
