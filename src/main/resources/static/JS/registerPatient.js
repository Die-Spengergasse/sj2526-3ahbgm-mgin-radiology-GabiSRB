
document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("myForm");

    document.getElementById("myForm").addEventListener("submit", (e) => {
        e.preventDefault();
        const formData = new FormData(form);

       register(formData.get("socialNumber"), formData.get("surname"), formData.get("firstname"), formData.get("gender"), formData.get("dateOfBirth"));
    })

})

async function register(sn,surname,firstname,gender,date) {
    console.log(firstname,gender,date, sn, surname);
    const data={
        "firstname":firstname,
        "surname":surname,
        "svnr":sn,
        "gender":gender,
        "birth":date
    }
    try {
      const res = await fetch("patient/add", {
             method: "POST",
                headers: {
                 "Content-Type": "application/json"
                },
             body: JSON.stringify(data)
           }).catch(e => console.log(e));

      if (res.status === 200) {
        alert("Patient successfully added");
      } else {
        alert("Failed to add patient");
      }
    }
    catch (e) {
        alert("An error occurred while adding the patient");
        console.error(e);
    }
}