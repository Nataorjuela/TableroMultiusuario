let points = { pointsarr: [] };
let timerId = setInterval(() => checkPoints(), 2000);
let timeDraw = setInterval(() => inDraw(), 5000);
let timeNewJson = setInterval(() => recorrerJson(),2000);
let reload = setInterval(() => fun(),1000,false);

let myVar;
let newJson;
let status;
let borrarTodo = setInterval(() => borrar(),1000);

function checkPoints() {
  let msg = points;
  points = { pointsarr: [] };

  fetch("/poin", {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(msg)
  })
    .then(res => res.json())
    .then(result => console.log(result));
}

function setup() {
  createCanvas(640, 480);
}

function draw() {
  if (mouseIsPressed === true) {
    let c = color(204, 0, 255 );
    fill(c);
    ellipse(mouseX, mouseY, 20, 20);
    noStroke();

    points.pointsarr.push([mouseX, mouseY])
  }
  if (mouseIsPressed === false) {
    fill(255, 255, 255);

  }

}

function recorrerJson(){
  fetch("/dibujar", {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    }
  })
    .then(res => res.json())
    .then(res => newJson = res)
    .then(resultado => console.log(resultado));

  for(let i = 0; i < newJson.pointsarr.length; i++) { 
    let c = color(255, 0, 115);
    fill(c);
    ellipse(newJson.pointsarr[i][0], newJson.pointsarr[i][1], 20, 20);
    noStroke();

	}
  
}

function fun(bb){
  var a = true;
  a = bb;
  if(a == false){
    let car = setInterval(() => recargar(),1000);
  }
}

function recargar(){
  myVar = setInterval(function(){ location.reload(); }, 1000);
}

function borrar(){
  fetch("/borrar", {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    }
  })
    .then(res => res.json())
    .then(res => status = res)
    .then(resultado => console.log(resultado));
}
