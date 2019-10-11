#	Configuración inical de BD para almacenamiento de fotografia
#	AUTOR		  |	 FECHA  	| DETALLE 
#	IZETTER			10-10-19	  Se genera la configuración inicial para almacenamiento de fotografias
	
	DROP DATABASE fotografias;
    CREATE DATABASE fotografias;
    USE fotografias;
    CREATE TABLE  `tblFotografias` (
      `ID` INT NOT NULL auto_increment,
      `titulo` varchar(45) NOT NULL,
      `categoria` INT,
      `imagen` LONGBLOB NOT NULL,
      PRIMARY KEY  (`ID`)
    );
    
     CREATE TABLE  `tblCategorias` (
      `ID` INT NOT NULL auto_increment,
      `nombre` varchar(45) NOT NULL,
       PRIMARY KEY  (`ID`)
    );