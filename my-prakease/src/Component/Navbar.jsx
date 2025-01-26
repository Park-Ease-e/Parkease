import "./Css/navbar.css";
import { Link } from "react-router-dom";
import img from "./img/1.jpg";
import logo from "./img/logo.png";


function Navbar() {
  return (
    <nav className="navbar navbar-expand-lg navbar-light bg-light shadow-sm">
      <div className="container">
        <a className="navbar-brand d-flex align-items-center" href="#">
          <img src={logo} alt="Logo" />

          <span className="ms-2 fs-4">ParkEase</span>
        </a>
        {/* Navbar Toggle Button */}

        {/* <button
            className="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarNav"
            aria-controls="navbarNav"
            aria-expanded="false"
            aria-label="Toggle navigation">
            <span className="navbar-toggler-icon" />
          </button> */}
        {/* Center: Navbar Links */}
        {/* <div className="collapse navbar-collapse" id="navbarNav">
            <ul className="navbar-nav me-auto mb-4 mb-lg-0">
              <li className="nav-item">
                <a className="nav-link active" aria-current="page" href="#">
                  Home
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link hover-overlay" href="#">
                  BooKing
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link hover-overlay" href="#">
                  FindYourSpot
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link hover-overlay" href="#">
                  About
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link hover-overlay" href="#">
                  Contact
                </a>
              </li>
            </ul>
          </div> */}

        {/* Right: Profile Dropdown */}

        <div className="dropdown">
          <a
            href="#"
            className="d-flex align-items-center text-decoration-none"
            id="dropdownMenuButton"
            data-bs-toggle="dropdown"
            aria-expanded="false"
          >
            <img src={img} alt="Profile" className="profile-img" />
          </a>
          <ul
            className="dropdown-menu dropdown-menu-end"
            aria-labelledby="dropdownMenuButton"
          >
            <li className="px-3 py-2">
              <p className="mb-0 fw-bold">Pankaj Pidurkar</p>
              <small className="text-muted">Pankajonx.gmail.com</small>
            </li>
            <hr className="dropdown-divider" />
            <li>
              <a className="dropdown-item" href="#">
                Profile Edit
              </a>
            </li>
            <li>
              <a className="dropdown-item" href="#">
                Previous Bookings
              </a>
            </li>
            <li>
              <hr className="dropdown-divider" />
            </li>
            <li>
              <Link
                to="./login"
                className="dropdown-item hover-color-red text-decoration-none"
              >
                SignOut
              </Link>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
}

export default Navbar;
