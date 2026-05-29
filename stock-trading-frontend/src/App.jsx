import { Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar";
import Dashboard from "./pages/Dashboard";
import Users from "./pages/Users";
import Stocks from "./pages/Stocks";
import Orders from "./pages/Orders";
import Trades from "./pages/Trades";
import OrderBook from "./pages/OrderBook";

function App() {
  return (
    <>
      <Navbar />
      <Routes>
        <Route path="/" element={<Dashboard />} />
        <Route path="/users" element={<Users />} />
        <Route path="/stocks" element={<Stocks />} />
        <Route path="/orders" element={<Orders />} />
        <Route path="/trades" element={<Trades />} />
        <Route path="/orderbook" element={<OrderBook />} />
      </Routes>
    </>
  );
}

export default App;