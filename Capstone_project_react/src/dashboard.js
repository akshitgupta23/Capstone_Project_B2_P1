import React from 'react';
import { Button, Alert } from 'react-native';
import {Route, Link} from 'react-router-dom';
import Add_branch from './add_branch';
const Dashboard = ()=>{return(
    <div>
            <h1 align="center">Global Bank Operations</h1>
            <center>
                    <Link to= "/display-customers"><Button
                            title="Display Customers"
                            onPress={() => Alert.alert('Simple Button pressed')}
                    /></Link>
                    <Link to = "/display-branches"><Button
                        title="Display Branch details"
                        onPress={() => Alert.alert('Simple Button pressed')}
                     /></Link>
                    <Link to= "/add-customer"><Button
                            title="Add Customer"
                            onPress={() => Alert.alert('Simple Button pressed')}
                    /></Link>
                    <Link to = "/add-branch"><Button
                        title="Add Branch"
                        onPress={() => Add_branch}
                     /></Link>
            </center>

    	</div>
)}

export default Dashboard;