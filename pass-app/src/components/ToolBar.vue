<template>
  <div class="header">
    <router-link to="/pod">Pod | </router-link>
    <router-link to="/deployment">Deployment | </router-link>
     <router-link to="/node">Node </router-link>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.header {
  color: white;
  background-color: #42b883;

  display: flex;
  padding: 8px;
}
.header .router-link-exact-activce {
  color: #35495e;
}
</style>
