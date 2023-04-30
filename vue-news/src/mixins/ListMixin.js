import bus from '@/utils/bus'

export default {
  // reuse component option
  mounted(){
    bus.$emit('end:spinner')
  }
  // created(){
  //   bus.$emit('start:spinner');
  //   this.$store.dispatch('FETCH_LIST',this.$route.name)
  //     .then( () => {
  //       console.log('fetched');
  //       bus.$emit('end:spinner')
  //     })
  //     .catch((error)=> {
  //       console.log(error)
  //     });
  // }
}