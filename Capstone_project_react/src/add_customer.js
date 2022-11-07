import React,{useState} from 'react' 
import axios from 'axios'
const Add_customer=()=> {
    const [AccountNo,setAccountNo]=useState(""); 
    const [CustomerNo,setCustomerNo]=useState(""); 
    const [BranchId,setBranchId]=useState(""); 
    const [Balance,setBalance]=useState(""); 
    const submitThis=(e)=>{
        e.preventDefault()
        const info={AccountNo:AccountNo, 
            CustomerNo:CustomerNo,BranchId:BranchId, Balance:Balance
            }; 
        console.log(info);
        //setDataInput([info]);
        console.log("form submitted------------------------------------------------------>");
        axios.post('http://localhost:8081/admin/addcustomer',{AccountNo:AccountNo, 
        CustomerNo:CustomerNo,BranchId:BranchId, Balance:Balance
        })
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
             <h1 align="center">Global Bank customer account opening page</h1>
             <center>
             <form action="" onSubmit={submitThis}>
                <table>
                    <tr>
                        <td>
                            <label htmlFor="AccountNo">
                                AccountNo
                            </label>
                        </td>
                        <td><input type="text" name="AccountNo" id="AccountNo" required value={AccountNo} onChange={(e)=>setAccountNo(e.target.value)}/>
                        </td>
                    </tr>
                    <tr>
                        <td><label htmlFor="CustomerNo">
                            CustomerNo
                        </label>
                        </td>
                        <td><input type="text" name="CustomerNo" id="CustomerNo" required value={CustomerNo} onChange={(e)=>setCustomerNo(e.target.value)}/>
                        </td>
                    </tr>
                    <tr>
                        <td><label htmlFor="BranchId">
                            BranchId
                        </label>
                        </td>
                        <td><input type="text" name="BranchId" id="BranchId" required value={BranchId} onChange={(e)=>setBranchId(e.target.value)}/>
                        </td>
                    </tr>
                    <tr>
                        <td><label htmlFor="Balance">
                            Balance
                        </label>
                        </td>
                        <td><input type="text" name="Balance" id="Balance" required value={Balance} onChange={(e)=>setBalance(e.target.value)}/>
                        </td>
                    </tr>
                    <button type="submit">Submit</button>
                    </table>
                </form>
             </center>
        </div>
    )
}
export default Add_customer;
