function AdminHome() {
    return ( 
        <div>
            <table className="table align-middle mb-0 bg-white">
  <thead className="bg-light">
    <tr>
      <th>Name</th>
      <th>Status</th>
      <th>Actions</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>
        <div className="d-flex align-items-center">
          <img
            src="https://mdbootstrap.com/img/new/avatars/8.jpg"
            alt=""
            style={{ width: 45, height: 45 }}
            className="rounded-circle"
          />
          <div className="ms-3">
            <p className="fw-bold mb-1">John Doe</p>
            <p className="text-muted mb-0">john.doe@gmail.com</p>
          </div>
        </div>
      </td>
     
      <td>
      <span class="badge bg-success">Active</span>
      </td>
      
      <td>
      <button
      type="button"
      className="btn btn-primary btn-sm btn-rounded fw-bold text-white shadow-sm"
      style={{ transition: 'all 0.3s ease-in-out' }}
    >
      <i className="fas fa-edit"></i> Edit
    </button>

      </td>
    </tr>
    <tr>
      <td>
        <div className="d-flex align-items-center">
          <img
            src="https://mdbootstrap.com/img/new/avatars/6.jpg"
            className="rounded-circle"
            alt=""
            style={{ width: 45, height: 45 }}
          />
          <div className="ms-3">
            <p className="fw-bold mb-1">Alex Ray</p>
            <p className="text-muted mb-0">alex.ray@gmail.com</p>
          </div>
        </div>
      </td>
     
      <td>
      <span class="badge bg-danger">Close</span>
      </td>
      
      <td>
      <button
      type="button"
      className="btn btn-primary btn-sm btn-rounded fw-bold text-white shadow-sm"
      style={{ transition: 'all 0.3s ease-in-out' }}
    >
      <i className="fas fa-edit"></i> Edit
    </button>
      </td>
    </tr>
    <tr>
      <td>
        <div className="d-flex align-items-center">
          <img
            src="https://mdbootstrap.com/img/new/avatars/7.jpg"
            className="rounded-circle"
            alt=""
            style={{ width: 45, height: 45 }}
          />
          <div className="ms-3">
            <p className="fw-bold mb-1">Kate Hunington</p>
            <p className="text-muted mb-0">kate.hunington@gmail.com</p>
          </div>
        </div>
      </td>
    
      <td>
        
      <span class="badge bg-success">Active</span>

        
      </td>
    
      <td>
      <button
      type="button"
      className="btn btn-primary btn-sm btn-rounded fw-bold text-white shadow-sm"
      style={{ transition: 'all 0.3s ease-in-out' }}
    >
      <i className="fas fa-edit"></i> Edit
    </button>

      </td>
    </tr>
  </tbody>
</table>

        </div>
     );
}

export default AdminHome;