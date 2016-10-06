import React,{Component} from 'react';
import {Link} from 'react-router';

class AppWrapper extends Component{
	
	render(){
		return(<div>
				 <Link to="/" className="btn btn-primary"> Home </Link>
				</div>
				);
	}
}

export default AppWrapper;