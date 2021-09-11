import { Link } from "react-router-dom";
import NavBar from "../../components/NavBar";
import Footer from "../../components/Footer";


const Home =()=> {
    return (
        <>
        <NavBar/>
        <div className="container">
        <div className="jumbotron">
            <h1 className="display-4">Vendas</h1>
            <p className="lead">Analise o desempenho das suas vendas por diferentes perspectivas</p>
            <hr/>
            <p>Esta aplicação consiste em exibir um dashboard a partir de dados fornecidos por um back end construído com Spring Boot.</p>
          
            <Link className="btn btn-outline-warning" to="/dashboard"> Acesse o Dashboard</Link>
        </div>
    </div>
    <Footer/>
    </>
    );
}

export default Home;