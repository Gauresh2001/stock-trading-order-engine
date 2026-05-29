import { Link } from "react-router-dom";

function Navbar() {
  return (
    <nav className="navbar">
      <h2>Stock Trading Engine</h2>

      <div>
        <Link to="/">Dashboard</Link>
        <Link to="/users">Users</Link>
        <Link to="/stocks">Stocks</Link>
        <Link to="/orders">Orders</Link>
        <Link to="/trades">Trades</Link>
        <Link to="/orderbook">Order Book</Link>
      </div>
    </nav>
  );
}

export default Navbar;