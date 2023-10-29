<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Course List ::</title>
    <%--    <link rel="stylesheet" type="text/css" href="assets/bootstrap-4.5/css/bootstrap.min.css"/>--%>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
          crossorigin="anonymous">
</head>
<body>
<div class="container m-auto bg-light w-75">
    <div class="row w-100 h2">Courses List ::</div>
    <div class="row w-100">
        <form class="form-inline" action="course-list" method="post">
            <div class="form-group mx-4">
                <label for="semester" class="mr-4">Select Semester : </label>
                <select name="semester" id="semester" class="px-4">
                    <c:forEach items="${semesters}" var="semester"
                               varStatus="vs">
                        <c:if test="${semester != null}">
                            <option value="${vs.index}" ${vs.index==selectedSemester ? 'selected':''}>${semester}</option>
                        </c:if>
                    </c:forEach>
                </select>
                <div class="px-3"><input type="submit" value="Search"></div>
                <div class="pl-10 flex-box">
                    <button style="border: 1px solid cadetblue"><a
                            href="index.jsp">Back</a></button>
                </div>
            </div>
        </form>
    </div>
    <c:if test="${subjects != null}">
        <div class="container m-auto h-auto">
            <form action="register" method="post">
                <input type="hidden" name="semester"
                       value="${selectedSemester}">
                <div class="row bg-white">
                    <div class="col-1">ลำดับ</div>
                    <div class="col-1">รหัส</div>
                    <div class="col-5">ชื่อวิชา</div>
                    <div class="col-1">หน่วยกิต</div>
                    <div class="col-1">เลือก</div>
                </div>
                <c:forEach items="${subjects}" var="subject" varStatus="vs">
                    <div class="row bg-transparent">
                        <div class="col-1">${vs.count}</div>
                        <div class="col-1">${subject.subjectId}</div>
                        <div class="col-6">${subject.title}</div>
                        <div class="col-1">${subject.credit}</div>
                        <div class="col-1">
                            <input type="checkbox" name="registeredSubjects"
                                ${existingSubjects[subject.subjectId] ? 'checked' : ''}
                                   value="${subject.subjectId}">
                        </div>
                    </div>
                </c:forEach>
                <hr>
                <div class="form-group"><input type="submit"></div>
            </form>
        </div>
    </c:if>
</div>
</body>
</html>
