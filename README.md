# Programación Orientada a Servicios: Proyecto Final

<!-- TOP PAGE-->
<a name="readme-top"></a>

## ⚠️ Advertencia 
El proyecto en **GitHub** se encuentra con la siguiente estructura:
* El archivo ***recomendacion.sql*** es la base de datos relacional en el manejador *MySQL*. 
* La carpeta ***POS_LlenadoBD*** es el llenado de las preferencias en la base de datos. 
* La carpeta ***POS_ProyectoFinal*** contiene la aplicación web. 
* La carpeta ***doc_img*** contiene todas la imagenes de la documentación.

***

## ✋ Acerca del proyecto
En esta sección se hablará acerca del proyecto en general, cual es su funcionamiento y que tecnologias contiene en general.

El proyecto es una aplicación web, la cual emula un foro de internet enfocado en las películas, dicha aplicación cuenta con una **barra de navegación** que siempre está visible a pesar del contenido de la página. Esta barra nos desplaza a las diferentes páginas por las cuales se puede interactuar; las páginas son: *Inicio*, *Buscador*, *Login* y *Registro* 

Dentro de la aplicación un usuario puede registrarse al foro al ingresar una información en **Registrar**; donde dicha información es ingresada en una base de datos relacional (MySQL). Al momento de darse de alta el usuario puede iniciar sesión con el nombre de usuario y contraseña de ingresó con anterioridad en **Login**; en dicho ingreso existe un filtro de autenticación para el filtrado de usuarios, en caso de ingresar un usuario erroneo el filtro rechaza su ingreso. 

Al momento de ingresar a un cuenta de usuario, se muestran todos los datos del usuario que registró; en la barra de navegación se muestra un nuevo apartado **Preferencias**, donde el usuario puede registrar las preferencias que se encuentran en la base de datos antes mencionada. Al momento de registrar sus preferencias se listaran algunas recomendaciones que la API de ***OMDBApi*** pueden hacer dependiendo de las películas, generos, directores y actores favoritos del usuario. Dichas recomendaciones se muestran gracias a unos métodos que filtran los datos que se consultan directamente desde la API de ***OMDBApi***.

Como último punto, se menciona el uso de un buscador al entrar al apartado **Buscador** en la barra de navegación. Esta busqueda de películas se realiza mediante una palabra referida, en donde el usuario puede ingresar una palabra y se listaran películas que contiene dicha palabra. La busqueda realiza consultando la API de ***OMDBApi***.

## 💻 Construido con...
En esta sección se listan todas las tecnologias usadas para la elaboración del proyecto, así como los lenguajes de programación, servidores y frameworks/librería.

* ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
* ![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)
* ![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)
* ![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)
* ![Apache Tomcat](https://img.shields.io/badge/apache%20tomcat-%23F8DC75.svg?style=for-the-badge&logo=apache-tomcat&logoColor=black)
* Java Servlets
* Java Server Pages (JSP)
* Librería JAX-RS 2.1.6
* Librería Jersey 2.34 (JAX-RS RI)
* json-simple-1.1.jar
* json-20220924.jar
* mysql-connector-j-8.0.31.jar


## 🏢 Entorno de Desarrollo (IDE)
En esta sección se muestra el entorno de desarrollo en el cual se desarrolló el proyecto:
* ![NetBeans IDE](https://img.shields.io/badge/NetBeansIDE-1B6AC6.svg?style=for-the-badge&logo=apache-netbeans-ide&logoColor=white)


## 🔎 Pruebas
En esa sección se listan los navegadores con los cuales se realizaron las pruebas pertinentes para verificar el buen funcionamiento del proyecto:
* ![Brave](https://img.shields.io/badge/Brave-FB542B?style=for-the-badge&logo=Brave&logoColor=white)
* ![Google Chrome](https://img.shields.io/badge/Google%20Chrome-4285F4?style=for-the-badge&logo=GoogleChrome&logoColor=white)


## 📷 Capturas
En esta sección se mostraran todas las capturas del proyecto acompañados de una breve explicación:

En la siguiente figura se muestra el diagrama UML de la base de datos relacional utilizada en el proyecto.

![PF_modelo.png](/doc_img/PF_modelo.png)
<div>
<p style='text-align:center; '>Figura 0. Diagrama UML de la base de datos relacional.</p>
</div>

***

En la página de inicio solo se muestra un breve descripción del proyecto y un contenedor para visualizar mejor.

![01_index.png](/doc_img/01_index.png)
<div>
<p style='text-align:center; '>Figura 1. Inicio.</p>
</div>
<br />
<br />

En la página de busqueda se observa un campo de texto para ingresar la busqueda.

![02](/doc_img/02_buscador.png)
<div>
<p style='text-align:center; '>Figura 2. Buscador pt.1.</p>
</div>
<br />
<br />

Al momento de ingresar un valor, nos visualiza una lista de películas donde posiblemente se encuentre nuestro resultado. Para visualizar de mejor manera se integra un selector para obtener más información de la película a buscar.

![03](/doc_img/03_buscador.png)
<div>
<p style='text-align:center; '>Figura 3. Buscador pt.2.</p>
</div>
<br />
<br />

Al dar clic en **Seleccionar**, se muestra la información completa de la película seleccionada. 

![04](/doc_img/04_buscador.png)
<div>
<p style='text-align:center; '>Figura 4. Buscador pt.3.</p>
</div>
<br />
<br />

En la página de registro, el usuario puede darse de alta en el foro, registrando su información en la base de datos relacional (MySQL), para así contar con acceso a las demás páginas del foro.

![05](/doc_img/05_registro.png)
<div>
<p style='text-align:center; '>Figura 5. Registro.</p>
</div>
<br />
<br />

Al darse de alta, se observa que el usuario se encuentra en la lista de la base de datos, esta lista se visualiza en formato de arreglo de JSON's.

![06](/doc_img/06_registro.png)
<div>
<p style='text-align:center; '>Figura 6. JSON de usuarios. </p>
</div>
<br />
<br />

En la página de login, el usuario puede ingresar a su cuenta gracias aun filtrado de autenticación.

![07](/doc_img/07_login.png)
<div>
<p style='text-align:center; '>Figura 7. Login.</p>
</div>
<br />
<br />

En la página del perfil del usuario se visualiza toda la información del usuario, por ejemplo: **nombre de usuario**, **nombre completo**, **edad**, **genero** y **correo electronico**.

![08](/doc_img/08_perfil.png)
<div>
<p style='text-align:center; '>Figura 8. Perfil de usuario.</p>
</div>
<br />
<br />

Gracias al filtrado de autenticación el usuario puede tener seguridad de su cuenta, en caso de que alguien ingrese un dato erroneo se envía a una página de error.

![09](/doc_img/09_errorLogin.png)
<div>
<p style='text-align:center; '>Figura 9. Error de autorización.</p>
</div>
<br />
<br />

En la página de preferencias el usuario puede registrar sus preferencias mediante su **id de usuario** y el **id de la prefenrencia** en sí.

![10](/doc_img/10_preferencias.png)
<div>
<p style='text-align:center; '>Figura 10. Preferencias.</p>
</div>
<br />
<br />

En la página de recomendaciones se listaran todas las recomendaciones que la API de ***OMDBApi*** recomienda dependiendo de las preferencias que el usuario tiene en la base de datos.

![11](/doc_img/11_recomendaciones.png)
<div>
<p style='text-align:center; '>Figura 11. Recomendaciones.</p>
</div>
<br />
<br />

A continuación, se muestra la estructura del proyecto dentro del entorno de desarrollo (IDE) *NetBeans 15*. Se observan que contiene lo siguiente: 
* Las **páginas estáticas** (*html* y *jsp*) 
* Los **estilos** (*css*) en la carpeta *styles* 
* Los **modelos** (*Actor.java*, *Director.java*, *Genero.java*, *Pelicula.java* & *Usuario.java*) 
* La **lógica de la base de datos** (*UtilBD.java*) 
* La **lógica de la API de OMDBApi** (*ClienteOMDBApi.java*)
* Los **Servlets** para la busqueda de películas y para el perfil del usuario (*ServletBusqueda.java*, *ServletInfo.java* & *ServletUsuario.java*) 
* El **RESTFul Web Service for Paterns** para el registro del usuario (*UsuarioResource.java* & *ApplicationConfig.java*)

![12](/doc_img/12_estructura.png)
<div>
<p style='text-align:center; '>Figura 12. Estructura del proyecto.</p>
</div>
<br />
<br />

En la siguiente figura se listan todas las librerías que se utilizaron en el proyecto:
* JAX-RS 2.1.6
* Jersey 2.34 (JAX-RS RI)
* json-simple-1.1.jar
* json-20220924.jar
* mysql-connector-j-8.0.31.jar

![13](/doc_img/13_librerias.png)
<div>
<p style='text-align:center; '>Figura 13. Librerías & JAR.</p>
</div>
<br />

## 📧 Contacto
* `al2162003789@azc.uam.mx`
* `al2163074102@azc.uam.mx`

<p align="right">(<a href="#readme-top">back to top</a>)</p>