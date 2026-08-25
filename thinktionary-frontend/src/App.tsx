import LoginSignup from "./components/LoginSignup/LoginSignup";
import LoginSuccess from "./components/LoginSignup/LoginSuccess.tsx";
import Dashboard from "./components/Dashboard/Dashboard.tsx";

import "./App.css";

import {BrowserRouter, Route, Routes} from "react-router-dom";


function App() {
    return (

        <>
            <BrowserRouter>
                <Routes>
                    <Route path="/login" element={<LoginSignup/>}/>
                    <Route path="/login-success" element={<LoginSuccess/>}/>
                    <Route path="/dashboard" element={<Dashboard/>}/>
                </Routes>
            </BrowserRouter>
        </>
    );

}

export default App;
