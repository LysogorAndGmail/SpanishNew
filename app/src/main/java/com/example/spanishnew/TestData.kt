package com.example.spanishnew

object TestData {
    val words: List<Word> by lazy {
        val list = mutableListOf<Word>()

        fun addLesson(number: Int, data: List<Pair<String, String>>) {
            data.forEach { list.add(Word(original = it.first, translationRu = it.second, lessonNumber = number)) }
        }

        // Урок 1: Основы
        addLesson(1, listOf(
            "Hola" to "Привет", "Adiós" to "Пока", "Gracias" to "Спасибо", "Por favor" to "Пожалуйста",
            "Sí" to "Да", "No" to "Нет", "Buenos días" to "Доброе утро", "Buenas tardes" to "Добрый день",
            "Buenas noches" to "Доброй ночи", "Lo siento" to "Извините", "Uno" to "Один", "Dos" to "Два",
            "Tres" to "Три", "Cuatro" to "Четыре", "Cinco" to "Пять", "Seis" to "Шесть",
            "Siete" to "Семь", "Ocho" to "Восемь", "Nueve" to "Девять", "Diez" to "Десять"
        ))

        // Урок 2: Семья и люди
        addLesson(2, listOf(
            "Madre" to "Мать", "Padre" to "Отец", "Hermano" to "Брат", "Hermana" to "Сестра",
            "Hijo" to "Сын", "Hija" to "Дочь", "Abuelo" to "Дедушка", "Abuela" to "Бабушка",
            "Tío" to "Дядя", "Tía" to "Тетя", "Primo" to "Двоюродный брат", "Prima" to "Двоюродная сестра",
            "Esposo" to "Муж", "Esposa" to "Жена", "Familia" to "Семья", "Niño" to "Ребенок",
            "Amigo" to "Друг", "Amiga" to "Подруга", "Gente" to "Люди", "Persona" to "Человек"
        ))

        // Урок 3: Глаголы движения и действия
        addLesson(3, listOf(
            "Hablar" to "Говорить", "Comer" to "Есть", "Beber" to "Пить", "Vivir" to "Жить",
            "Ir" to "Идти", "Ver" to "Видеть", "Escuchar" to "Слушать", "Leer" to "Читать",
            "Escribir" to "Писать", "Entender" to "Понимать", "Trabajar" to "Работать", "Estudiar" to "Учиться",
            "Comprar" to "Покупать", "Querer" to "Хотеть", "Poder" to "Мочь", "Saber" to "Знать",
            "Hacer" to "Делать", "Dar" to "Давать", "Salir" to "Выходить", "Venir" to "Приходить"
        ))

        // Урок 4: Цвета
        addLesson(4, listOf(
            "Rojo" to "Красный", "Azul" to "Синий", "Verde" to "Зеленый", "Amarillo" to "Желтый",
            "Negro" to "Черный", "Blanco" to "Белый", "Gris" to "Серый", "Naranja" to "Оранжевый",
            "Rosa" to "Розовый", "Marrón" to "Коричневый", "Morado" to "Фиолетовый", "Celeste" to "Голубой",
            "Dorado" to "Золотой", "Plateado" to "Серебряный", "Claro" to "Светлый", "Oscuro" to "Темный",
            "Brillante" to "Яркий", "Mate" to "Матовый", "Pálido" to "Бледный", "Colorido" to "Цветной"
        ))

        // Урок 5: Время
        addLesson(5, listOf(
            "Día" to "День", "Semana" to "Неделя", "Mes" to "Месяц", "Año" to "Год",
            "Hora" to "Час", "Minuto" to "Минута", "Segundo" to "Секунда", "Mañana" to "Утро / Завтра",
            "Tarde" to "День / Вечер", "Noche" to "Ночь", "Hoy" to "Сегодня", "Ayer" to "Вчера",
            "Ahora" to "Сейчас", "Luego" to "Потом", "Antes" to "До", "Después" to "После",
            "Pronto" to "Скоро", "Tarde" to "Поздно", "Temprano" to "Рано", "Siempre" to "Всегда"
        ))

        // Урок 6: Еда
        addLesson(6, listOf(
            "Pan" to "Хлеб", "Agua" to "Вода", "Leche" to "Молоко", "Queso" to "Сыр",
            "Huevo" to "Яйцо", "Fruta" to "Фрукт", "Verdura" to "Овощ", "Carne" to "Мясо",
            "Pollo" to "Курица", "Pescado" to "Рыба", "Arroz" to "Рис", "Pasta" to "Паста",
            "Sopa" to "Суп", "Ensalada" to "Салат", "Azúcar" to "Сахар", "Sal" to "Соль",
            "Café" to "Кофе", "Té" to "Чай", "Jugo" to "Сок", "Vino" to "Вино"
        ))

        // Урок 7: Дом
        addLesson(7, listOf(
            "Casa" to "Дом", "Puerta" to "Дверь", "Ventana" to "Окно", "Pared" to "Стена",
            "Techo" to "Потолок / Крыша", "Suelo" to "Пол", "Cocina" to "Кухня", "Baño" to "Ванная",
            "Dormitorio" to "Спальня", "Sala" to "Гостиная", "Mesa" to "Стол", "Silla" to "Стул",
            "Sofá" to "Диван", "Cama" to "Кровать", "Espejo" to "Зеркало", "Lámpara" to "Лампа",
            "Reloj" to "Часы", "Teléfono" to "Телефон", "Televisor" to "Телевизор", "Nevera" to "Холодильник"
        ))

        // Урок 8: Животные
        addLesson(8, listOf(
            "Perro" to "Собака", "Gato" to "Кот", "Caballo" to "Лошадь", "Vaca" to "Корова",
            "Cerdo" to "Свинья", "Oveja" to "Овца", "Pollo" to "Цыпленок", "Pájaro" to "Птица",
            "Pez" to "Рыба", "León" to "Лев", "Tigre" to "Тигр", "Elefante" to "Слон",
            "Mono" to "Обезьяна", "Serpiente" to "Змея", "Rana" to "Лягушка", "Mariposa" to "Бабочка",
            "Abeja" to "Пчела", "Hormiga" to "Муравей", "Ratón" to "Мышь", "Conejo" to "Кролик"
        ))

        // Урок 9: Тело
        addLesson(9, listOf(
            "Cabeza" to "Голова", "Cara" to "Лицо", "Ojo" to "Глаз", "Oreja" to "Ухо",
            "Nariz" to "Нос", "Boca" to "Рот", "Diente" to "Зуб", "Cuello" to "Шея",
            "Hombro" to "Плечо", "Brazo" to "Рука (от плеча)", "Codo" to "Локоть", "Mano" to "Кисть руки",
            "Dedo" to "Палец", "Pecho" to "Грудь", "Espalda" to "Спина", "Estómago" to "Живот",
            "Pierna" to "Нога", "Rodilla" to "Колено", "Pie" to "Ступня", "Corazón" to "Сердце"
        ))

        // Урок 10: Одежда
        addLesson(10, listOf(
            "Camisa" to "Рубашка", "Camiseta" to "Футболка", "Pantalones" to "Брюки", "Falda" to "Юбка",
            "Vestido" to "Платье", "Chaqueta" to "Куртка", "Abrigo" to "Пальто", "Zapatos" to "Обувь",
            "Botas" to "Ботинки", "Calcetines" to "Носки", "Sombrero" to "Шляпа", "Gorra" to "Кепка",
            "Guantes" to "Перчатки", "Bufanda" to "Шарф", "Cinturón" to "Ремень", "Corbata" to "Галстук",
            "Pijama" to "Пижама", "Traje" to "Костюм", "Gafas" to "Очки", "Bolsa" to "Сумка"
        ))

        // Для уроков 11-120 используем расширенный список слов в разных комбинациях
        val pool = listOf(
            "Ciudad" to "Город", "Calle" to "Улица", "Coche" to "Машина", "Avión" to "Самолет",
            "Tren" to "Поезд", "Bicicleta" to "Велосипед", "Escuela" to "Школа", "Libro" to "Книга",
            "Lápiz" to "Карандаш", "Papel" to "Бумага", "Sol" to "Солнце", "Luna" to "Луна",
            "Estrella" to "Звезда", "Cielo" to "Небо", "Mar" to "Море", "Montaña" to "Гора",
            "Árbol" to "Дерево", "Flor" to "Цветок", "Fuego" to "Огонь", "Tierra" to "Земля"
        )

        for (i in 11..120) {
            for (j in 1..20) {
                val base = pool[(j - 1) % pool.size]
                list.add(Word(
                    original = "${base.first} $j (L$i)",
                    translationRu = "${base.second} $j (У$i)",
                    lessonNumber = i
                ))
            }
        }

        list
    }
}
