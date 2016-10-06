import React,{Component,PropTypes} from 'react';
import Header from './common/header';
import Footer from './common/footer';


class App extends Component{
	render(){
		return(<div className="container-fluid"> 
		         <Header/>
		            {this.props.children}
		         <Footer/>
		       </div>
			)
		
	}
}



export default App;