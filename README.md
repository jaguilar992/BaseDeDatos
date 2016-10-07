# Proyecto: Base de datos

## BackEnd

### Definiciones en Proyecto

```java
	package basededatos;
	import clases.*;
	
	Contenedor personas;
	Contenedor instituciones;
	Contenedor ciudades;
	Contenedor paises;
	Contenedor relacionesP_I;
	Contenedor relacionesP_C;
	Contenedor relacionesI_C;
	Contenedor relacionesC_P;	
```

|#|Contenedor Relación:|id1|id2|Contenedor1|Contenedor2|
|---|---|---|---|---|---|
|1|relacionesP_I|Persona|Institucion|personas|instituciones|
|2|relacionesP_C|Persona|Ciudad|personas|ciudades|
|3|relacionesI_C|Institucion|Ciudad|instituciones|ciudades|
|4|realcionesC_P|Ciudad|Pais|ciudades|paises|


### Lectura de Objetos (Agregar a contenedor)
Ejemplos:
```java
package basededatos;
import clases.*;
import utiles.Leer;
Leer.leer_pais(paises);		//Devuelve objeto Pais

paises.agregarObjeto(nuevoObjeto); // Se agrega a contenedor

/**Funciona para personas, instituciones, ciudades, paises.**/

```
>Se envían los contenedores con el objetivo de verificar si no existe redundancia de ID
al leer los datos del objeto.

### Lectura de Objetos (Modificar en contenedor)
Ejemplos:
```java
package basededatos;
import clases.*;
import utiles.Leer;

// Obtiene el ID de la persona que se va a modificar, i es la cubeta de posición en contenedor
// Se hace mientras leerObjeto no devuelva null
int ID = ((Persona)personas.leerObjeto(i)).get_id(); 

//Devuelve objeto Persona, con nuevos datos, ID no cambia
Leer.leer_persona(personas,false,ID); 	

// Modificar el objeto en contenedor
personas.modificarObjeto(i,nuevoObjeto);

/**Funciona para personas, instituciones, ciudades, paises.**/

```
>Se envían los contenedores con el objetivo de verificar si no existe redundancia de ID
al leer los datos del objeto.

### Eliminar un objeto de contenedor
Ejemplos:
```java
	// [i,j,k] es la cubeta de posición en contenedor
	personas.eliminarObjeto(i);
	relacionesI_C.eliminarObjeto(j);
	paises.eliminarObjeto(k);
```

### Lectura de Relaciones
Ejemplos:
```java
package basededatos;
import clases.*;
import utiles.LeerRel;

// Devuelve una Relacion entre persona e institución
LeerRel.leer_relacion(personas, instituciones,1);

// Devuelve una Relacion entre persona y ciudad
LeerRel.leer_relacion(personas, ciudades,2);

// Devuelve una Relacion entre institución y ciudad
LeerRel.leer_relacion(instituciones, ciudades,3);

// Devuelve una Relacion entre ciudad y país // Se añade al contenedor
LeerRel.leer_relacion(ciudades, paises,4);
relacionesC_P.agregarObjeto(nuevoObjeto);

// Los enteros pasados por parametros indicaran los titulos de ayuda al usuario
// Según sea la relacion entre objetos a establecer (Ver Tabla)
```
>Se envían los contenedores con el objetivo de verificar si existen los ID's que el usuario ingresa

### Otros métodos de la clase Contenedor
```java
// Devuelve true solo si todos los objetos en el son null
personas.esVacio(); 

//Devuelve el tamaño (int) de array interno
personas.getLength();

//Imprime todos los objetos del contenedor que no son null
relacionesC_P.listarObjetos();

// UTIL: Cuando se necesita eliminar objetos, al añadir el parámetro true, se imprime el número de cubeta
relacionesC_P.listarObjetos(true);

```

### Métodos de la clase General
De esta clase Heredan las clases:
* Persona
* Institucion
* Ciudad
* Pais

>Propiedades comunes a las clases: id (int) , nombre (String)

#### Métodos usados con relaciones:
##### ```General.estaEnRelaciones(Contenedor c, idABuscar int)```
Este método se usa para comprobar la existencia del objeto (this) en alguna relación con otro(s), se utiliza al momento de eliminar un objeto.
Esto con el objetivo de cuidar la integridad de los datos.
>El idABuscar corresponde al id propio del objeto ubicado en el tipo de relación que almacena el Contenedor c. (Ver Tabla)

