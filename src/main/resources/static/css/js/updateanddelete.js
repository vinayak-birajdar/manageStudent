// Function to toggle edit mode for a specific row
function toggleEditMode(row) {
    const cells = row.querySelectorAll('td[contenteditable]');
    const isEditable = row.dataset.editable === "true";

    if (isEditable) {
        // save mode
        cells.forEach(cell => cell.contentEditable = "false");
        row.dataset.editable = "false";
        row.querySelector('.edit-btn').innerText = "Edit";
    } else {
        //edit mode
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
        name: cells[0].innerText.trim(),
        age: cells[1].innerText.trim(),
        classDiv: cells[2].innerText.trim(),
        phoneNumber: cells[3].innerText.trim()
    };
}
