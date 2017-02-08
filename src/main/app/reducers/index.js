import { combineReducers } from 'redux';
import {routerReducer} from 'react-router-redux';
import fetchNews from './fetchNewsReducer';



const rootReducer = combineReducers({
  /*
  * the keys of the objects here correspond to the fields of the state object
  *  that the rootReducer will manage
  */
  news: fetchNews,
  routing: routerReducer
});

export default rootReducer;
