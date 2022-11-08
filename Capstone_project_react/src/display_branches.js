import React,{useState} from 'react'
import axios from 'axios'
const Display_branch=()=> {
axios.get('http://localhost:8081/branch/displayAll').then(response =>{
console.log(response);
this.setState({
    Branches:response.data
    }
    )
})

return(
    <div>
            <h1 align="center">Branches</h1>
            <table>
            <thead>
            <tr>BranchId</tr>
            <tr>BranchName</tr>
            <tr>BranchAddress</tr>
            </thead>
            <tbody>
            {
                Branches.map((branch)=>{
                <tr>
                <td>{branch.branchId}</td>
                <td>{branch.branchName}</td>
                <td>{branch.branchAddress}</td>
                </tr>
                })
            }
            </tbody>
            </table>

    </div>
)
}

export default display_branches;