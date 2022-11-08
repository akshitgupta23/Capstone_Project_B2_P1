import React,{useState,useEffect} from 'react'
import axios from 'axios'
const DisplayCustomer=()=> {

const [Customers, setCustomers] = useState([]);
 {
axios.post('http://localhost:8081/customer/displayAll')
      .then(response => {
        console.log('Printing Customer data', response.data);
        setCustomers(response.data);
      })
      .catch(error => {
        console.log('Something went wrong', error);
      });
}

return(
    <div>
            <h1 align="center">Customers</h1>
           {
<center>
            <table border="1px solid" background-color= "##04AA6D" border-spacing="30px">
               <tr>
               <td padding= "15px"><h2>Customer Number</h2></td>
               <td padding= "15px"><h2>Firstname</h2></td>
               <td padding= "15px"><h2>Lastname</h2></td>
               <td padding= "15px"><h2>MiddleName</h2></td>
               <td padding= "15px"><h2>City</h2></td>
               <td padding= "15px"><h2>Contact</h2></td>
               <td padding= "15px"><h2>DOB</h2></td>
               <td padding= "15px"><h2>Occupation</h2></td>
               </tr>
               {
                           Customers.map(customer => (
                             <tr key={customer.customerNo}>
                               <td padding= "5px">{customer.customerNo}</td>
                               <td padding= "5px">{customer.firstName}</td>
                               <td padding= "5px">{customer.middleName}</td>
                               <td padding= "5px">{customer.lastName}</td>
                               <td padding= "5px">{customer.customerCity}</td>
                               <td padding= "5px">{customer.customerContactNo}</td>
                               <td padding= "5px">{customer.dob}</td>
                               <td padding= "5px">{customer.occupation}</td>
                             </tr>
                           ))
                }


            </table>
            </center>
}
    </div>
)
}

export default DisplayCustomer;
