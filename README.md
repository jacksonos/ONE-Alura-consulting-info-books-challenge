# 📚 Proyecto de Consumo de API de Libros con Java - ONE | Alura 

Este proyecto es una aplicación Java desarrollada como parte de un desafío del programa ONE (Oracle Next Education) de Alura. El objetivo es consumir la API de Gutendex para obtener información sobre libros y mostrar estadísticas relevantes, aplicando los conocimientos adquiridos en el curso de Java.  

## 🚀 Funcionalidades  

- **🔍 Obtención de Datos de la API**  
  - Consume la API de Gutendex para obtener datos de libros.  
  - Implementa la lógica necesaria para transformar los datos de la API en objetos Java.  

- **📖 Visualización de Resultados**  
  - Muestra una lista limitada de libros (por ejemplo, los primeros 5) con detalles como título, autor, etc.  
  - Presenta un "Top 10" de los libros más descargados, utilizando la información de descargas proporcionada por la API.  

- **🔎 Búsqueda de Libros**  
  - Permite buscar libros por título (o parte del título) en español.  
  - Muestra los resultados de la búsqueda con detalles relevantes de cada libro encontrado.  

- **📊 Estadísticas**  
  - Calcula y muestra estadísticas sobre los libros obtenidos de la API:  
    - 📈 Media de descargas.  
    - 📉 Número máximo de descargas para un libro.  
    - 📊 Número mínimo de descargas para un libro.  
    - 📚 Número total de registros analizados para generar las estadísticas.  

## 🛠️ Tecnologías Utilizadas  

- ⚙️ **Java 17**   
- 🌱 **Spring Framework** (opcional, pero recomendado para facilitar la gestión de dependencias y la estructura del proyecto)  
- 🌐 **Librerías para consumir APIs:**  
  - `java.net.http.HttpClient` (y otras clases del paquete `java.net.http`)  
- ⏳ **Librerías para manipulación de fechas y formatos:**  
  - `java.time.LocalDate` (y otras clases del paquete `java.time`)  
- 📦 **Utilidades y estructuras de datos:**  
  - `java.util.*` (incluye `List`, `Map`, `Set`, `stream` y `Collectors`)  
- 🔗 **Librerías para manipulación de JSON** (como Jackson o Gson)  

## ▶️ Cómo Ejecutar  

1. 🛒 Clonar el repositorio.  
2. ⚙️ Configurar las dependencias del proyecto (si usa Maven o Gradle).  
3. ▶️ Ejecutar la clase principal que inicia la aplicación.  

## ✨ Posibles Mejoras  

- 📑 Implementar paginación para mostrar los resultados de la API de forma más eficiente.  
- 🔍 Permitir la búsqueda de libros por otros criterios (autor, año de publicación, idioma, etc.).  
- 📊 Añadir más estadísticas relevantes sobre los libros.  
- 🖥️ Implementar una interfaz gráfica de usuario (GUI) para facilitar la interacción con la aplicación.  
- 🔄 Permitir al usuario elegir la API a consumir.

## 📄 Licencia

Este proyecto es de uso libre y educativo como parte del challenge del programa ONE de Oracle + Alura.
