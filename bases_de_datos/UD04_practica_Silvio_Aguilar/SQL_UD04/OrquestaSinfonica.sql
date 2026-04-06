-- ============================================================
--  BASE DE DATOS: OrquestaSinfonica
--  Incluye: creación de tablas, datos de ejemplo y 5 consultas
-- ============================================================

-- Crear y seleccionar la base de datos
CREATE DATABASE IF NOT EXISTS OrquestaSinfonica;
USE OrquestaSinfonica;

-- ============================================================
--  CREACIÓN DE TABLAS
-- ============================================================

CREATE TABLE IF NOT EXISTS orquesta (
    PK_OrquestaId     INT          NOT NULL AUTO_INCREMENT,
    NombreOrquesta    VARCHAR(45)  NOT NULL,
    PRIMARY KEY (PK_OrquestaId)
);

CREATE TABLE IF NOT EXISTS musico (
    PK_MusicoId               INT         NOT NULL AUTO_INCREMENT,
    Nombre                    VARCHAR(45) NOT NULL,
    Apellido1                 VARCHAR(45) NOT NULL,
    Apellido2                 VARCHAR(45),
    FK_Orquesta_Id            INT,
    FK_MusicoRecomendadorId   INT,
    PRIMARY KEY (PK_MusicoId),
    CONSTRAINT fk_musico_orquesta
        FOREIGN KEY (FK_Orquesta_Id) REFERENCES orquesta(PK_OrquestaId)
);

CREATE TABLE IF NOT EXISTS instrumento (
    PK_InstrumentoId      INT         NOT NULL AUTO_INCREMENT,
    NombreInstrumento     VARCHAR(45) NOT NULL,
    PRIMARY KEY (PK_InstrumentoId)
);

CREATE TABLE IF NOT EXISTS musicosinstrumentos (
    PK_MusicosInstrumentosId  INT        NOT NULL AUTO_INCREMENT,
    FK_MusicoId               INT        NOT NULL,
    FK_InstrumentoId          INT        NOT NULL,
    AñoEntrada                SMALLINT,
    PRIMARY KEY (PK_MusicosInstrumentosId),
    CONSTRAINT fk_mi_musico
        FOREIGN KEY (FK_MusicoId)      REFERENCES musico(PK_MusicoId),
    CONSTRAINT fk_mi_instrumento
        FOREIGN KEY (FK_InstrumentoId) REFERENCES instrumento(PK_InstrumentoId)
);

-- ============================================================
--  DATOS DE EJEMPLO
-- ============================================================

-- Orquestas
INSERT INTO orquesta (NombreOrquesta) VALUES
    ('Orquesta Nacional de España'),
    ('Orquesta Sinfónica de Madrid'),
    ('Orquesta de Valencia');

-- Músicos
INSERT INTO musico (Nombre, Apellido1, Apellido2, FK_Orquesta_Id) VALUES
    ('Carlos',    'Fernández',  'López',    1),
    ('Lucía',     'Fuentes',    'García',   1),
    ('Miguel',    'Pérez',      'Martínez', 2),
    ('Ana',       'Flores',     'Ruiz',     2),
    ('Jorge',     'García',     'Sánchez',  3),
    ('Marta',     'Fonseca',    'Torres',   3),
    ('David',     'Romero',     'Díaz',     1),
    ('Elena',     'Fernández',  'Vega',     3),
    ('Pablo',     'Navarro',    'Gil',      2),
    ('Sofía',     'Ferrer',     'Blanco',   1);

-- Instrumentos
INSERT INTO instrumento (NombreInstrumento) VALUES
    ('Violín'),
    ('Viola'),
    ('Cello'),
    ('Flauta'),
    ('Oboe'),
    ('Trompeta'),
    ('Piano');

-- Músicos-Instrumentos
INSERT INTO musicosinstrumentos (FK_MusicoId, FK_InstrumentoId, AñoEntrada) VALUES
    (1,  1, 2010),
    (2,  4, 2015),
    (3,  2, 2012),
    (4,  3, 2018),
    (5,  6, 2011),
    (6,  1, 2019),
    (7,  7, 2008),
    (8,  5, 2016),
    (9,  3, 2013),
    (10, 2, 2020);

-- ============================================================
--  CONSULTAS
-- ============================================================

-- ------------------------------------------------------------
-- Consulta 1: Listado sencillo
-- Muestra todos los músicos con sus columnas Nombre y Apellido1
-- ------------------------------------------------------------
SELECT
    Nombre,
    Apellido1
FROM musico;


-- ------------------------------------------------------------
-- Consulta 2: Filtrado por patrón
-- Músicos cuyo Apellido1 empiece por la letra "F"
-- LIKE 'F%' → cualquier valor que comience por F
-- ------------------------------------------------------------
SELECT
    Nombre,
    Apellido1
FROM musico
WHERE Apellido1 LIKE 'F%';


-- ------------------------------------------------------------
-- Consulta 3: Ordenación descendente
-- Igual que la consulta 2, pero ordenado por Nombre DESC
-- ------------------------------------------------------------
SELECT
    Nombre,
    Apellido1
FROM musico
WHERE Apellido1 LIKE 'F%'
ORDER BY Nombre DESC;


-- ------------------------------------------------------------
-- Consulta 4: INNER JOIN
-- Muestra Nombre, Apellido1 y NombreOrquesta para todos los músicos
-- Se usa alias (m, o) para mayor legibilidad
-- Solo devuelve músicos que tengan orquesta asignada (FK no nula)
-- ------------------------------------------------------------
SELECT
    m.Nombre,
    m.Apellido1,
    o.NombreOrquesta
FROM musico m
INNER JOIN orquesta o ON m.FK_Orquesta_Id = o.PK_OrquestaId;


-- ------------------------------------------------------------
-- Consulta 5: UNION de dos filtros
-- Une músicos de la orquesta 1 y músicos de la orquesta 3
-- UNION elimina duplicados automáticamente
-- Ambas subconsultas devuelven exactamente las mismas columnas
-- para que la unión sea compatible
-- ------------------------------------------------------------
SELECT
    Nombre,
    Apellido1,
    Apellido2
FROM musico
WHERE FK_Orquesta_Id = 1

UNION

SELECT
    Nombre,
    Apellido1,
    Apellido2
FROM musico
WHERE FK_Orquesta_Id = 3;
