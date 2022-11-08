import React,{useState} from 'react'
import axios from 'axios'
import { useNavigate } from 'react-router-dom';

const Login=()=>{
    const [email,setEmail]=useState("");
    const [passw,setPassw]=useState("");
    const navigate = useNavigate();
    const submitThis=(e)=>{
        e.preventDefault()
        console.log("form submitted------------------------------------------------------>");
        axios.post('http://localhost:8081/admin/login',{

            "username": email,

            "password": passw,


        })
            .then((response)=> {
                console.log(response.data)
                if(response.data === 'Valid User'){
                    //auth();
                    localStorage.setItem('temp', 'true');
                    console.log('Successfully Login');
                    navigate('/Successful-Login');
                }
                else{
                    console.log('Unsuccessfully Login');
                    navigate('/Unsuccessful-login');
                }
            })
            .catch((err)=>{
                console.log(err)
                console.log(err.response)
                navigate('/Unsuccessful-login');
            });

    }
    return(
        <div>
            <h1 align="center">Global Bank Admin login page</h1>
            <center>
                <form action="" onSubmit={submitThis}>
                <table>
                    <tr>
                        <td><label htmlFor="email">Enter the user id</label>
                        </td>
                        <td><input type="text" name="email" id="email" required value={email} onChange={(e)=>setEmail(e.target.value)}/>
                        </td>
                    </tr>
                    <tr>
                        <td><label htmlFor="passw">Enter the password</label>
                        </td>
                        <td><input type="password" name="passw" id="passw" value={passw} required onChange={(e)=>setPassw(e.target.value)}/>
                        </td>
                    </tr>
                    
                </table>
                <button type="submit">Login</button>
                    {/*<div>
                        <label htmlFor="email">Enter the user id</label>
                        <input type="text" name="email" id="email" required value={email} onChange={(e)=>setEmail(e.target.value)}/>
                    </div>
                    <div>
                        <label htmlFor="passw">Enter the password</label>
                        <input type="password" name="passw" id="passw" value={passw} required onChange={(e)=>setPassw(e.target.value)}/>
                    </div>
    */}
                </form>
            </center>

        </div>
    )}
export default Login;