import React,{useState,useEffect} from 'react'
import axios from 'axios'
const Display_branch=()=> {

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
            <table>
            <center>
               <tr>
               <td>BranchId</td>
               <td>BranchName</td>
               <td>BranchAddress</td>
               </tr>
               {
                           Branches.map(branch => (
                             <tr key={branch.branchId}>
                               <td>{branch.branchName}</td>
                               <td>{branch.branchAddress}</td>
                             </tr>
                           ))
                }

            </center>
            </table>
    </div>
)
}

export default Display_branch;
