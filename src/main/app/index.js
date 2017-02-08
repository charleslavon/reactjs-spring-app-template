import React from 'react';
import {render} from 'react-dom';
import { Provider } from 'react-redux';
import { Route, Router, IndexRoute, browserHistory } from 'react-router';
import App from './components/App';
import HomePageContainer from './containers/HomePageContainer';
import NotFound from './components/NotFound';
import { syncHistoryWithStore } from 'react-router-redux';
import configureStore from './store/configureStore';
require('./images/favicon.ico'); // Tell webpack to load favicon.ico and/or necessary styles
///import './styles/mystyles.scss';


const store = configureStore();

const history = syncHistoryWithStore(browserHistory, store);

render(
  <Provider store={store}>
    <Router history={history}>
      <Route path="/" component={App}>
        <IndexRoute component={HomePageContainer}/>
        <Route path="*" component={NotFound}/>
      </Route>
    </Router>
  </Provider>, document.getElementById('app')
);
