import { useEffect, useState } from "react";
import API from "../services/api";

function Stocks() {
  const [stocks, setStocks] = useState([]);
  const [form, setForm] = useState({
    symbol: "",
    companyName: "",
  });

  const loadStocks = async () => {
    const res = await API.get("/stocks");
    setStocks(res.data);
  };

  useEffect(() => {
    loadStocks();
  }, []);

  const handleSubmit = async (e) => {
    e.preventDefault();

    await API.post("/stocks", {
      symbol: form.symbol,
      companyName: form.companyName,
    });

    setForm({ symbol: "", companyName: "" });
    loadStocks();
  };

  return (
    <div className="container">
      <h1>Stock Management</h1>

      <form className="form" onSubmit={handleSubmit}>
        <input
          placeholder="Stock Symbol"
          value={form.symbol}
          onChange={(e) => setForm({ ...form, symbol: e.target.value })}
        />

        <input
          placeholder="Company Name"
          value={form.companyName}
          onChange={(e) => setForm({ ...form, companyName: e.target.value })}
        />

        <button>Add Stock</button>
      </form>

      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Symbol</th>
            <th>Company Name</th>
          </tr>
        </thead>

        <tbody>
          {stocks.map((stock) => (
            <tr key={stock.id}>
              <td>{stock.id}</td>
              <td>{stock.symbol}</td>
              <td>{stock.companyName}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default Stocks;