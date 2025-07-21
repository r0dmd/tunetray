# 🎵 TuneTray - App de Listas de Reproducción

TuneTray es una aplicación **full-stack** para gestionar canciones y listas de reproducción de manera sencilla y rápida.

---

## 🚀 Tecnologías Utilizadas

| Capa          | Tecnología                                           |
| ------------- | ---------------------------------------------------- |
| Backend       | Java 21, Spring Boot 3, Spring Data JPA, H2 Database |
| Frontend      | Angular 17, TypeScript                               |
| Base de Datos | H2 (en memoria, para demo)                           |

⚠️ **Importante:** Este es un proyecto para demostrar habilidades clave en **Spring Boot (Java)** y **Angular**, aplicando una arquitectura REST limpia y una interfaz sencilla.

- No incluye autenticación

- La API no está preparada para producción

- La base de datos H2 se despliega en memoria; no guarda datos al reiniciar

---

## 📂 Estructura del Proyecto

```
/backend   # API Spring Boot (Java)
/frontend  # Cliente Angular (TypeScript)
```

---

## 🛠️ Cómo Ejecutar el Proyecto

### 📥 Backend (Spring Boot)

1. Ir a la carpeta `/backend`

2. Ejecutar:
   
   ```bash
   ./mvnw spring-boot:run
   ```

3. API disponible en: `http://localhost:8080`

---

### 🎨 Frontend (Angular)

1. Ir a la carpeta `/frontend`

2. Ejecutar:
   
   ```bash
   pnpm install
   pnpm start
   ```
   
   ⚠️ Este proyecto utiliza **pnpm** para la gestión de dependencias. Asegúrate de tenerlo instalado con `npm install -g pnpm`.

3. Aplicación disponible en: `http://localhost:4200`

---