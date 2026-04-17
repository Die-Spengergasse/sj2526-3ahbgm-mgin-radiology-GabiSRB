
document.addEventListener("DOMContentLoaded", () => {


    document.getElementById("myForm").addEventListener("submit", (e) => {
        e.preventDefault();
        const formData = new FormData(e.target);

        register({
            "firstname":formData.get("firstname"),
            "surname":formData.get("surname"),
            "svnr":formData.get("socialNumber"),
            "gender":formData.get("gender"),
            "birth":formData.get("dateOfBirth")
        })

    })

})

async function register(patient) {
    document.querySelectorAll("p.status").forEach(p => p.textContent = "");

    try {

      const res = await fetch("patient/add", {
             method: "POST",
                headers: {
                 "Content-Type": "application/json"
                },
             body: JSON.stringify(patient)
           });

      if (res.status === 200) {
        alert("Patient successfully added");
        document.getElementById("myForm").reset();
      } else {
        const errors =await res.json();

        Object.entries(errors).forEach(([key,value]) => {
           document.getElementById(key+"Status").textContent=value;
        });

      }
    }
    catch (e) {
        alert("An error occurred while adding the patient");
        console.error(e);
    }
}