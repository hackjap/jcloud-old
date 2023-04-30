import { createStore } from "vuex";
import { fetchWorkLoadList } from "@/api/k8s";
export default createStore({
  state: {
    rabc_token: "",
    workload: {},
  },
  getters: {},
  mutations: {
    SET_WORKLOAD(state, workload) {
      state.workload = workload;
    },
  },
  actions: {
    FETCH_PODS({ commit }) {
      fetchWorkLoadList("pods")
        .then(({ data }) => {
          commit("SET_WORKLOAD", data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    FETCH_DEPLOYMENTS({ commit }) {
      fetchWorkLoadList("deployments")
        .then(({ data }) => {
          commit("SET_WORKLOAD", data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    FETCH_NODES({ commit }) {
      fetchWorkLoadList("nodes")
          .then(({ data }) => {
            commit("SET_WORKLOAD", data);
          })
          .catch((error) => {
            console.log(error);
          });
    },
  },
  modules: {},
});
