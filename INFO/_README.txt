Task:
На прикладі проекту Tomcat-MySQL-Books, створіть проект Tomcat-MySQL-Employee.
Сутність Employee має властивості: id, ім'я, посада, телефон.
В INFO/SQLs.sql надайте SQL-запити проекту.
----------------------------------

ТЕХСТЕК:
Apache Tomcat, MySQL, JDBC.

------------------------------------

1) Складаємо SQL-запити SQLs.sql.

2) Створюємо Maven-проект.
В Advanced Settings можемо прописати org.example.app

3) Додаємо залежності в pom.xml

4) Формуємо контент у org/example/app

5) В .gitignore додамо
src/main/java/org/example/app/credentials/

6) Створемо src/main/webapp та формуємо
тут контент.

Для створення CSS-коду кнопок можемо скористатися
https://www.bestcssbuttongenerator.com/

7) Для роботи з сервером у IntelliJ IDEA Community Edition
необхідний плагін.
File > Settings > Plugins > Marketplace.
Знаходимо плагін Smart Tomcat, встановлюємо.

* Якщо IntelliJ IDEA Ultimate, то без плагіна
https://www.jetbrains.com/help/idea/developing-web-applications.html

8) Конфігуруємо Smart Tomcat.

Run > Edit Configurations... > + > Smart Tomcat

Вкладка Configuration.

В Name пишемо, наприклад, books-app.

Клікаємо Configure. Стаємо на Tomcat Server. Клікаємо + .
Вибираємо папку необхідного Apache Tomcat.
Краще вибрати сервер, який встановлений із zip-файлу,
оскільки не вимагає зайвої аутентифікації при запуску.

Клікаємо OK.

Catalina base.
* Catalina – контейнер сервлетів Apache Tomcat. 
Catalina реалізує специфікації для сервлета та JSP.

Deployment directory. Вибираємо папку webapp свого проекту.

Use classpath of module має містити найменування
кореневої папки проекту.

Context path прописуємо  books-app.

Server port повинен містити порт Apache Tomcat, який в
налаштуваннях сервера.
Див. на сервері /conf/server.xml
<Connector port="8080"...

Клікаємо Apply та OK.

9) Запустимо Tomcat.
В IDE, зверху, клікаємо зелену кнопку запуску.
В консолі мають з'явитись повідомлення про функціонування
сервера.
Зупинити сервер можна, натиснувши червоний квадратик вгорі,
який має з'явитися після запуску сервера.

10) Сформуємо jar-файл (опційно).
Клікаємо праворуч Maven. Відкривається панель Maven.
В Lyfecycle клікаємо послідовно clean, compile, package.
В панель_проекта/target має з'явитися jar-файл.
Цей jar-файл копіюємо до папки webapps сервера на локальній машині.

11) Перевіряємо працездатність програми.
Запускаємо сервер.
В консолі повинно з'явитися таке посилання
http://localhost:8080/books-app
Клікаємо на посилання.
В браузері з'явиться стартова сторінка Web-додатку.
Тестуємо функціонал додатку.
Також перевіряємо внесення даних в БД через Workbench.



