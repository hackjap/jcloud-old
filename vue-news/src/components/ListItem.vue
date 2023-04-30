<template>
  <div>
    <ul class="news-list" >
      <li  v-for="item in listItems" :key="item.title" class="post">
        <!-- Point -->
        <div class="points">
          {{ item.points || 0 }}
        </div>
        <!-- ETC  -->
        <div>
          <p class="news-title">
            <template v-if="item.domain">
              <a :href="item.url">
                {{ item.title }}
              </a>
            </template>
            <template v-else>
              <router-link :to="`item/${item.id}`" class="link-text"> {{ item.title }} </router-link>
            </template>
          </p>
          <small class="link-text">
            {{ item.time_ago }} by
            <router-link 
              v-if="item.user"
              :to="`/user/${item.user}`"
               class="link-text">{{ item.user }}
            </router-link> 
            <a v-else :href="item.url">{{item.domain}}</a>
          </small>
        </div>
      </li>
    </ul>
    <!-- <p>
      </small>
    </p> -->
  </div>
</template>


<script>
export default {
  created(){ 
  },
  computed:{
    listItems() {
      return this.$store.state.list
    }
  }
}
</script>

<style>
.news-list {
    margin: 0;
    padding: 0;
  }
  .points{
    width: 80px;
    height: 80;
    display: flex;
    align-content: center;
    justify-content: center;
    color: #42b883;
  }
  .post{
    list-style: none;
    display: flex;
    align-items: center;
    border-bottom: 1px solid #eee;
  }
  .news-title {
    margin: 0;
  }
  .link-text {
    color: 828282;
  }

</style>