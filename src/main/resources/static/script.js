async function search() {

 const q = document.getElementById("query").value;

 const response = await fetch("/search?q=" + q);

 const data = await response.json();

 document.getElementById("result").textContent =
   JSON.stringify(data,null,2);

 const blob = new Blob([JSON.stringify(data)],{type:"application/json"});

 const link = document.createElement("a");

 link.href = URL.createObjectURL(blob);
 link.download = "results.json";
 link.click();
 }