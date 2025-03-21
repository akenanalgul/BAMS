import { useParams } from "react-router-dom";

const AccountDetails = () => {
  const { id } = useParams();

  // Örnek hesap verileri (ileride API ile değiştirilebilir)
  const accounts = [
    { id: 1, type: "Vadesiz Mevduat", balance: 12500.75, currency: "₺", transactions: ["500₺ Yatırıldı", "200₺ Çekildi"] },
    { id: 2, type: "Altın Hesabı", balance: 5.2, currency: "gr", transactions: ["1gr Satın Alındı", "0.5gr Satıldı"] },
    { id: 3, type: "Dolar Hesabı", balance: 850.5, currency: "$", transactions: ["300$ Yatırıldı", "100$ Çekildi"] },
  ];

  const account = accounts.find((acc) => acc.id === parseInt(id));

  if (!account) {
    return <h2 className="text-center text-red-500">Hesap bulunamadı!</h2>;
  }

  return (
    <div className="flex flex-col items-center justify-center min-h-screen bg-gray-100 p-6">
      <h1 className="text-3xl font-bold text-gray-900">{account.type} Detayları</h1>
      <div className="mt-4 p-6 bg-white shadow-lg rounded-lg w-full max-w-md">
        <p className="text-lg">Bakiye: <strong>{account.balance} {account.currency}</strong></p>
        <h2 className="mt-4 text-xl font-semibold">İşlem Geçmişi</h2>
        <ul className="mt-2 list-disc list-inside">
          {account.transactions.map((transaction, index) => (
            <li key={index}>{transaction}</li>
          ))}
        </ul>
      </div>
    </div>
  );
};

export default AccountDetails;
