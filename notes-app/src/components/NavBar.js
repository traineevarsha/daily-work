import { Link } from "react-router-dom";
function Navbar(){
  return(
    <div className="navbar">
      <h2 className="logo">Task Planner</h2>
      <div className="nav-links">
        <Link to="/add">
          <button>Add Task</button>
        </Link>
        <Link to="/list">
          <button>View Tasks</button>
        </Link>
      </div>
    </div>
  );
}
export default Navbar;