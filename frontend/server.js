const http = require('http');
const express = require('express');
const path = require('path');
const app = express();
app.use(express.json());
app.use(express.static("public"));

app.use('/', function(req,res){
    res.sendFile(path.join(__dirname+'/public/index.html'));
  });
const server = http.createServer(app);

var port = process.env.PORT || 3000;
app.listen(port);
console.log('server started '+ port);
