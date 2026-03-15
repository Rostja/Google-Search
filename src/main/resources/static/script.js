async function search() {

 const q = document.getElementById("query").value;

 const response = await fetch("/search?q=" + q);

 const data = await response.json();

 const content = document.getElementById("content");
 content.innerHTML = "";

 if (data.length === 0) {
     document.getElementById("demo").innerHTML = "No results found";
     return;
   }

   data.forEach(item => {

       const link = document.createElement("a");
       link.href = item.url;
       link.textContent = item.keyWord;
       link.target = "_blank";

       content.appendChild(link);
       content.appendChild(document.createElement("br"));
     });

 const blob = new Blob([JSON.stringify(data,null,2)],{type:"application/json"});

 const link = document.createElement("a");

 link.href = URL.createObjectURL(blob);
 link.download = "results.json";
 link.click();
 }