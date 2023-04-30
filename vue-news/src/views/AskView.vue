<template>
  <div>
    <ListItem></ListItem>
  </div>
</template>

<script>
// import {mapGetters} from 'vuex'
import ListItem from '@/components/ListItem.vue';
import ListMixin from '@/mixins/ListMixin';
// import bus from '@/utils/bus';
export default {
  components:{
    ListItem
  },
  // computed:{
  //   ...mapGetters(['fetchedAsk'])
  // },
  mixins: [ListMixin],
  created(){
    // this.$store.dispatch('FETCH_ASK');
  },


}
</script>
<style scoped>

</style>
