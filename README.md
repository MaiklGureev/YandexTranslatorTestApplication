# YandexTranslatorTestApplication

Android приложение переводчик использующий Yandex Translation API v2.

Dependencies: retrofit2, room, material design.

Видеодемонтрация: https://youtu.be/_moilrr-xvY

### Реализованные методы сервиса Yandex Translate:
1. detectLanguage 	Определяет язык текста.
2. listLanguages 	Получает список поддерживаемых языков.
3. translate 	Переводит текст на указанный язык.

### Струкутура приложения: 
+ package main:(главный и единственный экран)
  * MainActivity.class - главное активити
  * interface MainContract.class - интерфес описывающий взаимодействие View и Presenter
  * MainPresenter.class - класс 

+ package network:
  * package POJOs - содержит классы описывающие структуру запросов и ответов сервера
  * interface JSONPlaceHolderApi.class - интерфес запросов для refrofit2
  * NetworkService.class - класс singleton для получения экземпляра retrofit2

+ package savedHistoryList:
  * SavedHistoryAdapter - адаптер для списка сохранённых историй перевода

+ package sqlite:
  * RoomDB.class - класс описания базы данных для Room ORM
  * TranslationRecord.class - класс описывающий сущность в базе данных
  * interface TranslationRecordDAO.class - интерфейс описывающий запросы к Room ORM
  
 + AlertDialogHelper.class - класс для создания диалоговых окон история переводов и удаление выбранного перевода
 + DataProcessingTools.class - класс обработки и преобразования полученнх данных
 + Repository.class - класс singleton для работы с retrofit и Room ORM
 + StaticVariables.class - класс статических строковых перменных (DB_NAME,BASE_URL,FOLDER_ID,IAM_TOKEN,HEADER_1,HEADER_2)






