function httpGet(theUrl)
{
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", theUrl, false ); // false for synchronous request
    xmlHttp.send( null );
    return xmlHttp.responseText;
}

function editPersonA() 
{
	var response = httpGet("http://localhost:8080/PromptGenerator/PromptGenerator?subject=personA");
	document.getElementById("personAParagraph").innerHTML = response;
} 

function editRelationship() 
{
	console.log('sono nella funzione :D');
	var response = httpGet("http://localhost:8080/PromptGenerator/PromptGenerator?subject=relationship");
	document.getElementById("relationshipParagraph").innerHTML = response;
	console.log(response);
} 

function editPersonB() 
{
	var response = httpGet("http://localhost:8080/PromptGenerator/PromptGenerator?subject=personB");
	document.getElementById("personBParagraph").innerHTML = response;
}

function editPlace() 
{
	var response = httpGet("http://localhost:8080/PromptGenerator/PromptGenerator?subject=place");
	document.getElementById("placeParagraph").innerHTML = response;
}

function editTime() 
{
	var response = httpGet("http://localhost:8080/PromptGenerator/PromptGenerator?subject=time");
	document.getElementById("timeParagraph").innerHTML = response;
}

function editObject() 
{
	var response = httpGet("http://localhost:8080/PromptGenerator/PromptGenerator?subject=object");
	document.getElementById("objectParagraph").innerHTML = response;
}

function editSong() 
{
	var response = httpGet("http://localhost:8080/PromptGenerator/PromptGenerator?subject=song");
	var elementi = response.split(", ");
	var songName = elementi[0];
	var songLink = elementi[1];
	document.getElementById("songParagraph").innerHTML = songName;
	document.getElementById("songParagraph").setAttribute("href", songLink);

}

function onMouseOver() {
	document.getElementById("deleteText").innerHTML = "Click on the element to delete it";
}

function onMouseLeave() {
	document.getElementById("deleteText").innerHTML = "";
}

function removeText(id) {
	document.getElementById(id).innerHTML = "";
}