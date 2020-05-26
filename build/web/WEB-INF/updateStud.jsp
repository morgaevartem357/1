<%-- 
    Document   : editStudView
    Created on : 27.04.2018, 0:39:04
    Author     : HP
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Stud</title>
    </head>
    <body>
       <h3>Edit Student</h3>
       <c:if test="${not empty Student}">
       <form method="POST" action="${pageContext.request.contextPath}/updateStud">
         <table border="0">
            <tr>
               <td>Номер зачетки</td>
               <td><input type="text" name="NomerZachetki" value="${Student.getNomerZachetki()}" /></td>
            </tr>
            <tr>
               <td>Фамилия</td>
               <td><input type="text" name="Familiya" value="${Student.getFamiliya()}" /></td>
            </tr>
            <tr>
               <td>Имя</td>
               <td><input type="text" name="Imya" value="${Student.getImya()}" /></td>
            </tr>
            <tr>
               <td>Отчество</td>
               <td><input type="text" name="Otchestvo" value="${Student.getOtchestvo()}" /></td>
            </tr>
            <tr>
               <td>Город</td>
               <td><input type="text" name="Gorod" value="${Student.getGorod()}" /></td>
            </tr>
            <tr>
               <td>Группа</td>
               <td><select  name="Gruppyi" >
                       <%----%>
                <c:forEach items="${grList}" var="gr">
                    <option   ${gr.getShifr()==Student.getGruppyi().getShifr()? "selected" :"" }   value ="${gr.getShifr()}">${gr.getNazvanie()}</option>
                </c:forEach>
                 </select></td>
            </tr>
            <tr>
               <td>Адрес</td>
               <td><input type="text" name="Adres" value="${Student.getAdres()}" /></td>
            </tr>
            <tr>
               <td>Телефон</td>
               <td><input type="text" name="Tel" value="${Student.getTel()}" /></td>
            </tr>
            <tr>
               <td>Статус</td>
               <td><input type="text" name="Status" value="${Student.getStatus()}" /></td>
            </tr>
            <tr>
               <td colspan="2">                   
                   <input type="submit" value="Submit" />
                   <a href="studentsTable">Cancel</a>
               </td>
            </tr>
         </table>
      </form>
       </c:if> 
    </body>
</html>
