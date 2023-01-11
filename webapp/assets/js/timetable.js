let timetable = document.getElementById("timetable");
timetable.addEventListener('submit',async(e) =>{
    e.preventDefault();
    e.stopPropagation();


    let response = await fetch('http://localhost:8080/demo-1.0-SNAPSHOT/api/employee/courseid', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json;charset=utf-8'
    },
    body: JSON.stringify({
        roll_number : localStorage.getItem("roll_number")
    })
});
try {
    let result = await response.json();
    
    
    localStorage.setItem("data",JSON.stringify(result));
}
catch (err){
    console.log(err);
}

})
