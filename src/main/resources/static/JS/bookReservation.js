let patients = [];
let modalities = [];

window.addEventListener("load", async ()=> {
    patients = await getPatients();
    modalities = await getModalities();
    render();
});


document.addEventListener("DOMContentLoaded", ()=> {

    document.getElementById("reservationForm").addEventListener("submit", (e) => {
        e.preventDefault();
        const formData = new FormData(e.target);
        console.log(formData);
       bookAppointment(formData.get("patient"), formData.get("modality"),formData.get("bodyRegion"),formData.get("comment"), formData.get("dateTime"));
    });


});

async function bookAppointment(patientId, modalityId,bodyRegion, comment, datetime) {
    const data = {
        "patient": patientId,
        "modality": modalityId,
        "bodyRegion": bodyRegion,
        "comment": comment,
        "reservationDate": datetime,
    }
    try {
        const res = await fetch("/reservation/add", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        }).catch(e => console.log(e));

        if (res.status === 200) {
            alert("Appointment successfully booked");
            document.getElementById("reservationForm").reset();
        } else {
            alert("Failed to book appointment");
        }
    }
    catch (e) {
        alert("An error occurred while booking the appointment");
        console.error(e);
    }


}


async function getPatients() {
    const res = await fetch("/patient/getAll",{
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        }
    });
    return await res.json();
}

async function getModalities() {
    const res = await fetch("/modalities/getAll",{
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        }
    });
    return await res.json();
}

function render(){
    if(patients.length !==0){
        document.getElementById("patient").innerHTML += patients.map(p => `<option value="${p.id}">${p.firstname}, ${p.surname}, ${p.svnr}, ${p.birth}, ${p.gender}</option>`).join("");

    }
    if(modalities.length !== 0){
        document.getElementById("modality").innerHTML += modalities.map(m => `<option value="${m.id}">${m.type}, ${m.location}</option>`).join("");

    }

}