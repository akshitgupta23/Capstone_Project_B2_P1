import React,{useState} from 'react'
import axios from 'axios'
const DisplayBranch=()=> {

const [Branches, setBranches] = useState([]);
 axios.post('http://localhost:8081/branch/displayAll')
      .then(response => {
        console.log('Printing Brnach data', response.data);
        setBranches(response.data);
      })
      .catch(error => {
        console.log('Something went wrong', error);
      });

return(
    <div>
            <h1 align="center">Branches</h1>
            <center>
            <table border="1px solid" background-color= "##04AA6D" border-spacing="30px">
               <tr>
               <td padding= "15px"><h2>Branch Id</h2></td>
               <td padding= "15px"><h2>Branch Name</h2></td>
               <td padding= "15px"><h2>Branch Address</h2></td>
               </tr>
               {
                           Branches.map(branch => (
                             <tr key={branch.branchId}>
                               <td padding= "5px">{branch.branchId}</td>
                               <td padding= "5px">{branch.branchName}</td>
                               <td padding= "5px">{branch.branchAddress}</td>
                             </tr>
                           ))
                }


            </table>
            </center>
    </div>
)
}

export default DisplayBranch;
