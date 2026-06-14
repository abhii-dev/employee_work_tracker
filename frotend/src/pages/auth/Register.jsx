import React from 'react'
import axios from 'axios'
import {Link, useNavigate} from 'react-router-dom'
import {useState} from 'react'

function Register() {

  const navigate = useNavigate();

  const[formData, setFormData] = useState({
    name: "",
    email: "",
    password: "",
    role: "EMPLOYEE"
  });

  const handleChange = (e) =>{
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });

  };

  const handleSubmit = async(e) =>{
    e.preventDefault();

    try{
      const response = await axios.post(
          "http://localhost:8080/auth/register",
          formData
      )
      alert(response.data);

      navigate("/login");

    }catch(error){
      console.log(error);
      alert("Registration failed");

    }
  }


  return (
   <div className="min-h-screen flex justify-center items-center bg-slate-100">
      <div className="bg-white shadow-lg rounded-xl p-8 w-[400px]">

        <h1 className="text-3xl font-bold text-center mb-6">
          Register
        </h1>

        <form
          onSubmit={handleSubmit}
          className="space-y-4"
        >
          <input
            type="text"
            name="name"
            placeholder="Enter Name"
            className="w-full border p-3 rounded"
            value={formData.name}
            onChange={handleChange}
          />

          <input
            type="email"
            name="email"
            placeholder="Enter Email"
            className="w-full border p-3 rounded"
            value={formData.email}
            onChange={handleChange}
          />

          <input
            type="password"
            name="password"
            placeholder="Enter Password"
            className="w-full border p-3 rounded"
            value={formData.password}
            onChange={handleChange}
          />

          <select
            name="role"
            className="w-full border p-3 rounded"
            value={formData.role}
            onChange={handleChange}
          >
            <option value="EMPLOYEE">
              EMPLOYEE
            </option>

            <option value="MANAGER">
              MANAGER
            </option>

            <option value="ADMIN">
              ADMIN
            </option>
          </select>

          <button
            type="submit"
            className="w-full bg-blue-600 text-white p-3 rounded hover:bg-blue-700"
          >
            Register
          </button>
        </form>

        <p className="text-center mt-4">
          Already have an account?{" "}
          <Link
            to="/login"
            className="text-blue-600"
          >
            Login
          </Link>
        </p>

      </div>
    </div>
  );
}

export default Register