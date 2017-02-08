import * as types from '../constants/actionTypes';

export function fetchNews() {
  return {type: types.FETCH_NEWS};
}
