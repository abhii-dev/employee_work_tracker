import React from "react";
import {
  BrowserRouter,
  Routes,
  Route,
  Navigate,
} from "react-router-dom";

import Login from "./pages/auth/Login";
import Register from "./pages/auth/Register";

import AdminDashboard from "./pages/admin/AdminDashboard";
import EmployeeManagement from "./pages/admin/EmployeeManagement";
import ManagerManagement from "./pages/admin/ManagerManagement";

import AdminLayout from "./layouts/AdminLayout";

function App() {
  return (
    <BrowserRouter>
      <Routes>

        {/* Default Route */}
        <Route
          path="/"
          element={<Navigate to="/login" replace />}
        />

        {/* Auth Routes */}
        <Route
          path="/login"
          element={<Login />}
        />

        <Route
          path="/register"
          element={<Register />}
        />

        {/* Admin Routes */}
        <Route element={<AdminLayout />}>

          <Route
            path="/admin"
            element={
              <Navigate
                to="/admin/dashboard"
                replace
              />
            }
          />

          <Route
            path="/admin/dashboard"
            element={<AdminDashboard />}
          />

          <Route
            path="/admin/employees"
            element={<EmployeeManagement />}
          />

          <Route
            path="/admin/managers"
            element={<ManagerManagement />}
          />

        </Route>

      </Routes>
    </BrowserRouter>
  );
}

export default App;