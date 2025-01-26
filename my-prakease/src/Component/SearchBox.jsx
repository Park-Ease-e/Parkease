import { Link } from "react-router-dom";

function SearchBox() {
    return ( 
      <div className="container">
        <h1 className="text-center mb-">Book Your <span> Parking Spot </span></h1>
        <div className="search-box d-flex justify-content-center align-items-center gap-2">
          <input
            type="text"
            placeholder="Enter location..."
            className="form-control w-50"
          />
         
            <Link  to={'/Address'} className="btn btn-primary text-white text-decoration-none">
            Find Your Spot
            </Link>
         
        </div>
      </div>
    );
  }
  
  export default SearchBox;
  