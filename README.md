# Gestión de Activos Fijos!

Hola Dev. 
A continuación se exponen los pasos para montar y configurar el proyecto.

**Configuración de archivos ignorados**
El archivo `.gitignore` del proyecto no será utilizado para almacenar configuraciones de ambientes de cada desarrollador. Este archivo solo debe almacenar las configuraciones ignoradas pertenecientes al ámbito de la solución. Para ignorar las configuraciones del ambiente haremos lo siguiente:

 1. Crea un fichero llamado `.gitignore_global`en la carpeta raíz del usuario, Ejemplo: `C:\Users\Ale\.gitignore_global`
 2. Abrir en un editor de texto el fichero `.gitconfig` y agregar el nuevo fichero como fichero de exclusión de archivos. 

	> [core]
	longpaths = true
	excludesfile = C:/Users/Ale/.gitignore_global
3. Una vez configurado esto podemos incluir en este fichero las configuraciones generales correspondientes al ambiente de cada desarrollador. 
	