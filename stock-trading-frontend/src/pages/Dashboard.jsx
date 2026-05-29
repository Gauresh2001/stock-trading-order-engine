function Dashboard() {
  return (
    <div className="container">
      <div className="hero">
        <h1>Stock Trading Order Engine</h1>
        <p>
          A professional backend-powered stock trading system with users,
          stocks, buy/sell orders, order matching, trades and order book.
        </p>

        <div className="cards">
          <div className="card">Users Management</div>
          <div className="card">Stock Listing</div>
          <div className="card">Buy / Sell Orders</div>
          <div className="card">Trade History</div>
        </div>
      </div>
    </div>
  );
}

export default Dashboard;