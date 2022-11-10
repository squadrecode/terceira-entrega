import React from "react";
import Image from "../../assets/images/aboutus.png";
import "./style.css";
import { Link, NavLink } from "react-router-dom";
import Card from "../../components/Card";
import Image2 from "../../assets/images/2.png";
import Image3 from "../../assets/images/3.png";
import Image4 from "../../assets/images/4.png";
import Image6 from "../../assets/images/6.png";
import CardDev from "../../components/CardPartner";
import Roberta from "../../assets/images/roberta.jpeg";
function Sobre() {
  return (
    <div>
      <section className="home" id="home">
        <div className="image">
          <img src={Image} alt="" />
        </div>
        <div className="content">
          <h2>Quem somos</h2>
          <p>
            A Treete nasceu no intuito de cativar a solidariedade que existe em
            cada um. Num cenário em que a falta de equipamentos como
            computadores, smartphones e tablets foi um dos maiores obstáculos
            enfrentados para garantir atividades escolares remotas durante a
            pandemia, A treete surge para unificar educação e solidariedade!
          </p>
          <p>
            Além do acesso ao conteúdo didático exclusivo através de planos
            acessíveis, no feed da Treete cada conteúdo lido arrecada nossa
            moeda oficial, as Treets, que podem ser destinadas as causas que a
            Treete apoia. Simples assim! Você recebe recompensas por navegar no
            feed e ainda colabora com a nossa rede de apoio a estudantes em
            vulnerabilidade social.
          </p>
        </div>
      </section>
      <h1 class="heading">Nossos Desenvolvedores</h1>
      <section className="box-dev">
        <div className="dev-card">
          <img className="mx-auto d-block" src="" alt="" />
          <div className="description">
            <h3>Andressa Fernandes</h3>
            <p>full stack jr</p>
            <div className="share">
              <a href="https://github.com/andressafe" target="_blank" className="fab fa-brands fa-github"></a>
              <a href="/" className="fab fa-instagram"></a>
              <a href="/" className="fab fa-linkedin"></a>
            </div>
          </div>
        </div>
        <div className="dev-card">
          <img className="mx-auto d-block" src="" alt="" />
          <div className="description">
            <h3>Jefferson</h3>
            <p>full stack jr</p>
            <div className="share">
              <a href="https://github.com/jeffersonaa" target="_blank" className="fab fa-brands fa-github"></a>
              <a href="/" className="fab fa-instagram"></a>
              <a href="/" className="fab fa-linkedin"></a>
            </div>
          </div>
        </div>
        <div className="dev-card">
          <img className="mx-auto d-block" src="" alt="" />
          <div className="description">
            <h3>Henrique Janser</h3>
            <p>full stack jr</p>
            <div className="share">
              <a href="https://github.com/HenriqueJanser" className="fab fa-brands fa-github"></a>
              <a href="/" className="fab fa-instagram"></a>
              <a href="/" className="fab fa-linkedin"></a>
            </div>
          </div>
        </div>
        <div className="dev-card">
          <img className="mx-auto d-block" src={Roberta} alt="" />
          <div className="description">
            <h3>Roberta Teles</h3>
            <p>back-end</p>
            <div className="share">
              <a href="https://github.com/robertateles" target="_blank" className="fab fa-brands fa-github"></a>
              <a href="/" className="fab fa-instagram"></a>
              <a href="https://www.linkedin.com/in/roberta-teles/" target="_blank" className="fab fa-linkedin"></a>
            </div>
          </div>
        </div>
        <div className="dev-card">
          <img className="mx-auto d-block" src="" alt="" />
          <div className="description">
            <h3>Tamyres Pereira</h3>
            <p>back-end</p>
            <div className="share">
              <a href="https://github.com/tamyrespereirasilva" target="_blank" className="fab fa-brands fa-github"></a>
              <a href="" className="fab fa-instagram"></a>
              <a href="https://www.linkedin.com/in/tamyrespereirasilva" target="_blank" className="fab fa-linkedin"></a>
            </div>
          </div>
        </div>
      </section>
    </div>
  );
}

export default Sobre;
