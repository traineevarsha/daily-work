import React, { Component } from "react";
import AuthService from "../services/auth.service";
class Login extends Component {
  constructor(props) {
    super(props);
    this.state ={
      username:"",
      password:"",
      message:""
    };
  }
  handleLogin = event => {
    event.preventDefault();
    AuthService.login(this.state.username, this.state.password).then(
      () => {this.props.onLogin();
      },() => {this.setState({message: "Invalid username or password"});
      });
  };
  render() {
    return (
      <div className="auth-page">
        <div className="auth-card">
          <div className="auth-avatar">O</div>
          <label className="auth-label">Username</label>
          <input
            className="auth-input"
            type="text"
            value={this.state.username}
            onChange={event => this.setState({ username: event.target.value })}/>
          <label className="auth-label">Password</label>
          <input
            className="auth-input"
            type="password"
            value={this.state.password}
            onChange={event => this.setState({ password: event.target.value })}/>
          <button className="auth-button" onClick={this.handleLogin}> Login </button>
          {this.state.message && (<p className="auth-message">{this.state.message}</p> )}
          <p className="auth-switch">
            Do not have an account?
            <button
              type="button"
              className="auth-link"
              onClick={this.props.goToRegister}>Sign Up</button>
          </p>
        </div>
      </div>
    );
  }}
export default Login;