Ejemplos:
```java
//El método devuelve true si encuentra en el contenedor al menos un objeto con las propiedades (this).

// Para personas en contenedor relacionesP_I se usa el id1 
persona.estaEnRelaciones(relacionesP_I,1) 

// Para ciudades en contenedor relacionesI_C se usa el id2 
ciudad.estaEnRelaciones(relacionesI_C,2)

```

##### ```General.borrarOcurenciasEnRelaciones(Contenedor c, idABuscar int)```
Su funcionamiento es igual al anterior, solo que en vez de comprobar la existencia de la relación.
Elimina todas y cada una de las ocurrencias de relación donde aparecen las propiedades del objeto (this).

>El idABuscar corresponde al id propio del objeto ubicado en el tipo de relación que almacena el Contenedor c. (Ver Tabla)

Ejemplos:
```java
//El método elimina todas las relaciones donde esta objeto con las propiedades (this).

// Para personas en contenedor relacionesP_I se usa el id1 
persona.borrarOcurenciasEnRelaciones(relacionesP_I,1) 

// Para ciudades en contenedor relacionesI_C se usa el id2 
ciudad.borrarOcurenciasEnRelaciones(relacionesI_C,2)

```
Para resumir, la siguiente imagen muestra las comprobaciones que se deberían hacer al eliminar un objeto con sus relaciones.
![Resumen][logo]

[logo]: https://ajedrez92.files.wordpress.com/2016/10/diagram.png

#### Métodos de existencia (Usado en Leer.leer):
##### ```  General.existeEn(Contenedor c)```
Este método comprueba si existe el objeto con las mismas propiedades en el Contenedor c, devuelve **true** si lo encuentra.

Ejemplos:
```java
persona.existe(personas)
ciudad.existe(ciudades)

```

## FrontEnd:

### Uso de Menús:
```java
	package basededatos;
	import utiles.Menu;

	// Todos estos metodos retornan un entero...
	Menu.menu("Principal");
	
	Menu.menu("Personas");
	Menu.menu("Instituciones");
	Menu.menu("Ciudades");
	Menu.menu("Paises");

	Menu.menu("Relaciones");
	
	Menu.menu("Personas-Instituciones");
	Menu.menu("Personas-Ciudades");
	Menu.menu("Instituciones-Ciudades");
	Menu.menu("Ciudades-Paises");


	// Cada uno de estos menús lee un fichero donde se guardan las opciones e imprime cada linea
	// Para luego leer un entero con la opcion del usuario.


````

### Impresion de Relaciones
>Existen 2 formas de imprimir las relaciones en un contenedor.

**1. De forma desordenada:**
#### ```Relacion.listarAllRelaciones```
>Tal como se han agregado, indicando el número de cubeta en el que están.
Este método se usará cuando se le consulte al usuario por la relacion que desea eliminar
```java
package basededatos;
Relacion.listarAllRelaciones(relacionesP_I, personas, instituciones);
```
Un ejemplo de la salida:
```text
--------------------------------------------------
Relaciones en Contenedor
--------------------------------------------------
0::  2 - Daniel Figueroa - Guatemala  -->  1 - Youtube
1::  3 - Miguel Solorzano - Haiti  -->  1 - Youtube
2::  3 - Miguel Solorzano - Haiti  -->  2 - Google
```

**2. Agrupada según el contenedor2 en cada relación (Ver tabla):**
#### ```Relacion.listarGroupRelaciones```
> Es decir, si se envía a imprimir ```relacionesP_I``` (Personas, e instituciones)
Se agruparían por Institución.

```java
package basededatos;
Relacion.listarGroupRelaciones(relacionesP_I, personas, instituciones);
```
Un ejemplo de la salida:
```text
--------------------------------------------------
Youtube
--------------------------------------------------
2 - Daniel Figueroa - Guatemala
3 - Miguel Solorzano - Haiti
--------------------------------------------------
--------------------------------------------------
Google
--------------------------------------------------
3 - Miguel Solorzano - Haiti
--------------------------------------------------
```
> Nótese que los contenedores contienen las mismas relaciones entre objetos. Lo único que cambia es la forma de imprimirlos.

>Ambos métodos son **static**, métodos de clase (Relacion) y no de instancia.
#####