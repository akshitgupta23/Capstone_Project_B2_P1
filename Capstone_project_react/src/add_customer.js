import React,{useState} from 'react' 
import axios from 'axios'
const Add_customer=()=> {
    const current = new Date();
    const date = `${current.getDate()}/${current.getMonth()+1}/${current.getFullYear()}`;
    const [AccountNo,setAccountNo]=useState(""); 
    const [CustomerNo,setCustomerNo]=useState(""); 
    const [BranchId,setBranchId]=useState(""); 
    const [Balance,setBalance]=useState("");
    const [OpeningDate, setOpeningDate]=useState(date);
    const [AccountType, setAccountType]=useState("");
    const [AccountStatus, setAccountStatus]=useState("");
    const submitThis=(e)=>{
        e.preventDefault()
        const info={AccountNo:AccountNo, 
            CustomerNo:CustomerNo,BranchId:BranchId, Balance:Balance, OpeningDate:OpeningDate, AccountType:AccountType, AccountStatus:AccountStatus
            }; 
        console.log(info);
        //setDataInput([info]);
        console.log("form submitted------------------------------------------------------>");
        axios.post('http://localhost:8081/admin/addcustomer',{"accountNo":AccountNo,
        "customer":{"customerNo":CustomerNo},"branch":{"branchId":BranchId}, "openingBalance":Balance, "openingDate": OpeningDate,
        "accountType":AccountType, "accountStatus":AccountStatus
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
                    <tr>
                        <td><label htmlFor="OpeningDate">
                            Account Opening Date
                        </label>
                        </td>
                        <td><input type="text" name="OpeningDate" id="OpeningDate" required value={date} onChange={(e)=>setOpeningDate(e.target.value)}/>
                        </td>
                    </tr>
                    <tr>
                        <td><label htmlFor="AccountType">
                            Account Type
                        </label>
                        </td>
                        <td><select value =  {AccountType} onChange={(e)=>setAccountType(e.target.value)}>
                            <option value="savings">Savings</option>
                            <option value="current">Current</option>
                        </select></td>
                    </tr>
                    <tr>
                        <td><label htmlFor="AccountStatus">
                            Account Status
                        </label>
                        </td>
                        <td><select value =  {AccountStatus} onChange={(e)=>setAccountStatus(e.target.value)}>
                            <option value="active">Active</option>
                            <option value="inactive">Inactive</option>
                        </select></td>
                    </tr>
                    <button type="submit">Submit</button>
                    </table>
                </form>
             </center>
        </div>
    )
}
export default Add_customer;
