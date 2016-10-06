import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';
import { createStore, applyMiddleware } from 'redux';

import {Router,browserHistory} from 'react-router';
import reducers from './reducers';
import routes from './routes'
import promise from 'redux-promise';

// stylesheet
require('../css/sass/screen.scss');

const createStoreWithMiddleware = applyMiddleware(promise)(createStore);

  ReactDOM.render(
     <Provider store={createStoreWithMiddleware(reducers,window.devToolsExtension ? window.devToolsExtension() : f => f)}>
       <Router history={browserHistory} routes={routes} />
     </Provider>
     , document.getElementById('app'));