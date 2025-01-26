import Navbar from "./Navbar";
import Admin from './Admin';
function MainAdmin() {
    return ( 
    <div className="bg-white dark:bg-gray-800 vh-100 d-flex flex-column">
<Navbar/>
<div className="container mx-auto p-4 pt-6 mt-6">
   <Admin/> 
</div>
    </div> );
}

export default MainAdmin;