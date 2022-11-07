import React,{useState} from 'react' 
import axios from 'axios'
import Dropdown from './Dropdown';

const Add_branch = () => {
    const [BranchId,setBranchId]=useState(""); 
    const [BranchName,setBranchName]=useState(""); 
    const [BranchAddress,setBranchAddress]=useState("");
    const options = [
        {value: "delhi", label: "Delhi"},
        {value: "mumbai", label: "Mumbai"},
        {value: "bengaluru", label: "Bengaluru"},
        {value: "hyderabad", label: "Hyderabad"},
        {value: "chennai", label: "Chennai"},
    ];
    const submitThis=(e)=>{
        e.preventDefault()
        const info={BranchId:BranchId, 
            BranchName:BranchName,BranchAddress:BranchAddress}; 
        console.log(info);
        //setDataInput([info]);
        console.log("form submitted------------------------------------------------------>");
        axios.post('http://localhost:8081/admin/addbranch',info)
        .then((response)=> {
            console.log(response.data)
        })
        .catch((err)=>{
            console.log(err)
            console.log(err.response)
        });
    }
  return (
    <div>
        <h1 align="center">Global Bank Branch details opening page</h1>
             <center>
             <form action="" onSubmit={submitThis}>
                <table>
                    <tr>
                        <td><label htmlFor="BranchId">
                            Branch Id
                        </label>
                        </td>
                        <td><input type="text" name="BranchId" id="BranchId" required value={BranchId} onChange={(e)=>setBranchId(e.target.value)}/>
                        </td>
                    </tr>
                    <tr>
                        <td><label htmlFor="BranchName">
                         Branch Name
                        </label>
                        </td>
                        <td><input type="text" name="BranchName" id="BranchName" required value={BranchName} onChange={(e)=>setBranchName(e.target.value)}/>
                        </td>
                    </tr>
                    <tr>
                        <td><label htmlFor="BranchAddress">
                         Branch Address
                        </label>
                        </td>
                        <td><Dropdown placeholder="Select...." options={options} /></td>
                    </tr>
                    <button type="submit">Submit</button>
                    </table>
                </form>
             </center>
    </div>
  )
}

export default Add_branch