import Login from './login';
import AddCustomer from './add_customer';
import AddBranch from './add_branch';
import './App.css';
import Dashboard from './dashboard';
import DisplayBranch from './display_branches';
import DisplayCustomer from './display_customer';
import Successful from './successful'
import UnsuccessfulLogin from './unsuccessful_login'
import {Route, Routes, BrowserRouter} from "react-router-dom";

function App() {

    return (
        <BrowserRouter>
            <div className="App">

                <Routes>
                    <Route path='/' element={<Login/>} />
                    <Route path='/Dashboard' element={<Dashboard/>} />
                    <Route path='/add-branch' element={<AddBranch/>} />
                    <Route path='/add-customer' element={<AddCustomer/>} />
                    <Route path='/Successful-login' element={<Successful message="Login Successful "/>} />
                    <Route path='/Branch-added' element={<Successful message="Branch added Successfully"/>} />
                    <Route path='/Account-added' element={<Successful message="Account added Successfully"/>} />
                    <Route path='/Unsuccessful-login' element={<UnsuccessfulLogin/>} />
                    <Route path='/display-branch' element={<DisplayBranch/>} />
                    <Route path='/display-customer' element={<DisplayCustomer/>}  />

                </Routes>
            </div>
        </BrowserRouter>



    );
}

export default App;
