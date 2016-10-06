import axios from 'axios';
import * as types from './actionTypes';




export function fetchNews(){
  const request = axios.get('./newsData.json');
	return {
		type: types.FETCH_NEWS,
		payload: request
	};

}


export function fetchWeather(){
 const request = axios.get(url);
	return {
		type: types.FETCH_WEATHER,
		payload: request
	};

}

export function fetchParking(){
 const request = axios.get('./parking.json');
	return {
		type: types.FETCH_PARKING,
		payload: request
	};

}

export function fetchProviders(){
  const request = axios.get('./ProviderData.json');
  return{
    type: types.FETCH_PROVIDERS,
    payload:request
  }
}
