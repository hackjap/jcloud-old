import Vue from 'vue'
import VueRouter from 'vue-router'
import UserView from '@/views/UserView.vue';
import ItemView from '@/views/ItemView.vue'
import NewsView from '@/views/NewsView.vue'
import AskView from '@/views/AskView.vue'
import JobsView from '@/views/JobsView.vue'
import bus from '@/utils/bus';
import {store} from '@/store/index'
// import createListView from '@/views/CreateListView'

Vue.use(VueRouter)
export const router = new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/',
      redirect: '/news',
    },
    {
      path: '/news',
      component: NewsView,
      // component: createListView('NewsView'),
      name: 'news',
      beforeEnter: (to,from,next) => {
        bus.$emit('start:spinner');
        store.dispatch('FETCH_LIST',to.name)
          .then( () => {
            console.log('fetched');
            // bus.$emit('end:spinner')
            next()
          })
          .catch((error)=> {
            console.log(error)
          });
          
      }
    },
    {
      path: '/ask',
      component: AskView,
      // component: createListView('AskView'),
      name: 'ask',
      beforeEnter: (to,from,next) => {
        bus.$emit('start:spinner');
        store.dispatch('FETCH_LIST',to.name)
          .then( () => {
            console.log('fetched');
            // bus.$emit('end:spinner')
            next()
          })
          .catch((error)=> {
            console.log(error)
          });
          
      }
    },
    {
      path: '/jobs',
      // component: createListView('JobsView'),
      component: JobsView,
      name: 'jobs',
      beforeEnter: (to,from,next) => {
        bus.$emit('start:spinner');
        store.dispatch('FETCH_LIST',to.name)
          .then( () => {
            console.log('fetched');
            // bus.$emit('end:spinner')
            next()
          })
          .catch((error)=> {
            console.log(error)
          });
          
      }
    },
    {
      path: '/user/:id',
      component: UserView
    },
    {
      path: '/item/:id',
      component: ItemView
    },
  ]
});
