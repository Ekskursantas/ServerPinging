# Ping exercise
## Problem statement
We want to test the ping response times from 3 different servers, that we know is in 3 different parts of the world.
We want to prove that the servers response times are dependant on the location of these servers.

## Experiment setup
A prerequisite of our experiment is to find the location of the three servers, so we can compare the response times with the approximate distance from us to the servers location.

These are the three IPs:
- 128.199.144.199
- 167.99.51.33
- 46.101.253.149

We ran each IP through: https://www.iplocation.net/ to get the physical location of the server. Which gave us the following 3 locations

|IP Address|Country|Region|City|
|--|--|--|--|
|128.199.144.199|Singapore|Singapore|Singapore|
|167.99.51.33|United States|New Jersey|Clifton|
|46.101.253.149|Germany|Hessen|Frankfurt am Main|

Then we need the distance from our location in Kongens Lyngby, Denmark to each of the three locations.

- From Kongens Lyngby to Singapore there is 9977.28 km.
- From Kongens Lyngby to Clifton there is 6184.19 km.
- From Kongens Lyngby to Frankfurt am Main there is 679.00 km.

From our problem statement we then expect the response times to the server located in Frankfurt to be the fastest, and the ones to Singapore the slowest.

The second thing we want is to actually ping these IP addresses and measure response times.
To do this, we made a small Java program that pings each of these three servers and presents the average response time.
The code for executing the experiment can be found in this repository. 

The experiment is performed on a Macbook Pro from 15 with the following specs:
![Macbook pro specs](https://github.com/kryptag/Ping_Ufo_Assignment/blob/master/specs.png?raw=true)

And with the following internet connection from CPHBusiness in Kongens Lyngby:
![Internet connection](https://github.com/kryptag/Ping_Ufo_Assignment/blob/master/internet-connection.png?raw=true)

## The experiment
To execute the experiment, you will need Java 8 installed on your machine, and a Java IDE and you have to be able to execute the ping command to these three servers from your terminal.

1. Clone the project
2. Open the source code in your Java IDE.
3. Press run

The results should now be presented for you.

We chose to execute a ping to each of these servers 100 times to get an average.

Results from school:
![Results](https://github.com/kryptag/Ping_Ufo_Assignment/blob/master/results.png?raw=true)

## Evaluation
As we expected from our initial statement, the further away the physical server was located, the higher the ping times was. 

## Discussion
As we can see there seems to be some kind of relation between distance to the physical server and the ping times.

To find out, we simply divided the ping times in milliseconds with the distance in kilometers to get ms/km. 
Additionally we did a similar test to a Danish server located 18,36 km from the school to see if it was a linear relation.

From Kongens Lyngby (School network)
- Singapore: 282.793ms / 9977.28km = 0.02834369687 ms/km
- Clifton: 95.166ms / 6184.19km = 0.01538859575 ms/km
- Frankfurt am Main: 17.820ms / 679.00km = 0.0262444771 ms/km
- Taarnby, Denmark: 6,020ms / 18,36km = 0.32788671024 ms/km

As we can see, the relation here is not linear at all. If it was linear, the ms/km would be close to identical for all the servers. 

From this, we can deduct that there must be some other factors than just the distance to the physical server.
Some of these factors could be the connectivity to the different regions and the quality of the physical internet cables.
To further prove the relation between distance and ping response times, one could test to other locations that have the same distance as the ones already tested.
This would mean we would make another test that goes from another city with the same distance to Clifton as the distance we have from Lyngby.

