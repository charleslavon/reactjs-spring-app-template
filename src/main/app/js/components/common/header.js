import React from 'react';

import {Link, IndexLink} from 'react-router';

const Header = () =>{
	return(<div>
			<nav>
			<header className="bar">
             <div className="main-header">      
               <img src="images/logo.png" className="nuance-logo"/>
                   <div className="title">
                     <h1> React Portal Template App</h1>
                   </div>
               </div>
		     <IndexLink to="ROOT/" activeClassName="active"> Home </IndexLink>
            </header>
	      </nav>
	     </div>
		)
	
}


export default Header;