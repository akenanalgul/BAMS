import { useState } from "react";
import { Link } from "react-router-dom";

const Accounts = () => {
  const [accounts, setAccounts] = useState([
    { id: 1, type: "Vadesiz Mevduat", balance: 12500.75, currency: "₺" },
    { id: 2, type: "Altın Hesabı", balance: 5.2, currency: "gr" },
    { id: 3, type: "Dolar Hesabı", balance: 850.5, currency: "$" },
  ]);

  return (
    <div className="flex flex-col items-center justify-center min-h-screen bg-gray-100 p-6">
      <h1 className="text-3xl font-bold text-gray-900">Hesaplarım</h1>
      <table className="mt-6 w-full max-w-3xl bg-white shadow-lg rounded-lg">
        <thead className="bg-blue-600 text-white">
          <tr>
            <th className="p-4">Hesap Türü</th>
            <th className="p-4">Bakiye</th>
            <th className="p-4">Detaylar</th>
          </tr>
        </thead>
        <tbody>
          {accounts.map((account) => (
            <tr key={account.id} className="border-b text-center">
              <td className="p-4">{account.type}</td>
              <td className="p-4">{account.balance} {account.currency}</td>
              <td className="p-4">
                <Link to={`/accounts/${account.id}`} className="text-blue-500 hover:underline">Detay</Link>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Accounts;
