import { useState } from "react";
import Icon from "@/assets/Login/LoginImage.svg?react";
import api from "@/services/api";
import useAuthStore from "@/store/useAuthStore";
import axios from "axios";

import styles from "@/styles/Login/Login.module.css";
import GoogleLogin from "@/components/Login/GoogleLogin";

const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const setAuth = useAuthStore((state) => state.setAuth);

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post(
        "https://k11b202.p.ssafy.io/api/v1/auth/login",
        {
          email: email,
          password: password,
        }
      );

      const accessToken = response.headers["authorization"];
      console.log(accessToken);
      console.log(response);
      console.log(response.headers);
      setAuth(true, accessToken);
    } catch (error) {
      console.log("로그인 실패 : " + error);
    }
  };

  return (
    <div className={styles.container}>
      <div className={styles.left}>
        <Icon className={styles.icon} />
      </div>
      <div className={styles.right}>
        <div className={styles.title}>Log In</div>
        <form onSubmit={handleLogin}>
          <input
            type="email"
            name="email"
            id="email"
            placeholder="Email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
          <br />
          <input
            type="password"
            name="password"
            id="password"
            placeholder="Password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
          <div className={styles.buttonBox}>
            <button type="submit" className={styles.button}>
              로그인
            </button>
            <GoogleLogin />
          </div>
        </form>
      </div>
    </div>
  );
};
export default Login;
