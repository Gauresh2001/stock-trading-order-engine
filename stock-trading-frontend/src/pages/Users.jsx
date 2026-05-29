import { useEffect, useState } from "react";
import API from "../services/api";

function Users() {
  const [users, setUsers] = useState([]);
  const [form, setForm] = useState({
    name: "",
    email: "",
    balance: "",
  });

  const loadUsers = async () => {
    const res = await API.get("/users");
    setUsers(res.data);
  };

  useEffect(() => {
    loadUsers();
  }, []);

  const handleSubmit = async (e) => {
    e.preventDefault();

    await API.post("/users", {
      name: form.name,
      email: form.email,
      balance: Number(form.balance),
    });

    setForm({ name: "", email: "", balance: "" });
    loadUsers();
  };

  return (
    <div className="container">
      <h1>User Management</h1>

      <form className="form" onSubmit={handleSubmit}>
        <input
          placeholder="User Name"
          value={form.name}
          onChange={(e) => setForm({ ...form, name: e.target.value })}
        />

        <input
          placeholder="Email Address"
          value={form.email}
          onChange={(e) => setForm({ ...form, email: e.target.value })}
        />

        <input
          type="number"
          placeholder="Balance"
          value={form.balance}
          onChange={(e) => setForm({ ...form, balance: e.target.value })}
        />

        <button>Add User</button>
      </form>

      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Balance</th>
          </tr>
        </thead>

        <tbody>
          {users.map((user) => (
            <tr key={user.id}>
              <td>{user.id}</td>
              <td>{user.name}</td>
              <td>{user.email}</td>
              <td>₹{user.balance}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default Users;