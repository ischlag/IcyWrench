
0x00 Introduction

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


0x03 Examples

See the demo page on the server. Default port is 12345. Access with your browser.

0x04 Running Instructions

Run the Web Server like this:

java -jar IcyWrench.jar

