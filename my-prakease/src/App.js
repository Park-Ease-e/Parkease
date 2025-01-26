import { Route, Routes } from "react-router-dom";

import Navbar from "./Component/Navbar";
import Login from "./Component/Login";
import Forgot from "./Component/Forgot";
import NavbarForNonlogin from "./Component/NavbarForNonlogin";
import SearchBox from "./Component/SearchBox";
import Main from "./Component/Main";
import MainAdmin from "./Component/MainAdmin";
import AddresTable from "./Component/AddressTable";
import LoginRegister from './Component/LoginRegister';

function App() {
  return (
    <Routes>
      <Route path="/" element={<Main />}></Route>
      <Route path="Navbar" element={<Navbar />} />
      <Route path="Navbarfornonlogin" element={<NavbarForNonlogin />}></Route>

      <Route path="login" element={<Login />}></Route>
      <Route path="register" element={<LoginRegister/>}></Route>
      <Route path="forget" element={<Forgot />}></Route>
      <Route path="SearchBox" element={<SearchBox />}></Route>
      <Route path="admin" element={<MainAdmin />}></Route>
      <Route path="Address" element={<AddresTable />}></Route>

    </Routes>
  );
}

export default App;
