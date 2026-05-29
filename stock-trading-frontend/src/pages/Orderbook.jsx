import { useState } from "react";
import API from "../services/api";

function OrderBook() {
  const [symbol, setSymbol] = useState("");
  const [book, setBook] = useState(null);

  const searchOrderBook = async () => {
    const res = await API.get(`/orderbook/${symbol}`);
    setBook(res.data);
  };

  return (
    <div className="container">
      <h1>Market Depth / Order Book</h1>

      <div className="form">
        <input
          placeholder="Enter Stock Symbol"
          value={symbol}
          onChange={(e) => setSymbol(e.target.value)}
        />

        <button onClick={searchOrderBook}>Search Order Book</button>
      </div>

      {book && (
        <div className="book-grid">
          <div>
            <h2>Buy Orders</h2>

            <table>
              <thead>
                <tr>
                  <th>Order ID</th>
                  <th>Price</th>
                  <th>Remaining Qty</th>
                  <th>Status</th>
                </tr>
              </thead>

              <tbody>
                {book.buyOrders.map((order) => (
                  <tr key={order.orderId}>
                    <td>{order.orderId}</td>
                    <td>₹{order.price}</td>
                    <td>{order.remainingQuantity}</td>
                    <td>{order.status}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>

          <div>
            <h2>Sell Orders</h2>

            <table>
              <thead>
                <tr>
                  <th>Order ID</th>
                  <th>Price</th>
                  <th>Remaining Qty</th>
                  <th>Status</th>
                </tr>
              </thead>

              <tbody>
                {book.sellOrders.map((order) => (
                  <tr key={order.orderId}>
                    <td>{order.orderId}</td>
                    <td>₹{order.price}</td>
                    <td>{order.remainingQuantity}</td>
                    <td>{order.status}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      )}
    </div>
  );
}

export default OrderBook;