import axios from "axios";
// import axios from 'axios';

import { setInterceptors } from "@/api/common/interceptor";

function createInstance() {
  return axios.create({
    baseURL: process.env.VUE_APP_API_URL,
  });
}

// 액시오스 초기화 함수
function createInstanceWithAuth(url) {
  const instance = axios.create({
    baseURL: `${process.env.VUE_APP_API_URL}${url}`,
  });
  return setInterceptors(instance);
}

export const instance = createInstance();
export const k8s = createInstanceWithAuth("kubernetes/api");

//
// const config = {
//   baseUrl: process.env.VUE_APP_API_URL,
//   token:
//     "Bear eyJhbGciOiJSUzI1NiIsImtpZCI6IjRjbk9iUnJFRVRmWHM2S0NneEdQM1p0ZlYzNEh0TTFxdFI4cE9TdHExbjQifQ.eyJpc3MiOiJrdWJlcm5ldGVzL3NlcnZpY2VhY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9uYW1lc3BhY2UiOiJkZWZhdWx0Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZWNyZXQubmFtZSI6ImRlZmF1bHQtdG9rZW4tcjl2c3oiLCJrdWJlcm5ldGVzLmlvL3NlcnZpY2VhY2NvdW50L3NlcnZpY2UtYWNjb3VudC5uYW1lIjoiZGVmYXVsdCIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VydmljZS1hY2NvdW50LnVpZCI6Ijg3YzJhOTFiLTMwN2QtNDE1Ny1hMGEwLTcxY2I1YTdjYzVjYSIsInN1YiI6InN5c3RlbTpzZXJ2aWNlYWNjb3VudDpkZWZhdWx0OmRlZmF1bHQifQ.uKoa2lXxRAW88Meo2U3atMlcnbmE7ijqpM_jn-TnTHrwkT6RCH8ydHtFHoTODjb7Bs4utq_rjUZ6vk0Zk4kgF0FyA8Hj4QcOHG76uHom2F19WKwL9-7P5Y9wTYNInhX9jO2C6vfktmtouHe0AcjgUfjcgv0AZo0qdxZe2rAKgOusIl_4MROYh7kbSf1mMrqdTLHbisuivMsPYaKvTjrIsesm5a0Lm3_QNwwqWATnMsdo8Mg3OcAhUFA-4POJ6Op1rUhmX6Qsnb1jy0-pHzrrOJak9AUZ5tg8KbRVjCnVHk-M759QFpX23dTBikmIVw04fF6ms1u5Hexhk5PByN_q0Q",
//   header: {
//     headers: { Authorization: config.token },
//   },
// };
// async function fetchPodsList() {
//   const response = await axios.get(
//     `${config.baseUrl}api/v1/namespaces/default/pods`,
//     config.header
//   );
//   return response;
// }
