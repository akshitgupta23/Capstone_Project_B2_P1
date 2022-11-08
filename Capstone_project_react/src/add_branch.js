import React,{useState} from 'react' 
import axios from 'axios'
import { useNavigate } from 'react-router-dom';

const Add_branch = () => {
    const navigate = useNavigate();
    const [BranchId,setBranchId]=useState(""); 
    const [BranchName,setBranchName]=useState(""); 
    const [BranchAddress,setBranchAddress]=useState("Delhi");
    const submitThis=(e)=>{
        e.preventDefault()
        const info={"branchId":BranchId,
            "branchName":BranchName,"branchAddress":BranchAddress};
        console.log(info);
        console.log("form submitted------------------------------------------------------>");
        axios.post('http://localhost:8081/branch/registration',info)
        .then((response)=> {
            console.log(response.data)
            if(response.data.status===true)
            {
                navigate('/Branch-added');
            }
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
                        <td><select value =  {BranchAddress} onChange={(e)=>setBranchAddress(e.target.value)}>
                            <option value="delhi">Delhi</option>
                            <option value="mumbai">Mumbai</option>
                            <option value="bengaluru">Bengaluru</option>
                            <option value="chennai">Chennai</option>
                            <option value="hyderabad">Hyderabad</option>
                        </select></td>
                    </tr>
                    <button type="submit">Submit</button>
                    </table>
                </form>
             </center>
    </div>
  )
}

export default Add_branch