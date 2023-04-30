<template>
  <ToolBar></ToolBar>
  <router-view />
</template>

<script>
import ToolBar from "./components/ToolBar.vue";
export default {
  components: {
    ToolBar,
  },
};
</script>
<style></style>
