import { NavLink } from "react-router-dom";

const Sidebar = () => {
  return (
    <div className="w-64 bg-gray-900 text-white min-h-screen p-5">

      <h1 className="text-2xl font-bold mb-8">
        Employee Tracker
      </h1>

      <div className="flex flex-col gap-3">

        <NavLink
          to="/admin/dashboard"
          className={({ isActive }) =>
            `p-3 rounded ${
              isActive
                ? "bg-blue-600"
                : "hover:bg-gray-700"
            }`
          }
        >
          Dashboard
        </NavLink>

        <NavLink
          to="/admin/employees"
          className={({ isActive }) =>
            `p-3 rounded ${
              isActive
                ? "bg-blue-600"
                : "hover:bg-gray-700"
            }`
          }
        >
          Employees
        </NavLink>

        <NavLink
          to="/admin/managers"
          className={({ isActive }) =>
            `p-3 rounded ${
              isActive
                ? "bg-blue-600"
                : "hover:bg-gray-700"
            }`
          }
        >
          Managers
        </NavLink>

        <NavLink
          to="/admin/leaves"
          className={({ isActive }) =>
            `p-3 rounded ${
              isActive
                ? "bg-blue-600"
                : "hover:bg-gray-700"
            }`
          }
        >
          Leaves
        </NavLink>

      </div>

    </div>
  );
};

export default Sidebar;