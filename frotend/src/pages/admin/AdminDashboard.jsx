import { useEffect, useState } from "react";
import axios from "axios";

const AdminDashboard = () => {

  const [dashboard, setDashboard] = useState(null);

  useEffect(() => {
    fetchDashboard();
  }, []);

  const fetchDashboard = async () => {

    try {
      const token = localStorage.getItem("token");
      const response = await axios.get(
        "http://localhost:8080/api/dashboard/admin",
        {
          headers: {
            Authorization: `Bearer ${token}`
          }
        }

      );
      console.log(response.data);
      setDashboard(response.data);

    } catch (error) {

      console.log(error);

    }
  };

  if (!dashboard) {
    return <h2>Loading Dashboard...</h2>;
  }

  return (
    <div>

      <h1 className="text-3xl font-bold mb-6">
        Admin Dashboard
      </h1>

      {/* Cards */}

      <div className="grid grid-cols-1 md:grid-cols-3 gap-6">

        <div className="bg-white shadow p-5 rounded-lg">
          <h3>Total Employees</h3>

          <p className="text-3xl font-bold mt-2">
            {dashboard.totalEmployees}
          </p>
        </div>

        <div className="bg-white shadow p-5 rounded-lg">
          <h3>Total Managers</h3>

          <p className="text-3xl font-bold mt-2">
            {dashboard.totalManagers}
          </p>
        </div>

        <div className="bg-white shadow p-5 rounded-lg">
          <h3>Total Tasks</h3>

          <p className="text-3xl font-bold mt-2">
            {dashboard.totalTasks}
          </p>
        </div>

        <div className="bg-white shadow p-5 rounded-lg">
          <h3>Completed Tasks</h3>

          <p className="text-3xl font-bold mt-2 text-green-600">
            {dashboard.completedTasks}
          </p>
        </div>

        <div className="bg-white shadow p-5 rounded-lg">
          <h3>Pending Tasks</h3>

          <p className="text-3xl font-bold mt-2 text-red-600">
            {dashboard.pendingTasks}
          </p>
        </div>

        <div className="bg-white shadow p-5 rounded-lg">
          <h3>Average Performance</h3>

          <p className="text-3xl font-bold mt-2">
            {dashboard.averagePerformanceScore.toFixed(2)}
          </p>
        </div>

      </div>

      {/* Top Performer */}

      <div className="bg-white shadow p-5 rounded-lg mt-6">

        <h2 className="text-xl font-semibold mb-3">
          Top Performer
        </h2>

        <p className="text-green-600 text-2xl font-bold">
          {dashboard.topPerformer}
        </p>

      </div>

    </div>
  );
};

export default AdminDashboard;