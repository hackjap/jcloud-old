<template>
  <div>
    <ListItem></ListItem>
  </div>
</template>

<script>
import ListItem from '@/components/ListItem.vue';
import ListMixin from '@/mixins/ListMixin';
// import bus from '@/utils/bus'

export default {
 components: {
  ListItem
 },
 mixins: [ListMixin],
//  created(){
  // bus.$emit('start:spinner');
  // this.$store.dispatch('FETCH_NEWS')
  //   .then( () => {
  //     console.log('fetched');
  //     bus.$emit('end:spinner')
  //   })
  //   .catch((error)=> {
  //     console.log(error)
  //   });
//  }
}
</script>

