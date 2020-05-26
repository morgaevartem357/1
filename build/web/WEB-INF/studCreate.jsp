<%-- 
    Document   : createStudView
    Created on : 26.04.2018, 23:31:12
    Author     : Inga
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Student</title>
         <style type="text/css">
             
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #D3D3D3;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ffd8ca;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
    </head>
    <body>
       <h3>Create Stud</h3>
       <form method="POST" action="${pageContext.request.contextPath}/studCreate">
           <table border="0" class="tg">
            <tr>
               <td>Nomer Zachetki</td>
               <td><input type="text" name="NomerZachetki" value="" /></td>
            </tr>
            <tr>
               <td>Familiya</td>
               <td><input type="text" name="Familiya" value="" /></td>
            </tr>
            <tr>
               <td>Imya</td>
               <td><input type="text" name="Imya" value="" /></td>
            </tr>
            <tr>
               <td>Otchestvo</td>
               <td><input type="text" name="Otchestvo" value="" /></td>
            </tr>
            <tr>
               <td>Gorod</td>
               <td><input type="text" name="Gorod" value="" /></td>
            </tr>
            <tr>
               <td>Gruppa</td>
               <td><select name="Gruppyi" >
                <c:forEach items="${grList}" var="gr">
                 <option value ="${gr.getShifr()}">${gr.getNazvanie()}</option>
                </c:forEach>
                 </select></td>
            </tr>
            <tr>
               <td>Adres</td>
               <td><input type="text" name="Adres" value="" /></td>
            </tr>
            <tr>
               <td>Telephon</td>
               <td><input type="text" name="Tel" value="" /></td>
            </tr>
            <tr>
               <td>Status</td>
               <td><input type="text" name="Status" value="" /></td>
            </tr>
            <tr>
               <td colspan="2">                   
                   <input type="submit" value="Добавить" />
                   <a href="studentsTable">Назад</a>
               </td>
            </tr>
         </table>
      </form>
       
    </body>
</html>
