import React from 'react';
//import 'bootstrap/dist/css/bootstrap.min.css';
import { useState } from 'react';
import { Container, Alert } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import Login from './login';
function UnsuccessfulLogin({message}) {
    const [show, setShow] = useState(true)  
    if(show)
    {
        return (
            <div>
    
                <Container className='p-4'>
                    <Alert variant="danger" onClose={() => setShow(false)} dismissible >
                        <Alert.Heading> {message}</Alert.Heading>
                    </Alert>
                </Container>
    
                <Login />
            </div>
        );
    }
    else{
        return(
            <Login/>
        );
    }
    
}
export default UnsuccessfulLogin;