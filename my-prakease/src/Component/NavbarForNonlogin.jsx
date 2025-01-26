import "./Css/navbar.css";
import { Link } from "react-router-dom";
import img from "./img/image.gif";
import logo from "./img/logo.png";

function Navbar() {
  return (
    <nav className="navbar navbar-expand-lg navbar-light bg-light shadow-sm">
      <div className="container">
        <span className="navbar-brand d-flex align-items-center">
          <img src={logo} alt="Logo" />

          <span className="ms-2 fs-4">ParkEase</span>
        </span>
       

        {/* Right: Profile Dropdown */}

        <div className="dropdown">
          <span
            
            className="d-flex align-items-center text-decoration-none"
            id="dropdownMenuButton"
            data-bs-toggle="dropdown"
            aria-expanded="false"
          >
            <img src={img} alt="Profile" className="profile-img" />
          </span>
          <ul
            className="dropdown-menu dropdown-menu-end"
            aria-labelledby="dropdownMenuButton"
          >
            <li className="px-3 py-2">
              <p className="mb-0 fw-bold">Name Surname</p>
              <small className="text-muted">Example.gmail.com</small>
            </li>
            <hr className="dropdown-divider" />
            <li>
              <Link
                to="./login"
                className="dropdown-item hover-color-red text-decoration-none"
              >
                Register
              </Link>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
}

export default Navbar;
