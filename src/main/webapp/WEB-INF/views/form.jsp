<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Form</title>
    <!-- Link to External CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/form.css">
    <script>
      // Function to handle the Insert action
      function insertStudent(button) {
          // Gather form data into a JavaScript object
          const rollNo = document.getElementById("rollNo").value;
          const name = document.getElementById("name").value;
          const age = document.getElementById("age").value;
          const classDiv = document.getElementById("classDiv").value;
          const phoneNumber = document.getElementById("phoneNumber").value;

          // Check if rollNo is filled
          if (!rollNo.trim()) {
              alert("Roll Number is required!");
              return;
          }

          // Validate age to be a 3-digit number or less
          if (age.length > 3 || isNaN(age) || age <= 0 || age > 999) {
              alert("Age should be a valid number between 1 and 999!");
              return;
          }


          const formData = {
              rollNo: rollNo,
              name: name,
              age: age,
              classDiv: classDiv,
              phoneNumber: phoneNumber
          };


          fetch('/insertStudent', {
              method: 'POST',
              headers: { 'Content-Type': 'application/json' },
              body: JSON.stringify(formData)
          })
          .then(response => {
              if (!response.ok) {
                  throw new Error('Failed to insert student.');
              }
              return response.text();
          })
          .then(data => {
              alert(data);


              document.getElementById("studentForm").reset();
          })
          .catch(error => {
              alert('Error inserting student: ' + error.message);
          });
      }

    </script>
</head>
<body>
   <div class="form-container">
       <h2>Student Information</h2>
       <form id="studentForm" onsubmit="event.preventDefault(); insertStudent();">
           <!-- RollNo field (newly added) -->
           <div class="form-group">
               <label for="rollNo">Roll Number <span class="required">*</span>:</label>
               <input type="text" id="rollNo" name="rollNo" placeholder="Enter roll number" required>
           </div>

           <!-- Name field -->
           <div class="form-group">
               <label for="name">Name:</label>
               <input type="text" id="name" name="name" placeholder="Enter name" required>
           </div>

           <!-- Age field -->
           <div class="form-group">
               <label for="age">Age:</label>
               <input type="number" id="age" name="age" placeholder="Enter student's age" required>
           </div>

           <!-- Class field -->
           <div class="form-group">
               <label for="classDiv">Class:</label>
               <input type="text" id="classDiv" name="classDiv" placeholder="Enter student's class" required>
           </div>

           <!-- Phone field -->
           <div class="form-group">
              <label for="phoneNumber">Phone Number:</label>
              <input type="number" id="phoneNumber" name="phoneNumber" placeholder="Enter student's phone number" required>
           </div>

           <!-- Submit button -->
           <button type="button" class="btn" onclick="insertStudent()">Submit</button>
       </form>
   </div>
</body>
</html>
