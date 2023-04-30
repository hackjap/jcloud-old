<template>
  <div>
    <!-- 사용자 정보  -->
    <section>
      <UserProfile :info="fetchedItem">
        <!-- <div slot="username">{{ fetchedItem.user }}</div> -->
        <router-link slot="username" :to="`/user/${fetchedItem.user}`">
          {{ fetchedItem.user }}
        </router-link>
        <template slot="time">{{ 'Posted ' + fetchedItem.time_ago }}</template>
      </UserProfile>
      <!-- <div class="user-container">
        <div>
          <i class="fas fa-user"></i>
        </div>
        <div class="user-description">
          <router-link :to="`/user/${fetchedItem.user}`">
            {{ fetchedItem.user }}
          </router-link>
          <div class="time">
            {{fetchedItem.tiem_ago }}
          </div>
        </div>
      </div> -->
    
    </section>
    <section>
      <h2>{{ fetchedItem.title }}</h2>
    </section>

    <!-- 질문 댓글  -->
    <section>
      <div v-html="fetchedItem.content"></div>

    </section>
    <!-- <p>{{ fetchedItem.title }}</p> 
    <div> {{ fetchedItem.content}}</div> -->
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import UserProfile from '@/components/UserProfile.vue'
export default {
  components:{
    UserProfile
  },
  computed:{
    ...mapGetters(['fetchedItem']),
  },
  created(){
    const itemId = this.$route.params.id
    this.$store.dispatch('FETCH_ITEM',itemId)
  }
}
</script>

<style scoped>
  .user-container {
    display: flex;
    align-items: center;
    padding: 0.5rem;
    font-size: 2.5rem;
  }
  .user-description {
   padding-left: 10px;
  }
  .item {
    font-size: 0.7rem;
  }

</style>