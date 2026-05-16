# Mi Primera App Android con Kotlin y Jetpack Compose

App Android desarrollada como parte del curso de Udemy:  
**"Crea tu primera app de Android desde cero: Kotlin y Compose"**

## Tecnologias usadas

- **Kotlin** — Lenguaje de programacion
- **Jetpack Compose** — UI declarativa moderna
- **Retrofit** — Consumo de API REST
- **Material 3** — Diseno visual

## Funcionalidades

- Lista de posts consumida desde la API publica [JSONPlaceholder](https://jsonplaceholder.typicode.com/posts)
- Indicador de carga (CircularProgressIndicator) mientras se obtienen los datos
- Tarjetas (Cards) con titulo y cuerpo de cada post
- Manejo de errores de red

## Estructura del proyecto

```
app/src/main/java/com/miapp/
├── MainActivity.kt       # Actividad principal
├── Post.kt               # Modelo de datos
├── ApiService.kt         # Interfaz Retrofit (endpoints)
├── RetrofitClient.kt     # Cliente HTTP singleton
├── PostsScreen.kt        # Pantalla principal con LazyColumn y loading
└── ui/theme/
    └── Theme.kt          # Tema Material 3
```

## Como correr el proyecto

1. Clonar el repositorio
2. Abrir en Android Studio (Arctic Fox o superior)
3. Sincronizar Gradle
4. Correr en emulador o dispositivo fisico con Android 8.0+ (API 26)

## Curso

[Ver curso en Udemy](https://www.udemy.com/course/crea-apps-android-studio-desde-cero-kotlin-compose-retrofit/)
