#Choonz Final Project
Choonz is a Music Library Web Application that we have been tasked to create for the final project of our SDET course. The project aims to be able to sign in users based on differing levels of authority and each user can then CRUD different entities depending on their authentication. This is a full stack application using MySQL for the database, Spring-Boot framework for the Backend and a combination of HTML, CSS and JavaScript for the Frontend.

Concept
The Choonz website allows a vistor to read all of the entities, allows logged in users to CRUD their own playlists and an admin user to CRUD all the entities.

MUST HAVE - Track, Artist, Album
SHOULD HAVE - Genre, Playlist
COULD HAVE - Login system with different authentication depending on type of user
Client Requirements
General
Multiple users can sign up to the system
The styling of the entire site should be consistent
Users can browse the system without logging in, but won’t be able to CRUD
It would be nice to be able to search for a specific track, album, or artist
User Home Screen
Users can CRUD albums, artists, tracks and genres
Users should see cards for each playlist on their home screen
Albums
Users should view each album on its own page
The album should contain a list of songs
The albums page should contain a link to the artist page
Each track should link to a track page
Artists
Users should view each artist on its own page
The artist should contain a list of albums
Each album should link to an album page
Tracks
Users should view each track on its own page
The track page should show the name, lyrics, and genre
The track page should contain links to the relevant album and artist
Genres
Users should view each genre on its own page
The genre should contain a list of tracks
Each track should link to a track page
Playlists
A user can CRUD as many playlists as they like on their home screen
Users should CRUD their own playlists either by song id, name, or genre
Non-Functional Testing
Response times should be <10 milliseconds
Latency should be <2 seconds at 10000 concurrent users
Throughput rate should be >300/s
RAM allocation should be minimal, with few (if any) memory leaks
The application should be spike-, load-, stress-, and soak-tested
Prerequisites:
To use this application you will need:

Java Verison 14
Eclipse installed
MySQL Server 8.0+
Visual Studio Code
Spring Boot and Maven installed
For testing purposes:

JMeter installed 
Getting Started
Given that you achieve the prerequisites, to set up development you will need to:

Clone this repository to your local pc, using eclipse
Run the project as a Spring Boot Application.
The application is hosted as localhost:8081/ OR can be run as a live server from the index page using Visual Studio Code.
Running the Tests
The tests can be ran on Eclipse, this can be done by right-clicking on the project and running as a JUnit test. In regards to User acceptance tests, these can be found in test resources under the feature files which will have scenarios that can be run to tes the Front End. Non-functional testing is covered in the src/test/jmeter. The .jmx files can be find in there, with the html reports, alongside the excel sheets for a summary of data.

Test Coverage
![coverage 2](https://user-images.githubusercontent.com/85874668/132088579-6ae332a4-f4a5-4337-a88b-883ed44bd28d.png)


Authors
Training Team
Client - Angelica Charry - Software Delivery Manager
Product Owner - Nick Johnson - Initial work (backend & frontend development, specification)
Product Owner - Edward Reynolds - Initial work (testing, specification)
Jordan Harrison - General Java wizardry
Alan Davies
Savannah Vaithilingham
Vinesh Ghela
Piers Barber
Development Team
Team 1
David Algie-Scrum Master week 1
George Whyte- Scrum Master week 2
Sirish Khatry
Acknowledgements
TBD
