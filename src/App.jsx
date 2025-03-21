import { Routes, Route, useLocation } from "react-router-dom";
import Header from "./components/Header";
import Footer from "./components/Footer";
import Home from "./pages/Home";
import About from "./pages/About";
import Services from "./pages/Service";
import Contact from "./pages/Contact";
import Accounts from "./pages/Accounts";
import AccountDetails from "./pages/AccountDetails";
import Transfer from "./pages/Transfer";
import Login from "./pages/Login";
import Register from "./pages/Register";

import TransactionHistory from "./components/TransactionHistory";
import AccountManager from "./components/AccountManager";

function App() {
  const location = useLocation();
  return (
    <>
    {location.pathname !== "/login" && <Header />}  
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/about" element={<About />} />
        <Route path="/services" element={<Services />} /> 
        <Route path="/contact" element={<Contact />} />
        <Route path="/accounts" element={<Accounts/>} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/accounts/:id" element={<AccountDetails />} />
        <Route path="/transfer" element={<Transfer />} />
      </Routes>

      
      <Footer/>
    </>
  );
}

export default App;
