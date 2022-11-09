import Container from 'react-bootstrap/Container';
import Navbar from 'react-bootstrap/Navbar';
import Button from 'react-bootstrap/Button';
import { useNavigate } from 'react-router-dom';

function Navbar_logout() {
    const navigate = useNavigate();
    return (
      <Navbar expand="lg" variant="light" bg="primary" >
        <Container>
          <Navbar.Brand href="/Dashboard">HOME</Navbar.Brand>
    
          <Button variant="outline-danger" onClick={()=>navigate('/Logout')} > Logout</Button>
          
        </Container>
      </Navbar>
    );
  }
  
  export default Navbar_logout;