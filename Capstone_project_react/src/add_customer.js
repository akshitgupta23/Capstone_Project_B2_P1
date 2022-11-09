import React,{useState} from 'react' 
import axios from 'axios'
import { useNavigate } from 'react-router-dom';
import Navbar_logout from './navbar';
const Add_customer=()=> {
    const current = new Date().toISOString().substring(0,10);
    //const date = `${current.getFullYear()}-${current.getMonth()+1}-${current.getDate()}`;
    const date = current;
    const [AccountNo,setAccountNo]=useState(""); 
    const [CustomerNo,setCustomerNo]=useState("");
    const [BranchId,setBranchId]=useState(""); 
    const [Balance,setBalance]=useState("");
    const [OpeningDate, setOpeningDate]=useState(date);
    const [AccountType, setAccountType]=useState("savings");
    const [AccountStatus, setAccountStatus]=useState("active");
    const navigate = useNavigate();

    const [Branches, setBranches] = useState([]);
     axios.post('http://localhost:8081/branch/displayAll')
          .then(response => {
//            console.log('Printing Brnach data', response.data);
            setBranches(response.data);
          })
          .catch(error => {
            console.log('Something went wrong', error);
          });

     const [Customers, setCustomers] = useState([]);
      {
     axios.post('http://localhost:8081/customer/displayAll')
           .then(response => {
//             console.log('Printing Customer data', response.data);
             setCustomers(response.data);
           })
           .catch(error => {
             console.log('Something went wrong', error);
           });
     }

    const submitThis=(e)=>{

        e.preventDefault()
        
        const info={AccountNo:AccountNo, 
            CustomerNo:CustomerNo,BranchId:BranchId, Balance:Balance, OpeningDate:OpeningDate, AccountType:AccountType, AccountStatus:AccountStatus
            }; 
        console.log(info);
        //setDataInput([info]);
        console.log("form submitted------------------------------------------------------>");
        axios.post('http://localhost:8081/account/create',{"accountNo":AccountNo,
        "customer":{"customerNo":CustomerNo},"branch":{"branchId":BranchId}, "openingBalance":Balance, "openingDate": OpeningDate,
        "accountType":AccountType, "accountStatus":AccountStatus
        })
        .then((response)=> {
            console.log(response.data)
            if(response.data.status===true)
            navigate('/Branch-added');
        })
        .catch((err)=>{
            console.log(err)
            console.log(err.response)
        });
    }
    return (
        
        <div>
            <Navbar_logout/>
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
                        <td><select value =  {CustomerNo} onChange={(e)=>setCustomerNo(e.target.value)}>
                            {
                                Customers.map(customer => (
                                        <option value={customer.customerNo}>{customer.customerNo}</option>
                                   ))
                            }

                            </select></td>
                    </tr>
                    <tr>
                        <td><label htmlFor="BranchId">
                            BranchId
                        </label>
                        </td>
                        <td><select value =  {BranchId} onChange={(e)=>setBranchId(e.target.value)}>
                        {
                            Branches.map(branch => (
                                    <option value={branch.branchId}>{branch.branchId}</option>
                               ))
                        }

                        </select></td>

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
