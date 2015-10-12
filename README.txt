CS5001 - Practical 3 - Web Server

Student ID: 150021237

0x00 Short Introduction

This web server is called IcyWrench. It was completely written by myself. It is designed to support 
modules which implement any tcp based protocol. In this case the provided module is an http server
which can host dynamic web sites which are written in Java.


0x01 Features

- Supports Get as well as Post requests.
- Can return static html documents.
- Can return any file (including images like gif, jpeg and png) which is inside the wwwroot folder.
- Supports dynamic web sites which are written in Java. 
- This web server is multi threaded. It automatically initializes worker threads (depending on 
  how many cores the server has) and they work off the concurrent blocking queue.
- This project uses a self made log manager which provides different log level support. Current
  output is configured by default to console. 
- The web server itself is safe from a bad coded web site. If the web site fails it will show an 
  appropriate http error message. Currently supported is 400, 404, 500


0x02 Design

I'd like to point out the fact the my coding style is influenced by functional programming 
languages like Scala. This means that I support immutable and stateless classes whenever 
possible. A web server is a great software project to show the strengths of a more functional 
kind of approach. The focus in this project is on data which is operated on by stateless 
functions. This allows a clear and flexible architecture. I have used OOP everywhere I thought 
it would lead to a better overall programming flow.

Please have a look at ThreadPoolExecutor for my threading implementation.

Please have a look at HttpRequestHandler and HttpResponseHandler for my http encoding/decoding as 
well as the Java class loading mechanism which subdivides the server code from the web site code.


0x03 Examples

The current web site is very simple and shows the basic functionality.
The web site is located in [ProjectRoot]/wwwroot/
The web site can be accessed through your browser and console:
http://localhost:12345/

-> If a folder is called it will by default look for the Index class/page. There is currently an 
Index page in the wwwroot folder as well as in the test folder.
In wwwroot/test are further test files and pages located.

-> Have a look at http://localhost:12345/test/ or http://localhost:12345/test/Index

-> There is a dynamic web site: http://localhost:12345/test/Echo
It prints out whatever the client sends as content. See the example request below:
--------
GET /test/Echo HTTP/1.1
Content-Length: 5

asdfg
--------
Result: 

HTTP/1.1 200 OK
Content-Type: text/html
Content-Length: 56
Connection: close

Echo from request content is on the next line.
<br>asdfgConnection closed by foreign host.

-> There is an example for a recovery from a failure on the web site itself
   http://localhost:12345/test/Fail

-> Send following GET request to produce a 400 Error:
--------
GET /test/Echo HTTP/1.1
Content-Length: 5
asdfg
--------


0x04 Running Instructions

Run the Web Server like this:

java -jar IcyWrench.jar


