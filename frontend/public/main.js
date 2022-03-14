var squares = Array(25).fill('');
var nxn_=5;
var body = { nxn: nxn_, moves: [] };

//Squares Html variable
var squareHtml  = '<div className="board-row">';
var xIsNext = true;
var winner  = false;
// Render squares
for(let i=0; i<squares.length;i++){
  if(i % 5 === 0 && i > 0){
    squareHtml += '</div><div className="board-row">';
    squareHtml += buildSquare(i,squares.length);
  }else{
    squareHtml += buildSquare(i,squares.length);
  }
}
squareHtml += '</div>';
document.getElementById('board').innerHTML = squareHtml;
/*
 * Render square 
 * @param int
 */ 
function buildSquare(j,nxn){
  var ret;
  if(nxn === 9) ret = '<button class="square3" onClick="handleClick('+j+')" id="sq_'+j+'">'+squares[j]+'</button>';
  if(nxn === 16) ret = '<button class="square4" onClick="handleClick('+j+')" id="sq_'+j+'">'+squares[j]+'</button>';
  if(nxn === 25) ret = '<button class="square5" onClick="handleClick('+j+')" id="sq_'+j+'">'+squares[j]+'</button>';
  if(nxn === 36) ret = '<button class="square6" onClick="handleClick('+j+')" id="sq_'+j+'">'+squares[j]+'</button>';
  if(nxn === 49) ret = '<button class="square7" onClick="handleClick('+j+')" id="sq_'+j+'">'+squares[j]+'</button>';
  if(nxn === 64) ret = '<button class="square8" onClick="handleClick('+j+')" id="sq_'+j+'">'+squares[j]+'</button>';
  if(nxn === 81) ret = '<button class="square9" onClick="handleClick('+j+')" id="sq_'+j+'">'+squares[j]+'</button>';
  if(nxn === 100) ret = '<button class="square10" onClick="handleClick('+j+')" id="sq_'+j+'">'+squares[j]+'</button>';
  if(nxn === 121) ret = '<button class="square11" onClick="handleClick('+j+')" id="sq_'+j+'">'+squares[j]+'</button>';
  if(nxn === 144) ret = '<button class="square12" onClick="handleClick('+j+')" id="sq_'+j+'">'+squares[j]+'</button>';
  return ret;
}

/*
 * Square box click handler
 * @param int
 */
function handleClick(index){
  if(winner || squares[index]){
    return ;
  }


    document.getElementById("game_status").innerHTML = "Game In Progress";


  
  squares[index] = xIsNext ? 'X' : 'O';
  
  var xx = Math.floor(index / nxn_);
  var yy = index - (xx*nxn_);
  var player = "CIRCLE";
  if(xIsNext) player = "CROSS";
  var move = { playerType: player,coOrdinateX: xx, coOrdinateY: yy };
  body.moves.push(move);


  const sqs = squares.slice();
  var elementId = "sq_"+index;
  document.getElementById(elementId).innerHTML = xIsNext ? '<span style="color: red">X</span>' : '<span style="color: blue">O</span>';
  xIsNext = xIsNext ? false : true;
  console.log(squares);
  //calculateWinner(sqs);
}




function play(nxn) 
{

    document.getElementById("game_status").innerHTML = "Game Start";


    if(nxn == null) nxn = nxn_;
    else nxn_ = nxn;    
    var x = document.getElementById("result").innerHTML;
    if(x.slice(-1) == '!') document.getElementById("result").innerHTML = "";


    document.getElementById("n_x_n").innerHTML = nxn_ + " x " + nxn_;


    winner = false;
    squares = Array(nxn * nxn).fill('');
    body = { nxn: nxn_, moves: [] };


    squareHtml  = '<div className="board-row">';

  // Render squares
  for(let i=0; i<squares.length;i++){
    if(i % nxn === 0 && i > 0){
      squareHtml += '</div><div className="board-row">';
      squareHtml += buildSquare(i,squares.length);
    }else{
      squareHtml += buildSquare(i,squares.length);
    }
  }
  squareHtml += '</div>';
  document.getElementById('board').innerHTML = squareHtml;
  toggleSide();
}

function myFunction2()
{
    let uri = 'http://localhost:8080/newgame/4';

    //var query = {username: usrname, password: hash, userData: [{ websiteUrl: "Demo website" , websitePassword: "DemoPassword" }] };
    this.axios.post(uri).then(response => 
    console.log(response.data)); //alert("Account Created, Login to access")
    console.log(123);
}


function toggleSide()
{
    const checked = document.querySelector('#myCheck:checked') !== null;
    
    if(checked)
    {
        document.getElementById("tp").innerHTML = "⭕";
    }else
    {
        document.getElementById("tp").innerHTML = "❌";
    }


    if(checked == true)
    {
        xIsNext = false;
    }else
    {
        xIsNext = true;
    }
}   

function note(msj)
{
        notie.alert({ text: msj });
}






////////////////////
let tableHead = [
  { No: "", Winner: "", Board: "", NoOfMoves: "" }];


