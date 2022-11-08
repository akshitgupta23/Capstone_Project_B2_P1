import Login from './login';
import AddCustomer from './add_customer';
import AddBranch from './add_branch';
import './App.css';
import Dashboard from './dashboard';
import Display_branch from './display_branches';
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
                    <Route path='/display-branch' element={<Display_branch/>} />
                    <Route path='/display-customer' />

                </Routes>
            </div>
        </BrowserRouter>



    );
}

export default App;
