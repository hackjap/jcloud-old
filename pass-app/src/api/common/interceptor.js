// import store from "@/store/index";
import https from "https";

export function setInterceptors(instance) {
  // Add a request interceptor
  instance.interceptors.request.use(
    function (config) {
      // Do something before request is sent
      // console.log(config);
      config.headers.Authorization =
        "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IjRjbk9iUnJFRVRmWHM2S0NneEdQM1p0ZlYzNEh0TTFxdFI4cE9TdHExbjQifQ.eyJpc3MiOiJrdWJlcm5ldGVzL3NlcnZpY2VhY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9uYW1lc3BhY2UiOiJkZWZhdWx0Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZWNyZXQubmFtZSI6ImRlZmF1bHQtdG9rZW4tcjl2c3oiLCJrdWJlcm5ldGVzLmlvL3NlcnZpY2VhY2NvdW50L3NlcnZpY2UtYWNjb3VudC5uYW1lIjoiZGVmYXVsdCIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VydmljZS1hY2NvdW50LnVpZCI6Ijg3YzJhOTFiLTMwN2QtNDE1Ny1hMGEwLTcxY2I1YTdjYzVjYSIsInN1YiI6InN5c3RlbTpzZXJ2aWNlYWNjb3VudDpkZWZhdWx0OmRlZmF1bHQifQ.uKoa2lXxRAW88Meo2U3atMlcnbmE7ijqpM_jn-TnTHrwkT6RCH8ydHtFHoTODjb7Bs4utq_rjUZ6vk0Zk4kgF0FyA8Hj4QcOHG76uHom2F19WKwL9-7P5Y9wTYNInhX9jO2C6vfktmtouHe0AcjgUfjcgv0AZo0qdxZe2rAKgOusIl_4MROYh7kbSf1mMrqdTLHbisuivMsPYaKvTjrIsesm5a0Lm3_QNwwqWATnMsdo8Mg3OcAhUFA-4POJ6Op1rUhmX6Qsnb1jy0-pHzrrOJak9AUZ5tg8KbRVjCnVHk-M759QFpX23dTBikmIVw04fF6ms1u5Hexhk5PByN_q0Q";
      config.httpsAgent = new https.Agent({ rejectUnauthorized: false });
      return config;
    },
    function (error) {
      // Do something with request error
      return Promise.reject(error);
    }
  );

  // Add a response interceptor
  instance.interceptors.response.use(
    function (response) {
      // Any status code that lie within the range of 2xx cause this function to trigger
      // Do something with response data
      return response;
    },
    function (error) {
      // Any status codes that falls outside the range of 2xx cause this function to trigger
      // Do something with response error
      return Promise.reject(error);
    }
  );
  return instance;
}
