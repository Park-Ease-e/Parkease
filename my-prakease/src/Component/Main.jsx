import Nav from "./Navbar";
import SearchBox from "./SearchBox";
import img from "./img/BackGround.gif";
import './Css/Main.css';

function Main() {
  return (
    <div className="bg-white dark:bg-gray-800 vh-100 d-flex flex-column">
      <Nav />
      <div className="d-flex justify-content-center align-items-center">
        <img src={img} className="img-fluid main-img" alt="background" />
      </div>

      <div className="d-flex justify-content-center align-items-center flex-grow-1">
        <SearchBox />
      </div>
    </div>
  );
}

export default Main;
