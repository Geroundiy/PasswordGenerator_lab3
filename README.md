Веб-приложение на Spring Boot для генерации и управления паролями с тегами. Использует PostgreSQL, шифрует пароли (BCrypt). Поддерживает CRUD, полезные GET-эндпоинты и кэширование.

Требования для запуска:
- Java 17
- Maven
- PostgreSQL (база passworddb)
- Переменная DB_PASSWORD

1. Генерация пароля
GET: `http://localhost:8080/api/passwords/generate?length={длина}&complexity={сложность}&owner={владелец}`
- length: 4–30  
- complexity: 1 (цифры), 2 (+буквы), 3 (+символы)  
- owner: имя (необязательно)

- Пример: `http://localhost:8080/api/passwords/generate?length=12&complexity=3&owner=testUser`

2. Поиск паролей по тегу 
GET: `http://localhost:8080/api/passwords/tags/{имя_тега}`
Пример: `http://localhost:8080/api/passwords/tags/workИспользует`
@Query для выборки из БД и кэш (in-memory Map).

3. CRUD для паролей и тегов
- Пароли: POST, GET, PUT, DELETE на /api/passwords  
- Теги: POST, GET, PUT, DELETE на /api/tags


Особенности:

- Кэш: In-memory Map для методов generatePassword, findAll, findById, findPasswordsByTagName. Очищается при операциях create, update, delete.
- Хранение: Пароли шифруются (BCrypt) в таблице passwords, теги — в tags, связи — в password_tag (many-to-many). /
