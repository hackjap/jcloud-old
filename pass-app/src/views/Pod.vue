<template>
  <div>
    <ul class="item-list">
      <li v-for="item in this.$store.state.workload" :key="item.name" class="post">
        <div class="status" :class="{status_active:item.status == 'Running',
        status_none_active:item.status !='Running'}">
          <p>
          {{ item.status }}
          </p>
        </div>
        <div class="namespace">
          <p>
          {{ item.namespace }}
          </p>
        </div>
        <div>
          <p class="item-title">
            {{ item.name }}
          </p>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: name,

  created() {
    this.getData();
  },
  data() {
    return {
      pods: {},
    };
  },
  methods: {
    async getData() {
      this.$store.dispatch("FETCH_PODS");
    },
  },
};
</script>

<style scoped>
  .item-list {
    margin: 0;
    padding: 0;
  }
  .status_active{
    width: 100px;
    height: 50px;
    display: flex;
    align-content: center;
    justify-content: center;
    color: #42b883;
  }
  .status_none_active{
    width: 100px;
    height: 50px;
    display: flex;
    align-content: center;
    justify-content: center;
    color: red;
  }
  .namespace{
    width: 120px;
    height: 50px;
    display: flex;
    align-content: center;
    justify-content: center;
    color: blue;
    margin: 0;
  }
  .post{
    list-style: none;
    display: flex;
    align-items: center;
    border-bottom: 1px solid #eee;
  }
  .item-title {
    margin: 0;
  }
  .link-text {
    color: 828282;
  }
</style>
