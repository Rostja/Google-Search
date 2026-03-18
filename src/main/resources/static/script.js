let results = [];

async function search() {

 const q = document.getElementById("query").value;

 const response = await fetch("/search?q=" + q);

 results = await response.json();

 const content = document.getElementById("content");
 content.innerHTML = "";

 if (results.length === 0) {
     document.getElementById("demo").innerHTML = "No results found";
     return;
   }

   results.forEach(item => {

       const link = document.createElement("a");
       link.href = item.url;
       link.textContent = item.title;
       link.target = "_blank";

       content.appendChild(link);
       content.appendChild(document.createElement("br"));
     });
 }

 function downloadJSON() {
    if (results.length === 0) {
    alert("No JSON data to download");
    return;
 }

 const blob = new Blob([JSON.stringify(results,null, 2)],{type: "application/json"});

 const link = document.createElement("a");

 link.href = URL.createObjectURL(blob);
 link.download = "results.json";
 link.click();
 }