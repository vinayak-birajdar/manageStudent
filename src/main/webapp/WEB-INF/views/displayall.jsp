<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Display Students</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/displayall.css">
</head>
<body>
    <div class="container">
        <h2>Student Details</h2>

        <!-- Student Table -->
        <table class="student-table" id="studentTable">
            <thead>
                <tr>
                    <th>Roll No</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Class</th>
                    <th>Phone Number</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <!-- Loop through each student and display in table -->
                <c:forEach var="student" items="${studentss}">
                    <tr data-editable="false">
                        <td contenteditable="false">${student.rollNo}</td>
                        <td contenteditable="false">${student.name}</td>
                        <td contenteditable="false">${student.age}</td>
                        <td contenteditable="false">${student.classDiv}</td>
                        <td contenteditable="false">${student.phoneNumber}</td>
                        <td>
                            <button type="button" class="btn edit-btn" onclick="toggleEditMode(this.closest('tr'))">Edit</button>
                            <button type="button" class="btn" onclick="updateStudent(this)">Update</button>
                            <button type="button" class="btn" onclick="deleteStudent(this)">Delete</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>


        <div id="noStudentsMessage" style="display: none; margin-top: 20px;">No students found.</div>
    </div>

    <script>
        // Check if the student table has no rows and show the "No students found" message
        document.addEventListener("DOMContentLoaded", function () {
            const studentTable = document.getElementById('studentTable');
            const noStudentsMessage = document.getElementById('noStudentsMessage');

            // Check if the table body is empty (excluding the headers)
            if (studentTable.rows.length === 1) {
                noStudentsMessage.style.display = 'block';
            } else {
                noStudentsMessage.style.display = 'none';
            }
        });

        // Function to toggle edit mode for a specific row
        function toggleEditMode(row) {
            const cells = row.querySelectorAll('td[contenteditable]');
            const isEditable = row.dataset.editable === "true";

            if (isEditable) {
                cells.forEach(cell => cell.contentEditable = "false");
                row.dataset.editable = "false";
                row.querySelector('.edit-btn').innerText = "Edit";
            } else {
                cells.forEach(cell => cell.contentEditable = "true");
                row.dataset.editable = "true";
                row.querySelector('.edit-btn').innerText = "Save";
            }
        }

        // Function to handle the Update action
        function updateStudent(button) {
            const row = button.closest('tr');
            const formData = getRowData(row);

            fetch('/updateStudent', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(formData)
            })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Failed to update student.');
                }
                return response.text();
            })
            .then(data => {
                alert(data);
            })
            .catch(error => {
                alert('Error updating student: ' + error.message);
            });
        }

        // Function to handle the Delete action
        function deleteStudent(button) {
            const row = button.closest('tr');
            const formData = getRowData(row);

            fetch('/deleteStudent', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(formData)
            }).then(response => {
                if (response.ok) {
                    alert('Student deleted successfully!');
                    row.remove();
                } else {
                    alert('Failed to delete student. Status: ' + response.status);
                }
            }).catch(error => {
                alert('Error deleting student: ' + error.message);
            });
        }

        // Helper function to extract row data
        function getRowData(row) {
            const cells = row.querySelectorAll('td');
            return {
                rollNo: cells[0].innerText.trim(),
                name: cells[1].innerText.trim(),
                age: cells[2].innerText.trim(),
                classDiv: cells[3].innerText.trim(),
                phoneNumber: cells[4].innerText.trim()
            };
        }
    </script>
</body>
</html>