function generateTableHead(table, data) {
  let thead = table.createTHead();
  let row = thead.insertRow();
  for (let key of data) {
    let th = document.createElement("th");
    let text = document.createTextNode(key);
    th.appendChild(text);
    row.appendChild(th);
  }
}

function generateTable(table, data) 
{
    for (let i=data.length-1; i>=0; i--) 
    {
        let row = table.insertRow();


      let cell = row.insertCell();
      let text = document.createTextNode(i+1);
      cell.appendChild(text);
      
      cell = row.insertCell();
      text = document.createTextNode(data[i].winner);
      cell.appendChild(text);
      
      cell = row.insertCell();
      text = document.createTextNode(data[i].board.nxn+" x "+data[i].board.nxn);
      cell.appendChild(text);

      cell = row.insertCell();
      text = document.createTextNode(data[i].totalMove);
      cell.appendChild(text);
    }
}


function dataFetch()
{
    let uri = 'http://localhost:8080/history';

    this.axios.get(uri).then(response =>{ 
    
    let table = document.querySelector("table");
    table.innerHTML = "";

    let data = Object.keys(tableHead[0]);
    generateTableHead(table, data);
    generateTable(table, response.data);
    chart(response.data);
    }); //alert("Account Created, Login to access")
}

dataFetch();








function validate()
{
    
    if(body.moves.length == 0)
    {
        note("No Moves played yet");
        return;
    }


    let uri = 'http://localhost:8080/validate';
    this.axios.post(uri,body).then(response =>{ 
    //console.log(response.data);

    if(response.data == "Not determined, More move possible")
    {
        note(response.data);
    }else
    if(response.data == "Match draw")
    {
        document.getElementById("game_status").innerHTML = "Game Over";
        winner = true;
        document.getElementById("result").innerHTML = response.data;
    }else
    {
        document.getElementById("game_status").innerHTML = "Game Over";

        cnfetti();
        winner = true;
        document.getElementById("result").innerHTML = response.data;
    }

    });


}

////////////////////////////////////////////////////////////////
function cnfetti()
{
    var duration = 2 * 1000;
    var animationEnd = Date.now() + duration;
    var defaults = { startVelocity: 30, spread: 250, ticks: 600, zIndex: 0 };

    function randomInRange(min, max) {
      return Math.random() * (max - min) + min;
    }

    var interval = setInterval(function() {
      var timeLeft = animationEnd - Date.now();

      if (timeLeft <= 0) {
        return clearInterval(interval);
      }

      var particleCount = 50 * (timeLeft / duration);
      // since particles fall down, start a bit higher than random
      confetti(Object.assign({}, defaults, { particleCount, origin: { x: randomInRange(0.1, 0.3), y: Math.random() - 0.2 } }));
      confetti(Object.assign({}, defaults, { particleCount, origin: { x: randomInRange(0.7, 0.9), y: Math.random() - 0.2 } }));
    }, 250);
}
///////////////////////////////
function chart(data) 
{
    var circle = 0;
    var cross = 0;
    let array = new Array(12); for (let i=0; i<=12; ++i) array[i] = 0;
    var n = data.length;

    for (let i=data.length-1; i>=0; i--) 
    {
        if(data[i].winner == 'CIRCLE')
        {
            circle++;
        }else
        {
            cross++;
        }
        array[data[i].board.nxn]++;
    }

    var chart = new CanvasJS.Chart("chartContainer", {
    animationEnabled: true,
    title: {
        text: "Win ratio"
    },
    data: [{
        type: "pie",
        startAngle: 240,
        yValueFormatString: "##0.00\"%\"",
        indexLabel: "{label} {y}",
        dataPoints: [
            {y: (circle/(cross+circle))*100.0, label: "CIRCLE"},
            {y: (cross/(cross+circle))*100.0, label: "CROSS"},
        ]
    }]
});
chart.render();

chart = new CanvasJS.Chart("chartContainer2", {
    animationEnabled: true,
    title: {
        text: "Board ratio"
    },
    data: [{
        type: "pie",
        startAngle: 240,
        yValueFormatString: "##0.00\"%\"",
        indexLabel: "{label} {y}",
        dataPoints: [
            {y: (array[3]/n)*100.0, label: "3 x 3"},
            {y: (array[4]/n)*100.0, label: "4 x 4"},
            {y: (array[5]/n)*100.0, label: "5 x 5"},
            {y: (array[6]/n)*100.0, label: "6 x 6"},
            {y: (array[7]/n)*100.0, label: "7 x 7"},
            {y: (array[8]/n)*100.0, label: "8 x 8"},
            {y: (array[9]/n)*100.0, label: "9 x 9"},
            {y: (array[10]/n)*100.0, label: "10 x 10"},
            {y: (array[11]/n)*100.0, label: "11 x 11"},
            {y: (array[12]/n)*100.0, label: "12 x 12"},
        ]
    }]
});
chart.render();
}

//match in progress
//aws s3 image bucket 
