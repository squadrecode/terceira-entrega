import React from "react";
import './style.css';
import LoginImg from '../../assets/images/login.svg';

function Login(){
    return(
        <div className="main-login">
            <div className="left-login">
                <h1>Cadastre-se <br/> E faça parte da Treete.</h1>
                <img className="left-image" src={LoginImg} alt=""/>
            </div>
            <div className="right-login">
                <div className="card-login">
                    <h1>Cadastrar</h1>
                    <div className="textfield">
                        <h3>Nome:</h3>
                        <input type="text" name="nome" placeholder="Nome" required />
                    </div>
                    <div className="textfield">
                        <h3>Email:</h3>
                        <input type="email" name="email" placeholder="Email" required />
                    </div>
                    <div className="textfield">
                        <h3>Nome:</h3>
                        <input type="password" name="senha" placeholder="Senha" required />
                    </div>
                    <button className="btn-login">Cadastrar</button>
                </div>
            </div>
        </div>
    )
}

export default Login;