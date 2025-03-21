import React from "react";

const Home = () => {
  return (
    <div className="container mt-5">
      <div className="row">
        {/* Genel Bakiye Kartı */}
        <div className="col-md-6">
          <div className="card text-white bg-primary mb-3">
            <div className="card-header">Genel Bakiye</div>
            <div className="card-body">
              <h5 className="card-title">₺10,000</h5>
              <p className="card-text">Tüm hesaplarınızın toplam bakiyesi.</p>
            </div>
          </div>
        </div>

        {/* Son İşlemler Kartı */}
        <div className="col-md-6">
          <div className="card text-white bg-success mb-3">
            <div className="card-header">Son İşlemler</div>
            <div className="card-body">
              <h5 className="card-title">₺500 - ATM Para Çekme</h5>
              <p className="card-text">Tarih: 12 Şubat 2025</p>
              <button className="btn btn-light">Tümünü Gör</button>
            </div>
          </div>
        </div>
      </div>

      {/* Hesaplar ve İşlem Yap */}
      <div className="row">
        <div className="col-md-6">
          <div className="card">
            <div className="card-body">
              <h5 className="card-title">Hesaplarım</h5>
              <p className="card-text">Mevcut hesaplarınıza buradan ulaşabilirsiniz.</p>
              <button className="btn btn-outline-primary">Hesapları Gör</button>
            </div>
          </div>
        </div>

        <div className="col-md-6">
          <div className="card">
            <div className="card-body">
              <h5 className="card-title">Yeni İşlem Yap</h5>
              <p className="card-text">Havale, EFT veya fatura ödeme işlemlerini başlatın.</p>
              <button className="btn btn-outline-success">İşlem Yap</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Home;
