# Parameta
Repositorio con dos servicios rest y soap 
El servicio rest recibe como parametro un objeto json como el siguiente ejemplo 
validados que no sean vacios y/o nulos y que las fechas tengan formato valido (yyyy/dd/MM).

{
    "nombres": "Jhonatan",
    "apellidos": "Realpe",
    "tipoDocumento": "Cedula",
    "numeroDocumento": "1023923232",
    "fechaNacimiento": "2000/07/01",
    "fechaVinculacion": "2021/08/01",
    "cargo": "No hace nada",
    "salario": 2000000
}

 y retorna un Json como el siguiente con información de tiempo de permanencia en la compañia y edad del empleado 
 
 {
    "data": {
        "tiempoVinculacion": "0 Años,  0 Meses y 0 Días",
        "edadActual": "21 Años,  0 Meses y 2 Días"
    }
}

Servicio SOAP se encarga de registar el objeto que resive el servicio rest y retorna un boolean true si a sido registrado 
