import React from "react";
import Image from "../../assets/images/aboutus.png";
import './style.css';
import Card from "../../components/Card";
import Image2 from '../../assets/images/2.png';
import Image3 from '../../assets/images/3.png';
import Image4 from '../../assets/images/4.png';
import Image6 from '../../assets/images/6.png';

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
      <section className="prof">
                <Card
                image={Image4}
                name="Ana Julia"
                profissao="ux/ui designer"
                text="Você aprenderá como projetar interfaces."
                />
                <Card
                image={Image2}
                name="João Silva"
                profissao="banco de dados"
                text="Banco de dados é a organização e armazenagem de informações sobre um domínio específico. De forma mais simples, é o agrupamento de dados que tratam do mesmo assunto, e que precisam ser armazenados para segurança ou conferência futura. Venha conhecer na prática!"
                />
                <Card
                image={Image3}
                name="Clara Mendes"
                profissao="ciência da computação"
                text="Ciência da Computação é a área do conhecimento que atua no desenvolvimento de programas para diferentes dispositivos, a exemplo de celulares e computadores.
                Se você tem interesse em ciências exatas e programação, esse curso pode ser a sua opção."
                />
                <Card
                image={Image6}
                name="Alex Santos"
                profissao="engenharia da computação"
                text="O engenheiro da computação é aquele que projeta e cria hardwares e softwares, ou seja, os equipamentos digitais físicos (como computadores, smartphones, tablets, entre outros) e os sistemas e programas utilizados neles, respectivamente.
                Este profissional também pode atuar no gerenciamento da automação de máquinas, como máquinas industriais, o que também o coloca à frente na atuação em robótica."
                />
            </section>
    </div>
  );
}

export default Sobre;
