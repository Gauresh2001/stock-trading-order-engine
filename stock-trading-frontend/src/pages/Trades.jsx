import { useState } from "react";
import API from "../services/api";

function Trades() {
  const [symbol, setSymbol] = useState("");
  const [trades, setTrades] = useState([]);

  const searchTrades = async () => {
    const res = await API.get(`/trades/stock/${symbol}`);
    setTrades(res.data);
  };

  return (
    <div className="container">
      <h1>Trade History</h1>

      <div className="form">
        <input
          placeholder="Enter Stock Symbol"
          value={symbol}
          onChange={(e) => setSymbol(e.target.value)}
        />

        <button onClick={searchTrades}>Search Trades</button>
      </div>

      <table>
        <thead>
          <tr>
            <th>Trade ID</th>
            <th>Buy Order</th>
            <th>Sell Order</th>
            <th>Stock</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Executed At</th>
          </tr>
        </thead>

        <tbody>
          {trades.map((trade) => (
            <tr key={trade.tradeId}>
              <td>{trade.tradeId}</td>
              <td>{trade.buyOrderId}</td>
              <td>{trade.sellOrderId}</td>
              <td>{trade.stockSymbol}</td>
              <td>₹{trade.price}</td>
              <td>{trade.quantity}</td>
              <td>{trade.executedAt}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default Trades;