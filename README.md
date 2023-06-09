# Розыгрыш игрушек (Java)

## Задание
Необходимо написать программу розыгрыша игрушек в магазине детских товаров.
Стараемся применять ООП и работу с файлами.

### Желательный функционал программы:
* В программе должен быть минимум один класс со следующими свойствами:
    * id игрушки
    * текстовое название
    * количество
    * частота выпадения игрушки (вес в % от 100)
* Метод добавление новых игрушек и возможность изменения веса (частоты выпадения игрушки)
* Возможность организовать розыгрыш игрушек.

Например, следующим образом:

С помощью метода выбора призовой игрушки – мы получаем эту призовую игрушку и записываем в список\массив.
Это список призовых игрушек, которые ожидают выдачи.
Еще у нас должен быть метод – получения призовой игрушки.
После его вызова – мы удаляем из списка\массива первую игрушку и сдвигаем массив. А эту игрушку записываем в текстовый файл.
Не забываем уменьшить количество игрушек.

К написанию программы можно подойти более творчески и делать так, как Вы поняли задание. Немного менять и отходить от примера выше.

## Результат
Запуск программы из Main.

При запуске появится меню со списком команд:
1. Розыгрыш игрушки (список доступных игрушек не должен быть пустым, выигрыш записывается в лист ожидания)
2. Получить приз (получение первого приза из списка ожидания)
3. Настройки
4. Выход

Список настроек:
1. Добавить новую игрушку (ввести название, количество и вес, запись в файл)
2. Изменить вероятность выпадения игрушки (выбрать игрушку по id и ввести новый вес)
3. Увеличить количество игрушек (выбрать игрушку по id и ввести количество игрушек для добавления)
4. Уменьшить количество игрушек (выбрать игрушку по id и ввести количество игрушек для удаления, возможно полное удаление игрушки)
5. Удалить игрушку (выбрать игрушку по id и подтвердить действие)
6. Посмотреть количество призов 
7. Посмотреть список игрушек
8. Выход из настроек

Все добавляемые игрушки и изменения, а также разыгранные призы, записываются в файл (путь указан в файле Config).
Если список игрушек пуст, то некоторые команды становятся недоступными. 

При первом запуске программы создаются файлы для хранения данных (список подарков и очередь на получение призов). Далее нужно добавить игрушки для участия в розыгрыше. 

Игрушки с одинаковыми данными добавятся под разным id (как разные партии). Чтобы изменить количество игрушек или вероятность выпадения, нужно использовать соответствующие настройки.

После каждого розыгрыша приз удаляется из списка подарков и добавляется в конец списка на получение (с указанием имени победителя). Если какая-то игрушка заканчивается, то она удаляется из списка подарков.

При получении приза выдается первая игрушка из списка ожидания и вся очередь сдвигается.

При повторном запуске программы подтягиваются данные из файлов, если они не пустые, и работа продолжается.