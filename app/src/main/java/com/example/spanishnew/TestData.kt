package com.example.spanishnew

object TestData {
    val words = listOf(
        // Урок 1: Приветствия и основы
        Word(original = "Hola", translationRu = "Привет", translationUk = "Привіт", lessonNumber = 1),
        Word(original = "Adiós", translationRu = "Пока / До свидания", translationUk = "Бувай / До побачення", lessonNumber = 1),
        Word(original = "Gracias", translationRu = "Спасибо", translationUk = "Дякую", lessonNumber = 1),
        Word(original = "Por favor", translationRu = "Пожалуйста", translationUk = "Будь ласка", lessonNumber = 1),
        Word(original = "Sí", translationRu = "Да", translationUk = "Так", lessonNumber = 1),
        Word(original = "No", translationRu = "Нет", translationUk = "Ні", lessonNumber = 1),
        Word(original = "Buenos días", translationRu = "Доброе утро", translationUk = "Доброго ранку", lessonNumber = 1),
        Word(original = "Buenas tardes", translationRu = "Добрый день", translationUk = "Доброго дня", lessonNumber = 1),
        Word(original = "Buenas noches", translationRu = "Доброй ночи", translationUk = "Доброї ночі", lessonNumber = 1),
        Word(original = "Lo siento", translationRu = "Извините", translationUk = "Вибачте", lessonNumber = 1),

        // Урок 2: Числа и время
        Word(original = "Uno", translationRu = "Один", translationUk = "Один", lessonNumber = 2),
        Word(original = "Dos", translationRu = "Два", translationUk = "Два", lessonNumber = 2),
        Word(original = "Tres", translationRu = "Три", translationUk = "Три", lessonNumber = 2),
        Word(original = "Cuatro", translationRu = "Четыре", translationUk = "Чотири", lessonNumber = 2),
        Word(original = "Cinco", translationRu = "Пять", translationUk = "П'ять", lessonNumber = 2),
        Word(original = "Seis", translationRu = "Шесть", translationUk = "Шість", lessonNumber = 2),
        Word(original = "Siete", translationRu = "Семь", translationUk = "Сім", lessonNumber = 2),
        Word(original = "Ocho", translationRu = "Восемь", translationUk = "Вісім", lessonNumber = 2),
        Word(original = "Nueve", translationRu = "Девять", translationUk = "Дев'ять", lessonNumber = 2),
        Word(original = "Diez", translationRu = "Десять", translationUk = "Десять", lessonNumber = 2),

        // Урок 3: Семья
        Word(original = "Madre", translationRu = "Мать", translationUk = "Мати", lessonNumber = 3),
        Word(original = "Padre", translationRu = "Отец", translationUk = "Батько", lessonNumber = 3),
        Word(original = "Hermano", translationRu = "Брат", translationUk = "Брат", lessonNumber = 3),
        Word(original = "Hermana", translationRu = "Сестра", translationUk = "Сестра", lessonNumber = 3),
        Word(original = "Hijo", translationRu = "Сын", translationUk = "Син", lessonNumber = 3),
        Word(original = "Hija", translationRu = "Дочь", translationUk = "Донька", lessonNumber = 3),
        Word(original = "Abuelo", translationRu = "Дедушка", translationUk = "Дідусь", lessonNumber = 3),
        Word(original = "Abuela", translationRu = "Бабушка", translationUk = "Бабуся", lessonNumber = 3),
        Word(original = "Tío", translationRu = "Дядя", translationUk = "Дядько", lessonNumber = 3),
        Word(original = "Tía", translationRu = "Тетя", translationUk = "Тітка", lessonNumber = 3),

        // Урок 4: Еда
        Word(original = "Agua", translationRu = "Вода", translationUk = "Вода", lessonNumber = 4),
        Word(original = "Pan", translationRu = "Хлеб", translationUk = "Хліб", lessonNumber = 4),
        Word(original = "Leche", translationRu = "Молоко", translationUk = "Молоко", lessonNumber = 4),
        Word(original = "Fruta", translationRu = "Фрукт", translationUk = "Фрукт", lessonNumber = 4),
        Word(original = "Manzana", translationRu = "Яблоко", translationUk = "Яблуко", lessonNumber = 4),
        Word(original = "Carne", translationRu = "Мясо", translationUk = "М'ясо", lessonNumber = 4),
        Word(original = "Pescado", translationRu = "Рыба", translationUk = "Риба", lessonNumber = 4),
        Word(original = "Arroz", translationRu = "Рис", translationUk = "Рис", lessonNumber = 4),
        Word(original = "Café", translationRu = "Кофе", translationUk = "Кава", lessonNumber = 4),
        Word(original = "Té", translationRu = "Чай", translationUk = "Чай", lessonNumber = 4),

        // Урок 5: Глаголы
        Word(original = "Hablar", translationRu = "Говорить", translationUk = "Говорити", lessonNumber = 5),
        Word(original = "Comer", translationRu = "Есть (кушать)", translationUk = "Їсти", lessonNumber = 5),
        Word(original = "Beber", translationRu = "Пить", translationUk = "Пити", lessonNumber = 5),
        Word(original = "Vivir", translationRu = "Жить", translationUk = "Жити", lessonNumber = 5),
        Word(original = "Ir", translationRu = "Идти / Ехать", translationUk = "Йти / Їхати", lessonNumber = 5),
        Word(original = "Ver", translationRu = "Видеть", translationUk = "Бачити", lessonNumber = 5),
        Word(original = "Escuchar", translationRu = "Слушать", translationUk = "Слухати", lessonNumber = 5),
        Word(original = "Leer", translationRu = "Читать", translationUk = "Читати", lessonNumber = 5),
        Word(original = "Escribir", translationRu = "Писать", translationUk = "Писати", lessonNumber = 5),
        Word(original = "Entender", translationRu = "Понимать", translationUk = "Розуміти", lessonNumber = 5)
    )
}
