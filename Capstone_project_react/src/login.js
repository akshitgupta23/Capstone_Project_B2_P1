import React,{useState} from 'react' 
import axios from 'axios'
const Login=()=>{ 
	const [email,setEmail]=useState(""); 
	const [passw,setPassw]=useState(""); 
	//const[dataInput, setDataInput]=useState(""); 
	const submitThis=(e)=>{
        e.preventDefault()
		//const info={email:email,passw:passw}; 
        
		//setDataInput([info]);
        console.log("form submitted------------------------------------------------------>");
        axios.post('',{email:email, 
            password:passw
        })
        .then((response)=> {
            console.log(response.data)
        })
        .catch((err)=>{
            console.log(err)
            console.log(err.response)
        });
	}
	return(
	<div>
        <h1 align="center">Global Bank Admin login page</h1>
        <center>
            <form action="" onSubmit={submitThis}> 
                <div> 
                    <label htmlFor="email">Enter the user id</label>
                    <input type="text" name="email" id="email" required value={email} onChange={(e)=>setEmail(e.target.value)}/> 
                </div> 
                <div> 
                    <label htmlFor="passw">Enter the password</label>
                <input type="password" name="passw" id="passw" value={passw} required onChange={(e)=>setPassw(e.target.value)}/> 
                </div>  
                <button type="submit">Login</button>
            </form>
        </center>
		
	</div>
)} 
export default Login;