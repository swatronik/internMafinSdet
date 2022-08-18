//
//
//    //Присваиваем переменной значение из поля inputEquationId
//    //Создаем реквест хттп - отправляем апи запрос по указ эндпоинту - обрабатывать его обработка будет в гетМаппинг контроллере
//
//    function GetDecision() {
//        let inputEquation = document.getElementById("inputEquationId").value;
//           console.log(inputEquation)
//
//        let xmlHttpRequest = new XMLHttpRequest();
//        xmlHttpRequest.open("POST", window.location.href + "postEqualsEquation", false);
//        xmlHttpRequest.send(inputEquation);
//            if (xmlHttpRequest.status != 200) {
//                alert( 'Ошибка: ' + xmlHttpRequest.status);
//                return;
//            }
//        console.log(xmlHttpRequest.response)
//
//        let XmlResponseTextJsonParse = JSON.parse(xmlHttpRequest.responseText);
//            console.log(XmlResponseTextJsonParse);
//
//        var tableModel = "<tr><td>" + XmlResponseTextJsonParse.number + "</td>" +
//            "<td>" + XmlResponseTextJsonParse.equation + "</td>" +
//            "<td>" + XmlResponseTextJsonParse.roots + "</td>" +
//            "<td>" + XmlResponseTextJsonParse.date + "</td></tr>";
//            console.log(tableModel);
//
//        //'tbody' - часть xmlHttpRequest ???
//        var tableObj = document.createElement('tbody');
//        tableObj.innerHTML = tableModel;
//        document.getElementById('table_id_001').appendChild(tableObj);
//     }