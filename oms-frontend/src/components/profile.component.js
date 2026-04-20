import React, { useEffect, useState } from "react";
import AuthService from "../services/auth.service";

function Profile() {
  const [user, setUser] = useState(null);

  useEffect(() => {
    const currentUser = AuthService.getCurrentUser();
    setUser(currentUser);
  }, []);

  if (!user) {
    return <h3 style={{ textAlign: "center", marginTop: "100px" }}>Loading...</h3>;
  }

  return (
    <div style={styles.container}>
      <div style={styles.card}>
        <h2>My Profile</h2>

        <p><b>Username:</b> {user.username}</p>
        <p><b>Email:</b> {user.email}</p>

      </div>
    </div>
  );
}

const styles = {
  container: {
    display: "flex",
    justifyContent: "center",
    marginTop: "100px"
  },
  card: {
    padding: "20px",
    width: "300px",
    background: "#fff",
    borderRadius: "10px",
    boxShadow: "0 2px 8px rgba(0,0,0,0.1)"
  }
};

export default Profile;