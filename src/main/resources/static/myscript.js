function loadCitizens() {
    const CURRENT_URL = window.location.host
    fetch('http://' + CURRENT_URL + '/citizens')
        .then(response => response.json())
        .then(listOfCitizens => {
            listOfCitizens.forEach(function (citizen) {
                // var tbodyElement = document.getElementById("citizenBody");
                const tbodyElement = $("#citizenBody");
                const newRowElement = generateNewRow([citizen['id'], citizen['birthDate'], citizen['address'], citizen['country'], citizen['firstname']]);
                tbodyElement.append(newRowElement);
            });
        });
}

function generateNewRow(citizenValues) {
    var trElement = $('<tr>');
    citizenValues.forEach(function (value) {
        const td = $('<td>').text(value);
        trElement.append(td);
    })
    return trElement;
}

function cleanCitizens() {
    $('#citizenBody').empty();
}

function addNewUser() {
    const newUser = {
        "id": $("#newId").val(),
        "address": $("#newAddress").val(),
        "country": $("#newCountry").val(),
        "birthDate": $("#newBirthDate").val() + " 00:00:00",
        "firstname": $("#newFirstName").val(),
    };

    const options = {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(newUser)
    };

    const CURRENT_URL = window.location.host
    fetch('http://' + CURRENT_URL + '/citizens', options)
        .then(response => response.json())
        .then(listOfCitizens => {
            console.log("user was added! " + listOfCitizens)
        }).catch(error => {
        console.log("user not added! " + error)
    })
}

function showEmployee() {
    const options = {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        }
    };

    const CURRENT_URL = window.location.host
    fetch('http://' + CURRENT_URL + '/employees/100', options)
        .then(response => response.json())
        .then(employee => {
            console.log("employee" + employee)
            $("#employeeId").text(JSON.stringify(employee))
        }).catch(error => {
        console.log("employee not added! " + error)
    })
}