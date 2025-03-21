import axios from "axios";

const API_BASE_URL = "http://localhost:8080"; // Backend'in base URL'i

export default async function loginRequest(path, email, password) {
  try {
    const response = await axios.post(`${API_BASE_URL}/${path}`, {
      email: email,
      password: password,
    }, {
      headers: {
        "Content-Type": "application/json",
      },
    });

    console.log("Login successful:", response.data);
    return response.data; // Token veya kullanıcı bilgisi dönebilir
  } catch (error) {
    console.error("Login failed:", error.response?.data || error.message);
    throw error; // Hata durumunu dışarıya yansıt
  }
}
