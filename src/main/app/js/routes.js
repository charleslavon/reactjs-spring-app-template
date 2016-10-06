import React from 'react';
import {Route, IndexRoute} from 'react-router';
import App from './components/App';
import AppWrapper from './components/homepage';

export default(
		<Route path="/" component={App}>
		  <IndexRoute component={AppWrapper} />
		</Route>
		)