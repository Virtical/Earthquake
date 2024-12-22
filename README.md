1) Создание класса Earthquake, с необходимыми полями и конструктором
![Класс Earthquake](screenshots/2024-12-22_20-49-20.png)
2) Создание класса EarthquakeHandler и метода ParseEarthquakesFromCSV, который парсит файл и возвращает список землетрясений
![Класс EarthquakeHandler](screenshots/2024-12-22_20-51-41.png)
3) Создание класса Database и вспомогательных методов, для открытия БД, создания таблицы, сохранения данных, и закрытия БД
![Класс Database](screenshots/2024-12-22_20-53-58.png)
4) Сохранение данных в Базу Данных
![Данные в Базе Данных](screenshots/2024-12-22_21-08-08.png)
5) Создание метода для получения данных из Базы Данных
![Метод для получения данных из БД](screenshots/2024-12-22_20-54-48.png)
6) В классе EarthquakeHandler создание метода getEarthquakeCountsPerYear для получения количества зелетрясений по годам
![Метод getEarthquakeCountsPerYear](screenshots/2024-12-22_20-56-13.png)
7) Создание класса EarthquakeChart для создания графика количества землетрясений по годам
![Класс EarthquakeChart](screenshots/2024-12-22_21-07-18.png)
8) В классе EarthquakeHandler создание метода calculateAverageMagnitudeByState, который по заданному Штату считает среднюю магнитуду
![Метод calculateAverageMagnitudeByState](screenshots/2024-12-22_20-57-43.png)
9) В классе EarthquakeHandler создание метода findStateWithDeepestEarthquake, который по заданному году находит Штат в котором произошло самое глубокое землетрясение в этом году
![Метод findStateWithDeepestEarthquake](screenshots/2024-12-22_21-00-28.png)
10) Вывод графика и данных о средней магнитуды для штата "West Virginia", название штата, в котором произошло самое глубокое землетрясение в 2013 году в консоль
![График](screenshots/graph.png)
![Магнитуда](screenshots/magnitude.png)
![Штат](screenshots/state.png)
