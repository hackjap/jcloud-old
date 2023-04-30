import {fetchNewsList,fetchAskList,fetchJobsList,fetchUserInfo,fetchItemInfo,fetchList} from '@/api/index';
export default{
    FETCH_NEWS(context){
      return fetchNewsList()
        .then(response => {
          console.log(response);
          context.commit('SET_NEWS',response.data)
        })
        .catch(error=>{
          console.log(error);
        })
    },
    FETCH_ASK(context){
      return fetchAskList()
      .then(response => {
        context.commit('SET_ASK',response.data);
        return response;
      })
    },
    FETCH_JOBS(context){
      return fetchJobsList()
      .then(response=>{
        context.commit('SET_JOBS',response.data)
      })
    },
    FETCH_USER( {commit}, name){
      return fetchUserInfo(name)
      .then( ({data}) => {
          commit('SET_USER', data)
      })
      .catch( error => {
        console.log(error);
      })
    },
    FETCH_ITEM( {commit}, id){
      return fetchItemInfo(id)
        .then(({data}) =>{
          commit('SET_ITEM',data)
        })
        .catch( error => {
          console.log(error)
        })
    },
    async FETCH_LIST({commit},pageName){
        const {data} = await fetchList(pageName);
        commit('SET_LIST',data)
        return data;
    }
    // FETCH_LIST({commit},pageName){
    //   return fetchList(pageName)
    //     .then(({data})=>{
    //       commit('SET_LIST',data)
    //     })
    //     .catch( error =>{
    //       console.log(error);
    //     })
    // }
}