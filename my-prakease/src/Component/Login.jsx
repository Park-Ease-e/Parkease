import { Link } from "react-router-dom";
import "./Css/Loginregister.css";
import img from "./img/loginlog.png";
import NavbarForNonlogin from './NavbarForNonlogin';

function Login() {
  return (
    <div className="Container">
      <NavbarForNonlogin/>
      <section className="vh-100">
        <div className="container-fluid h-custom">
          <div className="row d-flex justify-content-center align-items-center h-100">
            <div className="col-md-9 col-lg-6 col-xl-5">
              <img src={img} className="img-fluid" alt="" />
            </div>
            <div className="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
              <form>
                <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
                  <h3 className="mb-4 pb-2 pb-md-0 mb-md-5">
                    Sign in <span className="text-yellow">On</span>{" "}
                    <span id="ti">ParkEase</span>{" "}
                  </h3>
                </div>

                {/* Email input */}
                <div data-mdb-input-init="" className="form-outline mb-4">
                  <input
                    type="email"
                    id="form3Example3"
                    className="form-control form-control-lg"
                    placeholder="Enter a valid email address"
                  />
                  <label className="form-label" htmlFor="form3Example3">
                    Email address
                  </label>
                </div>
                {/* Password input */}
                <div data-mdb-input-init="" className="form-outline mb-3">
                  <input
                    type="password"
                    id="form3Example4"
                    className="form-control form-control-lg"
                    placeholder="Enter password"
                  />
                  <label className="form-label" htmlFor="form3Example4">
                    Password
                  </label>
                </div>
                <div className="d-flex justify-content-between align-items-center">
                  {/* Checkbox */}
                  <div className="form-check mb-0">
                    <input
                      className="form-check-input me-2"
                      type="checkbox"
                      defaultValue=""
                      id="form2Example3"
                    />
                    <label className="form-check-label" htmlFor="form2Example3">
                      Remember me
                    </label>
                  </div>
                  <Link to="/forget" className="text-body">
                    Forgot password?
                  </Link>
                </div>
                <div className="text-center text-lg-start mt-4 pt-2">
                  <button
                    type="button"
                    data-mdb-button-init=""
                    data-mdb-ripple-init=""
                    className="btn btn-primary btn-lg"
                    style={{ paddingLeft: "2.5rem", paddingRight: "2.5rem" }}
                  >
                    Login
                  </button>
                  <p className="small fw-bold mt-2 pt-1 mb-0">
                    Don't have an account?{" "}
                    <Link to="/register" className="link-danger">
                      Register
                    </Link>
                  </p>
                </div>
              </form>
            </div>
          </div>
        </div>
      </section>
    </div>
  );
}

export default Login;
