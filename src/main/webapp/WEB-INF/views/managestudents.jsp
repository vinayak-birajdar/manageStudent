<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Students</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/managestudents.css">
</head>
<body>
    <div class="container">
        <!-- Title -->
        <h2 class="title">Manage Students Records</h2>

        <!-- Search Section -->
        <div class="search-section">
            <form action="/searchStudent" method="get">
                <input
                    type="text"
                    name="name"
                    placeholder="Enter name to search..."
                    required
                    class="search-input"
                >
                <button type="submit" class="btn">Search</button>
            </form>
        </div>

        <!-- Button Section -->
        <div class="button-section">
            <a href="/addStudent" class="btn">Add New Student</a>
            <a href="/displayAll" class="btn">Display All Students</a>
        </div>
    </div>

    <script src="/resources/js/scripts.js"></script>
</body>
</html>
