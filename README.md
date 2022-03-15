

# Tic-Tac-Toe
  
Its a full-stack tic-tac-toe application with Maven based **SpringBoot** backend and **Node-js** frontend using **Express-js** framework. This app is integrated with **Swagger** , tested with **Junit** and **MongoDB** is used for database. SpringBoot serves **REST** services so that frontend part can communicate. I depolyed this full stack project on Heroku so I suggest to take a look directly - https://tictactoe-jawad.herokuapp.com/

*** 
<div id="top"></div>

<!-- TABLE OF CONTENTS -->

## Table of Contents

  <ol>
    <li>
      <a href="#about2">About The Project</a>
      <ul>
        <li><a href="#build3">Structure</a></li>
      </ul>
    </li>
    <li><a href="#usage2">Usage</a>
        <ul>
        <li><a href="#backendUsage">Back-end usage</a></li>
        <li><a href="#frontendUsage">Front-end usage</a></li>
      </ul>
    </li>
    <li><a href="#features">Features</a></li>
    <li><a href="#contact2">Contact</a></li>
  </ol>


***
<div id="about2"></div>


<!-- ABOUT THE PROJECT -->

## About The Project

In this project, I created a fullstack project for <b>N x N</b> Tic-tac-toe application where <i>3 ≤ <b>n</b> ≤ 12</i>. The frontend and backend are developed independently, with the frontend responsible for I/O and style and the backend responsible for functionality and logics. The backend is RESTful. The frontend makes API requests to the backend and receives payload. All the API shown <a href="#usage2">here</a> and in <a href="#features">swagger</a> integration part. Backend keeps all the sucessful validation result in the database, I've used mongoDB atlas microservice which is <a href="backend/src/main/java/com/example/tictactoe/config/MongoDbConfig.java">configured</a> from backend. Later, I added unit testing with Junit and Mockito.


<p align="right">(<a href="#top">back to top</a>)</p>

***
<div id="build3"></div>

## Structure
  
* ### Dependency
  * **Backend** 
    Dependecy imported and used for SpringBoot framework -
    * Spring Data MongoDB
    * Spring Web
    * Spring Boot DevTools
    * Junit
    * Springfox-swagger
  * **Frontend** 
    Dependecies used in Node.js -
    * Axios
    * Express.js
    * Confetti.js
* ### Directory
  *  <details><summary>
	  <b>Backend</b><br>  
      </summary>
	    abced
      </details>

  *  <details><summary>
	  <b>Frontend</b><br>  
      </summary>
	    abced
      </details>


<p align="right">(<a href="#top">back to top</a>)</p> 

***
<div id="build2"></div>



<div id="usage2"></div>


<!-- USAGE EXAMPLES -->
## Usage

<div id="backendUsage"></div>


### <ins>Backend end-points -</ins> 
<b>Dropdown</b> to see images of usage. 
<details>
<summary>
	Validating any query, <b>POST</b> : <a>https://tictac-toe-backend.herokuapp.com/validate</a> <br>  
	Sample JSON for this request: <b>🔻expand🔻</b>

	{
      "nxn": 4,
      "moves": 
        [
          {
              "playerType": "CIRCLE","coOrdinateX": 0,"coOrdinateY": 0
          },
          {
              "playerType": "CROSS","coOrdinateX": 1,"coOrdinateY": 1
          }      
        ]
    }

</summary>
	<img src="images/validate.png">
</details>


<details>
<summary>
	Getting all match details, <b>GET</b> : <a>https://tictac-toe-backend.herokuapp.com/history </a><b>🔻expand🔻</b> <br> 

</summary>
	<img src="images/history.png">
</details>
<br>

<div id="frontendUsage"></div>


### <ins>Front-end views -</ins> 
<b>Dropdown</b> to see images of usage. 



<details>
<summary>
	Front page view : <a>https://tictactoe-jawad.herokuapp.com/</a> <b>🔻expand🔻</b><br>  
		
</summary>
	<img src="images/setup.png">
</details>

<details>
<summary>
	After setup the game in front page, game page view : <a>https://tictactoe-jawad.herokuapp.com/#game</a><b>🔻expand🔻</b> <br>  
		
</summary>
	<img src="images/game.png">
</details>

<details>
<summary>
	Game history : <a>https://tictactoe-jawad.herokuapp.com/#history</a><b>🔻expand🔻</b> <br>  
		
</summary>
	<img src="images/history2.png">
</details>




<p align="right">(<a href="#top">back to top</a>)</p>




***
<div id="features"></div>


## Features

<details>
<summary>
	Swagger is integrated and can be access at : <a>https://tictac-toe-backend.herokuapp.com/swagger-ui.html</a><b>🔻expand🔻</b> <br>  
		
</summary>
	<img src="images/swagger.png">
</details>

<details>
<summary>
	View of the database, using mongoDB compass : <b>🔻expand🔻</b> <br>  	
</summary>
	<img src="images/compass.png">
</details>

<details>
<summary>
	Custom exceptions are handled, which returns json payload with proper info without server side crash <b>🔻expand🔻</b> <br>  
		
</summary>
	<img src="images/null.png">
</details>

<details>
<summary>
	Tests are included, which can be found <a href="backend/src/test/java/com/example/tictactoe/GameUserServiceTest.java">here</a>.  
		
</summary>
</details>


<p align="right">(<a href="#top">back to top</a>)</p>



<div id="contact2"></div>


<!-- CONTACT -->
## Contact

You may contact with me via mail if needed. All necessary contact info are given at - <a href="https://hurutta.github.io"> my website. <a>


<p align="right">(<a href="#top">back to top</a>)</p>

