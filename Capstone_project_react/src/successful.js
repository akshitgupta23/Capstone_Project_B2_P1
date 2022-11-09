import React from 'react';
//import 'bootstrap/dist/css/bootstrap.min.css';
import { useState } from 'react';
import { Container, Alert } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import Dashboard from './dashboard';
import Navbar_logout from './navbar';
function Successful({message}) {
    const [show, setShow] = useState(true)  
    if(show)
    {
        return (
            <>
            <div>
                <Navbar_logout/>
            </div>
            <div>
                <Container className='p-4'>
                    <Alert variant="primary" onClose={() => setShow(false)} dismissible >
                        <Alert.Heading> {message}</Alert.Heading>
                    </Alert>
                </Container>
    
                <Dashboard />
            </div>
            </>
        );
    }
    else{
        return(
            <>
                <Navbar_logout/>
                <Dashboard />
            </>
            
        );
    }
    
}
export default Successful;