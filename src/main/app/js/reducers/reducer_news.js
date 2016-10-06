import * as types from '../actions/actionTypes';

//const INITIAL_STATE  = {news:[], post: null};

export default function(state = [], action){

	console.log('action recieved', action);

	switch(action.type){
		case types.FETCH_NEWS:
		return state.concat(action.payload.data.results.data.articleList.article);

		default:
		return state;
	}


}
