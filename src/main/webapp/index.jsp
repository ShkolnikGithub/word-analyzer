<%@ page contentType="text/html;charset=utf-8" %>

<html>
<head>
    <title>Welcome page</title>
</head>
<body>
<h2>Welcome!</h2>
<p>Для проверки работы приложения, пожалуйста, введите в адресной строке:
    http://localhost:8080/wordanalyzer/analyze?word=test</p>
<p>Для параметра word можно указать любое слово вместо слова "test".</p>
<p>В результате будет выведена та буква, которая встречается в слове наибольшее количество раз
    с указанием числа вхождений. Если несколько букв имеют одинаковое количество вхождений, то
    будет возвращена та буква, которая встречается в слове последней.</p>
</body>
</html>
