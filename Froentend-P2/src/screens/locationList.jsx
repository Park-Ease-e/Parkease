import { useState, useEffect } from "react";
import { toast } from "react-toastify";
import { useNavigate } from "react-router-dom";
import { getAllLocations, updateLocationStatus } from "../services/location";

export default function LocationList() {
  const [locations, setLocations] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    loadLocations();
  }, []);

  const loadLocations = async () => {
    try {
      const result = await getAllLocations();
      if (result.status === 200) {
        setLocations(result.data);
      } else {
        toast.error("Failed to fetch locations.");
      }
    } catch (error) {
      toast.error("Network error, please try again.");
    }
  };

  const onUpdateLocation = (id) => {
    navigate(`/update-location/${id}`);
  };

  const onMakeAvailableUnavailable = async (id) => {
    try {
      const result = await updateLocationStatus(id);
      if (result.status === 200) {
        toast.success("Location status updated.");
        setLocations((prevLocations) =>
          prevLocations.map((loc) =>
            loc.locationId === id ? { ...loc, is_active: !loc.is_active } : loc
          )
        );
      } else {
        toast.error("Failed to update status.");
      }
    } catch (error) {
      toast.error("Error updating status.");
    }
  };

  return (
    <div className="container mt-4">
      <h2 className="text-center mb-4">Location List</h2>

      <table className="table table-bordered table-striped">
        <thead className="table-dark">
          <tr>
            <th>ID</th>
            <th>Location Name</th>
            <th>Address</th>
            <th>Total Seats</th>
            <th>Hourly Rate</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {locations.map((location, index) => (
            <tr key={location.locationId || index}>
              <td>{location.locationId}</td>
              <td>{location.locationName}</td>
              <td>{location.address}</td>
              <td>{location.totalSeats}</td>
              <td>₹{location.hourlyRate}</td>
              <td>
                <button
                  className="btn btn-primary btn-sm me-2"
                  onClick={() => onUpdateLocation(location.locationId)}
                >
                  Update
                </button>
                <button
                  className={`btn btn-${location.is_active ? "danger" : "success"} btn-sm`}
                  onClick={() => onMakeAvailableUnavailable(location.locationId)}
                >
                  {location.is_active ? "Make Unavailable" : "Make Available"}
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
