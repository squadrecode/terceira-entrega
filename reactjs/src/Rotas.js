import Home from './pages/Home';
import Cursos from './pages/Cursos';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import Footer from './components/Footer';
import Planos from './pages/Planos';
import Doacao from './pages/Doacao';
import Contato from './pages/Contato';
import Sobre from './pages/Sobre';

function Rotas(){
    return(
        <Router>
            <Navbar/>
            <Routes>
                <Route path='/' element={<Home/>}/>
                <Route path='/cursos' element={<Cursos/>}/>
                <Route path='/planos' element={<Planos/>}/>
                <Route path='/doacao' element={<Doacao/>}/>
                <Route path='/contato' element={<Contato/>}/>
                <Route path='/sobre' element={<Sobre/>}/>
            </Routes>
            <Footer/>
        </Router>
    )
}
export default Rotas;