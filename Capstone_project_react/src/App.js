import Login from './login';
import AddCustomer from './add_customer';
import Addbranch from './add_branch';
import './App.css';
import Dashboard from './dashboard';
import Display_branch from './display_branches';
import {BrowserRouter, Route, Switch} from 'react-router-dom';

function App() {
  return (
  <BrowserRouter>
    <div className="App">
        <Switch>
            <Route path="/" exact><Login /></Route>
            <Route path="/dashboard" exact><Dashboard /></Route>
            <Route path="/display-customers" exact></Route>
            <Route path="/display-branch" exact><Display_branch/></Route>
            <Route path="/add-customer" exact><AddCustomer /></Route>
            <Route path="/add-branch" exact><Addbranch /></Route>
        </Switch>
    </div>


  </BrowserRouter>
  );
}

export default App;
