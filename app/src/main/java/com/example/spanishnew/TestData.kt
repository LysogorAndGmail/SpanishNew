package com.example.spanishnew

object TestData {
    val words: List<Word> by lazy {
        val list = mutableListOf<Word>()

        fun addLesson(number: Int, data: List<Triple<String, String, String>>) {
            data.forEach { list.add(Word(original = it.first, translationRu = it.second, translationUk = it.third, lessonNumber = number)) }
        }

        // Урок 1: Основы
        addLesson(1, listOf(
            Triple("Hola", "Привет", "Привіт"), Triple("Adiós", "Пока", "Бувай"), Triple("Gracias", "Спасибо", "Дякую"), Triple("Por favor", "Пожалуйста", "Будь ласка"),
            Triple("Sí", "Да", "Так"), Triple("No", "Нет", "Ні"), Triple("Buenos días", "Доброе утро", "Доброго ранку"), Triple("Buenas tardes", "Добрый день", "Доброго дня"),
            Triple("Buenas noches", "Доброй ночи", "Доброї ночі"), Triple("Lo siento", "Извините", "Вибачте"), Triple("Uno", "Один", "Один"), Triple("Dos", "Два", "Два"),
            Triple("Tres", "Три", "Три"), Triple("Cuatro", "Четыре", "Чотири"), Triple("Cinco", "Пять", "П'ять"), Triple("Seis", "Шесть", "Шість"),
            Triple("Siete", "Семь", "Сім"), Triple("Ocho", "Восемь", "Вісім"), Triple("Nueve", "Девять", "Дев'ять"), Triple("Diez", "Десять", "Десять")
        ))

        // Урок 2: Семья и люди
        addLesson(2, listOf(
            Triple("Madre", "Мать", "Мати"), Triple("Padre", "Отец", "Батько"), Triple("Hermano", "Брат", "Брат"), Triple("Hermana", "Сестра", "Сестра"),
            Triple("Hijo", "Сын", "Син"), Triple("Hija", "Дочь", "Донька"), Triple("Abuelo", "Дедушка", "Дідусь"), Triple("Abuela", "Бабушка", "Бабуся"),
            Triple("Tío", "Дядя", "Дядько"), Triple("Tía", "Тетя", "Тітка"), Triple("Primo", "Двоюродный брат", "Двоюрідний брат"), Triple("Prima", "Двоюродная сестра", "Двоюрідна сестра"),
            Triple("Esposo", "Муж", "Чоловік"), Triple("Esposa", "Жена", "Дружина"), Triple("Familia", "Семья", "Сім'я"), Triple("Niño", "Ребенок", "Дитина"),
            Triple("Amigo", "Друг", "Друг"), Triple("Amiga", "Подруга", "Подруга"), Triple("Gente", "Люди", "Люди"), Triple("Persona", "Человек", "Людина")
        ))

        // Урок 3: Глаголы движения и действия
        addLesson(3, listOf(
            Triple("Hablar", "Говорить", "Говорити"), Triple("Comer", "Есть", "Їсти"), Triple("Beber", "Пить", "Пити"), Triple("Vivir", "Жить", "Жити"),
            Triple("Ir", "Идти", "Йти"), Triple("Ver", "Видеть", "Бачити"), Triple("Escuchar", "Слушать", "Слухати"), Triple("Leer", "Читать", "Читати"),
            Triple("Escribir", "Писать", "Писати"), Triple("Entender", "Понимать", "Розуміти"), Triple("Trabajar", "Работать", "Працювати"), Triple("Estudiar", "Учиться", "Вчитися"),
            Triple("Comprar", "Покупать", "Купувати"), Triple("Querer", "Хотеть", "Хотіти"), Triple("Poder", "Мочь", "Могти"), Triple("Saber", "Знать", "Знати"),
            Triple("Hacer", "Делать", "Робити"), Triple("Dar", "Давать", "Давати"), Triple("Salir", "Выходить", "Виходити"), Triple("Venir", "Приходить", "Приходити")
        ))

        // Урок 4: Цвета
        addLesson(4, listOf(
            Triple("Rojo", "Красный", "Червоний"), Triple("Azul", "Синий", "Синій"), Triple("Verde", "Зеленый", "Зелений"), Triple("Amarillo", "Желтый", "Жовтий"),
            Triple("Negro", "Черный", "Чорний"), Triple("Blanco", "Белый", "Білий"), Triple("Gris", "Серый", "Сірий"), Triple("Naranja", "Оранжевый", "Помаранчевий"),
            Triple("Rosa", "Розовый", "Рожевий"), Triple("Marrón", "Коричневый", "Коричневий"), Triple("Morado", "Фиолетовый", "Фіолетовий"), Triple("Celeste", "Голубой", "Блакитний"),
            Triple("Dorado", "Золотой", "Золотий"), Triple("Plateado", "Серебряный", "Срібний"), Triple("Claro", "Светлый", "Світлий"), Triple("Oscuro", "Темный", "Темний"),
            Triple("Brillante", "Яркий", "Яскравий"), Triple("Mate", "Матовый", "Матовий"), Triple("Pálido", "Бледный", "Блідий"), Triple("Colorido", "Цветной", "Кольоровий")
        ))

        // Урок 5: Время
        addLesson(5, listOf(
            Triple("Día", "День", "День"), Triple("Semana", "Неделя", "Тиждень"), Triple("Mes", "Месяц", "Місяць"), Triple("Año", "Год", "Рік"),
            Triple("Hora", "Час", "Година"), Triple("Minuto", "Минута", "Хвилина"), Triple("Segundo", "Секунда", "Секунда"), Triple("Mañana", "Утро / Завтра", "Ранок / Завтра"),
            Triple("Tarde", "День / Вечер", "День / Вечір"), Triple("Noche", "Ночь", "Ніч"), Triple("Hoy", "Сегодня", "Сьогодні"), Triple("Ayer", "Вчера", "Вчора"),
            Triple("Ahora", "Сейчас", "Зараз"), Triple("Luego", "Потом", "Потім"), Triple("Antes", "До", "До"), Triple("Después", "После", "Після"),
            Triple("Pronto", "Скоро", "Скоро"), Triple("Tarde", "Поздно", "Пізно"), Triple("Temprano", "Рано", "Рано"), Triple("Siempre", "Всегда", "Завжди")
        ))

        // Урок 6: Еда
        addLesson(6, listOf(
            Triple("Pan", "Хлеб", "Хліб"), Triple("Agua", "Вода", "Вода"), Triple("Leche", "Молоко", "Молоко"), Triple("Queso", "Сыр", "Сир"),
            Triple("Huevo", "Яйцо", "Яйце"), Triple("Fruta", "Фрукт", "Фрукт"), Triple("Verdura", "Овощ", "Овоч"), Triple("Carne", "Мясо", "М'ясо"),
            Triple("Pollo", "Курица", "Курка"), Triple("Pescado", "Рыба", "Риба"), Triple("Arroz", "Рис", "Рис"), Triple("Pasta", "Паста", "Паста"),
            Triple("Sopa", "Суп", "Суп"), Triple("Ensalada", "Салат", "Салат"), Triple("Azúcar", "Сахар", "Цукор"), Triple("Sal", "Соль", "Сіль"),
            Triple("Café", "Кофе", "Кава"), Triple("Té", "Чай", "Чай"), Triple("Jugo", "Сок", "Сік"), Triple("Vino", "Вино", "Вино")
        ))

        // Урок 7: Дом
        addLesson(7, listOf(
            Triple("Casa", "Дом", "Будинок"), Triple("Puerta", "Дверь", "Двері"), Triple("Ventana", "Окно", "Вікно"), Triple("Pared", "Стена", "Стіна"),
            Triple("Techo", "Потолок / Крыша", "Стеля / Дах"), Triple("Suelo", "Пол", "Підлога"), Triple("Cocina", "Кухня", "Кухня"), Triple("Baño", "Ванная", "Ванна"),
            Triple("Dormitorio", "Спальня", "Спальня"), Triple("Sala", "Гостиная", "Вітальня"), Triple("Mesa", "Стол", "Стіл"), Triple("Silla", "Стул", "Стілець"),
            Triple("Sofá", "Диван", "Диван"), Triple("Cama", "Кровать", "Ліжко"), Triple("Espejo", "Зеркало", "Дзеркало"), Triple("Lámpara", "Лампа", "Лампа"),
            Triple("Reloj", "Часы", "Годинник"), Triple("Teléfono", "Телефон", "Телефон"), Triple("Televisor", "Телевизор", "Телевізор"), Triple("Nevera", "Холодильник", "Холодильник")
        ))

        // Урок 8: Животные
        addLesson(8, listOf(
            Triple("Perro", "Собака", "Пес"), Triple("Gato", "Кот", "Кіт"), Triple("Caballo", "Лошадь", "Кінь"), Triple("Vaca", "Корова", "Корова"),
            Triple("Cerdo", "Свинья", "Свиня"), Triple("Oveja", "Овца", "Вівця"), Triple("Pollo", "Цыпленок", "Курча"), Triple("Pájaro", "Птица", "Птах"),
            Triple("Pez", "Рыба", "Риба"), Triple("León", "Лев", "Лев"), Triple("Tigre", "Тигр", "Тигр"), Triple("Elefante", "Слон", "Слон"),
            Triple("Mono", "Обезьяна", "Мавпа"), Triple("Serpiente", "Змея", "Змія"), Triple("Rana", "Лягушка", "Жаба"), Triple("Mariposa", "Бабочка", "Метелик"),
            Triple("Abeja", "Пчела", "Бджола"), Triple("Hormiga", "Муравей", "Мураха"), Triple("Ratón", "Мышь", "Миша"), Triple("Conejo", "Кролик", "Кролик")
        ))

        // Урок 9: Тело
        addLesson(9, listOf(
            Triple("Cabeza", "Голова", "Голова"), Triple("Cara", "Лицо", "Обличчя"), Triple("Ojo", "Глаз", "Око"), Triple("Oreja", "Ухо", "Вухо"),
            Triple("Nariz", "Нос", "Ніс"), Triple("Boca", "Рот", "Рот"), Triple("Diente", "Зуб", "Зуб"), Triple("Cuello", "Шея", "Шия"),
            Triple("Hombro", "Плечо", "Плече"), Triple("Brazo", "Рука (от плеча)", "Рука"), Triple("Codo", "Локоть", "Лікоть"), Triple("Mano", "Кисть руки", "Кисть"),
            Triple("Dedo", "Палец", "Палець"), Triple("Pecho", "Грудь", "Груди"), Triple("Espalda", "Спина", "Спина"), Triple("Estómago", "Живот", "Живіт"),
            Triple("Pierna", "Нога", "Нога"), Triple("Rodilla", "Колено", "Коліно"), Triple("Pie", "Ступня", "Ступня"), Triple("Corazón", "Сердце", "Серце")
        ))

        // Урок 10: Одежда
        addLesson(10, listOf(
            Triple("Camisa", "Рубашка", "Сорочка"), Triple("Camiseta", "Футболка", "Футболка"), Triple("Pantalones", "Брюки", "Штани"), Triple("Falda", "Юбка", "Спідниця"),
            Triple("Vestido", "Платье", "Сукня"), Triple("Chaqueta", "Куртка", "Куртка"), Triple("Abrigo", "Пальто", "Пальто"), Triple("Zapatos", "Обувь", "Взуття"),
            Triple("Botas", "Ботинки", "Черевики"), Triple("Calcetines", "Носки", "Шкарпетки"), Triple("Sombrero", "Шляпа", "Капелюх"), Triple("Gorra", "Кепка", "Кепка"),
            Triple("Guantes", "Перчатки", "Рукавички"), Triple("Bufanda", "Шарф", "Шарф"), Triple("Cinturón", "Ремень", "Ремінь"), Triple("Corbata", "Галстук", "Краватка"),
            Triple("Pijama", "Пижама", "Піжама"), Triple("Traje", "Костюм", "Костюм"), Triple("Gafas", "Очки", "Окуляри"), Triple("Bolsa", "Сумка", "Сумка")
        ))

        // Для уроков 11-120 используем расширенный список слов в разных комбинациях
        val poolTriple = listOf(
            Triple("Ciudad", "Город", "Місто"), Triple("Calle", "Улица", "Вулиця"), Triple("Coche", "Машина", "Машина"), Triple("Avión", "Самолет", "Літак"),
            Triple("Tren", "Поезд", "Потяг"), Triple("Bicicleta", "Велосипед", "Велосипед"), Triple("Escuela", "Школа", "Школа"), Triple("Libro", "Книга", "Книга"),
            Triple("Lápiz", "Карандаш", "Олівець"), Triple("Papel", "Бумага", "Папір"), Triple("Sol", "Солнце", "Сонце"), Triple("Luna", "Луна", "Місяць"),
            Triple("Estrella", "Звезда", "Зірка"), Triple("Cielo", "Небо", "Небо"), Triple("Mar", "Море", "Море"), Triple("Montaña", "Гора", "Гора"),
            Triple("Árbol", "Дерево", "Дерево"), Triple("Flor", "Цветок", "Квітка"), Triple("Fuego", "Огонь", "Вогонь"), Triple("Tierra", "Земля", "Земля")
        )

        for (i in 11..120) {
            for (j in 1..20) {
                val base = poolTriple[(j - 1) % poolTriple.size]
                list.add(Word(
                    original = "${base.first} $j (L$i)",
                    translationRu = "${base.second} $j (У$i)",
                    translationUk = "${base.third} $j (У$i)",
                    lessonNumber = i
                ))
            }
        }

        list
    }
}
