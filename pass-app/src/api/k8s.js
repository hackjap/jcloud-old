import { k8s } from "./index";

async function fetchWorkLoadList(url) {
  // const agent = new https.Agent({
  //   rejectUnauthorized: false,
  // });
  try {
    return await k8s.get(url, {
      // httpsAgent: agent,
    });
  } catch (error) {
    console.log("error");
    console.log(error);
  }
}

export { fetchWorkLoadList };
