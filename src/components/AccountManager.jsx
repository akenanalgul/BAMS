import React, { useState, useEffect } from "react";

const AccountManager = () => {
  const [accounts, setAccounts] = useState([]);
  const [newAccountName, setNewAccountName] = useState("");

  useEffect(() => {
    fetch("http://localhost:8080/api/accounts")
      .then((response) => response.json())
      .then((data) => setAccounts(data))
      .catch((error) => console.error("Hesapları çekerken hata:", error));
  }, []);

  const addAccount = () => {
    fetch("http://localhost:8080/api/accounts", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ name: newAccountName }),
    })
      .then((response) => response.json())
      .then((data) => setAccounts([...accounts, data]))
      .catch((error) => console.error("Hesap ekleme hatası:", error));
  };

  const deleteAccount = (id) => {
    fetch(`http://localhost:8080/api/accounts/${id}`, { method: "DELETE" })
      .then(() => setAccounts(accounts.filter((acc) => acc.id !== id)))
      .catch((error) => console.error("Hesap silme hatası:", error));
  };

  return (
    <div>
      <h2>Hesap Yönetimi</h2>
      <input
        type="text"
        placeholder="Yeni hesap adı"
        value={newAccountName}
        onChange={(e) => setNewAccountName(e.target.value)}
      />
      <button onClick={addAccount}>Hesap Ekle</button>

      <ul>
        {accounts.map((acc) => (
          <li key={acc.id}>
            {acc.name} <button onClick={() => deleteAccount(acc.id)}>Sil</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default AccountManager;
