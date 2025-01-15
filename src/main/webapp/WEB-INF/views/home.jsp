<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Management</title>
    <!-- Link to External CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
    <script src="${pageContext.request.contextPath}/js/scripts.js"></script>
</head>
<body>
    <div class="container">
        <h1>Student Management</h1>
        <p>Access tools to add, update, and manage student data efficiently.</p>
        <a href="/addStudent" class="btn">Add Student</a>
        <!-- Removed the Update Student button -->
        <a href="/manageStudent" class="btn">Manage Student Data</a>
    </div>

    <!-- Link to External JS -->
    <script src="/resources/js/scripts.js"></script>
</body>
</html>
