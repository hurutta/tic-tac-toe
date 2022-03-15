const http = require('http');
const express = require('express');
const path = require('path');
const app = express();
app.use(express.json());
app.use(express.static("public"));
// default URL for website
app.use('/', function(req,res){
    res.sendFile(path.join(__dirname+'/public/index.html'));
    //__dirname : It will resolve to your project folder.
  });
const server = http.createServer(app);

var port = process.env.PORT || 8080;
app.listen(port);
console.log('server started '+ port);
