import axios from 'axios';

// HTTP REQUEST RESPONSE와 관련된 기본 설정  
const config = {
  baseUrl: 'https://api.hnpwa.com/v0/'
};

function fetchNewsList(){
  return axios.get(`${config.baseUrl}news/1.json`)
}

function fetchAskList(){
  return axios.get(`${config.baseUrl}ask/1.json`)
}

function fetchJobsList(){
  return axios.get(`${config.baseUrl}jobs/1.json`)
}

async function fetchList(pageName){
  try {
    const response = await axios.get(`${config.baseUrl}${pageName}/1.json`);
    return response;
  } catch (error) {
    console.log(error)
  }
}

function fetchUserInfo(username){
  return axios.get(`${config.baseUrl}user/${username}.json`)

}

function fetchItemInfo(itemId){
  return axios.get(`${config.baseUrl}item/${itemId}.json`)
}



export {
  fetchNewsList,fetchAskList,fetchJobsList,fetchUserInfo,fetchItemInfo,fetchList
}