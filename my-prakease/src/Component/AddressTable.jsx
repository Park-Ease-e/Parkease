import React, { useState } from "react";
import park from "./img/images.jpeg"; 
import Navbar from "./Navbar"; 
import "./Css/address.css"; 
import "./Css/spotbook.css"; 

function AddresTable() {
  const [showModal, setShowModal] = useState(false); 
  const [showPopup, setShowPopup] = useState(false);

  const openModal = () => setShowModal(true);
  const closeModal = () => setShowModal(false);

  const handleBookClick = () => {
    setShowPopup(true);
  };

  const handleClosePopup = () => {
    setShowPopup(false);
  };

  const submitForm = () => {
    alert("Form submitted successfully!");
    closeModal(); 
  };

  const bookSpot = (spotNumber) => {
    alert(`You have booked Spot ${spotNumber}`);
    setShowPopup(false); 
  };

  return (
    <div className="bg-white dark:bg-gray-800 vh-100 d-flex flex-column">
      <Navbar />
      <div className="container mt-4">
        <input
          type="text"
          className="form-control"
          placeholder="Search by name or address"
        />
        <div className="mb-3"></div>
        <table className="table">
          <thead>
            <tr>
              <th scope="col">Name</th>
              <th scope="col">Address</th>
              <th scope="col">Available Spot</th>
              <th scope="col">Images</th>
              <th scope="col">Book</th>
            </tr>
          </thead>
          <tbody>
            {[1, 2, 3].map((id) => (
              <tr key={id}>
                <th scope="row">ATL - Atlanta - The Parking Spot {id}</th>
                <td className="address">
                  2741 Camp Creek Pkwy, College Park, GA 30337
                </td>
                <td>
                  <span className="badge bg-success">Available</span>
                </td>
                <td>
                  <img
                    src={park}
                    alt={`Parking Spot ${id}`}
                    className="spot-img"
                  />
                </td>
                <td>
                  <button
                    className="btn btn-outline-primary"
                    onClick={openModal}
                  >
                    Book
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>

      {/* Modal */}
      {showModal && (
        <div className="modal-overlay" onClick={closeModal}>
          <div className="modal-content" onClick={(e) => e.stopPropagation()}>
            <h2>Booking Details</h2>
            <form id="bookingForm" className="form">
              <div className="form-group">
                <label htmlFor="carNo">Car No:</label>
                <input
                  type="text"
                  id="carNo"
                  name="carNo"
                  placeholder="MH12BC9020"
                  required
                />
              </div>
              <div className="form-group">
                <label htmlFor="entryDate">Entry Date:</label>
                <input type="date" id="entryDate" name="entryDate" required />
              </div>
              <div className="form-group">
                <label htmlFor="entryTime">Entry Time:</label>
                <input type="time" id="entryTime" name="entryTime" required />
              </div>
              <div className="form-group">
                <label htmlFor="exitDate">Exit Date:</label>
                <input type="date" id="exitDate" name="exitDate" required />
              </div>
              <div className="form-group">
                <label htmlFor="exitTime">Exit Time:</label>
                <input type="time" id="exitTime" name="exitTime" required />
              </div>
              <div className="form-group">
                <label htmlFor="carType">Car Type:</label>
                <input
                  type="text"
                  id="carType"
                  name="carType"
                  placeholder="Sedan, SUV, etc."
                />
              </div>
              <div className="form-group">
                <label className="btn btn-primary" onClick={handleBookClick}> Choice Your Spot</label>
               <p></p>
              </div>
              <div className="form-group">
                <button
                  type="button"
                  className="btn btn-primary"
                  onClick={submitForm}
                >
                 Book
                </button>
              </div>
            </form>
            <button className="btn btn-outline-danger" onClick={closeModal}>
              Close
            </button>
          </div>
        </div>
      )}

      {/* Popup */}
      {showPopup && (
        <div className="popup-container">
          <div className="popup-content">
            <h1>Find Your Spot</h1>
            <div className="parking-lot" id="parking-lot">
              {[...Array(15).keys()].map((i) => (
                <div
                  key={i}
                  className="spot available"
                  onClick={() => bookSpot(i + 1)}
                >
                  Spot {i + 1}
                </div>
              ))}
            </div>
            <button
              className="btn btn-outline-secondary"
              onClick={handleClosePopup}
            >
              
            </button>
          </div>
        </div>
      )}
    </div>
  );
}

export default AddresTable;
