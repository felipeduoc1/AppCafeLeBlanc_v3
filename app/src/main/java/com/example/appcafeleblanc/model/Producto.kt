package com.example.appcafeleblanc.model

// 1. DATA CLASS (El modelo de un solo producto)
data class Producto(
    val id: Int,
    val nombre: String,
    val precio: Int,
    val categoria: String,
    val descripcion: String,
    val imagen: String
)

// 2. LISTA DE PRODUCTOS (Declaración de nivel superior en el mismo archivo)
val listaProductos: List<Producto> = listOf(
    // --- Comidas ---
    Producto(
        id = 2,
        nombre = "Curry LeBlanc Original",
        precio = 8500,
        categoria = "Comidas",
        descripcion = "El famoso curry casero con la receta secreta, servido con arroz japonés.",
        imagen = "/imagenes/imagen2.png"
    ),
    Producto(
        id = 4,
        nombre = "Katsu Sando",
        precio = 6900,
        categoria = "Comidas",
        descripcion = "Sándwich japonés con chuleta de cerdo empanizada, col rallada y salsa tonkatsu.",
        imagen = "/imagenes/imagen4.png"
    ),
    Producto(
        id = 5,
        nombre = "Desayuno Japonés",
        precio = 7900,
        categoria = "Comidas",
        descripcion = "Set de desayuno tradicional con arroz, huevo, nori y sopa miso.",
        imagen = "/imagenes/imagen5.png"
    ),
    Producto(
        id = 9,
        nombre = "Onigiri Set (2 unidades)",
        precio = 4500,
        categoria = "Comidas",
        descripcion = "Bolas de arroz japonés rellenas de atún con mayonesa y umeboshi (ciruela encurtida), envueltas en nori.",
        imagen = "/imagenes/imagen9.png"
    ),
    Producto(
        id = 12,
        nombre = "Takoyaki (6 unidades)",
        precio = 6500,
        categoria = "Comidas",
        descripcion = "Populares bolitas de masa de harina de trigo rellenas de pulpo, cubiertas con salsa takoyaki y katsuobushi.",
        imagen = "/imagenes/imagen12.png"
    ),
    Producto(
        id = 15,
        nombre = "Yakisoba Clásico",
        precio = 8900,
        categoria = "Comidas",
        descripcion = "Fideos salteados al estilo japonés con carne de cerdo/pollo y verduras en salsa dulce y salada.",
        imagen = "/imagenes/imagen15.png"
    ),
    Producto(
        id = 18,
        nombre = "Karaage de Pollo (6 unid.)",
        precio = 7200,
        categoria = "Comidas",
        descripcion = "Trozos de pollo marinados al estilo japonés y fritos hasta quedar crujientes. Servidos con mayonesa cítrica.",
        imagen = "/imagenes/imagen18.png"
    ),

    // --- Bebidas ---
    Producto(
        id = 1,
        nombre = "Café LeBlanc Original",
        precio = 3200,
        categoria = "Bebidas",
        descripcion = "El blend especial de la casa, preparado con granos de café de tueste medio.",
        imagen = "/imagenes/imagen1.png"
    ),
    Producto(
        id = 6,
        nombre = "\"Joker's Wild\" Cocktail",
        precio = 4500,
        categoria = "Bebidas",
        descripcion = "Cóctel sin alcohol con jugo de granada, ginger ale y un toque de lima.",
        imagen = "/imagenes/imagen6.png"
    ),
    Producto(
        id = 7,
        nombre = "Matcha Latte \"Mementos\"",
        precio = 4300,
        categoria = "Bebidas",
        descripcion = "Té verde Matcha japonés de alta calidad, preparado con leche vaporizada y un toque de dulzor.",
        imagen = "/imagenes/imagen7.png"
    ),
    Producto(
        id = 10,
        nombre = "Café Helado V60",
        precio = 3500,
        categoria = "Bebidas",
        descripcion = "Café de especialidad filtrado en frío con el método V60, ideal para refrescarse.",
        imagen = "/imagenes/imagen10.png"
    ),
    Producto(
        id = 13,
        nombre = "Té Hōjicha Caliente",
        precio = 2900,
        categoria = "Bebidas",
        descripcion = "Té verde tostado que ofrece un sabor ahumado y notas a nuez, bajo en cafeína.",
        imagen = "/imagenes/imagen13.png"
    ),
    Producto(
        id = 16,
        nombre = "\"Phantom Thief\" Mocktail",
        precio = 5200,
        categoria = "Bebidas",
        descripcion = "Bebida efervescente de arándanos, menta y un toque secreto de especias. ¡Perfecta para una noche de planificación!",
        imagen = "/imagenes/imagen16.png"
    ),
    Producto(
        id = 19,
        nombre = "Calpis Soda",
        precio = 2800,
        categoria = "Bebidas",
        descripcion = "La popular bebida japonesa a base de leche, dulce y ligeramente ácida, servida fría y efervescente.",
        imagen = "/imagenes/imagen19.png"
    ),

    // --- Postres ---
    Producto(
        id = 3,
        nombre = "Cheesecake Persona",
        precio = 5800,
        categoria = "Postres",
        descripcion = "Cheesecake de estilo japonés con base de galleta y topping de frutos rojos.",
        imagen = "/imagenes/imagen3.png"
    ),
    Producto(
        id = 8,
        nombre = "Dorayaki \"Soledad\"",
        precio = 3800,
        categoria = "Postres",
        descripcion = "Dos panqueques japoneses rellenos de Anko (pasta de judía roja dulce). Un clásico de la repostería nipona.",
        imagen = "/imagenes/imagen8.png"
    ),
    Producto(
        id = 11,
        nombre = "Tarta de Sésamo Negro",
        precio = 5500,
        categoria = "Postres",
        descripcion = "Tarta cremosa con sabor intenso a sésamo negro, un postre elegante y no excesivamente dulce.",
        imagen = "/imagenes/imagen11.png"
    ),
    Producto(
        id = 14,
        nombre = "Mochi Ice Cream (2 unidades)",
        precio = 4900,
        categoria = "Postres",
        descripcion = "Postre japonés de helado envuelto en una suave masa de mochi. Sabores: Vainilla y Té Verde.",
        imagen = "/imagenes/imagen14.png"
    ),
    Producto(
        id = 17,
        nombre = "Mochi \"Corazón Oculto\"",
        precio = 4100,
        categoria = "Postres",
        descripcion = "Tres mochis artesanales con diferentes rellenos: Sésamo negro, Kinako (soja tostada) y Matcha.",
        imagen = "/imagenes/imagen17.png"
    ),
    Producto(
        id = 20,
        nombre = "Taiyaki de Anko",
        precio = 4200,
        categoria = "Postres",
        descripcion = "Pastel con forma de pez, crujiente por fuera y relleno de pasta dulce de judías rojas (anko). Se sirve caliente.",
        imagen = "/imagenes/imagen20.png"
    )
)