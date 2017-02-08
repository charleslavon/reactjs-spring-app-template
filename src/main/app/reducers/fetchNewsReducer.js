import * as types from '../constants/actionTypes';


//seperating concerns with the use of multiple specialized reducers
const reducers = (state = [], action) => {
    switch (action.type) {
        case types.FETCH_NEWS:
          return [
          ...state,
          fetchNews(state, action)
          ];
        default:
            return state;
    }
};

const fetchNews = () => {
  return {
      day: 'tomorrow',
      forecast: 'is probably gonna be a long day.'
  };
};

export default reducers;
