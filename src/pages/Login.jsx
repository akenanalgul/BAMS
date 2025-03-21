import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

import loginRequest from "../services/api";

const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error,setError] = useState("")
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();
    // Burada backend ile giriş işlemi yapılabilir
    try {
      const response = await loginRequest("login",email,password);
      console.log("Login successful:",response.data);

      localStorage.setItem("token",response.data.token);

      navigate("/dashboard"); // Başarılı giriş sonrası yönlendirme      
    } catch (error) {
      setError("Giriş başarısız!Lütfen bilgilerinizi kontrol edin.");
      console.log(error);
      
    }
    
  };

  return (
    <div className="container d-flex justify-content-center align-items-center vh-100">
      <div className="card p-4 shadow" style={{ width: "350px" }}>
        <h3 className="text-center">Giriş Yap123</h3>
        <form onSubmit={handleLogin}>
          <div className="mb-3">
            <label className="form-label">E-posta</label>
            <input
              type="email"
              className="form-control"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
          </div>
          <div className="mb-3">
            <label className="form-label">Şifre</label>
            <input
              type="password"
              className="form-control"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>
          <button type="submit" className="btn btn-primary w-100">Giriş Yap</button>
        </form>
        <p className="text-center mt-3">
          Hesabın yok mu? <Link to="/register">Kaydol</Link>
        </p>
      </div>
    </div>
  );
};

export default Login;
