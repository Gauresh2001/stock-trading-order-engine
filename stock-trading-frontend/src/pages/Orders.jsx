import { useEffect, useState } from "react";
import API from "../services/api";

function Orders() {
  const [orders, setOrders] = useState([]);
  const [form, setForm] = useState({
    userId: "",
    stockSymbol: "",
    price: "",
    quantity: "",
  });

  const loadOrders = async () => {
    const res = await API.get("/orders");
    setOrders(res.data);
  };

  useEffect(() => {
    loadOrders();
  }, []);

  const placeOrder = async (type) => {
    await API.post(`/orders/${type}`, {
      userId: Number(form.userId),
      stockSymbol: form.stockSymbol,
      price: Number(form.price),
      quantity: Number(form.quantity),
    });

    setForm({
      userId: "",
      stockSymbol: "",
      price: "",
      quantity: "",
    });

    loadOrders();
  };

  const cancelOrder = async (id) => {
    await API.delete(`/orders/${id}`);
    loadOrders();
  };

  return (
    <div className="container">
      <h1>Buy / Sell Orders</h1>

      <div className="form">
        <input
          placeholder="User ID"
          value={form.userId}
          onChange={(e) => setForm({ ...form, userId: e.target.value })}
        />

        <input
          placeholder="Stock Symbol"
          value={form.stockSymbol}
          onChange={(e) => setForm({ ...form, stockSymbol: e.target.value })}
        />

        <input
          type="number"
          placeholder="Price"
          value={form.price}
          onChange={(e) => setForm({ ...form, price: e.target.value })}
        />

        <input
          type="number"
          placeholder="Quantity"
          value={form.quantity}
          onChange={(e) => setForm({ ...form, quantity: e.target.value })}
        />

        <button onClick={() => placeOrder("buy")}>Place Buy Order</button>
        <button className="sell" onClick={() => placeOrder("sell")}>
          Place Sell Order
        </button>
      </div>

      <table>
        <thead>
          <tr>
            <th>Order ID</th>
            <th>User</th>
            <th>Stock</th>
            <th>Type</th>
            <th>Price</th>
            <th>Qty</th>
            <th>Remaining</th>
            <th>Status</th>
            <th>Action</th>
          </tr>
        </thead>

        <tbody>
          {orders.map((order) => (
            <tr key={order.orderId}>
              <td>{order.orderId}</td>
              <td>{order.userName}</td>
              <td>{order.stockSymbol}</td>
              <td>{order.orderType}</td>
              <td>₹{order.price}</td>
              <td>{order.quantity}</td>
              <td>{order.remainingQuantity}</td>
              <td>
                <span className={`status ${order.status.toLowerCase()}`}>
                  {order.status}
                </span>
              </td>
              <td>
                {order.status !== "FILLED" && order.status !== "CANCELLED" && (
                  <button
                    className="cancel"
                    onClick={() => cancelOrder(order.orderId)}
                  >
                    Cancel
                  </button>
                )}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default Orders;