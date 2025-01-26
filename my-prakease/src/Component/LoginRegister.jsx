import React, { useState } from "react";
import Navbar from './NavbarForNonlogin';

const RegisterForm = () => {
  const [formData, setFormData] = useState({
    username: "",
    email: "",
    phoneNumber: "",
    password: "",
    confirmPassword: "",
    profileImage: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS0kMuv7yUxyHmejrES3T3AeEHFxx242hgjSA&s", 
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleImageChange = (e) => {
    const file = e.target.files[0];
    if (file) {
      const reader = new FileReader();
      reader.onload = (event) => {
        setFormData({ ...formData, profileImage: event.target.result });
      };
      reader.readAsDataURL(file);
    }
  };

  const handleSubmit = () => {
    // Submit logic here
    console.log("Form data submitted:", formData);
  };

  return (
    <div className="bg-white dark:bg-gray-800 vh-100 d-flex flex-column">
      
<Navbar/>

    <div>
      
      <div className="row justify-content-center">
        <div className="col-md-7">
        <h3 className="text-center mb-1">
  Register On <span style={{ color: "red" }}>ParkEase</span>
</h3>

          <div className="text-center mb-4">
            <img
              id="selectedAvatar"
              src={formData.profileImage}
              alt="Profile"
              className="rounded-circle border"
              style={{
                width: "120px",
                height: "120px",
                objectFit: "cover",
                marginBottom: "15px",
              }}
              onError={(e) => {
                // Fallback to default image if loading fails
                e.target.src =
                  "https://img.icons8.com/color/512w/circled-user-male-skin-type-4--v2.png";
              }}
            />
            <div>
              <label
                htmlFor="customFile2"
                className="btn btn-warning text-white mt-2"
              >
                Choose Profile Picture
              </label>
              <input
                type="file"
                id="customFile2"
                className="form-control d-none"
                onChange={handleImageChange}
              />
            </div>
          </div>

          {/* Form Inputs */}
          <form>
            <div className="mb-3">
              <label htmlFor="username" className="form-label">Username</label>
              <input
                type="text"
                className="form-control"
                id="username"
                name="username"
                value={formData.username}
                onChange={handleChange}
              />
            </div>

            <div className="mb-3">
              <label htmlFor="email" className="form-label">Email</label>
              <input
                type="email"
                className="form-control"
                id="email"
                name="email"
                value={formData.email}
                onChange={handleChange}
              />
            </div>

            <div className="mb-3">
              <label htmlFor="phoneNumber" className="form-label">Phone Number</label>
              <input
                type="text"
                className="form-control"
                id="phoneNumber"
                name="phoneNumber"
                value={formData.phoneNumber}
                onChange={handleChange}
              />
            </div>

            <div className="mb-3">
              <label htmlFor="password" className="form-label">Password</label>
              <input
                type="password"
                className="form-control"
                id="password"
                name="password"
                value={formData.password}
                onChange={handleChange}
              />
            </div>

            <div className="mb-3">
              <label htmlFor="confirmPassword" className="form-label">Confirm Password</label>
              <input
                type="password"
                className="form-control"
                id="confirmPassword"
                name="confirmPassword"
                value={formData.confirmPassword}
                onChange={handleChange}
              />
            </div>

            <button
              type="button"
              className="btn btn-success w-100"
              onClick={handleSubmit}
            >
              Register
            </button>
          </form>
        </div>
      </div>
    </div>
    </div>
  );
};

export default RegisterForm;
