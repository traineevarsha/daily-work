import React, { Component } from "react";
import AuthService from "./services/auth.service";
import "./App.css";
import Login from "./components/login.component";
import Register from "./components/register.component";
import Profile from "./components/profile.component";
import OrderForm from "./components/OrderForm";
import Navbar from "./components/NavBar";
class App extends Component {
  state ={
    user:AuthService.getCurrentUser(),
    page:"login"
  };
  handleLogin =()=> {this.setState({
      user: AuthService.getCurrentUser(),
      page: "orders"
    });
  };
  handleLogout=() =>{
    AuthService.logout();
    this.setState({
      user: null,
      page: "login"
    });
  };
  render() {
    if (!this.state.user && this.state.page==="register") {
      return (
        <Register goToLogin={()=>this.setState({page:"login"})} />
      );
    }
    if (!this.state.user) {
      return (
        <Login
          onLogin={this.handleLogin}
          goToRegister={() => this.setState({ page: "register" })}/>
      );
    }
    return(
      <div>
        <Navbar
          user={this.state.user}
          goToOrders={() =>this.setState({ page:"orders" })}
          goToProfile={()=> this.setState({ page: "profile" })}
          handleLogout={this.handleLogout} />
        {this.state.page=== "profile" ? <Profile /> : <OrderForm />}
      </div>
    );
  }}
export default App;