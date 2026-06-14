const Navbar = () => {

  const handleLogout = () => {
    localStorage.removeItem("token");

    window.location.href = "/login";
  };

  return (
    <div className="bg-white shadow p-4 flex justify-between items-center">

      <h2 className="text-xl font-semibold">
        Admin Panel
      </h2>

      <button
        onClick={handleLogout}
        className="bg-red-500 text-white px-4 py-2 rounded"
      >
        Logout
      </button>

    </div>
  );
};

export default Navbar;