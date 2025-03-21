import { Link } from "react-router-dom";
import "./Header.css";
import "bootstrap/dist/css/bootstrap.min.css";


function Header() {
  return (
    <header className="header">
      <div className="logo">🏦 BAMS Bank</div>
      <nav>
        <ul className="nav-links">
          <li><Link to="/">Ana Sayfa</Link></li>
          <li><Link to="/about">Hakkımızda</Link></li>
          <Link to="/services" className="hover:underline">Hizmetlerimiz</Link>
          <Link to="/accounts" className="hover:underline">Hesaplarım</Link>
          <li><Link to="/transfer">Para Transferi</Link></li>
          <li><Link to="/contact">İletişim</Link></li>
        </ul>
      </nav>
    </header>
  );
}

export default Header;
