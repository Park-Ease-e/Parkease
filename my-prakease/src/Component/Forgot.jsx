import NavbarForNonlogin from './NavbarForNonlogin';
import { Link } from "react-router-dom";

import { useState } from "react";

function Forgetpassword() {
  const [showModal, setShowModal] = useState(false);

  const handleResetPassword = (event) => {
    event.preventDefault();
    setShowModal(true); // Show the OTP modal
  };

  const closeModal = () => setShowModal(false);

  return (
    <div>
      <>
      <NavbarForNonlogin/>
        <link
          rel="stylesheet"
          href="https://unpkg.com/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        />
        <section className="bg-light vh-100 d-flex align-items-center justify-content-center">
          <div className="container">
            <div className="row justify-content-center">
              <div className="col-12 col-md-8 col-lg-6">
                <div className="card border-light-subtle shadow-sm">
                  <div className="card-body p-4 p-md-5">
                    <div className="text-center mb-4">
                      <h2 className="h4">Password Reset</h2>
                      <p className="fs-6 fw-normal text-secondary">
                        Provide the email address associated with your account
                        to recover your password.
                      </p>
                    </div>
                    <form onSubmit={handleResetPassword}>
                      <div className="mb-3">
                        <div className="form-floating">
                          <input
                            type="email"
                            className="form-control"
                            name="email"
                            id="email"
                            placeholder="name@example.com"
                            required=""
                          />
                          <label htmlFor="email">Email</label>
                        </div>
                      </div>
                      <div>
                        <button className="btn btn-dark w-100" type="submit">
                          Reset Password
                        </button>
                      </div>
                    </form>
                    <div className="mt-4 text-center">
                     
                        <Link to={'/login'} className="link-secondary text-decoration-none me-3">
                        Login
                        </Link>
                        <Link to={'/register'}  className="link-secondary text-decoration-none me-3">
                        Register
                        </Link>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </section>

        {/* OTP Modal */}
        {showModal && (
          <div
            className="modal fade show d-block"
            tabIndex="-1"
            role="dialog"
            style={{ backgroundColor: "rgba(0, 0, 0, 0.5)" }}
          >
            <div className="modal-dialog modal-dialog-centered" role="document">
              <div className="modal-content">
                <div className="modal-header">
                  <h5 className="modal-title">Enter OTP</h5>
                  <button
                    type="button"
                    className="btn-close"
                    onClick={closeModal}
                  ></button>
                </div>
                <div className="modal-body">
                  <p className="text-muted">Enter the OTP sent to your email:</p>
                  <div className="form-floating mb-3">
                    <input
                      type="text"
                      className="form-control"
                      id="otp"
                      placeholder="Enter OTP"
                      maxLength="6"
                      required=""
                    />
                    <label htmlFor="otp">OTP</label>
                  </div>
                </div>
                <div className="modal-footer">
                  <button
                    type="button"
                    className="btn btn-secondary"
                    onClick={closeModal}
                  >
                    Cancel
                  </button>
                  <button type="button" className="btn btn-dark">
                    Verify OTP
                  </button>
                </div>
              </div>
            </div>
          </div>
        )}
      </>
    </div>
  );
}

export default Forgetpassword;
