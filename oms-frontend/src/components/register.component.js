import React, { Component } from "react";
import AuthService from "../services/auth.service";
class Register extends Component {
  constructor(props) {
    super(props);
    this.state = {
      username: "",
      email: "",
      password: "",
      message: ""
    };
  }
  handleRegister = event => {
    event.preventDefault();
    AuthService.register(
      this.state.username,
      this.state.email,
      this.state.password
    ).then(()=>{this.setState({message: "User registered successfully"
        });
      },()=>{
        this.setState({
          message: "Could not register user"
        });
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
          <label className="auth-label">Email</label>
          <input
            className="auth-input"
            type="text"
            value={this.state.email}
            onChange={event => this.setState({ email: event.target.value })}/>
          <label className="auth-label">Password</label>
          <input
            className="auth-input"
            type="password"
            value={this.state.password}
            onChange={event => this.setState({ password: event.target.value })} />
          <button className="auth-button" onClick={this.handleRegister}>
            Sign Up
          </button>
          {this.state.message && (<p className="auth-message">{this.state.message}</p> )}
          <p className="auth-switch">
            Already have an account?
            <button
              type="button"
              className="auth-link"
              onClick={this.props.goToLogin} >Login
            </button>
          </p>
        </div>
      </div>
    );
  }}
export default Register;