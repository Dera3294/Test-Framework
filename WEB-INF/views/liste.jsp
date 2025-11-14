<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Liste des notes - ${nom}</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
            margin: 0;
            padding: 40px;
            color: #333;
        }
        .container {
            max-width: 800px;
            margin: auto;
            background: white;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 8px 25px rgba(0,0,0,0.1);
        }
        h1 {
            color: #2c3e50;
            text-align: center;
            margin-bottom: 10px;
        }
        .subtitle {
            text-align: center;
            color: #7f8c8d;
            font-size: 1.1em;
            margin-bottom: 30px;
        }
        .notes-container {
            background: #f8f9fa;
            padding: 20px;
            border-radius: 8px;
            border-left: 5px solid #3498db;
        }
        .note-item {
            display: inline-block;
            background: #3498db;
            color: white;
            font-weight: bold;
            padding: 10px 18px;
            margin: 8px;
            border-radius: 50px;
            font-size: 1.1em;
            min-width: 50px;
            text-align: center;
            box-shadow: 0 2px 5px rgba(0,0,0,0.2);
        }
        .stats {
            margin-top: 25px;
            padding: 15px;
            background: #ecf0f1;
            border-radius: 8px;
            font-size: 1.1em;
        }
        .stats span {
            font-weight: bold;
            color: #2c3e50;
        }
        .footer {
            text-align: center;
            margin-top: 40px;
            color: #95a5a6;
            font-size: 0.9em;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Notes de ${nom}</h1>
    <p class="subtitle">Voici la liste complète des notes obtenues</p>

    <div class="notes-container">
        <c:forEach var="note" items="${notes}">
            <div class="note-item">${note}</div>
        </c:forEach>
    </div>

    <div class="stats">
        <p>
            <span>${notes.size()}</span> note(s) au total
            <c:if test="${not empty notes}">
                — Moyenne : 
                <span>
                    <c:set var="somme" value="0" />
                    <c:forEach var="n" items="${notes}">
                        <c:set var="somme" value="${somme + n}" />
                    </c:forEach>
                    ${somme / notes.size()}
                </span>
            </c:if>
        </p>
    </div>

    <div class="footer">
        Généré avec ModelView • Framework MVC léger
    </div>
</div>

</body>
</html>