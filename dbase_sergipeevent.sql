-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 27-Mar-2019 às 00:50
-- Versão do servidor: 10.1.34-MariaDB
-- PHP Version: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbase_sergipeevent`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `categoria`
--

CREATE TABLE `categoria` (
  `id_categoria` bigint(20) NOT NULL,
  `descricao` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `categoria`
--

INSERT INTO `categoria` (`id_categoria`, `descricao`) VALUES
(1, 'Tecnologia da Informação'),
(2, 'Extensão');

-- --------------------------------------------------------

--
-- Estrutura da tabela `eventos`
--

CREATE TABLE `eventos` (
  `id_evento` bigint(10) NOT NULL,
  `descricao` varchar(100) NOT NULL,
  `maximo` int(10) NOT NULL,
  `minimo` int(10) NOT NULL,
  `qtd_salas` int(10) NOT NULL,
  `classificao` varchar(15) NOT NULL,
  `abertura` date NOT NULL,
  `encerramento` date NOT NULL,
  `id_categoria` bigint(11) NOT NULL,
  `id_publico` bigint(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `eventos`
--

INSERT INTO `eventos` (`id_evento`, `descricao`, `maximo`, `minimo`, `qtd_salas`, `classificao`, `abertura`, `encerramento`, `id_categoria`, `id_publico`) VALUES
(2, 'Seminfo', 10, 1000, 23, 'Livre', '2019-03-26', '2019-03-30', 1, 1),
(3, 'Semex', 10, 200, 25, '18', '2019-03-28', '2019-03-30', 2, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `programacoes`
--

CREATE TABLE `programacoes` (
  `id_prog` bigint(10) NOT NULL,
  `tipo` varchar(25) NOT NULL,
  `descricao` text NOT NULL,
  `data_prog` datetime NOT NULL,
  `horario` datetime NOT NULL,
  `responsavel` varchar(50) NOT NULL,
  `tipo_local` varchar(50) NOT NULL,
  `local_evento` varchar(50) NOT NULL,
  `id_evento` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `programacoes`
--

INSERT INTO `programacoes` (`id_prog`, `tipo`, `descricao`, `data_prog`, `horario`, `responsavel`, `tipo_local`, `local_evento`, `id_evento`) VALUES
(1, 'Palestra', 'sobre APIs', '2019-03-26 20:00:00', '2020-00-00 00:00:00', 'Fabio', 'Auditório', 'auditorio', 2),
(2, 'Workshop', 'Trabalho', '2019-03-13 13:00:00', '2013-00-00 00:00:00', 'Ageu Paulo Santana', 'Quadra Esportiva', 'Quadra da Unit', 2),
(3, 'Workshop', 'laborayorio de engenharia', '2019-03-26 00:00:00', '0000-00-00 00:00:00', 'Maira', 'Sala de Aula', 'bloco a 25', 2),
(4, 'Workshop', 'Exemplo 2', '2019-03-28 14:19:57', '2019-03-28 14:19:57', 'Rafael', 'Sala de Aula', 'sala do bloco B 24', 3),
(5, 'Minicurso', 'Exemplo 3', '2019-03-29 14:20:39', '2019-03-29 14:20:39', 'Igot', 'Laboratório de Informática', 'sala do bloco B 24', 2),
(6, 'Curso', 'Exemplo 6', '2019-03-30 18:00:00', '2019-03-30 18:00:00', 'Nilton', 'Sala de Aula', '25 bloco A', 3),
(7, 'Workshop', 'Exemplo 7', '2019-03-26 14:34:55', '2019-03-26 14:34:55', 'Freitas', 'Quadra Esportiva', 'unit', 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `publicos`
--

CREATE TABLE `publicos` (
  `id_publico` bigint(20) NOT NULL,
  `descricao` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `publicos`
--

INSERT INTO `publicos` (`id_publico`, `descricao`) VALUES
(1, 'Universitários');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE `usuarios` (
  `id` bigint(15) NOT NULL,
  `login` varchar(15) NOT NULL,
  `senha` varchar(25) NOT NULL,
  `cargo` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `usuarios`
--

INSERT INTO `usuarios` (`id`, `login`, `senha`, `cargo`) VALUES
(1, 'admin', 'admin', 'admin'),
(2, 'AgeuPaulo', '1234', 'funcionario'),
(3, 'FabioGomes', '123456', 'funcionario');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Indexes for table `eventos`
--
ALTER TABLE `eventos`
  ADD PRIMARY KEY (`id_evento`),
  ADD KEY `id_categoria` (`id_categoria`),
  ADD KEY `id_publico` (`id_publico`);

--
-- Indexes for table `programacoes`
--
ALTER TABLE `programacoes`
  ADD PRIMARY KEY (`id_prog`),
  ADD KEY `id_evento` (`id_evento`);

--
-- Indexes for table `publicos`
--
ALTER TABLE `publicos`
  ADD PRIMARY KEY (`id_publico`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id_categoria` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `eventos`
--
ALTER TABLE `eventos`
  MODIFY `id_evento` bigint(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `programacoes`
--
ALTER TABLE `programacoes`
  MODIFY `id_prog` bigint(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `publicos`
--
ALTER TABLE `publicos`
  MODIFY `id_publico` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` bigint(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `eventos`
--
ALTER TABLE `eventos`
  ADD CONSTRAINT `eventos_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`),
  ADD CONSTRAINT `eventos_ibfk_2` FOREIGN KEY (`id_publico`) REFERENCES `publicos` (`id_publico`);

--
-- Limitadores para a tabela `programacoes`
--
ALTER TABLE `programacoes`
  ADD CONSTRAINT `programacoes_ibfk_1` FOREIGN KEY (`id_evento`) REFERENCES `eventos` (`id_evento`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
