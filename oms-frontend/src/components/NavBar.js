import React from "react";

function Navbar(props) {
    const { user } = props;

    return (
        <div className="navbar">
            <div className="navbar-left">
                <span className="navbar-logo">OMS</span>
            </div>

            <div className="navbar-right">
                <button className="navbar-btn" onClick={props.goToOrders}>Orders</button>
                <button className="navbar-btn" onClick={props.goToProfile}>Profile</button>
                <button className="navbar-btn" onClick={props.handleLogout}>Logout</button>
            </div>
        </div>
    );
}

export default Navbar;