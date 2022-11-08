import React from 'react';
//import 'bootstrap/dist/css/bootstrap.min.css';
import { useState } from 'react';
import { Container, Alert } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import Dashboard from './dashboard';
function SuccessfulLogin() {
    const [show, setShow] = useState(true)  
    if(show)
    {
        return (
            <div>
    
                <Container className='p-4'>
                    <Alert variant="primary" onClose={() => setShow(false)} dismissible >
                        <Alert.Heading>Successful Login</Alert.Heading>
                    </Alert>
                </Container>
    
                <Dashboard />
            </div>
        );
    }
    else{
        return(
            <Dashboard />
        );
    }
    
}
export default SuccessfulLogin;