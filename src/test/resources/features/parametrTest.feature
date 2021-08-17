#language:ru
#encoding:UTF-8

@test
Функционал: Параметризированный запуск тестов

  Структура сценария: Проверка цены товара <inventoryItem>
    Допустим авторизованный пользователь находится на странице каталога "https://www.saucedemo.com/inventory.html"
    И выполнено нажатие на ссылку "<inventoryItem>"
    Тогда цена товара равна "<inventoryPrice>"

    Примеры:
      | inventoryItem            | inventoryPrice |
      | Sauce Labs Backpack      |  $29.99        |
      | Sauce Labs Bike Light    |  $9.99         |
      | Sauce Labs Bolt T-Shirt  |  $15.99        |
      | Sauce Labs Fleece Jacket |  $49.99        |