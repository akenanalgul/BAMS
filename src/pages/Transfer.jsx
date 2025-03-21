import { useState, useEffect } from "react";

const Transfer = () => {
  const [accounts, setAccounts] = useState([
    { id: 1, type: "Vadesiz Mevduat", balance: 12500.75, currency: "₺" },
    { id: 2, type: "Altın Hesabı", balance: 5.2, currency: "gr" },
    { id: 3, type: "Dolar Hesabı", balance: 850.5, currency: "$" },
  ]);

  const [fromAccount, setFromAccount] = useState("");
  const [toAccount, setToAccount] = useState("");
  const [amount, setAmount] = useState("");
  const [message, setMessage] = useState("");
  const [totalBalance, setTotalBalance] = useState(0); // Genel toplam state'i

  // Genel toplamı hesaplayan fonksiyon
  const calculateTotalBalance = () => {
    const total = accounts
      .filter((acc) => acc.currency === "₺") // Sadece TL hesapları hesaba kat
      .reduce((sum, acc) => sum + acc.balance, 0);
    setTotalBalance(total);
  };

  useEffect(() => {
    calculateTotalBalance();
  }, [accounts]); // Hesaplar değiştikçe toplamı güncelle

  const handleTransfer = () => {
    const from = accounts.find((acc) => acc.id === parseInt(fromAccount));
    const to = accounts.find((acc) => acc.id === parseInt(toAccount));

    if (!from || !to) {
      setMessage("Geçerli hesap seçin.");
      return;
    }

    if (from.id === to.id) {
      setMessage("Aynı hesaba transfer yapılamaz.");
      return;
    }

    if (parseFloat(amount) <= 0 || isNaN(parseFloat(amount))) {
      setMessage("Geçerli bir miktar girin.");
      return;
    }

    if (from.balance < parseFloat(amount)) {
      setMessage("Bakiye yetersiz.");
      return;
    }

    // Güncellenmiş hesap listesi
    const updatedAccounts = accounts.map((acc) => {
      if (acc.id === from.id) {
        return { ...acc, balance: acc.balance - parseFloat(amount) };
      }
      if (acc.id === to.id) {
        return { ...acc, balance: acc.balance + parseFloat(amount) };
      }
      return acc;
    });

    setAccounts(updatedAccounts);
    setMessage(`Transfer başarılı! ${amount} ${from.currency}, ${to.type} hesabına gönderildi.`);
    setAmount("");
  };

  return (
    <div className="flex flex-col items-center justify-center min-h-screen bg-gray-100 p-6">
      <h1 className="text-3xl font-bold text-gray-900">Para Transferi</h1>

      {/* Genel Bakiye */}
      <p className="mt-2 text-lg text-gray-700 font-semibold">
        Genel Bakiye: {totalBalance.toFixed(2)} ₺
      </p>

      <div className="mt-4 p-6 bg-white shadow-lg rounded-lg w-full max-w-md">
        <label className="block mb-2">Gönderen Hesap:</label>
        <select value={fromAccount} onChange={(e) => setFromAccount(e.target.value)} className="w-full p-2 border rounded">
          <option value="">Seçiniz</option>
          {accounts.map((acc) => (
            <option key={acc.id} value={acc.id}>
              {acc.type} - {acc.balance.toFixed(2)} {acc.currency}
            </option>
          ))}
        </select>

        <label className="block mt-4 mb-2">Alıcı Hesap:</label>
        <select value={toAccount} onChange={(e) => setToAccount(e.target.value)} className="w-full p-2 border rounded">
          <option value="">Seçiniz</option>
          {accounts.map((acc) => (
            <option key={acc.id} value={acc.id}>
              {acc.type} - {acc.balance.toFixed(2)} {acc.currency}
            </option>
          ))}
        </select>

        <label className="block mt-4 mb-2">Tutar:</label>
        <input type="number" value={amount} onChange={(e) => setAmount(e.target.value)} className="w-full p-2 border rounded" />

        <button onClick={handleTransfer} className="w-full mt-4 bg-blue-500 text-white py-2 rounded hover:bg-blue-700">
          Gönder
        </button>

        {message && <p className="mt-4 text-center text-green-600">{message}</p>}
      </div>
    </div>
  );
};

export default Transfer;
