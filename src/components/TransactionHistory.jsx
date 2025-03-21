import React, { useState, useEffect } from "react";

const TransactionHistory = () => {
  const [transactions, setTransactions] = useState([]);

  useEffect(() => {
    // API'den işlem geçmişini çek (Örnek bir JSON kullanılıyor)
    fetch("http://localhost:8080/api/transactions")
      .then((response) => response.json())
      .then((data) => setTransactions(data))
      .catch((error) => console.error("Veri çekme hatası:", error));
  }, []);

  return (
    <div>
      <h2>İşlem Geçmişi</h2>
      <table border="1">
        <thead>
          <tr>
            <th>ID</th>
            <th>Hesap ID</th>
            <th>İşlem Türü</th>
            <th>Miktar</th>
          </tr>
        </thead>
        <tbody>
          {transactions.map((tx) => (
            <tr key={tx.id}>
              <td>{tx.id}</td>
              <td>{tx.account_id}</td>
              <td>{tx.transaction_type}</td>
              <td>{tx.amount}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default TransactionHistory;
