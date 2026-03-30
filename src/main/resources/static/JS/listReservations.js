
let modalities = [];

window.onload = async function() {
    modalities = await getModalities();
    render();
}


document.addEventListener("DOMContentLoaded", () => {

});

async function getModalities(){
    const res = await fetch("/modalities/getAll",{
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        }
    });
    return await res.json();
}

function renderModal(details){
    if(details.length !== 0) {
        document.getElementById("status").innerHTML = "";
        document.getElementById("reservations").innerHTML = details.map(detail => `<tr>
            <td>${detail.patientname}</td>
            <td>${detail.patientsvnr}</td>
            <td>${detail.bodyregion}</td>
            <td>${detail.comment}</td>
            <td>${detail.date}</td>
        </tr>`).join("");
        return
    }
    document.getElementById("reservations").innerHTML = "";
    document.getElementById("status").innerHTML = "No reservations found";

}

async function getReservations(element){
    const modality = {
        type: element.getAttribute("data-type"),
        location: element.getAttribute("data-location")
    };
    document.getElementById("exampleModalLabel").textContent ="Reservations from " + modality.type;
    const res = await fetch("/reservation/getPatients", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(modality),
    });

    if(res.ok){
        renderModal(await res.json());
    }
}


function render() {
    const modalityBody = document.getElementById("modalityList");
    if(modalities.length !== 0){
        modalityBody.innerHTML += modalities.map( modality => `<tr>
            <td><a onclick="getReservations(this)" data-type="${modality.type}" data-location="${modality.location}" href="#" data-bs-toggle="modal" data-bs-target="#reservationModal">${modality.type}</a></td>
            <td>${modality.description == null ? "" : modality.description}</td>
            <td>${modality.location}</td>
        </tr>`).join("");
    }


}